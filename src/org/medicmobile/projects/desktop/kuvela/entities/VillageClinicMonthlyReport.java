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
@Table(name = "village_clinic_monthly_report", catalog = "kuvela", schema = "")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "VillageClinicMonthlyReport.findAll", query = "SELECT v FROM VillageClinicMonthlyReport v"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByVcmrID", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.vcmrID = :vcmrID"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findBySender", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.sender = :sender"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findBySubmissionDate", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.submissionDate = :submissionDate"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByVillageClinicId", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.villageClinicId = :villageClinicId"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByReportingYear", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.reportingYear = :reportingYear"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByReportingMonth", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.reportingMonth = :reportingMonth"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByIfResidence", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.ifResidence = :ifResidence"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByFeverCasesLess1Day", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.feverCasesLess1Day = :feverCasesLess1Day"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByFeverCasesLess2Days", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.feverCasesLess2Days = :feverCasesLess2Days"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByFeverCasesLess3Days", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.feverCasesLess3Days = :feverCasesLess3Days"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByDiarrheaCasesLess1Day", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.diarrheaCasesLess1Day = :diarrheaCasesLess1Day"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByDiarrheaCasesLess2Days", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.diarrheaCasesLess2Days = :diarrheaCasesLess2Days"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByDiarrheaCasesLess3Days", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.diarrheaCasesLess3Days = :diarrheaCasesLess3Days"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByFastBreathCasesLess1Day", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.fastBreathCasesLess1Day = :fastBreathCasesLess1Day"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByFastBreathCasesLess2Days", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.fastBreathCasesLess2Days = :fastBreathCasesLess2Days"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByFastBreathCasesLess3Days", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.fastBreathCasesLess3Days = :fastBreathCasesLess3Days"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findBySupervisorVisits", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.supervisorVisits = :supervisorVisits"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByMentorshipSessions", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.mentorshipSessions = :mentorshipSessions"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByDaysstockedoutLA6X1", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.daysstockedoutLA6X1 = :daysstockedoutLA6X1"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByDaysstockedoutLA6X2", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.daysstockedoutLA6X2 = :daysstockedoutLA6X2"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByDaysstockedoutORS", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.daysstockedoutORS = :daysstockedoutORS"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByDaysstockedoutCotrimoxazole", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.daysstockedoutCotrimoxazole = :daysstockedoutCotrimoxazole"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByDaysstockedoutZinc", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.daysstockedoutZinc = :daysstockedoutZinc"),
    @NamedQuery(name = "VillageClinicMonthlyReport.findByDaysstockedoutEyeOintment", query = "SELECT v FROM VillageClinicMonthlyReport v WHERE v.daysstockedoutEyeOintment = :daysstockedoutEyeOintment")
})
public class VillageClinicMonthlyReport implements Serializable
{
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vcmr_ID")
    private Integer vcmrID;
    @Basic(optional = false)
    @Column(name = "sender")
    private String sender;
    @Basic(optional = false)
    @Column(name = "submission_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionDate;
    @Basic(optional = false)
    @Column(name = "village_clinic_id")
    private String villageClinicId;
    @Basic(optional = false)
    @Column(name = "reporting_year")
    private int reportingYear;
    @Basic(optional = false)
    @Column(name = "reporting_month")
    private int reportingMonth;
    @Basic(optional = false)
    @Column(name = "if_residence")
    private String ifResidence;
    @Basic(optional = false)
    @Column(name = "fever_cases_less_1_day")
    private int feverCasesLess1Day;
    @Basic(optional = false)
    @Column(name = "fever_cases_less_2_days")
    private int feverCasesLess2Days;
    @Basic(optional = false)
    @Column(name = "fever_cases_less_3_days")
    private int feverCasesLess3Days;
    @Basic(optional = false)
    @Column(name = "diarrhea_cases_less_1_day")
    private int diarrheaCasesLess1Day;
    @Basic(optional = false)
    @Column(name = "diarrhea_cases_less_2_days")
    private int diarrheaCasesLess2Days;
    @Basic(optional = false)
    @Column(name = "diarrhea_cases_less_3_days")
    private int diarrheaCasesLess3Days;
    @Basic(optional = false)
    @Column(name = "fast_breath_cases_less_1_day")
    private int fastBreathCasesLess1Day;
    @Basic(optional = false)
    @Column(name = "fast_breath_cases_less_2_days")
    private int fastBreathCasesLess2Days;
    @Basic(optional = false)
    @Column(name = "fast_breath_cases_less_3_days")
    private int fastBreathCasesLess3Days;
    @Basic(optional = false)
    @Column(name = "supervisor_visits")
    private int supervisorVisits;
    @Basic(optional = false)
    @Column(name = "mentorship_sessions")
    private int mentorshipSessions;
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

    public VillageClinicMonthlyReport()
    {
    }

    public VillageClinicMonthlyReport(Integer vcmrID)
    {
        this.vcmrID = vcmrID;
    }

    public VillageClinicMonthlyReport(Integer vcmrID, String sender, Date submissionDate, String villageClinicId, int reportingYear, int reportingMonth, String ifResidence, int feverCasesLess1Day, int feverCasesLess2Days, int feverCasesLess3Days, int diarrheaCasesLess1Day, int diarrheaCasesLess2Days, int diarrheaCasesLess3Days, int fastBreathCasesLess1Day, int fastBreathCasesLess2Days, int fastBreathCasesLess3Days, int supervisorVisits, int mentorshipSessions, int daysstockedoutLA6X1, int daysstockedoutLA6X2, int daysstockedoutORS, int daysstockedoutCotrimoxazole, int daysstockedoutZinc, int daysstockedoutEyeOintment)
    {
        this.vcmrID = vcmrID;
        this.sender = sender;
        this.submissionDate = submissionDate;
        this.villageClinicId = villageClinicId;
        this.reportingYear = reportingYear;
        this.reportingMonth = reportingMonth;
        this.ifResidence = ifResidence;
        this.feverCasesLess1Day = feverCasesLess1Day;
        this.feverCasesLess2Days = feverCasesLess2Days;
        this.feverCasesLess3Days = feverCasesLess3Days;
        this.diarrheaCasesLess1Day = diarrheaCasesLess1Day;
        this.diarrheaCasesLess2Days = diarrheaCasesLess2Days;
        this.diarrheaCasesLess3Days = diarrheaCasesLess3Days;
        this.fastBreathCasesLess1Day = fastBreathCasesLess1Day;
        this.fastBreathCasesLess2Days = fastBreathCasesLess2Days;
        this.fastBreathCasesLess3Days = fastBreathCasesLess3Days;
        this.supervisorVisits = supervisorVisits;
        this.mentorshipSessions = mentorshipSessions;
        this.daysstockedoutLA6X1 = daysstockedoutLA6X1;
        this.daysstockedoutLA6X2 = daysstockedoutLA6X2;
        this.daysstockedoutORS = daysstockedoutORS;
        this.daysstockedoutCotrimoxazole = daysstockedoutCotrimoxazole;
        this.daysstockedoutZinc = daysstockedoutZinc;
        this.daysstockedoutEyeOintment = daysstockedoutEyeOintment;
    }

    public Integer getVcmrID()
    {
        return vcmrID;
    }

    public void setVcmrID(Integer vcmrID)
    {
        Integer oldVcmrID = this.vcmrID;
        this.vcmrID = vcmrID;
        changeSupport.firePropertyChange("vcmrID", oldVcmrID, vcmrID);
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

    public String getVillageClinicId()
    {
        return villageClinicId;
    }

    public void setVillageClinicId(String villageClinicId)
    {
        String oldVillageClinicId = this.villageClinicId;
        this.villageClinicId = villageClinicId;
        changeSupport.firePropertyChange("villageClinicId", oldVillageClinicId, villageClinicId);
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

    public String getIfResidence()
    {
        return ifResidence;
    }

    public void setIfResidence(String ifResidence)
    {
        String oldIfResidence = this.ifResidence;
        this.ifResidence = ifResidence;
        changeSupport.firePropertyChange("ifResidence", oldIfResidence, ifResidence);
    }

    public int getFeverCasesLess1Day()
    {
        return feverCasesLess1Day;
    }

    public void setFeverCasesLess1Day(int feverCasesLess1Day)
    {
        int oldFeverCasesLess1Day = this.feverCasesLess1Day;
        this.feverCasesLess1Day = feverCasesLess1Day;
        changeSupport.firePropertyChange("feverCasesLess1Day", oldFeverCasesLess1Day, feverCasesLess1Day);
    }

    public int getFeverCasesLess2Days()
    {
        return feverCasesLess2Days;
    }

    public void setFeverCasesLess2Days(int feverCasesLess2Days)
    {
        int oldFeverCasesLess2Days = this.feverCasesLess2Days;
        this.feverCasesLess2Days = feverCasesLess2Days;
        changeSupport.firePropertyChange("feverCasesLess2Days", oldFeverCasesLess2Days, feverCasesLess2Days);
    }

    public int getFeverCasesLess3Days()
    {
        return feverCasesLess3Days;
    }

    public void setFeverCasesLess3Days(int feverCasesLess3Days)
    {
        int oldFeverCasesLess3Days = this.feverCasesLess3Days;
        this.feverCasesLess3Days = feverCasesLess3Days;
        changeSupport.firePropertyChange("feverCasesLess3Days", oldFeverCasesLess3Days, feverCasesLess3Days);
    }

    public int getDiarrheaCasesLess1Day()
    {
        return diarrheaCasesLess1Day;
    }

    public void setDiarrheaCasesLess1Day(int diarrheaCasesLess1Day)
    {
        int oldDiarrheaCasesLess1Day = this.diarrheaCasesLess1Day;
        this.diarrheaCasesLess1Day = diarrheaCasesLess1Day;
        changeSupport.firePropertyChange("diarrheaCasesLess1Day", oldDiarrheaCasesLess1Day, diarrheaCasesLess1Day);
    }

    public int getDiarrheaCasesLess2Days()
    {
        return diarrheaCasesLess2Days;
    }

    public void setDiarrheaCasesLess2Days(int diarrheaCasesLess2Days)
    {
        int oldDiarrheaCasesLess2Days = this.diarrheaCasesLess2Days;
        this.diarrheaCasesLess2Days = diarrheaCasesLess2Days;
        changeSupport.firePropertyChange("diarrheaCasesLess2Days", oldDiarrheaCasesLess2Days, diarrheaCasesLess2Days);
    }

    public int getDiarrheaCasesLess3Days()
    {
        return diarrheaCasesLess3Days;
    }

    public void setDiarrheaCasesLess3Days(int diarrheaCasesLess3Days)
    {
        int oldDiarrheaCasesLess3Days = this.diarrheaCasesLess3Days;
        this.diarrheaCasesLess3Days = diarrheaCasesLess3Days;
        changeSupport.firePropertyChange("diarrheaCasesLess3Days", oldDiarrheaCasesLess3Days, diarrheaCasesLess3Days);
    }

    public int getFastBreathCasesLess1Day()
    {
        return fastBreathCasesLess1Day;
    }

    public void setFastBreathCasesLess1Day(int fastBreathCasesLess1Day)
    {
        int oldFastBreathCasesLess1Day = this.fastBreathCasesLess1Day;
        this.fastBreathCasesLess1Day = fastBreathCasesLess1Day;
        changeSupport.firePropertyChange("fastBreathCasesLess1Day", oldFastBreathCasesLess1Day, fastBreathCasesLess1Day);
    }

    public int getFastBreathCasesLess2Days()
    {
        return fastBreathCasesLess2Days;
    }

    public void setFastBreathCasesLess2Days(int fastBreathCasesLess2Days)
    {
        int oldFastBreathCasesLess2Days = this.fastBreathCasesLess2Days;
        this.fastBreathCasesLess2Days = fastBreathCasesLess2Days;
        changeSupport.firePropertyChange("fastBreathCasesLess2Days", oldFastBreathCasesLess2Days, fastBreathCasesLess2Days);
    }

    public int getFastBreathCasesLess3Days()
    {
        return fastBreathCasesLess3Days;
    }

    public void setFastBreathCasesLess3Days(int fastBreathCasesLess3Days)
    {
        int oldFastBreathCasesLess3Days = this.fastBreathCasesLess3Days;
        this.fastBreathCasesLess3Days = fastBreathCasesLess3Days;
        changeSupport.firePropertyChange("fastBreathCasesLess3Days", oldFastBreathCasesLess3Days, fastBreathCasesLess3Days);
    }

    public int getSupervisorVisits()
    {
        return supervisorVisits;
    }

    public void setSupervisorVisits(int supervisorVisits)
    {
        int oldSupervisorVisits = this.supervisorVisits;
        this.supervisorVisits = supervisorVisits;
        changeSupport.firePropertyChange("supervisorVisits", oldSupervisorVisits, supervisorVisits);
    }

    public int getMentorshipSessions()
    {
        return mentorshipSessions;
    }

    public void setMentorshipSessions(int mentorshipSessions)
    {
        int oldMentorshipSessions = this.mentorshipSessions;
        this.mentorshipSessions = mentorshipSessions;
        changeSupport.firePropertyChange("mentorshipSessions", oldMentorshipSessions, mentorshipSessions);
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
        hash += (vcmrID != null ? vcmrID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VillageClinicMonthlyReport))
        {
            return false;
        }
        VillageClinicMonthlyReport other = (VillageClinicMonthlyReport) object;
        if ((this.vcmrID == null && other.vcmrID != null) || (this.vcmrID != null && !this.vcmrID.equals(other.vcmrID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "org.medicmobile.projects.desktop.kuvela.entities.VillageClinicMonthlyReport[ vcmrID=" + vcmrID + " ]";
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
