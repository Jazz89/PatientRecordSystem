/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyEncji;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Pacjent.findAll", query = "SELECT p FROM Pacjent p"),
    @NamedQuery(name = "Pacjent.findByNazwisko", query = "SELECT p FROM Pacjent p WHERE p.nazwisko LIKE :nazwisko"),
    @NamedQuery(name = "Pacjent.findByFilters", query = "SELECT p FROM Pacjent p WHERE"
            + " p.pesel LIKE :pesel and"
            + " p.imie LIKE :imie and"
            + " p.nazwisko LIKE :nazwisko and"
            + " p.plec LIKE :plec and"
            + " p.krew LIKE :krew and"          
            + " p.adres.miasto LIKE :miasto and"
            + " p.dataurodzenia BETWEEN '1920-01-01' AND '2000-01-01'")})
public class Pacjent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Size(max = 50)
    private String pesel;
    @Size(max = 50)
    private String imie;
    @Size(max = 50)
    private String nazwisko;
    @Size(max = 50)
    private String plec;
    @Size(max = 50)
    private String krew;
    @Temporal(TemporalType.DATE)
    private Date dataurodzenia;
    @Size(max = 50)
    private String telefon;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Nie porpawny E-mail ! Spróbuj jeszcze raz.")//if the field contains email address consider using this annotation to enforce field validation
    private String email;
    
    @OneToMany(mappedBy = "pacjent", cascade = {CascadeType.REMOVE})
    private List<Historiabadan> historiabadanList;
    
    @OneToMany(mappedBy = "pacjent", cascade = {CascadeType.REMOVE})
    private List<Wizyta> wizytaList;
    
    @OneToMany(mappedBy = "pacjent", cascade = {CascadeType.REMOVE})
    private List<Historialeczenia> historialeczeniaList;
    
    @JoinColumn(name = "adres", referencedColumnName = "id")
    @ManyToOne(cascade = {CascadeType.ALL})
    private Adres adres;    

    
    public Pacjent() {
        adres= new Adres();  
    }
    
    public void dodajHistorieLeczenia(Historialeczenia leczenie){        
        historialeczeniaList.add(leczenie);
        setHistorialeczeniaList(historialeczeniaList);        
    }
    
    public void dodajHistorieBadania(Historiabadan noweBadanie) {
        historiabadanList.add(noweBadanie);
        setHistoriabadanList(historiabadanList);
    }

    /*
     * Metody get i set 
     */
    public Pacjent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getKrew() {
        return krew;
    }

    public void setKrew(String krew) {
        this.krew = krew;
    }

    public Date getDataurodzenia() {
         System.out.println(new Date());
        return dataurodzenia;
    }

    public void setDataurodzenia(Date dataurodzenia) {
        System.out.println(new Date());
        this.dataurodzenia = dataurodzenia;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Historiabadan> getHistoriabadanList() {
        return historiabadanList;
    }

    public void setHistoriabadanList(List<Historiabadan> historiabadanList) {
        this.historiabadanList = historiabadanList;
    }

    @XmlTransient
    public Collection<Wizyta> getWizytaList() {
        return wizytaList;
    }

    public void setWizytaCollection(List<Wizyta> wizytaList) {
        this.wizytaList = wizytaList;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    @XmlTransient
    public List<Historialeczenia> getHistorialeczeniaList() {
        return historialeczeniaList;
    }

    public void setHistorialeczeniaList(List<Historialeczenia> historialeczeniaList) {
        this.historialeczeniaList = historialeczeniaList;
    }

    public int getWiek(){
       Date date = new Date();
       return date.compareTo(this.dataurodzenia);
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
        if (!(object instanceof Pacjent)) {
            return false;
        }
        Pacjent other = (Pacjent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "KlasyEncji.Pacjent[ id=" + id + " ]";
    }

   

    
}
