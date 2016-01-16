package br.com.t1tecnologia.finderj.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.t1tecnologia.finderj.enums.SessionEnum;
import br.com.t1tecnologia.finderj.enums.TipoUsuarioEnum;
import br.com.t1tecnologia.finderj.util.ConsoleLog;

/**
 * 
 * @author alexa Classe criada para controle de Autorização para regras em comum
 *         entre Usuário Admin e Empresa
 *
 */
public class AdminAndEmpresaInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse hsr1, Object o) throws Exception {
		ConsoleLog.write(request.getRequestURI(), this.getClass(), "preHandle");

		HttpSession session = request.getSession();

		if (!session.getAttribute(SessionEnum.TIPO_USUARIO.name()).equals(TipoUsuarioEnum.PESSOA_JURIDICA)) {
			if (!(boolean) session.getAttribute(SessionEnum.ADMIN.name())) {
				hsr1.sendRedirect("login");
				return false;
			}
		}

		return true;
	}

}
