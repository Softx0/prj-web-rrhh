/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.NivelDeRiesgo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DELL
 */
@Stateless
public class NivelDeRiesgoFacade extends AbstractFacade<NivelDeRiesgo> {

    @PersistenceContext(unitName = "prj-hhrr-webPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NivelDeRiesgoFacade() {
        super(NivelDeRiesgo.class);
    }
    
}
