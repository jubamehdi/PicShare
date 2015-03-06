/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Pattern;

/**
 *
 * @author juba
 */

@ManagedBean
@RequestScoped
public class Utilisateur {


    private String email;
    
    public Utilisateur() {
    }
    
}
