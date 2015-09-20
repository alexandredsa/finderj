/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.t1tecnologia.finderj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author alexandre
 */

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home(){
        return new ModelAndView("view/empresa/cadastro.html");
    }
}
