create database kuvela;

use kuvela;

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

DROP TABLE IF EXISTS `facility_stock`;
CREATE TABLE IF NOT EXISTS `facility_stock` (
  `fs_ID` int(11) NOT NULL AUTO_INCREMENT,
  `sender` varchar(10) NOT NULL DEFAULT '',
  `submission_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `health_facility_id` int(11) NOT NULL,
  `reporting_year` int(11) NOT NULL,
  `reporting_month` int(11) NOT NULL,
  `total_dispensed_LA_6X1` int(11) NOT NULL,
  `total_dispensed_LA_6X2` int(11) NOT NULL,
  `total_dispensed_ORS` int(11) NOT NULL,
  `total_dispensed_Cotrimoxazole` int(11) NOT NULL,
  `total_dispensed_Zinc` int(11) NOT NULL,
  `total_dispensed_Eye_Ointment` int(11) NOT NULL,
  `days_stocked_out_LA_6X1` int(11) NOT NULL,
  `days_stocked_out_LA_6X2` int(11) NOT NULL,
  `days_stocked_out_ORS` int(11) NOT NULL,
  `days_stocked_out_Cotrimoxazole` int(11) NOT NULL,
  `days_stocked_out_Zinc` int(11) NOT NULL,
  `days_stocked_out_Eye_Ointment` int(11) NOT NULL,
  PRIMARY KEY (`fs_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;


DROP TABLE IF EXISTS `village_clinic_monthly_report`;
CREATE TABLE IF NOT EXISTS `village_clinic_monthly_report` (
  `vcmr_ID` int(11) NOT NULL AUTO_INCREMENT,
  `sender` varchar(10) NOT NULL DEFAULT '',
  `submission_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `village_clinic_id` int(11) NOT NULL,
  `reporting_year` int(11) NOT NULL,
  `reporting_month` int(11) NOT NULL,
  `if_residence` varchar(5) NOT NULL DEFAULT '',
  `fever_cases_less_1_day` int(11) NOT NULL,
  `fever_cases_less_2_days` int(11) NOT NULL,
  `fever_cases_less_3_days` int(11) NOT NULL,
  `diarrhea_cases_less_1_day` int(11) NOT NULL,
  `diarrhea_cases_less_2_days` int(11) NOT NULL,
  `diarrhea_cases_less_3_days` int(11) NOT NULL,
  `fast_breath_cases_less_1_day` int(11) NOT NULL,
  `fast_breath_cases_less_2_days` int(11) NOT NULL,
  `fast_breath_cases_less_3_days` int(11) NOT NULL,
  `supervisor_visits` int(11) NOT NULL,
  `mentorship_sessions` int(11) NOT NULL,
  `days_stocked_out_LA_6X1` int(11) NOT NULL,
  `days_stocked_out_LA_6X2` int(11) NOT NULL,
  `days_stocked_out_ORS` int(11) NOT NULL,
  `days_stocked_out_Cotrimoxazole` int(11) NOT NULL,
  `days_stocked_out_Zinc` int(11) NOT NULL,
  `days_stocked_out_Eye_Ointment` int(11) NOT NULL,
  PRIMARY KEY (`vcmr_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

