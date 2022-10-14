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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author momo
 */
@Entity
@Table(name = "mouvement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mouvement.findAll", query = "SELECT m FROM Mouvement m")
    , @NamedQuery(name = "Mouvement.findByIdm", query = "SELECT m FROM Mouvement m WHERE m.idm = :idm")
    , @NamedQuery(name = "Mouvement.findByQtem", query = "SELECT m FROM Mouvement m WHERE m.qtem = :qtem")
    , @NamedQuery(name = "Mouvement.findByLibellem", query = "SELECT m FROM Mouvement m WHERE m.libellem = :libellem")})
public class Mouvement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idm")
    private Integer idm;
    @Column(name = "qtem")
    private Integer qtem;
    @Size(max = 2147483647)
    @Column(name = "libellem")
    private String libellem;
    @OneToMany(mappedBy = "idm")
    private List<Detailsmouvement> detailsmouvementList;
    @JoinColumn(name = "idtm", referencedColumnName = "idtm")
    @ManyToOne
    private Typemouvement idtm;

    public Mouvement() {
    }

    public Mouvement(Integer idm) {
        this.idm = idm;
    }

    public Integer getIdm() {
        return idm;
    }

    public void setIdm(Integer idm) {
        this.idm = idm;
    }

    public Integer getQtem() {
        return qtem;
    }

    public void setQtem(Integer qtem) {
        this.qtem = qtem;
    }

    public String getLibellem() {
        return libellem;
    }

    public void setLibellem(String libellem) {
        this.libellem = libellem;
    }

    @XmlTransient
    public List<Detailsmouvement> getDetailsmouvementList() {
        return detailsmouvementList;
    }

    public void setDetailsmouvementList(List<Detailsmouvement> detailsmouvementList) {
        this.detailsmouvementList = detailsmouvementList;
    }

    public Typemouvement getIdtm() {
        return idtm;
    }

    public void setIdtm(Typemouvement idtm) {
        this.idtm = idtm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idm != null ? idm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mouvement)) {
            return false;
        }
        Mouvement other = (Mouvement) object;
        if ((this.idm == null && other.idm != null) || (this.idm != null && !this.idm.equals(other.idm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Mouvement[ idm=" + idm + " ]";
    }
    
}
