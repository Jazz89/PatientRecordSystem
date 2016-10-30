/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyKontrolerow.Filtr;

import KlasyEncji.Pacjent;
import KlasyEncji.Pracownik;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author JAzz
 */
public class FiltrWizyt {

    private Pracownik pracownik;
    private Pacjent pacjent;    
    private Map filterMap = new HashMap();

    public Map getFilterMap() {
        filterMap.clear();
        if (pacjent!=null || pracownik!=null) {
 System.out.println("pracownik: "+ pracownik);
            if (pracownik!=null) {
                filterMap.put("email", pracownik.getEmail());
            } else {
                filterMap.put("email", "%");
            }           
            if (pacjent.getPesel()!=null) {
                filterMap.put("pesel", pacjent.getPesel());
            } else {
                filterMap.put("pesel", "%");
            }
           System.out.println("Mapa wizyt: "+ filterMap);
            return filterMap;
        } else throw new NullPointerException();
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }
    
}
