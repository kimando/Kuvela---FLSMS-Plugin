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
import org.medicmobile.projects.desktop.kuvela.controllers.exceptions.PreexistingEntityException;
import org.medicmobile.projects.desktop.kuvela.entities.PointsManager;

/**
 *
 * @author Kimando Emmanuel
 * @mail kimando@medicmobile.org
 * 
 */
public class PointsManagerJpaController implements Serializable
{

    public PointsManagerJpaController(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public void create(PointsManager pointsManager) throws PreexistingEntityException, Exception
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pointsManager);
            em.getTransaction().commit();
        } catch (Exception ex)
        {
            if (findPointsManager(pointsManager.getPhoneNumber()) != null)
            {
                throw new PreexistingEntityException("PointsManager " + pointsManager + " already exists.", ex);
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

    public void edit(PointsManager pointsManager) throws NonexistentEntityException, Exception
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            pointsManager = em.merge(pointsManager);
            em.getTransaction().commit();
        } catch (Exception ex)
        {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0)
            {
                String id = pointsManager.getPhoneNumber();
                if (findPointsManager(id) == null)
                {
                    throw new NonexistentEntityException("The pointsManager with id " + id + " no longer exists.");
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

    public void destroy(String id) throws NonexistentEntityException
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            PointsManager pointsManager;
            try
            {
                pointsManager = em.getReference(PointsManager.class, id);
                pointsManager.getPhoneNumber();
            } catch (EntityNotFoundException enfe)
            {
                throw new NonexistentEntityException("The pointsManager with id " + id + " no longer exists.", enfe);
            }
            em.remove(pointsManager);
            em.getTransaction().commit();
        } finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public List<PointsManager> findPointsManagerEntities()
    {
        return findPointsManagerEntities(true, -1, -1);
    }

    public List<PointsManager> findPointsManagerEntities(int maxResults, int firstResult)
    {
        return findPointsManagerEntities(false, maxResults, firstResult);
    }

    private List<PointsManager> findPointsManagerEntities(boolean all, int maxResults, int firstResult)
    {
        EntityManager em = getEntityManager();
        try
        {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PointsManager.class));
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

    public PointsManager findPointsManager(String id)
    {
        EntityManager em = getEntityManager();
        try
        {
            return em.find(PointsManager.class, id);
        } finally
        {
            em.close();
        }
    }

    public int getPointsManagerCount()
    {
        EntityManager em = getEntityManager();
        try
        {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PointsManager> rt = cq.from(PointsManager.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally
        {
            em.close();
        }
    }
    
}
