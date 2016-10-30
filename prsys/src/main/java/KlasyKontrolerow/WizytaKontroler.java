/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyKontrolerow;

import KlasyEncji.Pacjent;
import KlasyEncji.Pracownik;
import KlasyEncji.Wizyta;
import KlasyModeliDanych.WizytaLazyDataModel;
import KlasyUslug.WizytyCrud;
import KlasyKontrolerow.Filtr.FiltrWizyt;
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
@SessionScoped
@Named
public class WizytaKontroler implements Serializable {
    private @Inject
    WizytyCrud wizytaCrud;
    private LazyDataModel<Wizyta> wizytaLazyDataModel;
    private Wizyta[] wybraneWizyty;
    private Wizyta nowaWizyta = new Wizyta();
    private Wizyta wybranaWizyta = new Wizyta();
    private FiltrWizyt filtr = new FiltrWizyt();
    
    FacesMessage fcMsg;
    FacesContext context;
    SimpleDateFormat parserSDF;
    String formattedDate;
    String peselSubstring;
    
    
    public void doRead(ActionEvent actionEvent) {       
       try {
           wizytaLazyDataModel = new WizytaLazyDataModel(wizytaCrud, filtr.getFilterMap());
        } catch (NullPointerException e) {
            context = FacesContext.getCurrentInstance();
            fcMsg = new FacesMessage();
            fcMsg.setDetail("Wprowadź dane !");
            fcMsg.setSummary("Nie podano parametrów wyszukiwania.");
            context.addMessage(null, fcMsg);
        }
    }

    public void doCreate(ActionEvent actionEvent) {
        wizytaCrud.create(nowaWizyta);
    }

    public void doUpdate(ActionEvent actionEvent) {
        wizytaCrud.update(wybranaWizyta);
    }


    public void doDelete(ActionEvent actionEvent) {
        wizytaCrud.deleteItems(wybraneWizyty);
    }
    

    public LazyDataModel<Wizyta> getWizytaLazyDataModel() {
        return wizytaLazyDataModel;
    }

    public void setWizytaLazyDataModel(LazyDataModel<Wizyta> wizytaLazyDataModel) {
        this.wizytaLazyDataModel = wizytaLazyDataModel;
    }

    public Wizyta[] getWybraneWizyty() {
        return wybraneWizyty;
    }

    public void setWybraneWizyty(Wizyta[] wybraneWizyty) {
        this.wybraneWizyty = wybraneWizyty;
    }

    public Wizyta getNowaWizyta() {
        return nowaWizyta;
    }

    public void setNowaWizyta(Wizyta nowaWizyta) {
        this.nowaWizyta = nowaWizyta;
    }

    public Wizyta getWybranaWizyta() {
        return wybranaWizyta;
    }

    public void setWybranaWizyta(Wizyta wybranaWizyta) {
        this.wybranaWizyta = wybranaWizyta;
    }

    public FiltrWizyt getFiltr() {
        return filtr;
    }

    public void setFiltr(FiltrWizyt filtr) {
        this.filtr = filtr;
    }
    
}
