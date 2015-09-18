/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.t1tecnologia.finderj.controller;

import br.com.t1tecnologia.finderj.model.Usuario;
import br.com.t1tecnologia.finderj.repository.UsuarioRepository;
import br.com.t1tecnologia.finderj.util.config.ConvertToMd5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author alexandre
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/cadastrar")
    public void cadastrar(@RequestParam(value = "usua_login") String usuario, @RequestParam(value = "usua_senha") String senha) throws Exception {

        if (verificarLoginDisponivel(usuario)) {
            usuarioRepository.save(new Usuario(usuario, ConvertToMd5.CriptografaSenha(senha)));
        }
    }

    @RequestMapping(value = "/logar", method = RequestMethod.POST)
    public boolean autenticar(@RequestParam("usua_login") String usuario, @RequestParam("usua_senha") String senha) {
        Usuario u = usuarioRepository.findByUsuaLoginAndUsuaSenha(usuario, senha);

        return u != null;
    }

    private boolean verificarLoginDisponivel(String usuario) {
        return usuarioRepository.findByUsuaLogin(usuario) == null;
    }

}
