/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Partenaire;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author momo
 */
@Stateless
public class PartenaireFacade extends AbstractFacade<Partenaire> {

    @PersistenceContext(unitName = "ferme_web_0.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PartenaireFacade() {
        super(Partenaire.class);
    }
    
}
