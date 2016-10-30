/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyEncji;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JAzz
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historialeczenia.findAll", query = "SELECT h FROM Historialeczenia h "),
    @NamedQuery(name = "Historialeczenia.findByFilters", query = "SELECT h FROM Historialeczenia h WHERE"
            + " h.pacjent.pesel = :pacjent")})
public class Historialeczenia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Lob
    @Size(max = 65535)
    private String objawy;
    @Lob
    @Size(max = 65535)
    private String leczenie;
    @Lob
    @Size(max = 65535)
    private String wnioski;
    @JoinColumn(name = "pacjent", referencedColumnName = "id")
    @ManyToOne
    private Pacjent pacjent;

    public Historialeczenia() {
    }

    public Historialeczenia(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObjawy() {
        return objawy;
    }

    public void setObjawy(String objawy) {
        this.objawy = objawy;
    }

    public String getLeczenie() {
        return leczenie;
    }

    public void setLeczenie(String leczenie) {
        this.leczenie = leczenie;
    }

    public String getWnioski() {
        return wnioski;
    }

    public void setWnioski(String wnioski) {
        this.wnioski = wnioski;
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
        if (!(object instanceof Historialeczenia)) {
            return false;
        }
        Historialeczenia other = (Historialeczenia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "KlasyEncji.Historialeczenia[ id=" + id + " ]";
    }
}
