/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyKontrolerow;

import KlasyEncji.Specjalizacja;
import KlasyModeliDanych.SpecjalizacjaLazyDataModel;
import KlasyUslug.SpecjalizacjaCrud;
import KlasyKontrolerow.Filtr.FiltrSpecjalizacji;
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
public class SpecjalizacjaKontroler implements Serializable {
    
    private @Inject
    SpecjalizacjaCrud specjalizacjaCrud;
    private LazyDataModel<Specjalizacja> specjalizacjaLazyDataModel;
    private Specjalizacja[] wybraneSpecjalizacje;
    private Specjalizacja nowaSpecjalizacja = new Specjalizacja();
    private Specjalizacja wybranaSpecjalizacja = new Specjalizacja();
    private FiltrSpecjalizacji filtr = new FiltrSpecjalizacji();
    FacesMessage fcMsg;
    FacesContext context;
    SimpleDateFormat parserSDF;
    String formattedDate;
    String peselSubstring;

    

    public void doRead(ActionEvent actionEvent) {
       specjalizacjaLazyDataModel = new SpecjalizacjaLazyDataModel(specjalizacjaCrud, filtr.getFilterMap());
    }

    public void doCreate(ActionEvent actionEvent) {
        specjalizacjaCrud.create(nowaSpecjalizacja);
    }

    public void doUpdate(ActionEvent actionEvent) {
        specjalizacjaCrud.update(wybranaSpecjalizacja);
    }


    public void doDelete(ActionEvent actionEvent) {
        specjalizacjaCrud.deleteItems(wybraneSpecjalizacje);
    }

    public LazyDataModel<Specjalizacja> getSpecjalizacjaLazyDataModel() {
        return specjalizacjaLazyDataModel;
    }

    public void setSpecjalizacjaDataModel(LazyDataModel<Specjalizacja> specjalizacjaLazyDataModel) {
        this.specjalizacjaLazyDataModel = specjalizacjaLazyDataModel;
    }

    public Specjalizacja[] getWybraneSpecjalizacje() {
        return wybraneSpecjalizacje;
    }

    public void setWybraneSpecjalizacje(Specjalizacja[] wybraneSpecjalizacje) {
        this.wybraneSpecjalizacje = wybraneSpecjalizacje;
    }

    public Specjalizacja getWybranaSpecjalizacja() {
        return wybranaSpecjalizacja;
    }

    public void setWybranaSpecjalizacja(Specjalizacja wybranaSpecjalizacja) {
        this.wybranaSpecjalizacja = wybranaSpecjalizacja;
    }

    
    public FiltrSpecjalizacji getFiltr() {
        return filtr;
    }

    public void setFiltr(FiltrSpecjalizacji filtr) {
        this.filtr = filtr;
    }
    

  
        
}
