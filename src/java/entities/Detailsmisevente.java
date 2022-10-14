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
@Table(name = "detailsmisevente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detailsmisevente.findAll", query = "SELECT d FROM Detailsmisevente d")
    , @NamedQuery(name = "Detailsmisevente.findByIddmv", query = "SELECT d FROM Detailsmisevente d WHERE d.iddmv = :iddmv")
    , @NamedQuery(name = "Detailsmisevente.findByQtmv", query = "SELECT d FROM Detailsmisevente d WHERE d.qtmv = :qtmv")})
public class Detailsmisevente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddmv")
    private Integer iddmv;
    @Column(name = "qtmv")
    private Integer qtmv;
    @JoinColumn(name = "idart", referencedColumnName = "idart")
    @ManyToOne
    private Article idart;
    @OneToMany(mappedBy = "iddmv")
    private List<Detailscommande> detailscommandeList;

    public Detailsmisevente() {
    }

    public Detailsmisevente(Integer iddmv) {
        this.iddmv = iddmv;
    }

    public Integer getIddmv() {
        return iddmv;
    }

    public void setIddmv(Integer iddmv) {
        this.iddmv = iddmv;
    }

    public Integer getQtmv() {
        return qtmv;
    }

    public void setQtmv(Integer qtmv) {
        this.qtmv = qtmv;
    }

    public Article getIdart() {
        return idart;
    }

    public void setIdart(Article idart) {
        this.idart = idart;
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
        hash += (iddmv != null ? iddmv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detailsmisevente)) {
            return false;
        }
        Detailsmisevente other = (Detailsmisevente) object;
        if ((this.iddmv == null && other.iddmv != null) || (this.iddmv != null && !this.iddmv.equals(other.iddmv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Detailsmisevente[ iddmv=" + iddmv + " ]";
    }
    
}
