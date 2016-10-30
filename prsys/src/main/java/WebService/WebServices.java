/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import KlasyEncji.Historiabadan;
import KlasyEncji.Historialeczenia;
import KlasyEncji.Pacjent;
import KlasyEncji.Pokoj;
import KlasyEncji.Pracownik;
import KlasyEncji.Role;
import KlasyEncji.Specjalizacja;
import KlasyEncji.Wizyta;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JAzz
 */
@WebService(serviceName = "WebServices")
public class WebServices {

    @PersistenceContext
    private EntityManager em;

    @WebMethod(operationName = "getPacjentList")
    public List<Pacjent> getPacjentList() {
     return this.em.createNamedQuery("Pacjent.findAll").getResultList();
   
    }

    @WebMethod(operationName = "getPracownikList")
    public List<Pracownik> getPracownikList() {
        return this.em.createNamedQuery("Pracownik.findAll").getResultList();

    }

    @WebMethod(operationName = "getBadaniaList")
    public List<Historiabadan> getBadaniaList() {
        return this.em.createNamedQuery("Historiabadan.findAll").getResultList();
 
    }

    @WebMethod(operationName = "getLeczeniaList")
    public List<Historialeczenia> getLeczeniaList() {
        return this.em.createNamedQuery("Historialeczenia.findAll").getResultList();
 
    }

    @WebMethod(operationName = "getPokojList")
    public List<Pokoj> getPokojList() {
        return this.em.createNamedQuery("Pokoj.findAll").getResultList();

    }

    @WebMethod(operationName = "getRoleList")
    public List<Role> getRoleList() {
        return this.em.createNamedQuery("Role.findAll").getResultList();

    }

    @WebMethod(operationName = "getSpecjalizacjaList")
    public List<Specjalizacja> getSpecjalizacjaList() {
        return this.em.createNamedQuery("Specjalizacja.findAll").getResultList();

    }

    @WebMethod(operationName = "getWizytyList")
    public List<Wizyta> getWizytyList() {
        return this.em.createNamedQuery("Wizyta.findAll").getResultList();
    }
}
