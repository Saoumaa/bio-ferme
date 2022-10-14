/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author momo
 */
@Entity
@Table(name = "livraison")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livraison.findAll", query = "SELECT l FROM Livraison l")
    , @NamedQuery(name = "Livraison.findByIdl", query = "SELECT l FROM Livraison l WHERE l.idl = :idl")
    , @NamedQuery(name = "Livraison.findByDatel", query = "SELECT l FROM Livraison l WHERE l.datel = :datel")})
public class Livraison implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idl")
    private Integer idl;
    @Column(name = "datel")
    @Temporal(TemporalType.DATE)
    private Date datel;
    @OneToMany(mappedBy = "idl")
    private List<Livreur> livreurList;
    @OneToMany(mappedBy = "idl")
    private List<Detailslivraison> detailslivraisonList;

    public Livraison() {
    }

    public Livraison(Integer idl) {
        this.idl = idl;
    }

    public Integer getIdl() {
        return idl;
    }

    public void setIdl(Integer idl) {
        this.idl = idl;
    }

    public Date getDatel() {
        return datel;
    }

    public void setDatel(Date datel) {
        this.datel = datel;
    }

    @XmlTransient
    public List<Livreur> getLivreurList() {
        return livreurList;
    }

    public void setLivreurList(List<Livreur> livreurList) {
        this.livreurList = livreurList;
    }

    @XmlTransient
    public List<Detailslivraison> getDetailslivraisonList() {
        return detailslivraisonList;
    }

    public void setDetailslivraisonList(List<Detailslivraison> detailslivraisonList) {
        this.detailslivraisonList = detailslivraisonList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idl != null ? idl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livraison)) {
            return false;
        }
        Livraison other = (Livraison) object;
        if ((this.idl == null && other.idl != null) || (this.idl != null && !this.idl.equals(other.idl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Livraison[ idl=" + idl + " ]";
    }
    
}
