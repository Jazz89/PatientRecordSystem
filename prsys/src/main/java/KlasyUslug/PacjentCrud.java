/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyUslug;

import KlasyEncji.Pacjent;
import javax.ejb.Stateless;

/**
 *
 * @author JAzz
 */
@Stateless
public class PacjentCrud extends UslugiCrud<Pacjent> {

    public PacjentCrud() {
        super(Pacjent.class);
    }
}
