package br.com.t1tecnologia.finderj.service;

import br.com.t1tecnologia.finderj.enums.SessionEnum;
import br.com.t1tecnologia.finderj.model.Usuario;
import br.com.t1tecnologia.finderj.repository.UsuarioRepository;
import br.com.t1tecnologia.finderj.util.ConsoleLog;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexandre
 * Classe criada para recuperar dados do Session que sejam relevantes para os controllers.
 * 
 */
@Service("serviceSession")
public class SessionService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public SessionService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public Usuario getUsuarioSession(HttpServletRequest request) {
        try {
            String nomeUsuario = (String) request.getSession().getAttribute(SessionEnum.USUARIO.toString());
            Usuario u = usuarioRepository.findByUsuaLogin(nomeUsuario);
            return u;
        } catch (Exception ex) {
            ConsoleLog.writeString(ex.getMessage());
        }

        return null;

    }

}
