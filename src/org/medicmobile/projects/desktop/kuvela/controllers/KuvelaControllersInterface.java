/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.medicmobile.projects.desktop.kuvela.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import jxl.Workbook;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.medicmobile.projects.desktop.kuvela.controllers.exceptions.NonexistentEntityException;
import org.medicmobile.projects.desktop.kuvela.entities.FacilityStock;
import org.medicmobile.projects.desktop.kuvela.entities.PointsManager;
import org.medicmobile.projects.desktop.kuvela.entities.VillageClinicMonthlyReport;

/**
 *
 * @author Kimando Emmanuel
 * @mail kimando@medicmobile.org
 * 
 */
public class KuvelaControllersInterface
{
    public void updateVillageClinicMonthlyReport(String[] items, String sender, Date submissionDate)
    {
        System.out.println("Making a new vcmr instance");
        VillageClinicMonthlyReport vcmr = new VillageClinicMonthlyReport();
        
        System.out.println("calling the vcmr set methods");
        
        vcmr.setVcmrID(0);
        vcmr.setSender(sender);
        vcmr.setSubmissionDate(new Date());
        
        vcmr.setVillageClinicId(items[0]);
        vcmr.setReportingYear(Integer.parseInt(items[1]));
        vcmr.setReportingMonth(Integer.parseInt(items[2]));
        int residence = Integer.parseInt(items[3]);
        if(residence == 1){vcmr.setIfResidence("YES");}
        if(residence == 0){vcmr.setIfResidence("NO");}
        vcmr.setFeverCasesLess1Day(Integer.parseInt(items[4]));
        vcmr.setFeverCasesLess2Days(Integer.parseInt(items[5]));
        vcmr.setFeverCasesLess3Days(Integer.parseInt(items[6]));
        vcmr.setDiarrheaCasesLess1Day(Integer.parseInt(items[7]));
        vcmr.setDiarrheaCasesLess2Days(Integer.parseInt(items[8]));
        vcmr.setDiarrheaCasesLess3Days(Integer.parseInt(items[9]));
        vcmr.setFastBreathCasesLess1Day(Integer.parseInt(items[10]));
        vcmr.setFastBreathCasesLess2Days(Integer.parseInt(items[11]));
        vcmr.setFastBreathCasesLess3Days(Integer.parseInt(items[12]));
        vcmr.setSupervisorVisits(Integer.parseInt(items[13]));
        vcmr.setMentorshipSessions(Integer.parseInt(items[14]));
        vcmr.setDaysstockedoutLA6X1(Integer.parseInt(items[15]));
        vcmr.setDaysstockedoutLA6X2(Integer.parseInt(items[16]));
        vcmr.setDaysstockedoutORS(Integer.parseInt(items[17]));
        vcmr.setDaysstockedoutCotrimoxazole(Integer.parseInt(items[18]));
        vcmr.setDaysstockedoutZinc(Integer.parseInt(items[19]));
        vcmr.setDaysstockedoutEyeOintment(Integer.parseInt(items[20]));
        
        System.out.println("all vcmr set methods called");
        
        System.out.println("Making a new vcmr instance");
        
        EntityManagerFactory entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory("KuvelaPU");
        
        VillageClinicMonthlyReportJpaController vcmrController = new VillageClinicMonthlyReportJpaController(entityManagerFactory);
        
        System.out.println("Creating the vcmr");
        vcmrController.create(vcmr);
        
        System.out.println("Created new vcmr");
        
        try
        {
            System.out.println("Rewarding points");
            rewardPoints(sender);
            System.out.println("Points rewarded");
        }
        catch(Exception e){}
    }
    
    public void updateFacilityStock(String[] items, String sender, Date submissionDate)
    {
        System.out.println("Making a new facility stock instance");
        FacilityStock facilityStock = new FacilityStock();
        
        System.out.println("Calling the facility stock set methods");
        facilityStock.setFsID(0);
        facilityStock.setSender(sender);
        facilityStock.setSubmissionDate(submissionDate);
        facilityStock.setHealthFacilityId(items[0]);
        facilityStock.setReportingYear(Integer.parseInt(items[1]));
        facilityStock.setReportingMonth(Integer.parseInt(items[2]));
        facilityStock.setTotaldispensedLA6X1(Integer.parseInt(items[3]));
        facilityStock.setTotaldispensedLA6X2(Integer.parseInt(items[4]));
        facilityStock.setTotaldispensedORS(Integer.parseInt(items[5]));
        facilityStock.setTotaldispensedCotrimoxazole(Integer.parseInt(items[6]));
        facilityStock.setTotaldispensedZinc(Integer.parseInt(items[7]));
        facilityStock.setTotaldispensedEyeOintment(Integer.parseInt(items[8]));
        facilityStock.setDaysstockedoutLA6X1(Integer.parseInt(items[9]));
        facilityStock.setDaysstockedoutLA6X2(Integer.parseInt(items[10]));
        facilityStock.setDaysstockedoutORS(Integer.parseInt(items[11]));
        facilityStock.setDaysstockedoutCotrimoxazole(Integer.parseInt(items[12]));
        facilityStock.setDaysstockedoutZinc(Integer.parseInt(items[13]));
        facilityStock.setDaysstockedoutEyeOintment(Integer.parseInt(items[14]));
        
        System.out.println("all facility stock set methods called");
        
        System.out.println("Making a new vcmr instance");        
        EntityManagerFactory entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory("KuvelaPU");
        
        FacilityStockJpaController fsController = new FacilityStockJpaController(entityManagerFactory);
        
        System.out.println("Creating the facility stock");
        fsController.create(facilityStock);
        
        System.out.println("Created the facility stock");
        
        try
        {
            System.out.println("Rewarding points");
            rewardPoints(sender);
            System.out.println("Points rewarded");
        }
        catch(Exception e){}
    }
    
    private void rewardPoints(String sender) throws NonexistentEntityException, Exception
    {
        // check if sender exists
        // if exists update points accumulated
        // else create and update
        EntityManagerFactory entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory("KuvelaPU");
        PointsManagerJpaController pointsManagerController = new PointsManagerJpaController(entityManagerFactory);
        
        System.out.println("Check if the number exists");
        if (pointsManagerController.findPointsManager(sender) == null) // check if sender exists
        {
            System.out.println("Number doesnt exist so create a new blank record");
            // sender doesnt exist so create a new one and update points
            PointsManager pointsManager = new PointsManager(sender);
            pointsManagerController.create(pointsManager);
        }
        
        System.out.println("Get the record with the phone number supplied");
        // update points
        PointsManager currentPoints = pointsManagerController.findPointsManager(sender);
        PointsManager updatedPoints = new PointsManager(sender, currentPoints.getPoints() + 1, currentPoints.getLastRedeemed(), currentPoints.getAmountRedeemedLast(), currentPoints.getTotalCreditRedeemed());
        
        System.out.println("Update "+sender+" from "+currentPoints.getPoints()+" to "+updatedPoints.getPoints());
        pointsManagerController.edit(updatedPoints);
    }
    
    public String redeemPoints(String phoneNumber) throws NonexistentEntityException, Exception
    {
        String message = "";
        
        EntityManagerFactory entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory("KuvelaPU");
        PointsManagerJpaController pointsManagerController = new PointsManagerJpaController(entityManagerFactory);
        
        System.out.println("Check if the number exists");
        PointsManager currentPoints = pointsManagerController.findPointsManager(phoneNumber);
        if (currentPoints == null) // if the number doesnt exist
        {
            System.out.println("Number doesnt exist.. ask the user to start using the Kuvela app");
            message = "This seems to be the first time you are using Kuvela. Please fill some reports first to qualify for the incentives"; // 114 characters
        }
        else // if the number exists
        {
            int points = currentPoints.getPoints();
            if (points > 20) // if the points accumulated so far are more than 20, redeem
            {
                message = "*140*"+points+"*"+phoneNumber+"#";
                PointsManager updatedPoints = new PointsManager(phoneNumber, 0, new Date(), points, currentPoints.getTotalCreditRedeemed() + points);
                pointsManagerController.edit(updatedPoints);
            }
            else
            {
                message = "Sorry, you have "+currentPoints.getPoints()+" points so far. You need to have at lease 20 points to qualify for the incentive. Please fill more forms";
            }
        }
        return message;
    }
    
    public void exportVCMRToExcel() throws IOException, WriteException
    {
        Date date = new Date();
        
        WritableWorkbook workbook = Workbook.createWorkbook(new File("Village Clinic Monthly Report.xls")); 
        WritableSheet sheet = workbook.createSheet("First Sheet", 0); 


        EntityManagerFactory entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory("KuvelaPU");
        VillageClinicMonthlyReportJpaController vcmrController = new VillageClinicMonthlyReportJpaController(entityManagerFactory);
        
        List<VillageClinicMonthlyReport> allVCMRs = vcmrController.findVillageClinicMonthlyReportEntities();
        
        WritableFont times16font = new WritableFont(WritableFont.TIMES, 16, WritableFont.BOLD, false); 
        WritableCellFormat times16format = new WritableCellFormat (times16font); 

        sheet.addCell(new Label(0, 2, "Village Clinic Monthly Report - "+date, times16format)); 
        
        sheet.addCell(createLabel(0, 4, "Record"));
        sheet.addCell(createLabel(1, 4, "Sender"));
        sheet.addCell(createLabel(2, 4, "Submission Date"));
        sheet.addCell(createLabel(3, 4, "Village Clinic ID"));
        sheet.addCell(createLabel(4, 4, "Reporting Year"));
        sheet.addCell(createLabel(5, 4, "Reporting Month"));
        sheet.addCell(createLabel(6, 4, "If Residence"));
        sheet.addCell(createLabel(7, 4, "Fever Cases < 1 Day"));
        sheet.addCell(createLabel(8, 4, "Fever Cases < 2 Days"));
        sheet.addCell(createLabel(9, 4, "Fever Cases < 3 days"));
        sheet.addCell(createLabel(10, 4, "Diarrhea Cases < 1 Day"));
        sheet.addCell(createLabel(11, 4, "Diarrhea Cases < 2 Days"));
        sheet.addCell(createLabel(12, 4, "Diarrhea Cases < 3 Days"));
        sheet.addCell(createLabel(13, 4, "Fast Breath Cases < 1 Day"));
        sheet.addCell(createLabel(14, 4, "Fast Breath Caes < 2 Days"));
        sheet.addCell(createLabel(15, 4, "Fast Breat Cases < 3 Days"));
        sheet.addCell(createLabel(16, 4, "Supervisor Visits"));
        sheet.addCell(createLabel(17, 4, "Mentorship Sessions"));
        sheet.addCell(createLabel(18, 4, "Days Stocked Out LA 6X1"));
        sheet.addCell(createLabel(19, 4, "Days Stocked Out LA 6X2"));
        sheet.addCell(createLabel(20, 4, "Days Stocked Out ORS"));
        sheet.addCell(createLabel(21, 4, "Days Stocked Out Cotrimoxazole"));
        sheet.addCell(createLabel(22, 4, "Days Stocked Out LA Zinc"));
        sheet.addCell(createLabel(23, 4, "Days Stocked Out Eye Ointment"));
        
        int size = allVCMRs.size();               
        for(int i = 0; i < size; i++)
        {
            VillageClinicMonthlyReport entry = allVCMRs.get(i);
            
            sheet.addCell(createNumber(0, i + 5, entry.getVcmrID())); 
            sheet.addCell(createLabel(1, i + 5, entry.getSender()));
            sheet.addCell(createDate(2, i + 5, entry.getSubmissionDate())); 
            sheet.addCell(createLabel(3, i + 5, entry.getVillageClinicId())); 
            sheet.addCell(createNumber(4, i + 5, entry.getReportingYear())); 
            sheet.addCell(createNumber(5, i + 5, entry.getReportingMonth())); 
            sheet.addCell(createLabel(6, i + 5, entry.getIfResidence())); 
            sheet.addCell(createNumber(7, i + 5, entry.getFeverCasesLess1Day())); 
            sheet.addCell(createNumber(8, i + 5, entry.getFeverCasesLess2Days())); 
            sheet.addCell(createNumber(9, i + 5, entry.getFeverCasesLess3Days())); 
            sheet.addCell(createNumber(10, i + 5, entry.getDiarrheaCasesLess1Day())); 
            sheet.addCell(createNumber(11, i + 5, entry.getDiarrheaCasesLess2Days())); 
            sheet.addCell(createNumber(12, i + 5, entry.getDiarrheaCasesLess3Days())); 
            sheet.addCell(createNumber(13, i + 5, entry.getFastBreathCasesLess1Day())); 
            sheet.addCell(createNumber(14, i + 5, entry.getFastBreathCasesLess2Days())); 
            sheet.addCell(createNumber(15, i + 5, entry.getFastBreathCasesLess3Days())); 
            sheet.addCell(createNumber(16, i + 5, entry.getSupervisorVisits())); 
            sheet.addCell(createNumber(17, i + 5, entry.getMentorshipSessions())); 
            sheet.addCell(createNumber(18, i + 5, entry.getDaysstockedoutLA6X1())); 
            sheet.addCell(createNumber(19, i + 5, entry.getDaysstockedoutLA6X2())); 
            sheet.addCell(createNumber(20, i + 5, entry.getDaysstockedoutORS())); 
            sheet.addCell(createNumber(21, i + 5, entry.getDaysstockedoutCotrimoxazole())); 
            sheet.addCell(createNumber(22, i + 5, entry.getDaysstockedoutZinc())); 
            sheet.addCell(createNumber(23, i + 5, entry.getDaysstockedoutEyeOintment())); 
        }
        
        workbook.write(); 
        workbook.close(); 

    }
    
    private Number createNumber(int column, int row, double value)
    {
        return new Number(column, row, value);
    }
    private Label createLabel(int column, int row, String text)
    {
        return new Label(column, row, text);
    }
    private DateTime createDate(int column, int row, Date date)
    {
        return new DateTime(column, row, date);
    }
    
    public static void main(String [] args) throws IOException, WriteException, NonexistentEntityException, Exception
    {
        KuvelaControllersInterface test = new KuvelaControllersInterface();
        test.rewardPoints("+254729111366");
    }
}
