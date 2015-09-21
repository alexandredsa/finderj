package br.com.t1tecnologia.finderj.controller;

import br.com.t1tecnologia.finderj.enums.converter.EnumConverterFactory;
import br.com.t1tecnologia.finderj.model.Empresa;
import br.com.t1tecnologia.finderj.model.Usuario;
import br.com.t1tecnologia.finderj.repository.EmpresaRepository;
import br.com.t1tecnologia.finderj.service.SessionService;
import br.com.t1tecnologia.finderj.util.ConsoleLog;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    SessionService sessionService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home() {
        return new ModelAndView("view/empresa/cadastro.html");
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = {"/cadastrar", "/editar"})
    public String salvar(Empresa empresa, HttpServletRequest request, @RequestParam("emprNome") String nomeEmpresa) {
        Usuario usuario = sessionService.getUsuarioSession(request);
        Empresa empresaExistente = verificarUsuarioPossuiEmpresa(usuario);
        
        empresa.setEmprUsuario(usuario);
        if (empresaExistente != null) {
            empresa.setID((empresaExistente.getID()));
            return editar(empresa);
        }

        return inserir(empresa);

    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = {"/cadastrar/options", "/editar/options"})
    public Map<String, ?> getOptions(@RequestParam(value = "key") String key) {
        return EnumConverterFactory.getEnumOptions(key);

    }

    private boolean isEmpresaNomeDisponivel(String nomeEmpresa) {
        return empresaRepository.findByEmprNome(nomeEmpresa) == null;
    }

    private Empresa verificarUsuarioPossuiEmpresa(Usuario usuario) {
        return empresaRepository.findByEmprUsuario(usuario);
    }

    private String inserir(Empresa empresa) {
        if (isEmpresaNomeDisponivel(empresa.getEmprNome())) {
            empresaRepository.save(empresa);
            return "true";
        }

        return "false";
    }

    private String editar(Empresa empresa) {
        try {
            empresaRepository.save(empresa);
            return "true";
        } catch (Exception ex) {
            ConsoleLog.writeString(ex.getMessage());
            return "false";
        }
    }

}
