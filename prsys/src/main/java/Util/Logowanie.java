/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JAzz
 */
@Named
@SessionScoped
public class Logowanie implements Serializable {
    
    private String haslo;
    private String email;
    private Date dateTime;

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Logowanie(){
        
    }

    public Date getDateTime() {
        System.out.println("getDate Time"+ new Date());
        return new Date();
    }
    
    
    public void login(ActionEvent actionevent) throws IOException{
   
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
         try{  
        request.login(email, haslo);
        
        if(request.isUserInRole("Admin")){
        context.getExternalContext().redirect(request.getContextPath()+"/Admin.xhtml");
        }
        if(request.isUserInRole("Pracownik")){
        context.getExternalContext().redirect(request.getContextPath()+"/Pracownik.xhtml");
        }
      }
      catch(ServletException e){
          System.out.println(e);
          context.addMessage(null, new FacesMessage("Błąd !", "Niepoprawny e-mail lub hasło. Spróbuj jeszcze raz."));
                  
      }
    }
    
    public void wyloguj(ActionEvent actionevent) {  
       HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if(session != null){
            session.invalidate();
        }
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "/Login.xhtml?faces-redirect=true");
    }
    
}
