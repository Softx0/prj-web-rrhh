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
@Table(name = "estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")
    , @NamedQuery(name = "Estado.findById", query = "SELECT e FROM Estado e WHERE e.id = :id")
    , @NamedQuery(name = "Estado.findByDescripcion", query = "SELECT e FROM Estado e WHERE e.descripcion = :descripcion")})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Long id;
    @Size(max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "estado")
    private Collection<Puestos> puestosCollection;
    @OneToMany(mappedBy = "estado")
    private Collection<Capacitaciones> capacitacionesCollection;
    @OneToMany(mappedBy = "estado")
    private Collection<Competencias> competenciasCollection;
    @OneToMany(mappedBy = "estado")
    private Collection<Idiomas> idiomasCollection;
    @OneToMany(mappedBy = "estado")
    private Collection<Empleado> empleadoCollection;
    @OneToMany(mappedBy = "estado")
    private Collection<NivelDeRiesgo> nivelDeRiesgoCollection;
    @OneToMany(mappedBy = "estado")
    private Collection<NivelAcademico> nivelAcademicoCollection;
    @OneToMany(mappedBy = "estado")
    private Collection<Departamento> departamentoCollection;

    public Estado() {
    }

    public Estado(Long id) {
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
    public Collection<Puestos> getPuestosCollection() {
        return puestosCollection;
    }

    public void setPuestosCollection(Collection<Puestos> puestosCollection) {
        this.puestosCollection = puestosCollection;
    }

    @XmlTransient
    public Collection<Capacitaciones> getCapacitacionesCollection() {
        return capacitacionesCollection;
    }

    public void setCapacitacionesCollection(Collection<Capacitaciones> capacitacionesCollection) {
        this.capacitacionesCollection = capacitacionesCollection;
    }

    @XmlTransient
    public Collection<Competencias> getCompetenciasCollection() {
        return competenciasCollection;
    }

    public void setCompetenciasCollection(Collection<Competencias> competenciasCollection) {
        this.competenciasCollection = competenciasCollection;
    }

    @XmlTransient
    public Collection<Idiomas> getIdiomasCollection() {
        return idiomasCollection;
    }

    public void setIdiomasCollection(Collection<Idiomas> idiomasCollection) {
        this.idiomasCollection = idiomasCollection;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @XmlTransient
    public Collection<NivelDeRiesgo> getNivelDeRiesgoCollection() {
        return nivelDeRiesgoCollection;
    }

    public void setNivelDeRiesgoCollection(Collection<NivelDeRiesgo> nivelDeRiesgoCollection) {
        this.nivelDeRiesgoCollection = nivelDeRiesgoCollection;
    }

    @XmlTransient
    public Collection<NivelAcademico> getNivelAcademicoCollection() {
        return nivelAcademicoCollection;
    }

    public void setNivelAcademicoCollection(Collection<NivelAcademico> nivelAcademicoCollection) {
        this.nivelAcademicoCollection = nivelAcademicoCollection;
    }

    @XmlTransient
    public Collection<Departamento> getDepartamentoCollection() {
        return departamentoCollection;
    }

    public void setDepartamentoCollection(Collection<Departamento> departamentoCollection) {
        this.departamentoCollection = departamentoCollection;
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
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
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
