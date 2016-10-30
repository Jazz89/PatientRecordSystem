/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyEncji;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JAzz
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wizyta.findAll", query = "SELECT w FROM Wizyta w"),
    @NamedQuery(name = "Wizyta.findById", query = "SELECT w FROM Wizyta w WHERE w.id = :id"),
    @NamedQuery(name = "Wizyta.findByDatawizyty", query = "SELECT w FROM Wizyta w WHERE w.datawizyty = :datawizyty"),
    @NamedQuery(name = "Wizyta.findByFilters", query = "SELECT w FROM Wizyta w WHERE"
            + " w.pacjent.pesel LIKE :pesel and"
            + " w.pracownik.email LIKE :email")})
public class Wizyta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "datawizyty")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date datawizyty;
    @JoinColumn(name = "pracownik", referencedColumnName = "id")
    @ManyToOne
    private Pracownik pracownik;
    @JoinColumn(name = "pokoj", referencedColumnName = "id")
    @ManyToOne
    private Pokoj pokoj;
    @JoinColumn(name = "pacjent", referencedColumnName = "id")
    @ManyToOne
    private Pacjent pacjent;

    public Wizyta() {  
    }

    public Wizyta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatawizyty() {
        System.out.println("GetWizyta: "+ datawizyty);
        return datawizyty;
    }

    public void setDatawizyty(Date datawizyty) {
        System.out.println("SetWizyta: "+ datawizyty);
        this.datawizyty = datawizyty;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public Pokoj getPokoj() {
        return pokoj;
    }

    public void setPokoj(Pokoj pokoj) {
        this.pokoj = pokoj;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
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
        if (!(object instanceof Wizyta)) {
            return false;
        }
        Wizyta other = (Wizyta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "KlasyEncji.Wizyta[ id=" + id + " ]";
    }
    
}
