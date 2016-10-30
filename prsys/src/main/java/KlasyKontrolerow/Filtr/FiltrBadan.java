/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyKontrolerow.Filtr;

import KlasyEncji.Pacjent;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author JAzz
 */
public class FiltrBadan {
    
    private Pacjent pacjent = new Pacjent();
    private String nazwa = "";
    private Map filterMap = new HashMap();
    
       public Map getFilterMap() {
        filterMap.clear();
        if (!pacjent.getPesel().equals("") || !nazwa.equals("")) {

            if (!pacjent.getImie().equals("")) {
                filterMap.put("pesel", pacjent.getPesel());
            } else {
                filterMap.put("pesel", "%");
            }
          if (nazwa.equals("")) {
                filterMap.put("nazwa", nazwa + "%");
            } else {
                filterMap.put("nazwa", "%");
            }
          

            return filterMap;
        } else {
            throw new NullPointerException();
        }
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }
    
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }            
    
    
}
