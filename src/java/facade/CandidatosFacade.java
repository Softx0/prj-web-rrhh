/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Candidatos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DELL
 */
@Stateless
public class CandidatosFacade extends AbstractFacade<Candidatos> {

    @PersistenceContext(unitName = "prj-hhrr-webPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CandidatosFacade() {
        super(Candidatos.class);
    }
    
    
    
    
    /*
    public List<Candidatos> procesoThanos(String Cedula) {

        Query rows = em.createNativeQuery("INSERT INTO Empleado (Cedula,Nombre,Salario_Mensual,Puesto) SELECT Cedula,Nombre,Salario_Aspira,Puesto_Aspira FROM Candidatos WHERE candidatos.Cedula = '" + Cedula + "'", Candidatos.class);
        /* 
        int row = rows.executeUpdate();
        if (row == 0) {
            System.out.println("Don't add any row!");
        } else {
            System.out.println(row + " row(s)affected.");
            em.close();
        }
         
        List<Candidatos> thanosGano = rows.getResultList();
        return thanosGano;
    }
     */

}
