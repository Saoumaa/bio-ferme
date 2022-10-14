/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author momo
 */
@Entity
@Table(name = "detailscommande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detailscommande.findAll", query = "SELECT d FROM Detailscommande d")
    , @NamedQuery(name = "Detailscommande.findByIddc", query = "SELECT d FROM Detailscommande d WHERE d.iddc = :iddc")
    , @NamedQuery(name = "Detailscommande.findByQtedc", query = "SELECT d FROM Detailscommande d WHERE d.qtedc = :qtedc")})
public class Detailscommande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddc")
    private Integer iddc;
    @Column(name = "qtedc")
    private Integer qtedc;
    @JoinColumn(name = "idc", referencedColumnName = "idc")
    @ManyToOne
    private Commande idc;
    @JoinColumn(name = "iddmv", referencedColumnName = "iddmv")
    @ManyToOne
    private Detailsmisevente iddmv;

    public Detailscommande() {
    }

    public Detailscommande(Integer iddc) {
        this.iddc = iddc;
    }

    public Integer getIddc() {
        return iddc;
    }

    public void setIddc(Integer iddc) {
        this.iddc = iddc;
    }

    public Integer getQtedc() {
        return qtedc;
    }

    public void setQtedc(Integer qtedc) {
        this.qtedc = qtedc;
    }

    public Commande getIdc() {
        return idc;
    }

    public void setIdc(Commande idc) {
        this.idc = idc;
    }

    public Detailsmisevente getIddmv() {
        return iddmv;
    }

    public void setIddmv(Detailsmisevente iddmv) {
        this.iddmv = iddmv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddc != null ? iddc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detailscommande)) {
            return false;
        }
        Detailscommande other = (Detailscommande) object;
        if ((this.iddc == null && other.iddc != null) || (this.iddc != null && !this.iddc.equals(other.iddc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Detailscommande[ iddc=" + iddc + " ]";
    }
    
}
