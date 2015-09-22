/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.t1tecnologia.finderj.interceptor;

import br.com.t1tecnologia.finderj.enums.SessionEnum;
import br.com.t1tecnologia.finderj.enums.TipoUsuarioEnum;
import br.com.t1tecnologia.finderj.util.ConsoleLog;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author alexandre
 */
public class EmpresaInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse hsr1, Object o) throws Exception {
        ConsoleLog.write(request.getRequestURI(), this.getClass(), "preHandle");
        
        HttpSession session = request.getSession();

        if (!session.getAttribute(SessionEnum.TIPO_USUARIO.name()).equals(TipoUsuarioEnum.PESSOA_JURIDICA)) {
            if (!(boolean) session.getAttribute(SessionEnum.ADMIN.name())) {
                return false;
            }
        }

        return true;
    }

}
