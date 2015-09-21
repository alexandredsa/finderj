/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.t1tecnologia.finderj.controller;

import br.com.t1tecnologia.finderj.enums.SessionEnum;
import br.com.t1tecnologia.finderj.enums.TipoUsuarioEnum;
import br.com.t1tecnologia.finderj.enums.converter.EnumConverterFactory;
import br.com.t1tecnologia.finderj.model.Usuario;
import br.com.t1tecnologia.finderj.repository.UsuarioRepository;
import br.com.t1tecnologia.finderj.util.ConvertToMd5;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author alexandre
 */
@Controller
@RequestMapping(value = {"/usuario", "/login"})
public class UsuarioController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("/view/usuario/login.html");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cadastro")
    public ModelAndView cadastro() {
        return new ModelAndView("/view/usuario/cadastro.html");
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/cadastrar")
    public String cadastrar(Usuario u) throws Exception {
        try {
            if (verificarLoginDisponivel(u.getUsuaLogin())) {
                u.setUsuaSenha(ConvertToMd5.CriptografaSenha(u.getUsuaSenha()));
                u.setUsuaAdmin(false);
                u.setUsuaAtivo(true);
                usuarioRepository.save(u);
                return "true";
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return "false";
    }

    @ResponseBody
    @RequestMapping(value = "/logar", method = RequestMethod.POST)
    public ModelAndView autenticar(Usuario u, HttpSession session) throws Exception {
        u = usuarioRepository.findByUsuaLoginAndUsuaSenhaAndUsuaAtivoTrue(u.getUsuaLogin(), ConvertToMd5.CriptografaSenha(u.getUsuaSenha()));

        if (u != null) {
            session.setAttribute(SessionEnum.USUARIO.name(), u.getUsuaLogin());
            session.setAttribute(SessionEnum.TIPO_USUARIO.name(), u.getTipoUsuario());
            session.setAttribute(SessionEnum.ADMIN.name(), u.isUsuaAdmin());

            return new ModelAndView("redirect:/empresa");
        }

        return new ModelAndView("redirect:/usuario/login");
    }

    private boolean verificarLoginDisponivel(String usuario) {
        return usuarioRepository.findByUsuaLogin(usuario) == null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/cadastrar/options")
    public Map<String, ?> getOptions(@RequestParam(value = "key") String key) {
        return EnumConverterFactory.getEnumOptions(key);
    }

}
