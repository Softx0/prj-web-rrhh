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
@Table(name = "nivel_de_riesgo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelDeRiesgo.findAll", query = "SELECT n FROM NivelDeRiesgo n")
    , @NamedQuery(name = "NivelDeRiesgo.findById", query = "SELECT n FROM NivelDeRiesgo n WHERE n.id = :id")
    , @NamedQuery(name = "NivelDeRiesgo.findByNiveldeRiesgo", query = "SELECT n FROM NivelDeRiesgo n WHERE n.niveldeRiesgo = :niveldeRiesgo")})
public class NivelDeRiesgo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nivel_de_Riesgo")
    private String niveldeRiesgo;
    @OneToMany(mappedBy = "niveldeRiesgo")
    private Collection<Puestos> puestosCollection;
    @JoinColumn(name = "Estado", referencedColumnName = "Id")
    @ManyToOne
    private Estado estado;

    public NivelDeRiesgo() {
    }

    public NivelDeRiesgo(Long id) {
        this.id = id;
    }

    public NivelDeRiesgo(Long id, String niveldeRiesgo) {
        this.id = id;
        this.niveldeRiesgo = niveldeRiesgo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNiveldeRiesgo() {
        return niveldeRiesgo;
    }

    public void setNiveldeRiesgo(String niveldeRiesgo) {
        this.niveldeRiesgo = niveldeRiesgo;
    }

    @XmlTransient
    public Collection<Puestos> getPuestosCollection() {
        return puestosCollection;
    }

    public void setPuestosCollection(Collection<Puestos> puestosCollection) {
        this.puestosCollection = puestosCollection;
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
        if (!(object instanceof NivelDeRiesgo)) {
            return false;
        }
        NivelDeRiesgo other = (NivelDeRiesgo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+niveldeRiesgo;
    }
    
}
