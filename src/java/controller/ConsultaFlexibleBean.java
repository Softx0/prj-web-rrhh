/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Candidatos;
import facade.CandidatosFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author DELL
 */
@Named(value = "consultaFlexibleBean")
@SessionScoped
public class ConsultaFlexibleBean implements Serializable {

    /**
     * Creates a new instance of ConsultaFlexibleBean
     */
    //Variable cedula para recibirla como parametro
    private String cedula = null;

    //List de candidatos de todo el query
    private List<Candidatos> listaCandidato = new ArrayList<>();

    //Instancia de la BD 
    @EJB
    private CandidatosFacade connCandidato;

    //
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    //

    //
    public List<Candidatos> getListaCandidato() {
        return listaCandidato;
    }

    public void setListaCandidato(List<Candidatos> listaCandidato) {
        this.listaCandidato = listaCandidato;
    }
    //

    //metodo que coge la lista de candidatos la iguala a la conexion con la BD y
    //coge el metodo que recibe la cedula
    //para realizar el query que ya sabemos de pasar lso dats de una tabla a la otra.
    //Ahora este metodo debe llamarse en la vista, en la del admin en el apartado de candidatos
    /*public void infinityWar() {
        listaCandidato = connCandidato.procesoThanos(cedula);
    }*/

    //Constructor
    public ConsultaFlexibleBean() {
    }

}
