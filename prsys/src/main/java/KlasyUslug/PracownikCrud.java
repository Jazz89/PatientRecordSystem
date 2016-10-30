/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyUslug;

import KlasyEncji.Pracownik;
import javax.ejb.Stateless;

/**
 *
 * @author JAzz
 */
@Stateless
public class PracownikCrud extends UslugiCrud<Pracownik> {

    public PracownikCrud() {
        super(Pracownik.class);
    }
}
