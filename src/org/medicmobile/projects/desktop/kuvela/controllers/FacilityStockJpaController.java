/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.medicmobile.projects.desktop.kuvela.controllers;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.medicmobile.projects.desktop.kuvela.controllers.exceptions.NonexistentEntityException;
import org.medicmobile.projects.desktop.kuvela.entities.FacilityStock;

/**
 *
 * @author Kimando Emmanuel
 * @mail kimando@medicmobile.org
 * 
 */
public class FacilityStockJpaController implements Serializable
{

    public FacilityStockJpaController(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public void create(FacilityStock facilityStock)
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(facilityStock);
            em.getTransaction().commit();
        } finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void edit(FacilityStock facilityStock) throws NonexistentEntityException, Exception
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            facilityStock = em.merge(facilityStock);
            em.getTransaction().commit();
        } catch (Exception ex)
        {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0)
            {
                Integer id = facilityStock.getFsID();
                if (findFacilityStock(id) == null)
                {
                    throw new NonexistentEntityException("The facilityStock with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            FacilityStock facilityStock;
            try
            {
                facilityStock = em.getReference(FacilityStock.class, id);
                facilityStock.getFsID();
            } catch (EntityNotFoundException enfe)
            {
                throw new NonexistentEntityException("The facilityStock with id " + id + " no longer exists.", enfe);
            }
            em.remove(facilityStock);
            em.getTransaction().commit();
        } finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public List<FacilityStock> findFacilityStockEntities()
    {
        return findFacilityStockEntities(true, -1, -1);
    }

    public List<FacilityStock> findFacilityStockEntities(int maxResults, int firstResult)
    {
        return findFacilityStockEntities(false, maxResults, firstResult);
    }

    private List<FacilityStock> findFacilityStockEntities(boolean all, int maxResults, int firstResult)
    {
        EntityManager em = getEntityManager();
        try
        {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FacilityStock.class));
            Query q = em.createQuery(cq);
            if (!all)
            {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally
        {
            em.close();
        }
    }

    public FacilityStock findFacilityStock(Integer id)
    {
        EntityManager em = getEntityManager();
        try
        {
            return em.find(FacilityStock.class, id);
        } finally
        {
            em.close();
        }
    }

    public int getFacilityStockCount()
    {
        EntityManager em = getEntityManager();
        try
        {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FacilityStock> rt = cq.from(FacilityStock.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally
        {
            em.close();
        }
    }
    
}
