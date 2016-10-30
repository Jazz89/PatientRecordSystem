/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyKontrolerow;

import KlasyEncji.Pacjent;
import KlasyModeliDanych.PacjentDataModel;
import KlasyUslug.PacjentCrud;
import KlasyKontrolerow.Filtr.FiltrPacjent;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PersistenceException;
import org.primefaces.model.LazyDataModel;
/**
 *
 * @author JAzz
 */
@Named
@SessionScoped
public class PacjentKontroler implements Serializable {

    private @Inject
    PacjentCrud pacjentCrud;
    private LazyDataModel<Pacjent> pacjentDataModel;
    private Pacjent[] wybraniPacjenci;
    private List<Pacjent> pacjentList = new ArrayList<Pacjent>();
    private FiltrPacjent filtr = new FiltrPacjent();
    private Pacjent nowyPacjent = new Pacjent();
    private Pacjent wybranyPacjent = new Pacjent();
    FacesMessage fcMsg;
    FacesContext context;
    SimpleDateFormat parserSDF;
    String formattedDate;
    String peselSubstring;

    public void doRead(ActionEvent actionEvent) {
        try {
            pacjentDataModel = new PacjentDataModel(pacjentCrud, filtr.getPacjentFilterMap());
        } catch (NullPointerException e) {
            context = FacesContext.getCurrentInstance();
            fcMsg = new FacesMessage();
            fcMsg.setDetail("Wprowadz dane !");
            fcMsg.setSummary("Nie podano parametrów wyszukiwania.");
            context.addMessage(null, fcMsg);

        }
        
    }

    public void doCreate(ActionEvent actionEvent) throws ParseException {
        try {
            System.out.println("doCreate");
            dataIsEqualPesel(nowyPacjent);
            pacjentCrud.create(nowyPacjent);
        } catch (IllegalArgumentException e) {
            context = FacesContext.getCurrentInstance();
            fcMsg = new FacesMessage();
            fcMsg.setDetail("Błąd !");
            fcMsg.setSummary("Numer pesel nie zgadza się z datą urodzenia");
            context.addMessage(null, fcMsg);
        }
        catch (PersistenceException e) {
            context = FacesContext.getCurrentInstance();
            fcMsg = new FacesMessage();
            fcMsg.setDetail("asdasdasdasd");
            fcMsg.setSummary("Nie podano parametrów wyszukiwania.");
            context.addMessage(null, fcMsg);

        }
    }

    public void doUpdate(ActionEvent actionEvent) throws ParseException {
        try {
            dataIsEqualPesel(wybranyPacjent);
            pacjentCrud.update(wybranyPacjent);
        } catch (IllegalArgumentException e) {
            context = FacesContext.getCurrentInstance();
            fcMsg = new FacesMessage();
            fcMsg.setDetail("Błąd !");
            fcMsg.setSummary("Numer pesel nie zgadza się z datą urodzenia");
            context.addMessage(null, fcMsg);
        }
    }

    public void doDelete(ActionEvent actionEvent) {
        System.out.println("usuwanie ");
        pacjentCrud.deleteItems(wybraniPacjenci);
    }

    public List<Pacjent> doFind(String nazwisko) {
        Map map = new HashMap();
        map.put("nazwisko", nazwisko + "%");
        pacjentList = pacjentCrud.findWithNamedQuery("Pacjent.findByNazwisko", map);
        return pacjentList;
    }

    public Pacjent[] getWybraniPacjenci() {
        return wybraniPacjenci;
    }

    public void setWybraniPacjenci(Pacjent[] wybraniPacjenci) {
        this.wybraniPacjenci = wybraniPacjenci;
    }

    public LazyDataModel<Pacjent> getPacjentDataModel() {
        return pacjentDataModel;
    }

    public void setPacjentDataModel(LazyDataModel<Pacjent> pacjentDataModel) {
        this.pacjentDataModel = pacjentDataModel;
    }

    public Pacjent getNowyPacjent() {
        return nowyPacjent;
    }

    public void setNowyPacjent(Pacjent nowyPacjent) {
        this.nowyPacjent = nowyPacjent;
    }

    public Pacjent getWybranyPacjent() {
        return wybranyPacjent;
    }

    public void setWybranyPacjent(Pacjent wybranyPacjent) {
        this.wybranyPacjent = wybranyPacjent;
    }

    public FiltrPacjent getFiltr() {
        return filtr;
    }

    public void setFiltr(FiltrPacjent filtr) {
        this.filtr = filtr;
    }

    public boolean wybraniPacjenciIsEmpty() {
        return wybraniPacjenci == null || wybraniPacjenci.length == 0;
    }

    public List<Pacjent> getPacjentList() {
        return pacjentList;
    }

    public void setPacjentList(List<Pacjent> pacjentList) {
        this.pacjentList = pacjentList;
    }

    public void dataIsEqualPesel(Pacjent pacjent) throws ParseException {
        parserSDF = new SimpleDateFormat("yyMMdd");
        formattedDate = parserSDF.format(pacjent.getDataurodzenia());
        peselSubstring = pacjent.getPesel().substring(0, 6);
        if (!peselSubstring.equals(formattedDate)) {
            throw new IllegalArgumentException();
        }
    }
    /*   private Map getMapaFiltru() {
     if(wyszukiwanyPacjent==null || wyszukiwanyPacjent.){
     throw new NullPointerException();
     }
     else{
        
     return mapaFiltru;
     }
        
     filterMap.clear();
     if (!pesel.equals("") || !plec.equals("") || !imie.equals("") || !nazwisko.equals("") || !krew.equals("") || !email.equals("") || !telefon.equals("") || !miasto.equals("")) {

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
     filterMap.put("plec", plec + "%");
     } else {
     filterMap.put("plec", "%");
     }
     if (!telefon.equals("")) {
     filterMap.put("telefon", telefon + "%");
     } else {
     filterMap.put("telefon", "%");
     }
     if (!krew.equals("")) {
     filterMap.put("krew", krew + "%");
     } else {
     filterMap.put("krew", "%");
     }
     if (!email.equals("")) {
     filterMap.put("email", email + "%");
     } else {
     filterMap.put("email", "%");
     }
     if (!miasto.equals("")) {
     filterMap.put("miasto", miasto + "%");
     } else {
     filterMap.put("miasto", "%");
     }
     if (!miasto.equals("")) {
     filterMap.put("kraj", kraj + "%");
     } else {
     filterMap.put("kraj", "%");
     }
     return filterMap;
     }
     else throw new NullPointerException();//return null;
        
        
     }*/
}
