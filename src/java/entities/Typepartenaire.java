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
@Table(name = "typepartenaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typepartenaire.findAll", query = "SELECT t FROM Typepartenaire t")
    , @NamedQuery(name = "Typepartenaire.findByIdtp", query = "SELECT t FROM Typepartenaire t WHERE t.idtp = :idtp")
    , @NamedQuery(name = "Typepartenaire.findByLibelletp", query = "SELECT t FROM Typepartenaire t WHERE t.libelletp = :libelletp")})
public class Typepartenaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtp")
    private Integer idtp;
    @Size(max = 2147483647)
    @Column(name = "libelletp")
    private String libelletp;
    @OneToMany(mappedBy = "idtp")
    private List<Partenaire> partenaireList;

    public Typepartenaire() {
    }

    public Typepartenaire(Integer idtp) {
        this.idtp = idtp;
    }

    public Integer getIdtp() {
        return idtp;
    }

    public void setIdtp(Integer idtp) {
        this.idtp = idtp;
    }

    public String getLibelletp() {
        return libelletp;
    }

    public void setLibelletp(String libelletp) {
        this.libelletp = libelletp;
    }

    @XmlTransient
    public List<Partenaire> getPartenaireList() {
        return partenaireList;
    }

    public void setPartenaireList(List<Partenaire> partenaireList) {
        this.partenaireList = partenaireList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtp != null ? idtp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typepartenaire)) {
            return false;
        }
        Typepartenaire other = (Typepartenaire) object;
        if ((this.idtp == null && other.idtp != null) || (this.idtp != null && !this.idtp.equals(other.idtp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Typepartenaire[ idtp=" + idtp + " ]";
    }
    
}
