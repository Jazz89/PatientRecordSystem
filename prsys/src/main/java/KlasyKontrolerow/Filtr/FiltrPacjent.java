/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyKontrolerow.Filtr;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/**
 *
 * @author JAzz
 */
public class FiltrPacjent {

    private String pesel = "";
    private String imie = "";
    private String nazwisko = "";
    private String miasto = "";
    private String krew = "";
    private String plec = "";
    private Date dataurodzeniamin = null;
    private Date dataurodzeniamax = null;
    private Map filterMap = new HashMap();

    public Map getPacjentFilterMap() {
        
        filterMap.clear();
        System.out.println("pesel :"+pesel);
        System.out.println("imie :"+imie);
        System.out.println("nazwisko :"+nazwisko);
        System.out.println("miasto :"+miasto);
        System.out.println("krew :"+krew);
        System.out.println("plec :"+plec);       
        if (!pesel.equals("") || plec!=null|| !imie.equals("") || !nazwisko.equals("") || !krew.equals("%") || !miasto.equals("")) {

            if (!pesel.equals("")) {
                filterMap.put("pesel", pesel + "%");
            } else {
                filterMap.put("pesel", "%");
            }
            if (!imie.equals("")) {
                filterMap.put("imie", imie + "%");
            } else {
                filterMap.put("imie", "%");
            }
            if (!nazwisko.equals("")) {
                filterMap.put("nazwisko", nazwisko + "%");
            } else {
                filterMap.put("nazwisko", "%");
            }
            if (!plec.equals("")) {
                filterMap.put("plec", plec);
            } else {
                filterMap.put("plec", "%");
            }
            
            if (!krew.equals("")) {
                filterMap.put("krew", krew);
            } else {
                filterMap.put("krew", "%");
            }
           
            if (!miasto.equals("")) {
                filterMap.put("miasto", miasto + "%");
            } else {
                filterMap.put("miasto", "%");
            }                
            
            if (dataurodzeniamin!=null) {
                System.out.println(dataurodzeniamin);
                filterMap.put("dataurodzeniamin", dataurodzeniamin);
            } else {
            //    Date date = new Date();
           //     SimpleDateFormat formater = new SimpleDateFormat("MMMM d, yyyy", );
          //      System.out.println(new Date("Sat Apr 19 00:00:00 CET 2013"));
         //       filterMap.put("dataurodzeniamin", new Date("Sat Apr 19 00:00:00 CET 1913"));
              //Sat Apr 19 00:00:00 CET 1975  
            }
            
            if (dataurodzeniamax!=null) {
                filterMap.put("dataurodzeniamax", dataurodzeniamax);
            } else {
         //       System.out.println(new Date("Sat Apr 19 00:00:00 CET 2013"));
         //      filterMap.put("dataurodzeniamax", new Date("Sat Apr 19 00:00:00 CET 2013"));
                
                
            }
 
            System.out.println(filterMap);
            return filterMap;
            
        }
        else throw new NullPointerException();
    }

    private void reset(){
      pesel = "";
      imie = "";
      nazwisko = "";
      miasto = "";
      krew = "";
      plec = "";
      dataurodzeniamin = null;
      dataurodzeniamax = null;
      filterMap.clear();
    }
    
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getKrew() {
        return krew;
    }

    public void setKrew(String krew) {
        this.krew = krew;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Date getDataurodzeniamin() {
        return dataurodzeniamin;
    }

    public void setDataurodzeniamin(Date dataurodzeniamin) {
        this.dataurodzeniamin = dataurodzeniamin;
    }

    public Date getDataurodzeniamax() {
        return dataurodzeniamax;
    }

    public void setDataurodzeniamax(Date dataurodzeniamax) {
        this.dataurodzeniamax = dataurodzeniamax;
    }
    
   

}
