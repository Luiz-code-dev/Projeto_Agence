package com.agence.global.projetoAgence.security;

import com.agence.global.projetoAgence.service.ImplementacaoUserDetailsSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/*Mapeia URls, endereços, autoriza ou bloqueia acessos a Urls
* By:Luiz Melo*/
@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private ImplementacaoUserDetailsSercice implementacaoUserDetailsSercice;

    /*Configura as solicitações de acesso por Http*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*Ativando a proteção contra usuário que não estão validados por TOKEN*/
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())

                /*Ativando a permissão para acesso a página incial do sistema EX: sistema.com.br/index*/
                .disable().authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/v1/index").permitAll()

                /*URL de Logout - Redireciona após o user deslogar do sistema*/
                .anyRequest().authenticated().and().logout().logoutSuccessUrl("/v1/index")

                /*Maperia URL de Logout e insvalida o usuário*/
                .logoutRequestMatcher(new AntPathRequestMatcher("/v1/logout"))

                /*Filtra requisições de login para autenticação*/
                .and().addFilterBefore(new JWTLoginFilter("/v1/auth", authenticationManager())
                        , UsernamePasswordAuthenticationFilter.class)

                /*Filtra demais requisições paa verificar a presenção do TOKEN JWT no HEADER HTTP*/
                .addFilterBefore(new JWTApiAutenticacaoFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.userDetailsService(implementacaoUserDetailsSercice)
                .passwordEncoder(new BCryptPasswordEncoder());


    }



}
