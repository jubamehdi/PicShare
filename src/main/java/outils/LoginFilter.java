/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outils;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juba
 */
public class LoginFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;
        String session = (String) req.getSession().getAttribute("username");
        String url = req.getRequestURI();
        
        System.err.print("dofilter fonction : "+url);
        /*
        A. si c'est une requete à destination de forum ou logout.xhtml et la session n'est pas ouverte 
            (pas d'objet sesison) alors redirect vers login.xhtml
        B. si c'est une requete à déstination de registre(inscription) ou login et la session 
            est ouvert alors redirect vers forum.xhtml
        C. si c'est une requete à destination de logout est la session est ouvert alor 
            fermer la session , redirection vers login.xhtml
        */
       
        if(session==null){
            if(url.indexOf("/faces/compteUtilisateur.xhtml")>=0 ){
                rep.sendRedirect(req.getServletContext().getContextPath()+"index.xhtml");
            }
            else{
                chain.doFilter(request, response);
            }
        }else
        
                 chain.doFilter(request, response);
             
        
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
