/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyKontrolerow;

import KlasyModeliDanych.PracownikDataModel;
import KlasyEncji.Pracownik;
import KlasyEncji.Role;
import KlasyEncji.Specjalizacja;
import KlasyUslug.PracownikCrud;
import KlasyKontrolerow.Filtr.FiltrPracownik;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
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
public class PracownikKontroler implements Serializable {

    private @Inject
    PracownikCrud pracownikCrud;
    private LazyDataModel<Pracownik> pracownikDataModel;
    private Pracownik[] wybraniPracownicy;
    private Pracownik nowyPracownik = new Pracownik();
    private Pracownik wybranyPracownik = new Pracownik();
    private Pracownik wyszukiwanyPracownik = new Pracownik();
    private List<Pracownik> pracownikList = new ArrayList<Pracownik>();
    private List<Specjalizacja> specjalizacjeList;
    private List<Role> roleList;
    private FiltrPracownik filtr = new FiltrPracownik();
    

    @PostConstruct
    public void init() {
        roleList = pracownikCrud.findWithNamedQuery("Role.findAll");
        specjalizacjeList = pracownikCrud.findWithNamedQuery("Specjalizacja.findAll");
    }

    public void doRead(ActionEvent actionEvent) {
        try {
            pracownikDataModel = new PracownikDataModel(pracownikCrud, filtr.getPracownikFilterMap());
        } catch (NullPointerException e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wprowadz dane !", "Nie podano parametrów wyszukiwania."));
        }
    }

    public void doCreate(ActionEvent actionEvent) {
        System.out.println("doCreate");
        pracownikCrud.create(nowyPracownik);
    }

    public void doUpdate(ActionEvent actionEvent) {
        pracownikCrud.update(wybranyPracownik);
    }

    public void doDelete(ActionEvent actionEvent) {
        pracownikCrud.deleteItems(wybraniPracownicy);
    }
    
    public List<Pracownik> doFind(String nazwisko){   
        System.out.println("PracownikKontroler.doFind");
        Map map = new HashMap();
        map.put("nazwisko", nazwisko+"%");
        pracownikList=pracownikCrud.findWithNamedQuery("Pracownik.findByNazwisko", map);       
        return pracownikList;
    }

    public LazyDataModel<Pracownik> getPracownikDataModel() {
        return pracownikDataModel;
    }

    public void setPracownikDataModel(LazyDataModel<Pracownik> pracownikDataModel) {
        this.pracownikDataModel = pracownikDataModel;
    }

    public Pracownik[] getWybraniPracownicy() {
        return wybraniPracownicy;
    }

    public void setWybraniPracownicy(Pracownik[] wybraniPracownicy) {
        this.wybraniPracownicy = wybraniPracownicy;
    }

    public Pracownik getNowyPracownik() {
        return nowyPracownik;
    }

    public void setNowyPracownik(Pracownik nowyPracownik) {
        this.nowyPracownik = nowyPracownik;
    }

    public Pracownik getWybranyPracownik() {
        return wybranyPracownik;
    }

    public void setWybranyPracownik(Pracownik wybranyPracownik) {       
        this.wybranyPracownik = wybranyPracownik;
    }

    public List<Specjalizacja> getSpecjalizacjeList() {
        return specjalizacjeList;
    }

    public void setSpecjalizacjeList(List<Specjalizacja> specjalizacjeList) {
        this.specjalizacjeList = specjalizacjeList;
    }

    public FiltrPracownik getFiltr() {
        return filtr;
    }

    public void setFiltr(FiltrPracownik filtr) {
        this.filtr = filtr;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Pracownik getWyszukiwanyPracownik() {
        return wyszukiwanyPracownik;
    }

    public void setWyszukiwanyPracownik(Pracownik wyszukiwanyPracownik) {
        this.wyszukiwanyPracownik = wyszukiwanyPracownik;
    }

    public List<Pracownik> getPracownikList() {
        return pracownikList;
    }

    public void setPracownikList(List<Pracownik> pracownikList) {
        this.pracownikList = pracownikList;
    }
    
    
   
}
