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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "facility_stock", catalog = "kuvela", schema = "")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "FacilityStock.findAll", query = "SELECT f FROM FacilityStock f"),
    @NamedQuery(name = "FacilityStock.findByFsID", query = "SELECT f FROM FacilityStock f WHERE f.fsID = :fsID"),
    @NamedQuery(name = "FacilityStock.findBySender", query = "SELECT f FROM FacilityStock f WHERE f.sender = :sender"),
    @NamedQuery(name = "FacilityStock.findBySubmissionDate", query = "SELECT f FROM FacilityStock f WHERE f.submissionDate = :submissionDate"),
    @NamedQuery(name = "FacilityStock.findByHealthFacilityId", query = "SELECT f FROM FacilityStock f WHERE f.healthFacilityId = :healthFacilityId"),
    @NamedQuery(name = "FacilityStock.findByReportingYear", query = "SELECT f FROM FacilityStock f WHERE f.reportingYear = :reportingYear"),
    @NamedQuery(name = "FacilityStock.findByReportingMonth", query = "SELECT f FROM FacilityStock f WHERE f.reportingMonth = :reportingMonth"),
    @NamedQuery(name = "FacilityStock.findByTotaldispensedLA6X1", query = "SELECT f FROM FacilityStock f WHERE f.totaldispensedLA6X1 = :totaldispensedLA6X1"),
    @NamedQuery(name = "FacilityStock.findByTotaldispensedLA6X2", query = "SELECT f FROM FacilityStock f WHERE f.totaldispensedLA6X2 = :totaldispensedLA6X2"),
    @NamedQuery(name = "FacilityStock.findByTotaldispensedORS", query = "SELECT f FROM FacilityStock f WHERE f.totaldispensedORS = :totaldispensedORS"),
    @NamedQuery(name = "FacilityStock.findByTotaldispensedCotrimoxazole", query = "SELECT f FROM FacilityStock f WHERE f.totaldispensedCotrimoxazole = :totaldispensedCotrimoxazole"),
    @NamedQuery(name = "FacilityStock.findByTotaldispensedZinc", query = "SELECT f FROM FacilityStock f WHERE f.totaldispensedZinc = :totaldispensedZinc"),
    @NamedQuery(name = "FacilityStock.findByTotaldispensedEyeOintment", query = "SELECT f FROM FacilityStock f WHERE f.totaldispensedEyeOintment = :totaldispensedEyeOintment"),
    @NamedQuery(name = "FacilityStock.findByDaysstockedoutLA6X1", query = "SELECT f FROM FacilityStock f WHERE f.daysstockedoutLA6X1 = :daysstockedoutLA6X1"),
    @NamedQuery(name = "FacilityStock.findByDaysstockedoutLA6X2", query = "SELECT f FROM FacilityStock f WHERE f.daysstockedoutLA6X2 = :daysstockedoutLA6X2"),
    @NamedQuery(name = "FacilityStock.findByDaysstockedoutORS", query = "SELECT f FROM FacilityStock f WHERE f.daysstockedoutORS = :daysstockedoutORS"),
    @NamedQuery(name = "FacilityStock.findByDaysstockedoutCotrimoxazole", query = "SELECT f FROM FacilityStock f WHERE f.daysstockedoutCotrimoxazole = :daysstockedoutCotrimoxazole"),
    @NamedQuery(name = "FacilityStock.findByDaysstockedoutZinc", query = "SELECT f FROM FacilityStock f WHERE f.daysstockedoutZinc = :daysstockedoutZinc"),
    @NamedQuery(name = "FacilityStock.findByDaysstockedoutEyeOintment", query = "SELECT f FROM FacilityStock f WHERE f.daysstockedoutEyeOintment = :daysstockedoutEyeOintment")
})
public class FacilityStock implements Serializable
{
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fs_ID")
    private Integer fsID;
    @Basic(optional = false)
    @Column(name = "sender")
    private String sender;
    @Basic(optional = false)
    @Column(name = "submission_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionDate;
    @Basic(optional = false)
    @Column(name = "health_facility_id")
    private String healthFacilityId;
    @Basic(optional = false)
    @Column(name = "reporting_year")
    private int reportingYear;
    @Basic(optional = false)
    @Column(name = "reporting_month")
    private int reportingMonth;
    @Basic(optional = false)
    @Column(name = "total_dispensed_LA_6X1")
    private int totaldispensedLA6X1;
    @Basic(optional = false)
    @Column(name = "total_dispensed_LA_6X2")
    private int totaldispensedLA6X2;
    @Basic(optional = false)
    @Column(name = "total_dispensed_ORS")
    private int totaldispensedORS;
    @Basic(optional = false)
    @Column(name = "total_dispensed_Cotrimoxazole")
    private int totaldispensedCotrimoxazole;
    @Basic(optional = false)
    @Column(name = "total_dispensed_Zinc")
    private int totaldispensedZinc;
    @Basic(optional = false)
    @Column(name = "total_dispensed_Eye_Ointment")
    private int totaldispensedEyeOintment;
    @Basic(optional = false)
    @Column(name = "days_stocked_out_LA_6X1")
    private int daysstockedoutLA6X1;
    @Basic(optional = false)
    @Column(name = "days_stocked_out_LA_6X2")
    private int daysstockedoutLA6X2;
    @Basic(optional = false)
    @Column(name = "days_stocked_out_ORS")
    private int daysstockedoutORS;
    @Basic(optional = false)
    @Column(name = "days_stocked_out_Cotrimoxazole")
    private int daysstockedoutCotrimoxazole;
    @Basic(optional = false)
    @Column(name = "days_stocked_out_Zinc")
    private int daysstockedoutZinc;
    @Basic(optional = false)
    @Column(name = "days_stocked_out_Eye_Ointment")
    private int daysstockedoutEyeOintment;

    public FacilityStock()
    {
    }

    public FacilityStock(Integer fsID)
    {
        this.fsID = fsID;
    }

    public FacilityStock(Integer fsID, String sender, Date submissionDate, String healthFacilityId, int reportingYear, int reportingMonth, int totaldispensedLA6X1, int totaldispensedLA6X2, int totaldispensedORS, int totaldispensedCotrimoxazole, int totaldispensedZinc, int totaldispensedEyeOintment, int daysstockedoutLA6X1, int daysstockedoutLA6X2, int daysstockedoutORS, int daysstockedoutCotrimoxazole, int daysstockedoutZinc, int daysstockedoutEyeOintment)
    {
        this.fsID = fsID;
        this.sender = sender;
        this.submissionDate = submissionDate;
        this.healthFacilityId = healthFacilityId;
        this.reportingYear = reportingYear;
        this.reportingMonth = reportingMonth;
        this.totaldispensedLA6X1 = totaldispensedLA6X1;
        this.totaldispensedLA6X2 = totaldispensedLA6X2;
        this.totaldispensedORS = totaldispensedORS;
        this.totaldispensedCotrimoxazole = totaldispensedCotrimoxazole;
        this.totaldispensedZinc = totaldispensedZinc;
        this.totaldispensedEyeOintment = totaldispensedEyeOintment;
        this.daysstockedoutLA6X1 = daysstockedoutLA6X1;
        this.daysstockedoutLA6X2 = daysstockedoutLA6X2;
        this.daysstockedoutORS = daysstockedoutORS;
        this.daysstockedoutCotrimoxazole = daysstockedoutCotrimoxazole;
        this.daysstockedoutZinc = daysstockedoutZinc;
        this.daysstockedoutEyeOintment = daysstockedoutEyeOintment;
    }

    public Integer getFsID()
    {
        return fsID;
    }

    public void setFsID(Integer fsID)
    {
        Integer oldFsID = this.fsID;
        this.fsID = fsID;
        changeSupport.firePropertyChange("fsID", oldFsID, fsID);
    }

    public String getSender()
    {
        return sender;
    }

    public void setSender(String sender)
    {
        String oldSender = this.sender;
        this.sender = sender;
        changeSupport.firePropertyChange("sender", oldSender, sender);
    }

    public Date getSubmissionDate()
    {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate)
    {
        Date oldSubmissionDate = this.submissionDate;
        this.submissionDate = submissionDate;
        changeSupport.firePropertyChange("submissionDate", oldSubmissionDate, submissionDate);
    }

    public String getHealthFacilityId()
    {
        return healthFacilityId;
    }

    public void setHealthFacilityId(String healthFacilityId)
    {
        String oldHealthFacilityId = this.healthFacilityId;
        this.healthFacilityId = healthFacilityId;
        changeSupport.firePropertyChange("healthFacilityId", oldHealthFacilityId, healthFacilityId);
    }

    public int getReportingYear()
    {
        return reportingYear;
    }

    public void setReportingYear(int reportingYear)
    {
        int oldReportingYear = this.reportingYear;
        this.reportingYear = reportingYear;
        changeSupport.firePropertyChange("reportingYear", oldReportingYear, reportingYear);
    }

    public int getReportingMonth()
    {
        return reportingMonth;
    }

    public void setReportingMonth(int reportingMonth)
    {
        int oldReportingMonth = this.reportingMonth;
        this.reportingMonth = reportingMonth;
        changeSupport.firePropertyChange("reportingMonth", oldReportingMonth, reportingMonth);
    }

    public int getTotaldispensedLA6X1()
    {
        return totaldispensedLA6X1;
    }

    public void setTotaldispensedLA6X1(int totaldispensedLA6X1)
    {
        int oldTotaldispensedLA6X1 = this.totaldispensedLA6X1;
        this.totaldispensedLA6X1 = totaldispensedLA6X1;
        changeSupport.firePropertyChange("totaldispensedLA6X1", oldTotaldispensedLA6X1, totaldispensedLA6X1);
    }

    public int getTotaldispensedLA6X2()
    {
        return totaldispensedLA6X2;
    }

    public void setTotaldispensedLA6X2(int totaldispensedLA6X2)
    {
        int oldTotaldispensedLA6X2 = this.totaldispensedLA6X2;
        this.totaldispensedLA6X2 = totaldispensedLA6X2;
        changeSupport.firePropertyChange("totaldispensedLA6X2", oldTotaldispensedLA6X2, totaldispensedLA6X2);
    }

    public int getTotaldispensedORS()
    {
        return totaldispensedORS;
    }

    public void setTotaldispensedORS(int totaldispensedORS)
    {
        int oldTotaldispensedORS = this.totaldispensedORS;
        this.totaldispensedORS = totaldispensedORS;
        changeSupport.firePropertyChange("totaldispensedORS", oldTotaldispensedORS, totaldispensedORS);
    }

    public int getTotaldispensedCotrimoxazole()
    {
        return totaldispensedCotrimoxazole;
    }

    public void setTotaldispensedCotrimoxazole(int totaldispensedCotrimoxazole)
    {
        int oldTotaldispensedCotrimoxazole = this.totaldispensedCotrimoxazole;
        this.totaldispensedCotrimoxazole = totaldispensedCotrimoxazole;
        changeSupport.firePropertyChange("totaldispensedCotrimoxazole", oldTotaldispensedCotrimoxazole, totaldispensedCotrimoxazole);
    }

    public int getTotaldispensedZinc()
    {
        return totaldispensedZinc;
    }

    public void setTotaldispensedZinc(int totaldispensedZinc)
    {
        int oldTotaldispensedZinc = this.totaldispensedZinc;
        this.totaldispensedZinc = totaldispensedZinc;
        changeSupport.firePropertyChange("totaldispensedZinc", oldTotaldispensedZinc, totaldispensedZinc);
    }

    public int getTotaldispensedEyeOintment()
    {
        return totaldispensedEyeOintment;
    }

    public void setTotaldispensedEyeOintment(int totaldispensedEyeOintment)
    {
        int oldTotaldispensedEyeOintment = this.totaldispensedEyeOintment;
        this.totaldispensedEyeOintment = totaldispensedEyeOintment;
        changeSupport.firePropertyChange("totaldispensedEyeOintment", oldTotaldispensedEyeOintment, totaldispensedEyeOintment);
    }

    public int getDaysstockedoutLA6X1()
    {
        return daysstockedoutLA6X1;
    }

    public void setDaysstockedoutLA6X1(int daysstockedoutLA6X1)
    {
        int oldDaysstockedoutLA6X1 = this.daysstockedoutLA6X1;
        this.daysstockedoutLA6X1 = daysstockedoutLA6X1;
        changeSupport.firePropertyChange("daysstockedoutLA6X1", oldDaysstockedoutLA6X1, daysstockedoutLA6X1);
    }

    public int getDaysstockedoutLA6X2()
    {
        return daysstockedoutLA6X2;
    }

    public void setDaysstockedoutLA6X2(int daysstockedoutLA6X2)
    {
        int oldDaysstockedoutLA6X2 = this.daysstockedoutLA6X2;
        this.daysstockedoutLA6X2 = daysstockedoutLA6X2;
        changeSupport.firePropertyChange("daysstockedoutLA6X2", oldDaysstockedoutLA6X2, daysstockedoutLA6X2);
    }

    public int getDaysstockedoutORS()
    {
        return daysstockedoutORS;
    }

    public void setDaysstockedoutORS(int daysstockedoutORS)
    {
        int oldDaysstockedoutORS = this.daysstockedoutORS;
        this.daysstockedoutORS = daysstockedoutORS;
        changeSupport.firePropertyChange("daysstockedoutORS", oldDaysstockedoutORS, daysstockedoutORS);
    }

    public int getDaysstockedoutCotrimoxazole()
    {
        return daysstockedoutCotrimoxazole;
    }

    public void setDaysstockedoutCotrimoxazole(int daysstockedoutCotrimoxazole)
    {
        int oldDaysstockedoutCotrimoxazole = this.daysstockedoutCotrimoxazole;
        this.daysstockedoutCotrimoxazole = daysstockedoutCotrimoxazole;
        changeSupport.firePropertyChange("daysstockedoutCotrimoxazole", oldDaysstockedoutCotrimoxazole, daysstockedoutCotrimoxazole);
    }

    public int getDaysstockedoutZinc()
    {
        return daysstockedoutZinc;
    }

    public void setDaysstockedoutZinc(int daysstockedoutZinc)
    {
        int oldDaysstockedoutZinc = this.daysstockedoutZinc;
        this.daysstockedoutZinc = daysstockedoutZinc;
        changeSupport.firePropertyChange("daysstockedoutZinc", oldDaysstockedoutZinc, daysstockedoutZinc);
    }

    public int getDaysstockedoutEyeOintment()
    {
        return daysstockedoutEyeOintment;
    }

    public void setDaysstockedoutEyeOintment(int daysstockedoutEyeOintment)
    {
        int oldDaysstockedoutEyeOintment = this.daysstockedoutEyeOintment;
        this.daysstockedoutEyeOintment = daysstockedoutEyeOintment;
        changeSupport.firePropertyChange("daysstockedoutEyeOintment", oldDaysstockedoutEyeOintment, daysstockedoutEyeOintment);
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (fsID != null ? fsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacilityStock))
        {
            return false;
        }
        FacilityStock other = (FacilityStock) object;
        if ((this.fsID == null && other.fsID != null) || (this.fsID != null && !this.fsID.equals(other.fsID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "org.medicmobile.projects.desktop.kuvela.entities.FacilityStock[ fsID=" + fsID + " ]";
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
