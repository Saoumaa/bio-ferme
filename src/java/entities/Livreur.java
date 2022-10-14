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
@Table(name = "livreur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livreur.findAll", query = "SELECT l FROM Livreur l")
    , @NamedQuery(name = "Livreur.findByIdli", query = "SELECT l FROM Livreur l WHERE l.idli = :idli")})
public class Livreur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idli")
    private Integer idli;
    @JoinColumn(name = "idl", referencedColumnName = "idl")
    @ManyToOne
    private Livraison idl;
    @JoinColumn(name = "idp", referencedColumnName = "idp")
    @ManyToOne
    private Partenaire idp;

    public Livreur() {
    }

    public Livreur(Integer idli) {
        this.idli = idli;
    }

    public Integer getIdli() {
        return idli;
    }

    public void setIdli(Integer idli) {
        this.idli = idli;
    }

    public Livraison getIdl() {
        return idl;
    }

    public void setIdl(Livraison idl) {
        this.idl = idl;
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
        hash += (idli != null ? idli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livreur)) {
            return false;
        }
        Livreur other = (Livreur) object;
        if ((this.idli == null && other.idli != null) || (this.idli != null && !this.idli.equals(other.idli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Livreur[ idli=" + idli + " ]";
    }
    
}
