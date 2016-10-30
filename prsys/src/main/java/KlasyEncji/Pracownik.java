/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyEncji;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JAzz
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pracownik.findAll", query = "SELECT p FROM Pracownik p"),
    @NamedQuery(name = "Pracownik.findByNazwisko", query = "SELECT p FROM Pracownik p WHERE p.nazwisko LIKE :nazwisko"),
    @NamedQuery(name = "Pracownik.findByFilters", query = "SELECT p FROM Pracownik p WHERE"
            + " p.imie LIKE :imie and"
            + " p.nazwisko LIKE :nazwisko and"
            + " p.specjalizacja.nazwa LIKE :specjalizacja and"
            + " p.email LIKE :email and"
            + " p.adres.kraj LIKE :kraj and"
            + " p.adres.miasto LIKE :miasto")})
public class Pracownik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Size(max = 50)
    private String imie;
    @Size(max = 50)
    private String nazwisko;
    @Size(max = 11)
    private String godzinypracy;
    @Size(max = 64)
    private String haslo;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    private String email;
    @JoinTable(name = "pracownikrole", joinColumns = {
        @JoinColumn(name = "pracownikid", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "roleid", referencedColumnName = "id")})
    @ManyToMany
    private List<Role> roleList;
    @JoinColumn(name = "specjalizacja", referencedColumnName = "id")
    @ManyToOne
    private Specjalizacja specjalizacja;
    
    @JoinColumn(name = "adres", referencedColumnName = "id")
    @ManyToOne(cascade = {CascadeType.ALL})
    private Adres adres;
    @OneToMany(mappedBy = "pracownik")
    private List<Wizyta> wizytaList;

    public Pracownik() {
        adres=new Adres();
        roleList=new ArrayList<Role>();
    }

    public Pracownik(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
         System.out.println("getImie " +imie);
        return imie;
    }

    public void setImie(String imie) {
         System.out.println("setImie " +imie);
        this.imie = imie;
    }

    public String getNazwisko() {
        System.out.println("getNazwisko "+nazwisko);
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        System.out.println("setNazwisko "+nazwisko);
        this.nazwisko = nazwisko;
    }

    public String getHaslo() {
        System.out.println("getHaslo " +haslo);
        return haslo;
    }

    public void setHaslo(String haslo) {
        System.out.println("setHaslo "+haslo);
        this.haslo = haslo;
    }

    public String getEmail() {
        System.out.println("getEmail "+ email);
        return email;
    }

    public void setEmail(String email) {
        System.out.println("setEmail "+email);
        this.email = email;
    }

    @XmlTransient
    public List<Role> getRoleList() {
        System.out.println("getRoleList "+roleList);
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        System.out.println("setRoleList "+roleList);
        this.roleList = roleList;
    }

    public Specjalizacja getSpecjalizacja() {
        System.out.println("getSpecjalizacja "+specjalizacja);
        return specjalizacja;
    }

    public void setSpecjalizacja(Specjalizacja specjalizacja) {
        System.out.println("setSpecjalizacja "+specjalizacja);
        this.specjalizacja = specjalizacja;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    @XmlTransient
    public List<Wizyta> getWizytaList() {
        return wizytaList;
    }

    public void setWizytaList(List<Wizyta> wizytaList) {
        this.wizytaList = wizytaList;
    }

    public String getGodzinypracy() {
        return godzinypracy;
    }

    public void setGodzinypracy(String godzinypracy) {
        this.godzinypracy = godzinypracy;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pracownik)) {
            return false;
        }
        Pracownik other = (Pracownik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "KlasyEncji.Pracownik[ id=" + id + " ]";
    }

    
}
