/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyUslug;


import KlasyEncji.Wizyta;
import javax.ejb.Stateless;

/**
 *
 * @author JAzz
 */
@Stateless
public class WizytyCrud extends UslugiCrud<Wizyta>{
    public WizytyCrud() {
        super(Wizyta.class);
    }
}
