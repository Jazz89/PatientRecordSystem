/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyUslug;

import KlasyEncji.Historialeczenia;
import javax.ejb.Stateless;


/**
 *
 * @author JAzz
 */
@Stateless
public class LeczeniaCrud extends UslugiCrud<Historialeczenia>{
    public LeczeniaCrud() {
        super(Historialeczenia.class);
    }
}
