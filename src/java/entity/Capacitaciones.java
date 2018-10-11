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
 * @author DELL
 */
@Entity
@Table(name = "capacitaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capacitaciones.findAll", query = "SELECT c FROM Capacitaciones c")
    , @NamedQuery(name = "Capacitaciones.findById", query = "SELECT c FROM Capacitaciones c WHERE c.id = :id")
    , @NamedQuery(name = "Capacitaciones.findByTitulo", query = "SELECT c FROM Capacitaciones c WHERE c.titulo = :titulo")
    , @NamedQuery(name = "Capacitaciones.findByFechaDesde", query = "SELECT c FROM Capacitaciones c WHERE c.fechaDesde = :fechaDesde")
    , @NamedQuery(name = "Capacitaciones.findByFechaHasta", query = "SELECT c FROM Capacitaciones c WHERE c.fechaHasta = :fechaHasta")
    , @NamedQuery(name = "Capacitaciones.findByInstitucion", query = "SELECT c FROM Capacitaciones c WHERE c.institucion = :institucion")})
public class Capacitaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Titulo")
    private String titulo;
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
    @Size(max = 100)
    @Column(name = "Institucion")
    private String institucion;
    @JoinColumn(name = "Estado", referencedColumnName = "Id")
    @ManyToOne
    private Estado estado;
    @JoinColumn(name = "Nivel", referencedColumnName = "Id")
    @ManyToOne
    private NivelAcademico nivel;
    @OneToMany(mappedBy = "capacitaciones")
    private Collection<Candidatos> candidatosCollection;

    public Capacitaciones() {
    }

    public Capacitaciones(Long id) {
        this.id = id;
    }

    public Capacitaciones(Long id, String titulo, Date fechaDesde, Date fechaHasta) {
        this.id = id;
        this.titulo = titulo;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public NivelAcademico getNivel() {
        return nivel;
    }

    public void setNivel(NivelAcademico nivel) {
        this.nivel = nivel;
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
        if (!(object instanceof Capacitaciones)) {
            return false;
        }
        Capacitaciones other = (Capacitaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + institucion;
    }

}
