/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyKontrolerow;

import KlasyEncji.Historiabadan;
import KlasyModeliDanych.BadanieModelDanych;
import KlasyUslug.BadaniaCrud;
import KlasyKontrolerow.Filtr.FiltrBadan;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author JAzz
 */
@Named
@SessionScoped
public class BadaniaKontroler implements Serializable {
    

    private @Inject
    BadaniaCrud badaniaCrud;
    private LazyDataModel<Historiabadan> badaniaDataModel;
    private Historiabadan[] wybraneBadania;
    private Historiabadan noweBadanie = new Historiabadan();
    private Historiabadan wybraneBadanie = new Historiabadan();
    private FiltrBadan filtr = new FiltrBadan();
    FacesMessage fcMsg;
    FacesContext context;
    SimpleDateFormat parserSDF;
    String formattedDate;
    String peselSubstring;
    
      public void doRead(ActionEvent actionEvent) {
       try {
            badaniaDataModel = new BadanieModelDanych(badaniaCrud,filtr.getFilterMap());
        } catch (NullPointerException e) {
            context = FacesContext.getCurrentInstance();
            fcMsg = new FacesMessage();
            fcMsg.setDetail("Wproawdz nazwisko pacjenta i wybierz go z wyświetlonej listy lub wprowadź nazwę badania.");
            fcMsg.setSummary("Brak danych wyszukiwania !");
            context.addMessage(null, fcMsg);
        }
          
    }

    public void doCreate() {
        badaniaCrud.create(noweBadanie);
    }

    public void doUpdate(ActionEvent actionEvent) {
        badaniaCrud.update(wybraneBadanie);
    }

    public void doDelete(ActionEvent actionEvent) {
        badaniaCrud.deleteItems(wybraneBadania);
    }

    public LazyDataModel<Historiabadan> getBadaniaDataModel() {
        return badaniaDataModel;
    }

    public void setBadaniaDataModel(LazyDataModel<Historiabadan> badaniaDataModel) {
        this.badaniaDataModel = badaniaDataModel;
    }

    public Historiabadan[] getWybraneBadania() {
        return wybraneBadania;
    }

    public void setWybraneBadania(Historiabadan[] wybraneBadania) {
        this.wybraneBadania = wybraneBadania;
    }

    public Historiabadan getNoweBadanie() {
        return noweBadanie;
    }

    public void setNoweBadanie(Historiabadan noweBadanie) {
        this.noweBadanie = noweBadanie;
    }

    public Historiabadan getWybraneBadanie() {
        return wybraneBadanie;
    }

    public void setWybraneBadanie(Historiabadan wybraneBadanie) {
        this.wybraneBadanie = wybraneBadanie;
    }

   

    

    public FiltrBadan getFiltr() {
        return filtr;
    }

    public void setFiltr(FiltrBadan filtr) {
        this.filtr = filtr;
    }   
    
}
