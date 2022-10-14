/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author momo
 */
@Entity
@Table(name = "vente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vente.findAll", query = "SELECT v FROM Vente v")
    , @NamedQuery(name = "Vente.findByIdv", query = "SELECT v FROM Vente v WHERE v.idv = :idv")
    , @NamedQuery(name = "Vente.findByLibellev", query = "SELECT v FROM Vente v WHERE v.libellev = :libellev")})
public class Vente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idv")
    private Integer idv;
    @Size(max = 2147483647)
    @Column(name = "libellev")
    private String libellev;
    @OneToMany(mappedBy = "idv")
    private List<Detailsvente> detailsventeList;

    public Vente() {
    }

    public Vente(Integer idv) {
        this.idv = idv;
    }

    public Integer getIdv() {
        return idv;
    }

    public void setIdv(Integer idv) {
        this.idv = idv;
    }

    public String getLibellev() {
        return libellev;
    }

    public void setLibellev(String libellev) {
        this.libellev = libellev;
    }

    @XmlTransient
    public List<Detailsvente> getDetailsventeList() {
        return detailsventeList;
    }

    public void setDetailsventeList(List<Detailsvente> detailsventeList) {
        this.detailsventeList = detailsventeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idv != null ? idv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vente)) {
            return false;
        }
        Vente other = (Vente) object;
        if ((this.idv == null && other.idv != null) || (this.idv != null && !this.idv.equals(other.idv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Vente[ idv=" + idv + " ]";
    }
    
}
