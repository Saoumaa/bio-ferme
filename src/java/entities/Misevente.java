/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author momo
 */
@Entity
@Table(name = "misevente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Misevente.findAll", query = "SELECT m FROM Misevente m")
    , @NamedQuery(name = "Misevente.findByIdmv", query = "SELECT m FROM Misevente m WHERE m.idmv = :idmv")
    , @NamedQuery(name = "Misevente.findByIddmv", query = "SELECT m FROM Misevente m WHERE m.iddmv = :iddmv")
    , @NamedQuery(name = "Misevente.findByDatemv", query = "SELECT m FROM Misevente m WHERE m.datemv = :datemv")})
public class Misevente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmv")
    private Integer idmv;
    @Column(name = "iddmv")
    private Integer iddmv;
    @Column(name = "datemv")
    @Temporal(TemporalType.DATE)
    private Date datemv;
    @JoinColumn(name = "idp", referencedColumnName = "idp")
    @ManyToOne
    private Partenaire idp;

    public Misevente() {
    }

    public Misevente(Integer idmv) {
        this.idmv = idmv;
    }

    public Integer getIdmv() {
        return idmv;
    }

    public void setIdmv(Integer idmv) {
        this.idmv = idmv;
    }

    public Integer getIddmv() {
        return iddmv;
    }

    public void setIddmv(Integer iddmv) {
        this.iddmv = iddmv;
    }

    public Date getDatemv() {
        return datemv;
    }

    public void setDatemv(Date datemv) {
        this.datemv = datemv;
    }

    public Partenaire getIdp() {
        return idp;
    }

    public void setIdp(Partenaire idp) {
        this.idp = idp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmv != null ? idmv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Misevente)) {
            return false;
        }
        Misevente other = (Misevente) object;
        if ((this.idmv == null && other.idmv != null) || (this.idmv != null && !this.idmv.equals(other.idmv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Misevente[ idmv=" + idmv + " ]";
    }
    
}
