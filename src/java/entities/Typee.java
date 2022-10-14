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
@Table(name = "typee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typee.findAll", query = "SELECT t FROM Typee t")
    , @NamedQuery(name = "Typee.findByIdtype", query = "SELECT t FROM Typee t WHERE t.idtype = :idtype")
    , @NamedQuery(name = "Typee.findByLibelletype", query = "SELECT t FROM Typee t WHERE t.libelletype = :libelletype")})
public class Typee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtype")
    private Integer idtype;
    @Size(max = 2147483647)
    @Column(name = "libelletype")
    private String libelletype;
    @OneToMany(mappedBy = "idtype")
    private List<Article> articleList;

    public Typee() {
    }

    public Typee(Integer idtype) {
        this.idtype = idtype;
    }

    public Integer getIdtype() {
        return idtype;
    }

    public void setIdtype(Integer idtype) {
        this.idtype = idtype;
    }

    public String getLibelletype() {
        return libelletype;
    }

    public void setLibelletype(String libelletype) {
        this.libelletype = libelletype;
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
        hash += (idtype != null ? idtype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typee)) {
            return false;
        }
        Typee other = (Typee) object;
        if ((this.idtype == null && other.idtype != null) || (this.idtype != null && !this.idtype.equals(other.idtype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Typee[ idtype=" + idtype + " ]";
    }
    
}
