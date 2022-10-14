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
@Table(name = "typemouvement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typemouvement.findAll", query = "SELECT t FROM Typemouvement t")
    , @NamedQuery(name = "Typemouvement.findByIdtm", query = "SELECT t FROM Typemouvement t WHERE t.idtm = :idtm")
    , @NamedQuery(name = "Typemouvement.findByLibelletm", query = "SELECT t FROM Typemouvement t WHERE t.libelletm = :libelletm")})
public class Typemouvement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtm")
    private Integer idtm;
    @Size(max = 2147483647)
    @Column(name = "libelletm")
    private String libelletm;
    @OneToMany(mappedBy = "idtm")
    private List<Mouvement> mouvementList;

    public Typemouvement() {
    }

    public Typemouvement(Integer idtm) {
        this.idtm = idtm;
    }

    public Integer getIdtm() {
        return idtm;
    }

    public void setIdtm(Integer idtm) {
        this.idtm = idtm;
    }

    public String getLibelletm() {
        return libelletm;
    }

    public void setLibelletm(String libelletm) {
        this.libelletm = libelletm;
    }

    @XmlTransient
    public List<Mouvement> getMouvementList() {
        return mouvementList;
    }

    public void setMouvementList(List<Mouvement> mouvementList) {
        this.mouvementList = mouvementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtm != null ? idtm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typemouvement)) {
            return false;
        }
        Typemouvement other = (Typemouvement) object;
        if ((this.idtm == null && other.idtm != null) || (this.idtm != null && !this.idtm.equals(other.idtm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Typemouvement[ idtm=" + idtm + " ]";
    }
    
}
