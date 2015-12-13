package br.com.t1tecnologia.finderj.interceptor;

import br.com.t1tecnologia.finderj.enums.SessionEnum;
import br.com.t1tecnologia.finderj.util.ConsoleLog;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author alexandre
 */
public class ApplicationInterceptor extends HandlerInterceptorAdapter {

    public ApplicationInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse hsr1, Object o) throws Exception {
        ConsoleLog.write(request.getRequestURI(), this.getClass(), "preHandle");
        
        return request.getSession().getAttribute(SessionEnum.USUARIO.name()) != null;

    }

}
