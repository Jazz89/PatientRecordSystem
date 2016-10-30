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
public class FiltrPracownik {

    private String imie = "";
    private String nazwisko = "";
    private String email = "";
    private String kraj = "";
    private String miasto = "";
    private String specjalizacja = "";
    private String rola = "";
    private Map filterPracownikMap = new HashMap();

    public Map getPracownikFilterMap() {
        filterPracownikMap.clear();
        if (!imie.equals("") || !nazwisko.equals("") || !email.equals("") || !miasto.equals("") || specjalizacja!=null) {

            if (!imie.equals("")) {
                filterPracownikMap.put("imie", imie + "%");
            } else {
                filterPracownikMap.put("imie", "%");
            }
            if (!nazwisko.equals("")) {
                filterPracownikMap.put("nazwisko", nazwisko + "%");
            } else {
                filterPracownikMap.put("nazwisko", "%");
            }
            if (!email.equals("")) {
                filterPracownikMap.put("email", email + "%");
            } else {
                filterPracownikMap.put("email", "%");
            }
            if (!miasto.equals("")) {
                filterPracownikMap.put("miasto", miasto + "%");
            } else {
                filterPracownikMap.put("miasto", "%");
            }
            if (!kraj.equals("")) {
                filterPracownikMap.put("kraj", kraj + "%");
            } else {
                filterPracownikMap.put("kraj", "%");
            }
            
            if (specjalizacja!=null) {
                filterPracownikMap.put("specjalizacja", specjalizacja + "%");
            } else {
                filterPracownikMap.put("specjalizacja", "%");
            }

            return filterPracownikMap;
        } else {
            throw new NullPointerException();
        }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }
}
