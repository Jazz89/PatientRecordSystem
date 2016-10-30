/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyUslug;

import KlasyEncji.Historiabadan;
import javax.ejb.Stateless;

/**
 *
 * @author JAzz
 */
@Stateless
public class BadaniaCrud extends UslugiCrud<Historiabadan>{
    public BadaniaCrud() {
        super(Historiabadan.class);
    }
}
