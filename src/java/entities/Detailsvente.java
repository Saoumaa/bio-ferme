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
@Table(name = "detailsvente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detailsvente.findAll", query = "SELECT d FROM Detailsvente d")
    , @NamedQuery(name = "Detailsvente.findByIddv", query = "SELECT d FROM Detailsvente d WHERE d.iddv = :iddv")
    , @NamedQuery(name = "Detailsvente.findByQtedv", query = "SELECT d FROM Detailsvente d WHERE d.qtedv = :qtedv")})
public class Detailsvente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddv")
    private Integer iddv;
    @Column(name = "qtedv")
    private Integer qtedv;
    @JoinColumn(name = "idv", referencedColumnName = "idv")
    @ManyToOne
    private Vente idv;
    @OneToMany(mappedBy = "iddv")
    private List<Detailslivraison> detailslivraisonList;

    public Detailsvente() {
    }

    public Detailsvente(Integer iddv) {
        this.iddv = iddv;
    }

    public Integer getIddv() {
        return iddv;
    }

    public void setIddv(Integer iddv) {
        this.iddv = iddv;
    }

    public Integer getQtedv() {
        return qtedv;
    }

    public void setQtedv(Integer qtedv) {
        this.qtedv = qtedv;
    }

    public Vente getIdv() {
        return idv;
    }

    public void setIdv(Vente idv) {
        this.idv = idv;
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
        hash += (iddv != null ? iddv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detailsvente)) {
            return false;
        }
        Detailsvente other = (Detailsvente) object;
        if ((this.iddv == null && other.iddv != null) || (this.iddv != null && !this.iddv.equals(other.iddv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Detailsvente[ iddv=" + iddv + " ]";
    }
    
}
