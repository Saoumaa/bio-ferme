/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author momo
 */
@Entity
@Table(name = "partenaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partenaire.findAll", query = "SELECT p FROM Partenaire p")
    , @NamedQuery(name = "Partenaire.findByIdp", query = "SELECT p FROM Partenaire p WHERE p.idp = :idp")
    , @NamedQuery(name = "Partenaire.findByNom", query = "SELECT p FROM Partenaire p WHERE p.nom = :nom")
    , @NamedQuery(name = "Partenaire.findByPrenom", query = "SELECT p FROM Partenaire p WHERE p.prenom = :prenom")
    , @NamedQuery(name = "Partenaire.findByTelephone", query = "SELECT p FROM Partenaire p WHERE p.telephone = :telephone")
    , @NamedQuery(name = "Partenaire.findByEmail", query = "SELECT p FROM Partenaire p WHERE p.email = :email")
    , @NamedQuery(name = "Partenaire.findByDatenai", query = "SELECT p FROM Partenaire p WHERE p.datenai = :datenai")
    , @NamedQuery(name = "Partenaire.findByPass", query = "SELECT p FROM Partenaire p WHERE p.pass = :pass")})
public class Partenaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idp")
    private Integer idp;
    @Size(max = 2147483647)
    @Column(name = "nom")
    private String nom;
    @Size(max = 2147483647)
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "telephone")
    private BigInteger telephone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "email")
    private String email;
    @Column(name = "datenai")
    @Temporal(TemporalType.DATE)
    private Date datenai;
    @Size(max = 2147483647)
    @Column(name = "pass")
    private String pass;
    @JoinColumn(name = "idtp", referencedColumnName = "idtp")
    @ManyToOne
    private Typepartenaire idtp;
    @OneToMany(mappedBy = "idp")
    private List<Livreur> livreurList;
    @OneToMany(mappedBy = "idp")
    private List<Commande> commandeList;
    @OneToMany(mappedBy = "idp")
    private List<Misevente> miseventeList;

    public Partenaire() {
    }

    public Partenaire(Integer idp) {
        this.idp = idp;
    }

    public Integer getIdp() {
        return idp;
    }

    public void setIdp(Integer idp) {
        this.idp = idp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public BigInteger getTelephone() {
        return telephone;
    }

    public void setTelephone(BigInteger telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatenai() {
        return datenai;
    }

    public void setDatenai(Date datenai) {
        this.datenai = datenai;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Typepartenaire getIdtp() {
        return idtp;
    }

    public void setIdtp(Typepartenaire idtp) {
        this.idtp = idtp;
    }

    @XmlTransient
    public List<Livreur> getLivreurList() {
        return livreurList;
    }

    public void setLivreurList(List<Livreur> livreurList) {
        this.livreurList = livreurList;
    }

    @XmlTransient
    public List<Commande> getCommandeList() {
        return commandeList;
    }

    public void setCommandeList(List<Commande> commandeList) {
        this.commandeList = commandeList;
    }

    @XmlTransient
    public List<Misevente> getMiseventeList() {
        return miseventeList;
    }

    public void setMiseventeList(List<Misevente> miseventeList) {
        this.miseventeList = miseventeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idp != null ? idp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partenaire)) {
            return false;
        }
        Partenaire other = (Partenaire) object;
        if ((this.idp == null && other.idp != null) || (this.idp != null && !this.idp.equals(other.idp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Partenaire[ idp=" + idp + " ]";
    }
    
}
