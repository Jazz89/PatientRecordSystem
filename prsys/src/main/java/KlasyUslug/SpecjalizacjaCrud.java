/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyUslug;


import KlasyEncji.Specjalizacja;
import javax.ejb.Stateless;

/**
 *
 * @author JAzz
 */
@Stateless
public class SpecjalizacjaCrud extends UslugiCrud<Specjalizacja>{
    public SpecjalizacjaCrud() {
        super(Specjalizacja.class);
    }
}
