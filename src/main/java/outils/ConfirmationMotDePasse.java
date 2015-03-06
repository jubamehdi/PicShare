/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outils;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author juba
 */
@FacesValidator("ConfirmeMdpValidator")
public class ConfirmationMotDePasse implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       String mdp = (String) value;
       String confirm = (String) component.getAttributes().get("confirmMdp");
       
       if(!value.equals(confirm)){
           throw new ValidatorException(new FacesMessage("veuillez introduire le même mot de passe"));
       }
    }
    
}
