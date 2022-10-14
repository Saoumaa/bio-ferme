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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author momo
 */
@Entity
@Table(name = "commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c")
    , @NamedQuery(name = "Commande.findByIdc", query = "SELECT c FROM Commande c WHERE c.idc = :idc")
    , @NamedQuery(name = "Commande.findByQtc", query = "SELECT c FROM Commande c WHERE c.qtc = :qtc")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idc")
    private Integer idc;
    @Column(name = "qtc")
    private Integer qtc;
    @JoinColumn(name = "idp", referencedColumnName = "idp")
    @ManyToOne
    private Partenaire idp;
    @OneToMany(mappedBy = "idc")
    private List<Detailscommande> detailscommandeList;

    public Commande() {
    }

    public Commande(Integer idc) {
        this.idc = idc;
    }

    public Integer getIdc() {
        return idc;
    }

    public void setIdc(Integer idc) {
        this.idc = idc;
    }

    public Integer getQtc() {
        return qtc;
    }

    public void setQtc(Integer qtc) {
        this.qtc = qtc;
    }

    public Partenaire getIdp() {
        return idp;
    }

    public void setIdp(Partenaire idp) {
        this.idp = idp;
    }

    @XmlTransient
    public List<Detailscommande> getDetailscommandeList() {
        return detailscommandeList;
    }

    public void setDetailscommandeList(List<Detailscommande> detailscommandeList) {
        this.detailscommandeList = detailscommandeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idc != null ? idc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.idc == null && other.idc != null) || (this.idc != null && !this.idc.equals(other.idc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Commande[ idc=" + idc + " ]";
    }
    
}
