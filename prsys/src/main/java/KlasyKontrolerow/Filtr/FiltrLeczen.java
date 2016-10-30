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
public class FiltrLeczen {

    private Pacjent pacjent = new Pacjent();
    private String objawy = "";
    private String leczenie = "";
    String[] tab;
    private Map filterMap = new HashMap();

    public Map getFilterMap() {
        filterMap.clear();

            if (!pacjent.getPesel().equals("")) {
                filterMap.put("pacjent", pacjent.getPesel());
            } else {
                filterMap.put("pacjent", "%");
            }
         /*   if (!objawy.equals("")) {
                StringBuilder result = new StringBuilder();
                tab = objawy.split(",");
                result.append("(");
                for (int i = 0; i < tab.length; i++) {
                    result.append("'%");
                    result.append(tab[i]);
                    result.append("%'");
                    result.append(",");
                }
             
                 System.out.println(result.substring(0, result.length() - 1));
              //  filterMap.put("objawy", result.substring(0, result.length() - 1));
                 filterMap.put("objawy", result.substring(0, result.length() - 1)+")");
            } else {
                filterMap.put("objawy", "%");
            }
            if (!leczenie.equals("")) {
                filterMap.put("leczenie", "%"+leczenie+"%");
            } else {
                filterMap.put("leczenie", "%");
            }
            * */

            return filterMap;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    public String getObjawy() {
        return objawy;
    }

    public void setObjawy(String objawy) {
        this.objawy = objawy;
    }

    public String getLeczenie() {
        return leczenie;
    }

    public void setLeczenie(String leczenie) {
        this.leczenie = leczenie;
    }
}
