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
@Table(name = "article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a")
    , @NamedQuery(name = "Article.findByIdart", query = "SELECT a FROM Article a WHERE a.idart = :idart")
    , @NamedQuery(name = "Article.findByLibellear", query = "SELECT a FROM Article a WHERE a.libellear = :libellear")
    , @NamedQuery(name = "Article.findBySexe", query = "SELECT a FROM Article a WHERE a.sexe = :sexe")
    , @NamedQuery(name = "Article.findByAge", query = "SELECT a FROM Article a WHERE a.age = :age")
    , @NamedQuery(name = "Article.findByPoids", query = "SELECT a FROM Article a WHERE a.poids = :poids")})
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idart")
    private Integer idart;
    @Size(max = 2147483647)
    @Column(name = "libellear")
    private String libellear;
    @Size(max = 2147483647)
    @Column(name = "sexe")
    private String sexe;
    @Column(name = "age")
    private Integer age;
    @Column(name = "poids")
    private Integer poids;
    @JoinColumn(name = "idcat", referencedColumnName = "idcat")
    @ManyToOne
    private Categorie idcat;
    @JoinColumn(name = "idtype", referencedColumnName = "idtype")
    @ManyToOne
    private Typee idtype;
    @OneToMany(mappedBy = "idart")
    private List<Detailsmisevente> detailsmiseventeList;
    @OneToMany(mappedBy = "idart")
    private List<Detailsmouvement> detailsmouvementList;

    public Article() {
    }

    public Article(Integer idart) {
        this.idart = idart;
    }

    public Integer getIdart() {
        return idart;
    }

    public void setIdart(Integer idart) {
        this.idart = idart;
    }

    public String getLibellear() {
        return libellear;
    }

    public void setLibellear(String libellear) {
        this.libellear = libellear;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    public Categorie getIdcat() {
        return idcat;
    }

    public void setIdcat(Categorie idcat) {
        this.idcat = idcat;
    }

    public Typee getIdtype() {
        return idtype;
    }

    public void setIdtype(Typee idtype) {
        this.idtype = idtype;
    }

    @XmlTransient
    public List<Detailsmisevente> getDetailsmiseventeList() {
        return detailsmiseventeList;
    }

    public void setDetailsmiseventeList(List<Detailsmisevente> detailsmiseventeList) {
        this.detailsmiseventeList = detailsmiseventeList;
    }

    @XmlTransient
    public List<Detailsmouvement> getDetailsmouvementList() {
        return detailsmouvementList;
    }

    public void setDetailsmouvementList(List<Detailsmouvement> detailsmouvementList) {
        this.detailsmouvementList = detailsmouvementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idart != null ? idart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.idart == null && other.idart != null) || (this.idart != null && !this.idart.equals(other.idart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Article[ idart=" + idart + " ]";
    }
    
}
