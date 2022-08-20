package com.agence.global.projetoAgence.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*Filtro onde todas asrequisições serão capturadas para autenticar
* by: Luiz Melo*/
public class JWTApiAutenticacaoFilter extends GenericFilterBean {



    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        /*Estabelece a autenticação para a requisição*/
        Authentication authentication = new JWTTokenAutenticacaoService().getAuthentication((HttpServletRequest) request);

        /*Coloca o processo de autenticação no spring security*/
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request,response);
    }
}
