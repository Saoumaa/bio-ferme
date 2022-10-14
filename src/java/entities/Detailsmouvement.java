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
@Table(name = "detailsmouvement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detailsmouvement.findAll", query = "SELECT d FROM Detailsmouvement d")
    , @NamedQuery(name = "Detailsmouvement.findByIdDm", query = "SELECT d FROM Detailsmouvement d WHERE d.idDm = :idDm")})
public class Detailsmouvement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dm")
    private Integer idDm;
    @JoinColumn(name = "idart", referencedColumnName = "idart")
    @ManyToOne
    private Article idart;
    @JoinColumn(name = "idm", referencedColumnName = "idm")
    @ManyToOne
    private Mouvement idm;

    public Detailsmouvement() {
    }

    public Detailsmouvement(Integer idDm) {
        this.idDm = idDm;
    }

    public Integer getIdDm() {
        return idDm;
    }

    public void setIdDm(Integer idDm) {
        this.idDm = idDm;
    }

    public Article getIdart() {
        return idart;
    }

    public void setIdart(Article idart) {
        this.idart = idart;
    }

    public Mouvement getIdm() {
        return idm;
    }

    public void setIdm(Mouvement idm) {
        this.idm = idm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDm != null ? idDm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detailsmouvement)) {
            return false;
        }
        Detailsmouvement other = (Detailsmouvement) object;
        if ((this.idDm == null && other.idDm != null) || (this.idDm != null && !this.idDm.equals(other.idDm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Detailsmouvement[ idDm=" + idDm + " ]";
    }
    
}
