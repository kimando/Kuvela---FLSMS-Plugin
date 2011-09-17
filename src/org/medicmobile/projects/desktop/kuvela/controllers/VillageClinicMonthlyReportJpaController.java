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
import org.medicmobile.projects.desktop.kuvela.entities.VillageClinicMonthlyReport;

/**
 *
 * @author Kimando Emmanuel
 * @mail kimando@medicmobile.org
 * 
 */
public class VillageClinicMonthlyReportJpaController implements Serializable
{

    public VillageClinicMonthlyReportJpaController(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public void create(VillageClinicMonthlyReport villageClinicMonthlyReport)
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(villageClinicMonthlyReport);
            em.getTransaction().commit();
        } finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public void edit(VillageClinicMonthlyReport villageClinicMonthlyReport) throws NonexistentEntityException, Exception
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            villageClinicMonthlyReport = em.merge(villageClinicMonthlyReport);
            em.getTransaction().commit();
        } catch (Exception ex)
        {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0)
            {
                Integer id = villageClinicMonthlyReport.getVcmrID();
                if (findVillageClinicMonthlyReport(id) == null)
                {
                    throw new NonexistentEntityException("The villageClinicMonthlyReport with id " + id + " no longer exists.");
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
            VillageClinicMonthlyReport villageClinicMonthlyReport;
            try
            {
                villageClinicMonthlyReport = em.getReference(VillageClinicMonthlyReport.class, id);
                villageClinicMonthlyReport.getVcmrID();
            } catch (EntityNotFoundException enfe)
            {
                throw new NonexistentEntityException("The villageClinicMonthlyReport with id " + id + " no longer exists.", enfe);
            }
            em.remove(villageClinicMonthlyReport);
            em.getTransaction().commit();
        } finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }

    public List<VillageClinicMonthlyReport> findVillageClinicMonthlyReportEntities()
    {
        return findVillageClinicMonthlyReportEntities(true, -1, -1);
    }

    public List<VillageClinicMonthlyReport> findVillageClinicMonthlyReportEntities(int maxResults, int firstResult)
    {
        return findVillageClinicMonthlyReportEntities(false, maxResults, firstResult);
    }

    private List<VillageClinicMonthlyReport> findVillageClinicMonthlyReportEntities(boolean all, int maxResults, int firstResult)
    {
        EntityManager em = getEntityManager();
        try
        {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VillageClinicMonthlyReport.class));
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

    public VillageClinicMonthlyReport findVillageClinicMonthlyReport(Integer id)
    {
        EntityManager em = getEntityManager();
        try
        {
            return em.find(VillageClinicMonthlyReport.class, id);
        } finally
        {
            em.close();
        }
    }

    public int getVillageClinicMonthlyReportCount()
    {
        EntityManager em = getEntityManager();
        try
        {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VillageClinicMonthlyReport> rt = cq.from(VillageClinicMonthlyReport.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally
        {
            em.close();
        }
    }
    
}
