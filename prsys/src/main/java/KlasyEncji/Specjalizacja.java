/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KlasyEncji;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    @NamedQuery(name = "Specjalizacja.findAll", query = "SELECT s FROM Specjalizacja s"),
    @NamedQuery(name = "Specjalizacja.findByNazwa", query = "SELECT s FROM Specjalizacja s WHERE s.nazwa = :nazwa")})
public class Specjalizacja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Size(max = 50)
    private String nazwa;
    @OneToMany(mappedBy = "specjalizacja")
    private List<Pracownik> pracownikList;

    public Specjalizacja() {
    }

    public Specjalizacja(Integer id) {
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

    @XmlTransient
    public List<Pracownik> getPracownikList() {
        return pracownikList;
    }

    public void setPracownikCollection(List<Pracownik> pracownikList) {
        this.pracownikList = pracownikList;
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
        if (!(object instanceof Specjalizacja)) {
            return false;
        }
        Specjalizacja other = (Specjalizacja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "KlasyEncji.Specjalizacja[ id=" + id + " ]";
    }
    
}
