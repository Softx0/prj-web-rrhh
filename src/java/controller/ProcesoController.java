/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import helper.Validacion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author DELL
 */
@Named(value = "procesoController")
@SessionScoped
public class ProcesoController implements Serializable {

    /**
     * Creates a new instance of procesoController
     */
    public ProcesoController() {
    }

    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String gemaDelInfinito() {

        Validacion vali = new Validacion();
        CandidatosController candidato = new CandidatosController();
        EmpleadoController empleado = new EmpleadoController();

        if (vali.transferirCandidato(id)) {
            candidato.recreateModel();
            empleado.recreateModel();
            return "admin2";

        } else {
            return "admin2";

        }

    }

}
