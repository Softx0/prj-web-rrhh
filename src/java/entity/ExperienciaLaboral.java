/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "experiencia_laboral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExperienciaLaboral.findAll", query = "SELECT e FROM ExperienciaLaboral e")
    , @NamedQuery(name = "ExperienciaLaboral.findById", query = "SELECT e FROM ExperienciaLaboral e WHERE e.id = :id")
    , @NamedQuery(name = "ExperienciaLaboral.findByEmpresa", query = "SELECT e FROM ExperienciaLaboral e WHERE e.empresa = :empresa")
    , @NamedQuery(name = "ExperienciaLaboral.findByPuestoOcupado", query = "SELECT e FROM ExperienciaLaboral e WHERE e.puestoOcupado = :puestoOcupado")
    , @NamedQuery(name = "ExperienciaLaboral.findByFechaDesde", query = "SELECT e FROM ExperienciaLaboral e WHERE e.fechaDesde = :fechaDesde")
    , @NamedQuery(name = "ExperienciaLaboral.findByFechaHasta", query = "SELECT e FROM ExperienciaLaboral e WHERE e.fechaHasta = :fechaHasta")
    , @NamedQuery(name = "ExperienciaLaboral.findBySalario", query = "SELECT e FROM ExperienciaLaboral e WHERE e.salario = :salario")})
public class ExperienciaLaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Empresa")
    private String empresa;
    @Size(max = 100)
    @Column(name = "Puesto_Ocupado")
    private String puestoOcupado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Desde")
    @Temporal(TemporalType.DATE)
    private Date fechaDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Hasta")
    @Temporal(TemporalType.DATE)
    private Date fechaHasta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Salario")
    private double salario;
    @OneToMany(mappedBy = "experienciaLaboral")
    private Collection<Candidatos> candidatosCollection;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(Long id) {
        this.id = id;
    }

    public ExperienciaLaboral(Long id, String empresa, Date fechaDesde, Date fechaHasta, double salario) {
        this.id = id;
        this.empresa = empresa;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPuestoOcupado() {
        return puestoOcupado;
    }

    public void setPuestoOcupado(String puestoOcupado) {
        this.puestoOcupado = puestoOcupado;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
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
        if (!(object instanceof ExperienciaLaboral)) {
            return false;
        }
        ExperienciaLaboral other = (ExperienciaLaboral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+puestoOcupado;
    }
    
}
