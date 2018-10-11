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
@Table(name = "candidatos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidatos.findAll", query = "SELECT c FROM Candidatos c")
    , @NamedQuery(name = "Candidatos.findById", query = "SELECT c FROM Candidatos c WHERE c.id = :id")
    , @NamedQuery(name = "Candidatos.findByCedula", query = "SELECT c FROM Candidatos c WHERE c.cedula = :cedula")
    , @NamedQuery(name = "Candidatos.findByNombre", query = "SELECT c FROM Candidatos c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Candidatos.findBySalarioAspira", query = "SELECT c FROM Candidatos c WHERE c.salarioAspira = :salarioAspira")
    , @NamedQuery(name = "Candidatos.findByRecomendadoPor", query = "SELECT c FROM Candidatos c WHERE c.recomendadoPor = :recomendadoPor")})
public class Candidatos implements Serializable {

    
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "Cedula")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Salario_Aspira")
    private double salarioAspira;
    @Size(max = 80)
    @Column(name = "Recomendado_Por")
    private String recomendadoPor;
    @JoinColumn(name = "Puesto_Aspira", referencedColumnName = "Id")
    @ManyToOne
    private Puestos puestoAspira;
    @JoinColumn(name = "Competencias", referencedColumnName = "Id")
    @ManyToOne
    private Competencias competencias;
    @JoinColumn(name = "Capacitaciones", referencedColumnName = "Id")
    @ManyToOne
    private Capacitaciones capacitaciones;
    @JoinColumn(name = "Idiomas", referencedColumnName = "Id")
    @ManyToOne
    private Idiomas idiomas;
    @JoinColumn(name = "Experiencia_Laboral", referencedColumnName = "Id")
    @ManyToOne
    private ExperienciaLaboral experienciaLaboral;
    @JoinColumn(name = "Estado_Candidato", referencedColumnName = "Id")
    @ManyToOne
    private EstadoCandidato estadoCandidato;
    @OneToMany(mappedBy = "candidato")
    private Collection<Empleado> empleadoCollection;

    public Candidatos() {
    }

    public Candidatos(Long id) {
        this.id = id;
    }

    public Candidatos(Long id, String cedula, String nombre, double salarioAspira) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.salarioAspira = salarioAspira;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalarioAspira() {
        return salarioAspira;
    }

    public void setSalarioAspira(double salarioAspira) {
        this.salarioAspira = salarioAspira;
    }

    public String getRecomendadoPor() {
        return recomendadoPor;
    }

    public void setRecomendadoPor(String recomendadoPor) {
        this.recomendadoPor = recomendadoPor;
    }

    public Puestos getPuestoAspira() {
        return puestoAspira;
    }

    public void setPuestoAspira(Puestos puestoAspira) {
        this.puestoAspira = puestoAspira;
    }

    public Competencias getCompetencias() {
        return competencias;
    }

    public void setCompetencias(Competencias competencias) {
        this.competencias = competencias;
    }

    public Capacitaciones getCapacitaciones() {
        return capacitaciones;
    }

    public void setCapacitaciones(Capacitaciones capacitaciones) {
        this.capacitaciones = capacitaciones;
    }

    public Idiomas getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(Idiomas idiomas) {
        this.idiomas = idiomas;
    }

    public ExperienciaLaboral getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(ExperienciaLaboral experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public EstadoCandidato getEstadoCandidato() {
        return estadoCandidato;
    }

    public void setEstadoCandidato(EstadoCandidato estadoCandidato) {
        this.estadoCandidato = estadoCandidato;
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
        if (!(object instanceof Candidatos)) {
            return false;
        }
        Candidatos other = (Candidatos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+nombre;
    }
    //
}
