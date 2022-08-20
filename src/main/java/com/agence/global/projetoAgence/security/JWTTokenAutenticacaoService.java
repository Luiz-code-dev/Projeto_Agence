package com.agence.global.projetoAgence.security;

import com.agence.global.projetoAgence.ApplicationContextLoad;
import com.agence.global.projetoAgence.entidades.Usuario;
import com.agence.global.projetoAgence.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Service
@Component
public class JWTTokenAutenticacaoService {


    /*Tempo de validade do Token de 8 horas*/
    private static final long EXPIRATION_TIME = 28800000;

    /*senha unica para compor a autenticação*/
    private static final String SECRET = "fleetmg@!";

    /*Prefixo padrão de token*/
    private static final String TOKEN_PREFIX = "Bearer";

    private static final String HEADER_STRING = "Authorization";

    /*Gerando token de autenticação*/
    public void addAuthentication(HttpServletResponse response, String username) throws Exception{

        /*Montagem do Token*/
        String JWT = Jwts.builder() //Chama o gerador de token
                .setSubject(username)//Adiciona o usuario
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) //tempo de expiração de token
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();//compactação e algoritimos de geração

        /*Junto o token com o prefixo*/
        String token = TOKEN_PREFIX + " " + JWT; //Bearea

        /*Adiciona no cabeçalho http*/
        response.addHeader(HEADER_STRING, token);

    }

    /*Retorna o usuário validado com o token se não retorna null*/
    public Authentication getAuthentication(HttpServletRequest request){

        /*Pega o token enviado pelo Http*/
        String token = request.getHeader(HEADER_STRING);

        if(token != null) {
            /*Validação do token do usuario na requisição*/
            String user = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody().getSubject();
            if (user != null) {
                Usuario usuario = ApplicationContextLoad.getApplicationContext()
                        .getBean(UsuarioRepository.class).findByUserByLogin(user);
                /*retornar o usuario logado*/
                if (usuario != null) {
                    return  new UsernamePasswordAuthenticationToken(usuario.getLogin(),
                            usuario.getSenha(),
                            usuario.getAuthorities());
                }
            }
        }
            return null; //Não autorizado
        }
}
