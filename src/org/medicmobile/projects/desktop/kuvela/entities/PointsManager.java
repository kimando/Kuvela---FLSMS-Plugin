/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.medicmobile.projects.desktop.kuvela.entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kimando Emmanuel
 * @mail kimando@medicmobile.org
 * 
 */
@Entity
@Table(name = "points_manager", catalog = "kuvela", schema = "")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "PointsManager.findAll", query = "SELECT p FROM PointsManager p"),
    @NamedQuery(name = "PointsManager.findByPhoneNumber", query = "SELECT p FROM PointsManager p WHERE p.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "PointsManager.findByPoints", query = "SELECT p FROM PointsManager p WHERE p.points = :points"),
    @NamedQuery(name = "PointsManager.findByLastRedeemed", query = "SELECT p FROM PointsManager p WHERE p.lastRedeemed = :lastRedeemed"),
    @NamedQuery(name = "PointsManager.findByAmountRedeemedLast", query = "SELECT p FROM PointsManager p WHERE p.amountRedeemedLast = :amountRedeemedLast"),
    @NamedQuery(name = "PointsManager.findByTotalCreditRedeemed", query = "SELECT p FROM PointsManager p WHERE p.totalCreditRedeemed = :totalCreditRedeemed")
})
public class PointsManager implements Serializable
{
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "points")
    private int points;
    @Basic(optional = false)
    @Column(name = "last_redeemed")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastRedeemed;
    @Basic(optional = false)
    @Column(name = "amount_redeemed_last")
    private int amountRedeemedLast;
    @Basic(optional = false)
    @Column(name = "total_credit_redeemed")
    private int totalCreditRedeemed;

    public PointsManager()
    {
    }

    public PointsManager(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public PointsManager(String phoneNumber, int points, Date lastRedeemed, int amountRedeemedLast, int totalCreditRedeemed)
    {
        this.phoneNumber = phoneNumber;
        this.points = points;
        this.lastRedeemed = lastRedeemed;
        this.amountRedeemedLast = amountRedeemedLast;
        this.totalCreditRedeemed = totalCreditRedeemed;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        String oldPhoneNumber = this.phoneNumber;
        this.phoneNumber = phoneNumber;
        changeSupport.firePropertyChange("phoneNumber", oldPhoneNumber, phoneNumber);
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        int oldPoints = this.points;
        this.points = points;
        changeSupport.firePropertyChange("points", oldPoints, points);
    }

    public Date getLastRedeemed()
    {
        return lastRedeemed;
    }

    public void setLastRedeemed(Date lastRedeemed)
    {
        Date oldLastRedeemed = this.lastRedeemed;
        this.lastRedeemed = lastRedeemed;
        changeSupport.firePropertyChange("lastRedeemed", oldLastRedeemed, lastRedeemed);
    }

    public int getAmountRedeemedLast()
    {
        return amountRedeemedLast;
    }

    public void setAmountRedeemedLast(int amountRedeemedLast)
    {
        int oldAmountRedeemedLast = this.amountRedeemedLast;
        this.amountRedeemedLast = amountRedeemedLast;
        changeSupport.firePropertyChange("amountRedeemedLast", oldAmountRedeemedLast, amountRedeemedLast);
    }

    public int getTotalCreditRedeemed()
    {
        return totalCreditRedeemed;
    }

    public void setTotalCreditRedeemed(int totalCreditRedeemed)
    {
        int oldTotalCreditRedeemed = this.totalCreditRedeemed;
        this.totalCreditRedeemed = totalCreditRedeemed;
        changeSupport.firePropertyChange("totalCreditRedeemed", oldTotalCreditRedeemed, totalCreditRedeemed);
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PointsManager))
        {
            return false;
        }
        PointsManager other = (PointsManager) object;
        if ((this.phoneNumber == null && other.phoneNumber != null) || (this.phoneNumber != null && !this.phoneNumber.equals(other.phoneNumber)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "org.medicmobile.projects.desktop.kuvela.entities.PointsManager[ phoneNumber=" + phoneNumber + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
