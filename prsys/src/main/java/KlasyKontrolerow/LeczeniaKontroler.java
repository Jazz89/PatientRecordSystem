/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyKontrolerow;

import KlasyEncji.Historialeczenia;
import KlasyModeliDanych.LeczenieModelDanych;
import KlasyUslug.LeczeniaCrud;
import KlasyKontrolerow.Filtr.FiltrLeczen;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
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
public class LeczeniaKontroler extends Kontroler implements Serializable {
    

    private @Inject
    LeczeniaCrud leczenieCrud;
    private LazyDataModel<Historialeczenia> leczeniaDataModel;
    private Historialeczenia[] wybraneLeczenia;
    private Historialeczenia noweLeczenie = new Historialeczenia();
    private Historialeczenia wybraneLeczenie = new Historialeczenia();
    private FiltrLeczen filtr = new FiltrLeczen();
    List<Historialeczenia> leczenieList;
    FacesMessage fcMsg;
    FacesContext context;
    SimpleDateFormat parserSDF;
    String formattedDate;
    String peselSubstring;
    
    @Override
    public void doRead(ActionEvent actionEvent) {
        leczeniaDataModel = new LeczenieModelDanych(leczenieCrud,filtr.getFilterMap());
    }

    @Override
    public void doCreate(ActionEvent actionEvent) {
        leczenieCrud.create(noweLeczenie);
    }

    @Override
    public void doUpdate(ActionEvent actionEvent) {
        leczenieCrud.update(wybraneLeczenie);
    }

    @Override
    public void doDelete(ActionEvent actionEvent) {
        leczenieCrud.deleteItems(wybraneLeczenia);
    }

    public LazyDataModel<Historialeczenia> getLeczeniaDataModel() {
        return leczeniaDataModel;
    }

    public void setLeczeniaDataModel(LazyDataModel<Historialeczenia> leczeniaDataModel) {
        this.leczeniaDataModel = leczeniaDataModel;
    }

    public Historialeczenia[] getWybraneLeczenia() {
        return wybraneLeczenia;
    }

    public void setWybraneLeczenia(Historialeczenia[] wybraneLeczenia) {
        this.wybraneLeczenia = wybraneLeczenia;
    }

    public Historialeczenia getNoweLeczenie() {
        return noweLeczenie;
    }

    public void setNoweLeczenie(Historialeczenia noweLeczenie) {
        this.noweLeczenie = noweLeczenie;
    }

    public Historialeczenia getWybraneLeczenie() {
        return wybraneLeczenie;
    }

    public void setWybraneLeczenie(Historialeczenia wybraneLeczenie) {
        this.wybraneLeczenie = wybraneLeczenie;
    }

    public FiltrLeczen getFiltr() {
        return filtr;
    }

    public void setFiltr(FiltrLeczen filtr) {
        this.filtr = filtr;
    }

    @Override
    void doFind(ActionEvent actionEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
