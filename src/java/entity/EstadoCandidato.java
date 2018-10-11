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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "estado_candidato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCandidato.findAll", query = "SELECT e FROM EstadoCandidato e")
    , @NamedQuery(name = "EstadoCandidato.findById", query = "SELECT e FROM EstadoCandidato e WHERE e.id = :id")
    , @NamedQuery(name = "EstadoCandidato.findByDescripcion", query = "SELECT e FROM EstadoCandidato e WHERE e.descripcion = :descripcion")})
public class EstadoCandidato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Long id;
    @Size(max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "estadoCandidato")
    private Collection<Candidatos> candidatosCollection;

    public EstadoCandidato() {
    }

    public EstadoCandidato(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Candidatos> getCandidatosCollection() {
        return candidatosCollection;
    }

    public void setCandidatosCollection(Collection<Candidatos> candidatosCollection) {
        this.candidatosCollection = candidatosCollection;
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
        if (!(object instanceof EstadoCandidato)) {
            return false;
        }
        EstadoCandidato other = (EstadoCandidato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+descripcion;
    }
    
}
