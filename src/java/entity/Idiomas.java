/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author DELL
 */
@Entity
@Table(name = "idiomas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Idiomas.findAll", query = "SELECT i FROM Idiomas i")
    , @NamedQuery(name = "Idiomas.findById", query = "SELECT i FROM Idiomas i WHERE i.id = :id")
    , @NamedQuery(name = "Idiomas.findByIdioma", query = "SELECT i FROM Idiomas i WHERE i.idioma = :idioma")})
public class Idiomas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Idioma")
    private String idioma;
    @OneToMany(mappedBy = "idiomas")
    private Collection<Candidatos> candidatosCollection;
    @JoinColumn(name = "Estado", referencedColumnName = "Id")
    @ManyToOne
    private Estado estado;

    public Idiomas() {
    }

    public Idiomas(Long id) {
        this.id = id;
    }

    public Idiomas(Long id, String idioma) {
        this.id = id;
        this.idioma = idioma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @XmlTransient
    public Collection<Candidatos> getCandidatosCollection() {
        return candidatosCollection;
    }

    public void setCandidatosCollection(Collection<Candidatos> candidatosCollection) {
        this.candidatosCollection = candidatosCollection;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Idiomas)) {
            return false;
        }
        Idiomas other = (Idiomas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+idioma;
    }
    
}
