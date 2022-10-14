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
@Table(name = "detailslivraison")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detailslivraison.findAll", query = "SELECT d FROM Detailslivraison d")
    , @NamedQuery(name = "Detailslivraison.findByIddl", query = "SELECT d FROM Detailslivraison d WHERE d.iddl = :iddl")})
public class Detailslivraison implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddl")
    private Integer iddl;
    @JoinColumn(name = "iddv", referencedColumnName = "iddv")
    @ManyToOne
    private Detailsvente iddv;
    @JoinColumn(name = "idl", referencedColumnName = "idl")
    @ManyToOne
    private Livraison idl;

    public Detailslivraison() {
    }

    public Detailslivraison(Integer iddl) {
        this.iddl = iddl;
    }

    public Integer getIddl() {
        return iddl;
    }

    public void setIddl(Integer iddl) {
        this.iddl = iddl;
    }

    public Detailsvente getIddv() {
        return iddv;
    }

    public void setIddv(Detailsvente iddv) {
        this.iddv = iddv;
    }

    public Livraison getIdl() {
        return idl;
    }

    public void setIdl(Livraison idl) {
        this.idl = idl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddl != null ? iddl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detailslivraison)) {
            return false;
        }
        Detailslivraison other = (Detailslivraison) object;
        if ((this.iddl == null && other.iddl != null) || (this.iddl != null && !this.iddl.equals(other.iddl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Detailslivraison[ iddl=" + iddl + " ]";
    }
    
}
