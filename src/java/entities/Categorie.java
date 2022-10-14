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
@Table(name = "categorie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorie.findAll", query = "SELECT c FROM Categorie c")
    , @NamedQuery(name = "Categorie.findByIdcat", query = "SELECT c FROM Categorie c WHERE c.idcat = :idcat")
    , @NamedQuery(name = "Categorie.findByLibellecat", query = "SELECT c FROM Categorie c WHERE c.libellecat = :libellecat")})
public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcat")
    private Integer idcat;
    @Size(max = 2147483647)
    @Column(name = "libellecat")
    private String libellecat;
    @OneToMany(mappedBy = "idcat")
    private List<Article> articleList;

    public Categorie() {
    }

    public Categorie(Integer idcat) {
        this.idcat = idcat;
    }

    public Integer getIdcat() {
        return idcat;
    }

    public void setIdcat(Integer idcat) {
        this.idcat = idcat;
    }

    public String getLibellecat() {
        return libellecat;
    }

    public void setLibellecat(String libellecat) {
        this.libellecat = libellecat;
    }

    @XmlTransient
    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcat != null ? idcat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.idcat == null && other.idcat != null) || (this.idcat != null && !this.idcat.equals(other.idcat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Categorie[ idcat=" + idcat + " ]";
    }
    
}
