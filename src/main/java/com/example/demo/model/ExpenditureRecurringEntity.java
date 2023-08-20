package com.example.demo.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recurring_expenditure")
public class ExpenditureRecurringEntity {

    @Id
    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "physical_expenditure")
    private BigDecimal physicalExpenditure;

    @Column(name = "advertisement_expenses")
    private BigDecimal advertisementExpenses;

    @Column(name = "audit_fee")
    private BigDecimal auditFee;

    @Column(name = "bank_charges")
    private BigDecimal bankCharges;

    @Column(name = "books_and_periodicals_journals")
    private BigDecimal booksAndPeriodicalsJournals;

    @Column(name = "electricity_charges")
    private BigDecimal electricityCharges;

    @Column(name = "financial_charges_or_interest_charges")
    private BigDecimal financialChargesOrInterestCharges;

    @Column(name = "general_expenses")
    private BigDecimal generalExpenses;

    @Column(name = "guest_house_maintenance")
    private BigDecimal guestHouseMaintenance;

    @Column(name = "horticulture_expenses")
    private BigDecimal horticultureExpenses;

    @Column(name = "house_keeping_charges")
    private BigDecimal houseKeepingCharges;

    @Column(name = "students_insurance_and_building_insurance")
    private BigDecimal studentsInsuranceAndBuildingInsurance;

    @Column(name = "professional_charges")
    private BigDecimal professionalCharges;

    @Column(name = "rates_and_taxes_professional_tax_property_tax")
    private BigDecimal ratesAndTaxesProfessionalTaxPropertyTax;

    @Column(name = "repairs_and_maintenance")
    private BigDecimal repairsAndMaintenance;

    @Column(name = "building_maintenance")
    private BigDecimal buildingMaintenance;

    @Column(name = "vehicle_maintenance")
    private BigDecimal vehicleMaintenance;

    @Column(name = "electrical_maintenance")
    private BigDecimal electricalMaintenance;

    @Column(name = "computer_maintenance")
    private BigDecimal computerMaintenance;

    @Column(name = "generator_maintenance")
    private BigDecimal generatorMaintenance;

    @Column(name = "furniture_maintenance")
    private BigDecimal furnitureMaintenance;

    @Column(name = "security_charges")
    private BigDecimal securityCharges;

    @Column(name = "telephone_charges")
    private BigDecimal telephoneCharges;

    @Column(name = "transportation_of_goods_and_service")
    private BigDecimal transportationOfGoodsAndService;

    @Column(name = "water_treatment_plant_maintenance")
    private BigDecimal waterTreatmentPlantMaintenance;

    @Column(name = "sewage_treatment_plant_expenses")
    private BigDecimal sewageTreatmentPlantExpenses;

    @Column(name = "academic_expenditure")
    private BigDecimal academicExpenditure;

    @Column(name = "statutory_inspections_and_accreditation_expenses")
    private BigDecimal statutoryInspectionsAndAccreditationExpenses;

    @Column(name = "nba_naac_autonomous_ffc")
    private BigDecimal nbaNaacAutonomousFfc;

    @Column(name = "affiliation_fee")
    private BigDecimal affiliationFee;

    @Column(name = "jntu_common_service_fees")
    private BigDecimal jntuCommonServiceFees;

    @Column(name = "students_gifts_merit_prizes")
    private BigDecimal studentsGiftsMeritPrizes;

    @Column(name = "governing_body_expenses")
    private BigDecimal governingBodyExpenses;

    @Column(name = "faculty_car_hire_charges")
    private BigDecimal facultyCarHireCharges;

    @Column(name = "faculty_development_programs")
    private BigDecimal facultyDevelopmentPrograms;

    @Column(name = "examination_expenses_board_of_study_expenses")
    private BigDecimal examinationExpensesBoardOfStudyExpenses;

    @Column(name = "staff_conveyance_and_travelling_expenses")
    private BigDecimal staffConveyanceAndTravellingExpenses;

    @Column(name = "hospital_stifund_expenses")
    private BigDecimal hospitalStifundExpenses;

    @Column(name = "hospitality_charges")
    private BigDecimal hospitalityCharges;

    @Column(name = "inspection_charges_aicte_jntu_ntruhs")
    private BigDecimal inspectionChargesAicteJntuNtruhs;

    @Column(name = "internet_website_expenses")
    private BigDecimal internetWebsiteExpenses;

    @Column(name = "students_extra_co_curricular_activities")
    private BigDecimal studentsExtraCoCurricularActivities;

    @Column(name = "first_induction_program")
    private BigDecimal firstInductionProgram;

    @Column(name = "annual_day_expenses")
    private BigDecimal annualDayExpenses;

    @Column(name = "specify_and_other_functions")
    private BigDecimal specifyAndOtherFunctions;

    @Column(name = "lab_maintenance")
    private BigDecimal labMaintenance;

    @Column(name = "consumables")
    private BigDecimal consumables;

    @Column(name = "glasswares")
    private BigDecimal glasswares;

    @Column(name = "membership_certification_exps")
    private BigDecimal membershipCertificationExps;

    @Column(name = "pg_new_courses_new_colleges")
    private BigDecimal pgNewCoursesNewColleges;

    @Column(name = "postage_and_courier_charges")
    private BigDecimal postageAndCourierCharges;

    @Column(name = "printing_and_stationery")
    private BigDecimal printingAndStationery;

    @Column(name = "research_and_development")
    private BigDecimal researchAndDevelopment;

    @Column(name = "in_house_randd")
    private BigDecimal inHouseRandD;

    @Column(name = "consultancy_incentives")
    private BigDecimal consultancyIncentives;

    @Column(name = "seed_funding")
    private BigDecimal seedFunding;

    @Column(name = "incentives_for_paper_publication")
    private BigDecimal incentivesForPaperPublication;

    @Column(name = "incentives_on_patents")
    private BigDecimal incentivesOnPatents;

    @Column(name = "seminar_and_workshops")
    private BigDecimal seminarAndWorkshops;

    @Column(name = "students_extra_curricular_activities_development")
    private BigDecimal studentsExtraCurricularActivitiesDevelopment;

    @Column(name = "remunerations_to_visiting_faculty")
    private BigDecimal remunerationsToVisitingFaculty;

    @Column(name = "placement_training_and_recruitment_cell")
    private BigDecimal placementTrainingAndRecruitmentCell;

    @Column(name = "fm_vtv_maintenance")
    private BigDecimal fmVtvMaintenance;

    @Column(name = "students_concession_fee")
    private BigDecimal studentsConcessionFee;

    @Column(name = "grants_expenditure")
    private BigDecimal grantsExpenditure;

    @Column(name = "board_of_study_expenses")
    private BigDecimal boardOfStudyExpenses;

    @Column(name = "personnel_expenses")
    private BigDecimal personnelExpenses;

    @Column(name = "salaries_and_wages")
    private BigDecimal salariesAndWages;

    @Column(name = "provident_fund_epf_fpf")
    private BigDecimal providentFundEpfFpf;

    @Column(name = "staff_welfare")
    private BigDecimal staffWelfare;

    @Column(name = "contribution_to_esi")
    private BigDecimal contributionToEsi;

    @Column(name = "mediclaim")
    private BigDecimal mediclaim;

    @Column(name = "gratuity_provision_premium")
    private BigDecimal gratuityProvisionPremium;

    @Column(name = "total_recurring_expenditure")
    private BigDecimal totalRecurringExpenditure;
    
    @Column(name="surplus_before_capex")
    private BigDecimal surplusBeforeCapeX;

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public BigDecimal getPhysicalExpenditure() {
		return physicalExpenditure;
	}

	public void setPhysicalExpenditure(BigDecimal physicalExpenditure) {
		this.physicalExpenditure = physicalExpenditure;
	}

	public BigDecimal getAdvertisementExpenses() {
		return advertisementExpenses;
	}

	public void setAdvertisementExpenses(BigDecimal advertisementExpenses) {
		this.advertisementExpenses = advertisementExpenses;
	}

	public BigDecimal getAuditFee() {
		return auditFee;
	}

	public void setAuditFee(BigDecimal auditFee) {
		this.auditFee = auditFee;
	}

	public BigDecimal getBankCharges() {
		return bankCharges;
	}

	public void setBankCharges(BigDecimal bankCharges) {
		this.bankCharges = bankCharges;
	}

	public BigDecimal getBooksAndPeriodicalsJournals() {
		return booksAndPeriodicalsJournals;
	}

	public void setBooksAndPeriodicalsJournals(BigDecimal booksAndPeriodicalsJournals) {
		this.booksAndPeriodicalsJournals = booksAndPeriodicalsJournals;
	}

	public BigDecimal getElectricityCharges() {
		return electricityCharges;
	}

	public void setElectricityCharges(BigDecimal electricityCharges) {
		this.electricityCharges = electricityCharges;
	}

	public BigDecimal getFinancialChargesOrInterestCharges() {
		return financialChargesOrInterestCharges;
	}

	public void setFinancialChargesOrInterestCharges(BigDecimal financialChargesOrInterestCharges) {
		this.financialChargesOrInterestCharges = financialChargesOrInterestCharges;
	}

	public BigDecimal getGeneralExpenses() {
		return generalExpenses;
	}

	public void setGeneralExpenses(BigDecimal generalExpenses) {
		this.generalExpenses = generalExpenses;
	}

	public BigDecimal getGuestHouseMaintenance() {
		return guestHouseMaintenance;
	}

	public void setGuestHouseMaintenance(BigDecimal guestHouseMaintenance) {
		this.guestHouseMaintenance = guestHouseMaintenance;
	}

	public BigDecimal getHorticultureExpenses() {
		return horticultureExpenses;
	}

	public void setHorticultureExpenses(BigDecimal horticultureExpenses) {
		this.horticultureExpenses = horticultureExpenses;
	}

	public BigDecimal getHouseKeepingCharges() {
		return houseKeepingCharges;
	}

	public void setHouseKeepingCharges(BigDecimal houseKeepingCharges) {
		this.houseKeepingCharges = houseKeepingCharges;
	}

	public BigDecimal getStudentsInsuranceAndBuildingInsurance() {
		return studentsInsuranceAndBuildingInsurance;
	}

	public void setStudentsInsuranceAndBuildingInsurance(BigDecimal studentsInsuranceAndBuildingInsurance) {
		this.studentsInsuranceAndBuildingInsurance = studentsInsuranceAndBuildingInsurance;
	}

	public BigDecimal getProfessionalCharges() {
		return professionalCharges;
	}

	public void setProfessionalCharges(BigDecimal professionalCharges) {
		this.professionalCharges = professionalCharges;
	}

	public BigDecimal getRatesAndTaxesProfessionalTaxPropertyTax() {
		return ratesAndTaxesProfessionalTaxPropertyTax;
	}

	public void setRatesAndTaxesProfessionalTaxPropertyTax(BigDecimal ratesAndTaxesProfessionalTaxPropertyTax) {
		this.ratesAndTaxesProfessionalTaxPropertyTax = ratesAndTaxesProfessionalTaxPropertyTax;
	}

	public BigDecimal getRepairsAndMaintenance() {
		return repairsAndMaintenance;
	}

	public void setRepairsAndMaintenance(BigDecimal repairsAndMaintenance) {
		this.repairsAndMaintenance = repairsAndMaintenance;
	}

	public BigDecimal getBuildingMaintenance() {
		return buildingMaintenance;
	}

	public void setBuildingMaintenance(BigDecimal buildingMaintenance) {
		this.buildingMaintenance = buildingMaintenance;
	}

	public BigDecimal getVehicleMaintenance() {
		return vehicleMaintenance;
	}

	public void setVehicleMaintenance(BigDecimal vehicleMaintenance) {
		this.vehicleMaintenance = vehicleMaintenance;
	}

	public BigDecimal getElectricalMaintenance() {
		return electricalMaintenance;
	}

	public void setElectricalMaintenance(BigDecimal electricalMaintenance) {
		this.electricalMaintenance = electricalMaintenance;
	}

	public BigDecimal getComputerMaintenance() {
		return computerMaintenance;
	}

	public void setComputerMaintenance(BigDecimal computerMaintenance) {
		this.computerMaintenance = computerMaintenance;
	}

	public BigDecimal getGeneratorMaintenance() {
		return generatorMaintenance;
	}

	public void setGeneratorMaintenance(BigDecimal generatorMaintenance) {
		this.generatorMaintenance = generatorMaintenance;
	}

	public BigDecimal getFurnitureMaintenance() {
		return furnitureMaintenance;
	}

	public void setFurnitureMaintenance(BigDecimal furnitureMaintenance) {
		this.furnitureMaintenance = furnitureMaintenance;
	}

	public BigDecimal getSecurityCharges() {
		return securityCharges;
	}

	public void setSecurityCharges(BigDecimal securityCharges) {
		this.securityCharges = securityCharges;
	}

	public BigDecimal getTelephoneCharges() {
		return telephoneCharges;
	}

	public void setTelephoneCharges(BigDecimal telephoneCharges) {
		this.telephoneCharges = telephoneCharges;
	}

	public BigDecimal getTransportationOfGoodsAndService() {
		return transportationOfGoodsAndService;
	}

	public void setTransportationOfGoodsAndService(BigDecimal transportationOfGoodsAndService) {
		this.transportationOfGoodsAndService = transportationOfGoodsAndService;
	}

	public BigDecimal getWaterTreatmentPlantMaintenance() {
		return waterTreatmentPlantMaintenance;
	}

	public void setWaterTreatmentPlantMaintenance(BigDecimal waterTreatmentPlantMaintenance) {
		this.waterTreatmentPlantMaintenance = waterTreatmentPlantMaintenance;
	}

	public BigDecimal getSewageTreatmentPlantExpenses() {
		return sewageTreatmentPlantExpenses;
	}

	public void setSewageTreatmentPlantExpenses(BigDecimal sewageTreatmentPlantExpenses) {
		this.sewageTreatmentPlantExpenses = sewageTreatmentPlantExpenses;
	}

	public BigDecimal getAcademicExpenditure() {
		return academicExpenditure;
	}

	public void setAcademicExpenditure(BigDecimal academicExpenditure) {
		this.academicExpenditure = academicExpenditure;
	}

	public BigDecimal getStatutoryInspectionsAndAccreditationExpenses() {
		return statutoryInspectionsAndAccreditationExpenses;
	}

	public void setStatutoryInspectionsAndAccreditationExpenses(BigDecimal statutoryInspectionsAndAccreditationExpenses) {
		this.statutoryInspectionsAndAccreditationExpenses = statutoryInspectionsAndAccreditationExpenses;
	}

	public BigDecimal getNbaNaacAutonomousFfc() {
		return nbaNaacAutonomousFfc;
	}
	

	public BigDecimal getSurplusBeforeCapeX() {
		return surplusBeforeCapeX;
	}

	public void setSurplusBeforeCapeX(BigDecimal surplusBeforeCapeX) {
		this.surplusBeforeCapeX = surplusBeforeCapeX;
	}

	public void setNbaNaacAutonomousFfc(BigDecimal nbaNaacAutonomousFfc) {
		this.nbaNaacAutonomousFfc = nbaNaacAutonomousFfc;
	}

	public BigDecimal getAffiliationFee() {
		return affiliationFee;
	}

	public void setAffiliationFee(BigDecimal affiliationFee) {
		this.affiliationFee = affiliationFee;
	}

	public BigDecimal getJntuCommonServiceFees() {
		return jntuCommonServiceFees;
	}

	public void setJntuCommonServiceFees(BigDecimal jntuCommonServiceFees) {
		this.jntuCommonServiceFees = jntuCommonServiceFees;
	}

	public BigDecimal getStudentsGiftsMeritPrizes() {
		return studentsGiftsMeritPrizes;
	}

	public void setStudentsGiftsMeritPrizes(BigDecimal studentsGiftsMeritPrizes) {
		this.studentsGiftsMeritPrizes = studentsGiftsMeritPrizes;
	}

	public BigDecimal getGoverningBodyExpenses() {
		return governingBodyExpenses;
	}

	public void setGoverningBodyExpenses(BigDecimal governingBodyExpenses) {
		this.governingBodyExpenses = governingBodyExpenses;
	}

	public BigDecimal getFacultyCarHireCharges() {
		return facultyCarHireCharges;
	}

	public void setFacultyCarHireCharges(BigDecimal facultyCarHireCharges) {
		this.facultyCarHireCharges = facultyCarHireCharges;
	}

	public BigDecimal getFacultyDevelopmentPrograms() {
		return facultyDevelopmentPrograms;
	}

	public void setFacultyDevelopmentPrograms(BigDecimal facultyDevelopmentPrograms) {
		this.facultyDevelopmentPrograms = facultyDevelopmentPrograms;
	}

	public BigDecimal getExaminationExpensesBoardOfStudyExpenses() {
		return examinationExpensesBoardOfStudyExpenses;
	}

	public void setExaminationExpensesBoardOfStudyExpenses(BigDecimal examinationExpensesBoardOfStudyExpenses) {
		this.examinationExpensesBoardOfStudyExpenses = examinationExpensesBoardOfStudyExpenses;
	}

	public BigDecimal getStaffConveyanceAndTravellingExpenses() {
		return staffConveyanceAndTravellingExpenses;
	}

	public void setStaffConveyanceAndTravellingExpenses(BigDecimal staffConveyanceAndTravellingExpenses) {
		this.staffConveyanceAndTravellingExpenses = staffConveyanceAndTravellingExpenses;
	}

	public BigDecimal getHospitalStifundExpenses() {
		return hospitalStifundExpenses;
	}

	public void setHospitalStifundExpenses(BigDecimal hospitalStifundExpenses) {
		this.hospitalStifundExpenses = hospitalStifundExpenses;
	}

	public BigDecimal getHospitalityCharges() {
		return hospitalityCharges;
	}

	public void setHospitalityCharges(BigDecimal hospitalityCharges) {
		this.hospitalityCharges = hospitalityCharges;
	}

	public BigDecimal getInspectionChargesAicteJntuNtruhs() {
		return inspectionChargesAicteJntuNtruhs;
	}

	public void setInspectionChargesAicteJntuNtruhs(BigDecimal inspectionChargesAicteJntuNtruhs) {
		this.inspectionChargesAicteJntuNtruhs = inspectionChargesAicteJntuNtruhs;
	}

	public BigDecimal getInternetWebsiteExpenses() {
		return internetWebsiteExpenses;
	}

	public void setInternetWebsiteExpenses(BigDecimal internetWebsiteExpenses) {
		this.internetWebsiteExpenses = internetWebsiteExpenses;
	}

	public BigDecimal getStudentsExtraCoCurricularActivities() {
		return studentsExtraCoCurricularActivities;
	}

	public void setStudentsExtraCoCurricularActivities(BigDecimal studentsExtraCoCurricularActivities) {
		this.studentsExtraCoCurricularActivities = studentsExtraCoCurricularActivities;
	}

	public BigDecimal getFirstInductionProgram() {
		return firstInductionProgram;
	}

	public void setFirstInductionProgram(BigDecimal firstInductionProgram) {
		this.firstInductionProgram = firstInductionProgram;
	}

	public BigDecimal getAnnualDayExpenses() {
		return annualDayExpenses;
	}

	public void setAnnualDayExpenses(BigDecimal annualDayExpenses) {
		this.annualDayExpenses = annualDayExpenses;
	}

	public BigDecimal getSpecifyAndOtherFunctions() {
		return specifyAndOtherFunctions;
	}

	public void setSpecifyAndOtherFunctions(BigDecimal specifyAndOtherFunctions) {
		this.specifyAndOtherFunctions = specifyAndOtherFunctions;
	}

	public BigDecimal getLabMaintenance() {
		return labMaintenance;
	}

	public void setLabMaintenance(BigDecimal labMaintenance) {
		this.labMaintenance = labMaintenance;
	}

	public BigDecimal getConsumables() {
		return consumables;
	}

	public void setConsumables(BigDecimal consumables) {
		this.consumables = consumables;
	}

	public BigDecimal getGlasswares() {
		return glasswares;
	}

	public void setGlasswares(BigDecimal glasswares) {
		this.glasswares = glasswares;
	}

	public BigDecimal getMembershipCertificationExps() {
		return membershipCertificationExps;
	}

	public void setMembershipCertificationExps(BigDecimal membershipCertificationExps) {
		this.membershipCertificationExps = membershipCertificationExps;
	}

	public BigDecimal getPgNewCoursesNewColleges() {
		return pgNewCoursesNewColleges;
	}

	public void setPgNewCoursesNewColleges(BigDecimal pgNewCoursesNewColleges) {
		this.pgNewCoursesNewColleges = pgNewCoursesNewColleges;
	}

	public BigDecimal getPostageAndCourierCharges() {
		return postageAndCourierCharges;
	}

	public void setPostageAndCourierCharges(BigDecimal postageAndCourierCharges) {
		this.postageAndCourierCharges = postageAndCourierCharges;
	}

	public BigDecimal getPrintingAndStationery() {
		return printingAndStationery;
	}

	public void setPrintingAndStationery(BigDecimal printingAndStationery) {
		this.printingAndStationery = printingAndStationery;
	}

	public BigDecimal getResearchAndDevelopment() {
		return researchAndDevelopment;
	}

	public void setResearchAndDevelopment(BigDecimal researchAndDevelopment) {
		this.researchAndDevelopment = researchAndDevelopment;
	}

	public BigDecimal getInHouseRandD() {
		return inHouseRandD;
	}

	public void setInHouseRandD(BigDecimal inHouseRandD) {
		this.inHouseRandD = inHouseRandD;
	}

	public BigDecimal getConsultancyIncentives() {
		return consultancyIncentives;
	}

	public void setConsultancyIncentives(BigDecimal consultancyIncentives) {
		this.consultancyIncentives = consultancyIncentives;
	}

	public BigDecimal getSeedFunding() {
		return seedFunding;
	}

	public void setSeedFunding(BigDecimal seedFunding) {
		this.seedFunding = seedFunding;
	}

	public BigDecimal getIncentivesForPaperPublication() {
		return incentivesForPaperPublication;
	}

	public void setIncentivesForPaperPublication(BigDecimal incentivesForPaperPublication) {
		this.incentivesForPaperPublication = incentivesForPaperPublication;
	}

	public BigDecimal getIncentivesOnPatents() {
		return incentivesOnPatents;
	}

	public void setIncentivesOnPatents(BigDecimal incentivesOnPatents) {
		this.incentivesOnPatents = incentivesOnPatents;
	}

	public BigDecimal getSeminarAndWorkshops() {
		return seminarAndWorkshops;
	}

	public void setSeminarAndWorkshops(BigDecimal seminarAndWorkshops) {
		this.seminarAndWorkshops = seminarAndWorkshops;
	}

	public BigDecimal getStudentsExtraCurricularActivitiesDevelopment() {
		return studentsExtraCurricularActivitiesDevelopment;
	}

	public void setStudentsExtraCurricularActivitiesDevelopment(BigDecimal studentsExtraCurricularActivitiesDevelopment) {
		this.studentsExtraCurricularActivitiesDevelopment = studentsExtraCurricularActivitiesDevelopment;
	}

	public BigDecimal getRemunerationsToVisitingFaculty() {
		return remunerationsToVisitingFaculty;
	}

	public void setRemunerationsToVisitingFaculty(BigDecimal remunerationsToVisitingFaculty) {
		this.remunerationsToVisitingFaculty = remunerationsToVisitingFaculty;
	}

	public BigDecimal getPlacementTrainingAndRecruitmentCell() {
		return placementTrainingAndRecruitmentCell;
	}

	public void setPlacementTrainingAndRecruitmentCell(BigDecimal placementTrainingAndRecruitmentCell) {
		this.placementTrainingAndRecruitmentCell = placementTrainingAndRecruitmentCell;
	}

	public BigDecimal getFmVtvMaintenance() {
		return fmVtvMaintenance;
	}

	public void setFmVtvMaintenance(BigDecimal fmVtvMaintenance) {
		this.fmVtvMaintenance = fmVtvMaintenance;
	}

	public BigDecimal getStudentsConcessionFee() {
		return studentsConcessionFee;
	}

	public void setStudentsConcessionFee(BigDecimal studentsConcessionFee) {
		this.studentsConcessionFee = studentsConcessionFee;
	}

	public BigDecimal getGrantsExpenditure() {
		return grantsExpenditure;
	}

	public void setGrantsExpenditure(BigDecimal grantsExpenditure) {
		this.grantsExpenditure = grantsExpenditure;
	}

	public BigDecimal getBoardOfStudyExpenses() {
		return boardOfStudyExpenses;
	}

	public void setBoardOfStudyExpenses(BigDecimal boardOfStudyExpenses) {
		this.boardOfStudyExpenses = boardOfStudyExpenses;
	}

	public BigDecimal getPersonnelExpenses() {
		return personnelExpenses;
	}

	public void setPersonnelExpenses(BigDecimal personnelExpenses) {
		this.personnelExpenses = personnelExpenses;
	}

	public BigDecimal getSalariesAndWages() {
		return salariesAndWages;
	}

	public void setSalariesAndWages(BigDecimal salariesAndWages) {
		this.salariesAndWages = salariesAndWages;
	}

	public BigDecimal getProvidentFundEpfFpf() {
		return providentFundEpfFpf;
	}

	public void setProvidentFundEpfFpf(BigDecimal providentFundEpfFpf) {
		this.providentFundEpfFpf = providentFundEpfFpf;
	}

	public BigDecimal getStaffWelfare() {
		return staffWelfare;
	}

	public void setStaffWelfare(BigDecimal staffWelfare) {
		this.staffWelfare = staffWelfare;
	}

	public BigDecimal getContributionToEsi() {
		return contributionToEsi;
	}

	public void setContributionToEsi(BigDecimal contributionToEsi) {
		this.contributionToEsi = contributionToEsi;
	}

	public BigDecimal getMediclaim() {
		return mediclaim;
	}

	public void setMediclaim(BigDecimal mediclaim) {
		this.mediclaim = mediclaim;
	}

	public BigDecimal getGratuityProvisionPremium() {
		return gratuityProvisionPremium;
	}

	public void setGratuityProvisionPremium(BigDecimal gratuityProvisionPremium) {
		this.gratuityProvisionPremium = gratuityProvisionPremium;
	}

	public BigDecimal getTotalRecurringExpenditure() {
		return totalRecurringExpenditure;
	}

	public void setTotalRecurringExpenditure(BigDecimal totalRecurringExpenditure) {
		this.totalRecurringExpenditure = totalRecurringExpenditure;
	}

    // Constructor, Getter and Setter methods, and other business logic
    // ...
	
}
