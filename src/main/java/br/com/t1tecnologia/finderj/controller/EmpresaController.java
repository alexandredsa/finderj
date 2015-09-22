package br.com.t1tecnologia.finderj.controller;

import br.com.t1tecnologia.finderj.enums.converter.EnumConverterFactory;
import br.com.t1tecnologia.finderj.model.Empresa;
import br.com.t1tecnologia.finderj.model.Usuario;
import br.com.t1tecnologia.finderj.repository.EmpresaRepository;
import br.com.t1tecnologia.finderj.service.SessionService;
import br.com.t1tecnologia.finderj.util.ConsoleLog;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public ModelAndView home(Model model) {
        ModelAndView MvHome = new ModelAndView("empresa/editar");
        MvHome.addObject("nomeUsuario", sessionService.getUsuarioName());
        if (sessionService.getEmpresaUsuarioSession() != null) {
            MvHome.setViewName("empresa/editar");
        } else {
            MvHome.setViewName("empresa/cadastro");
        }
        
        return MvHome;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = {"/cadastrar"})
    public String salvar(Empresa empresa, HttpServletRequest request, @RequestParam("emprNome") String nomeEmpresa) {
        Usuario usuario = sessionService.getUsuarioSession();
        empresa.setEmprUsuario(usuario);

        if (isEmpresaNomeDisponivel(empresa.getEmprNome())) {
            empresaRepository.save(empresa);
            return "true";
        }

        return "Nome de empresa já cadastrado.";

    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/editar")
    public String editar(Empresa empresa, HttpServletRequest request) {
        try {
            Usuario usuario = sessionService.getUsuarioSession();
            Empresa empresaExistente = sessionService.getEmpresaUsuarioSession();

            if (empresaExistente != null) {
                empresa.setID((empresaExistente.getID()));
                empresaRepository.save(empresa);
                return "true";
            }

        } catch (Exception ex) {
            ConsoleLog.writeString(ex.getMessage());
        }

        return "false";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = {"/cadastrar/options", "/editar/options"})
    public Map<String, ?> getOptions(@RequestParam(value = "key") String key) {
        return EnumConverterFactory.getEnumOptions(key);

    }

    private boolean isEmpresaNomeDisponivel(String nomeEmpresa) {
        return empresaRepository.findByEmprNome(nomeEmpresa) == null;
    }

}
