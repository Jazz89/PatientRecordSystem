/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyKontrolerow.Filtr;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author JAzz
 */
public class FiltrSpecjalizacji {

    private String nazwa = "";
    private Map filterMap = new HashMap();

    public Map getFilterMap() {
        filterMap.clear();
        if (!nazwa.equals("")) {
            filterMap.put("imie", nazwa);
        } else {
            filterMap.put("imie", "%");
        }

        return filterMap;

    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    
}
