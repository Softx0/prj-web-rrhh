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
@Table(name = "puestos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puestos.findAll", query = "SELECT p FROM Puestos p")
    , @NamedQuery(name = "Puestos.findById", query = "SELECT p FROM Puestos p WHERE p.id = :id")
    , @NamedQuery(name = "Puestos.findByPuesto", query = "SELECT p FROM Puestos p WHERE p.puesto = :puesto")
    , @NamedQuery(name = "Puestos.findBySalarioMinimo", query = "SELECT p FROM Puestos p WHERE p.salarioMinimo = :salarioMinimo")
    , @NamedQuery(name = "Puestos.findBySalarioMaximo", query = "SELECT p FROM Puestos p WHERE p.salarioMaximo = :salarioMaximo")})
public class Puestos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Puesto")
    private String puesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Salario_Minimo")
    private double salarioMinimo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Salario_Maximo")
    private double salarioMaximo;
    @JoinColumn(name = "Departamento", referencedColumnName = "Id")
    @ManyToOne
    private Departamento departamento;
    @JoinColumn(name = "Nivel_de_Riesgo", referencedColumnName = "Id")
    @ManyToOne
    private NivelDeRiesgo niveldeRiesgo;
    @JoinColumn(name = "Estado", referencedColumnName = "Id")
    @ManyToOne
    private Estado estado;
    @OneToMany(mappedBy = "puestoAspira")
    private Collection<Candidatos> candidatosCollection;
    @OneToMany(mappedBy = "puesto")
    private Collection<Empleado> empleadoCollection;

    public Puestos() {
    }

    public Puestos(Long id) {
        this.id = id;
    }

    public Puestos(Long id, String puesto, double salarioMinimo, double salarioMaximo) {
        this.id = id;
        this.puesto = puesto;
        this.salarioMinimo = salarioMinimo;
        this.salarioMaximo = salarioMaximo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalarioMinimo() {
        return salarioMinimo;
    }

    public void setSalarioMinimo(double salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }

    public double getSalarioMaximo() {
        return salarioMaximo;
    }

    public void setSalarioMaximo(double salarioMaximo) {
        this.salarioMaximo = salarioMaximo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public NivelDeRiesgo getNiveldeRiesgo() {
        return niveldeRiesgo;
    }

    public void setNiveldeRiesgo(NivelDeRiesgo niveldeRiesgo) {
        this.niveldeRiesgo = niveldeRiesgo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Candidatos> getCandidatosCollection() {
        return candidatosCollection;
    }

    public void setCandidatosCollection(Collection<Candidatos> candidatosCollection) {
        this.candidatosCollection = candidatosCollection;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
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
        if (!(object instanceof Puestos)) {
            return false;
        }
        Puestos other = (Puestos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+puesto;
    }
    
}
