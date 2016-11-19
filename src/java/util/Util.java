/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Kleber
 */
public class Util {
    public static void redirecionar(String pagina) throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().
                redirect(FacesContext.getCurrentInstance().
                        getExternalContext().getRequestContextPath()+"/"+pagina);
    }
    
    public static void enviarMSGGrafica(String titulo, String msg){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,titulo, msg);
            RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
}
