/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyEncji;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JAzz
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historiabadan.findAll", query = "SELECT h FROM Historiabadan h "),
    @NamedQuery(name = "Historiabadan.findByFilters", query = "SELECT h FROM Historiabadan h WHERE"
            + " h.pacjent.pesel = :pesel and"
            + " h.nazwa LIKE :nazwa")})
public class Historiabadan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Size(max = 50)
    private String nazwa;
    @Lob
    @Size(max = 65535)
    private String wyniki;
    @Temporal(TemporalType.DATE)
    private Date databadan;
    @JoinColumn(name = "pacjent", referencedColumnName = "id")
    @ManyToOne
    private Pacjent pacjent;

    public Historiabadan() {
    }

    public Historiabadan(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getWyniki() {
        return wyniki;
    }

    public void setWyniki(String wyniki) {
        this.wyniki = wyniki;
    }

    public Date getDatabadan() {
        return databadan;
    }

    public void setDatabadan(Date databadan) {
        this.databadan = databadan;
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
        if (!(object instanceof Historiabadan)) {
            return false;
        }
        Historiabadan other = (Historiabadan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "KlasyEncji.Historiabadan[ id=" + id + " ]";
    }
    
}
