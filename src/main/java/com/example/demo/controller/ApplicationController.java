package com.example.demo.controller;

import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.http.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.AttributeEntity;
import com.example.demo.model.DepartmentsEntity;
import com.example.demo.model.ExpenditureRecurringEntity;
import com.example.demo.model.IncomeEntity;
import com.example.demo.model.ExpenditureNonRecurringEntity;

import com.example.demo.model.IncomeFormDTO;
import com.example.demo.repository.DepartmentsRepository;
import com.example.demo.repository.ExpenditureNonRecurringRepository;
import com.example.demo.repository.ExpenditureRecurringRepository;
import com.example.demo.repository.IncomeRepository;

import com.example.demo.service.BudgetService;
import com.example.demo.service.DepartmentsService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;

@Controller
public class ApplicationController {
	private final DepartmentsRepository departmentsRepository;
	private final DepartmentsService departmentsService;
	private final BudgetService budgetService;
	private final IncomeRepository incomeRepository;
	private final ExpenditureRecurringRepository expenditureRecurringRepository;
	private final ExpenditureNonRecurringRepository expenditureNonRecurringRepository;

	public ApplicationController(DepartmentsRepository departmentsRepository, DepartmentsService departmentsService,
			BudgetService budgetService, IncomeRepository incomeRepository,
			ExpenditureRecurringRepository expenditureRecurringRepository,
			ExpenditureNonRecurringRepository expenditureNonRecurringRepository) {
		this.departmentsRepository = departmentsRepository;
		this.departmentsService = departmentsService;
		this.incomeRepository = incomeRepository;
		this.budgetService = budgetService;
		this.expenditureRecurringRepository = expenditureRecurringRepository;
		this.expenditureNonRecurringRepository = expenditureNonRecurringRepository;

	}

	@GetMapping("/")
	public String homePage(Model model) {
		List<DepartmentsEntity> departmentList = departmentsService.getAllDepartments();
		model.addAttribute("departmentNames", departmentList);
		return "Home";
	}

	@GetMapping("/generate-pdf/{id}")
	void generatePDF(@PathVariable("id") int departmentId, HttpServletResponse response) {
		DepartmentsEntity department = departmentsService.getDepartmentWithAttributes(departmentId);
		List<String> attributeOrder = Arrays.asList(

				"Income", "Total Tuition Fee", "B.Tech / B.Pharm / BDS / Polytechnic/School",
				"M.Tec/ Mpharm / MDS/MBA/ MCA", "Research Grants", "Hospital Revenue (clinic wise)",
				"Hostel Fee and Mess Fee", "Transportation Fee", "Other Revenue (Radio Vishnu 90.4)", "Total Income",
				"Recurring Expenditure", "Physical-Expenditure", "Advertisement Expenses", "Audit Fee", "Bank Charges",
				"Books and Periodicals, Journals", "Electricity Charges", "Financial Charges / Interest Charges",
				"General Expenses", "Guest House Maintenance", "Horticulture Expenses", "House Keeping Charges",
				"Students Insurance and Building Insurance", "Professional Charges",
				"Rates and Taxes, Professional Tax, Property Tax", "Total Repairs and Maintenance Expenses",
				"Building Maintenance", "Vehicle Maintenance", "Electrical Maintenance", "Computer Maintenance",
				"Generator Maintenance", "Furniture Maintenance", "Security charges", "Telephone Charges",
				"Transportation of Goods and Service", "Water treatment plant Maintenance",
				"Sewage treatment plant expenses", "Physical Expenditure", "Academic-Expenditure",
				"Statutory Inspections and Accreditation Expenses", "NBA / NAAC/ Autonomous/ FFC", "Affiliation Fee",
				"JNTU Common Service Fees", "Students Gifts, Merit Prizes", "Governing body expenses",
				"Faculty car hire charges", "Faculty development programs",
				"Examination expenses and board of study expenses", "Staff conveyance and travelling expenses",
				"Hospital stifund expenses", "Hospitality charges", "Inspection Charges (AICTE / JNTU/NTUHS)",
				"Internet / Website Expenses", "Students Extra Co-Curricular Activities", "1st Induction Program",
				"Annual day expenses", "Specify and other Functions", "Total Expenses for Lab Maintenance",
				"Consumables", "Glasswares", "Membership, Certification Exps", "PG New Courses/ New Colleges",
				"Postage and Courier Charges", "Printing and Stationery", "Total Expenses on Research and Development",
				"In House R&D", "Consultancy Incentives", "Seed Funding", "Incentives for paper publication",
				"Incentives on Patents", "Seminar and Workshops", "Students extra curricular activities(development)",
				"Remunerations to visiting faculty", "Placement training and Recruitment cell", "FM / VTV Maintenanace",
				"Students concession fee", "Grants expenditure", "Board of study expenses", "Total Personnel expenses",
				"Salaries and Wages", "Provident Fund (EPF+FPF)", "Staff welfare", "Contribution to ESI", "Mediclaim",
				"Gratuity Provision / Premium", "Academic expenditure", "Total recurring expenditure",
				"Surplus before CapeX", "Infrastructure requirements", "Lab Equipments", "Computers and Peripherals",
				"Softwares of all Departments", "Furniture and Fixtures", "Air-conditioner/projectors/UPS",
				"Electrical equipment", "Library books and journals", "Sports equipment", "Motor vehicles",
				"Net Surplus/Deficit after CapeX", "Total Non-Recurring Expenditure");

		List<String> nonBoldAttributes = Arrays.asList("B.Tech / B.Pharm / BDS / Polytechnic/School",
				"M.Tec/ Mpharm / MDS/MBA/ MCA", "Building Maintenance", "Vehicle Maintenance", "Electrical Maintenance",
				"Computer Maintenance", "Generator Maintenance", "Furniture Maintenance", "NBA / NAAC/ Autonomous/ FFC",
				"1st Induction Program", "Annual day expenses", "Specify and other Functions", "Consumables",
				"Glasswares", "In House R&D", "Consultancy Incentives", "Seed Funding",
				"Incentives for paper publication", "Incentives on Patents");

		try {
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=department_" + departmentId + ".pdf");

			ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
			Document document = new Document();
			PdfWriter.getInstance(document, pdfOutputStream);

			document.open();

			Font headingFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
			Paragraph heading = new Paragraph("Shri Vishnu Engineering College for Women", headingFont);
			heading.setAlignment(Element.ALIGN_CENTER);
			document.add(heading);

			Font subheadingFont = FontFactory.getFont(FontFactory.HELVETICA, 16);
			Paragraph subheading = new Paragraph("Budget for the year 2023-24", subheadingFont);
			subheading.setAlignment(Element.ALIGN_CENTER);
			document.add(subheading);

			document.add(new Paragraph(" "));
			float cellWidth = 200f;

			PdfPTable table = new PdfPTable(2);
			PdfPCell headerCell1 = new PdfPCell(
					new Phrase("Particulars", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
			PdfPCell headerCell2 = new PdfPCell(
					new Phrase("Proposed Budget 2023-24", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));

			headerCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			headerCell2.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(headerCell1);
			table.addCell(headerCell2);

			for (String attributeName : attributeOrder) {
				AttributeEntity attribute = findAttributeByName(department.getAttributes(), attributeName);
				if (attribute == null) {
					if ("Physical-Expenditure".equals(attributeName)) {

						PdfPCell missingAttributeCell = new PdfPCell();
						missingAttributeCell.setColspan(1);
						missingAttributeCell.setFixedHeight(40f);

						missingAttributeCell.setHorizontalAlignment(Element.ALIGN_LEFT);
						missingAttributeCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

						Font missingAttributeFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11);
						Phrase missingAttributePhrase = new Phrase(attributeName, missingAttributeFont);
						missingAttributeCell.setPhrase(missingAttributePhrase);

						table.addCell(missingAttributeCell);

						PdfPCell emptyCell = new PdfPCell();
						emptyCell.setColspan(1);
						emptyCell.setFixedHeight(10f);

						table.addCell(emptyCell);
					} else if ("Academic-Expenditure".equals(attributeName)) {
						PdfPCell missingAttributeCell = new PdfPCell();
						missingAttributeCell.setColspan(1);
						missingAttributeCell.setFixedHeight(40f);
						missingAttributeCell.setHorizontalAlignment(Element.ALIGN_LEFT);
						missingAttributeCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

						Font missingAttributeFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11);
						Phrase missingAttributePhrase = new Phrase(attributeName, missingAttributeFont);
						missingAttributeCell.setPhrase(missingAttributePhrase);

						table.addCell(missingAttributeCell);
						PdfPCell emptyCell = new PdfPCell();
						emptyCell.setColspan(1);
						emptyCell.setFixedHeight(10f);
						table.addCell(emptyCell);
					} else {
						PdfPCell mergedCell = new PdfPCell();
						mergedCell.setColspan(2);
						mergedCell.setFixedHeight(40f);
						mergedCell.setBorder(Rectangle.BOX);
						mergedCell.setHorizontalAlignment(Element.ALIGN_CENTER);

						Font missingAttributeFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11);
						Phrase missingAttributePhrase = new Phrase(attributeName, missingAttributeFont);
						mergedCell.setPhrase(missingAttributePhrase);

						table.addCell(mergedCell);
					}
				} else {

					PdfPCell attributeCell = new PdfPCell();
					PdfPCell valueCell = new PdfPCell();
					attributeCell.setFixedHeight(10f);
					attributeCell.setMinimumHeight(10f);
					attributeCell.setPadding(3);

					valueCell.setPhrase(new Phrase(attribute.getBudgetInLakhs().toString()));
					boolean isNonBoldAttribute = nonBoldAttributes.contains(attributeName);
					String attributeNameToDisplay = attributeName;
					if ("Total Tuition Fee".equals(attributeNameToDisplay)) {
						attributeNameToDisplay = "Tuition Fee";
					}
					if ("Total Income".equals(attributeNameToDisplay)) {
						attributeNameToDisplay = "Total";
					}
					if (isNonBoldAttribute) {

						Font nonBoldFont = FontFactory.getFont(FontFactory.HELVETICA, 11);
						attributeCell.addElement(new Phrase(attributeNameToDisplay, nonBoldFont));
						attributeCell.setHorizontalAlignment(Element.ALIGN_LEFT);
						attributeCell.setPaddingLeft(14);
					} else {

						Font boldFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11);
						attributeCell.addElement(new Phrase(attributeNameToDisplay, boldFont));
						attributeCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					}
					table.addCell(attributeCell);
					table.addCell(valueCell);
				}
			}
			document.add(table);
			document.close();

			response.getOutputStream().write(pdfOutputStream.toByteArray());
			response.getOutputStream().close();

		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
	}

	public AttributeEntity findAttributeByName(List<AttributeEntity> attributeList, String attributeName) {
		for (AttributeEntity attribute : attributeList) {
			if (attribute.getAttribute().equals(attributeName)) {
				return attribute;
			}
		}
		return null;
	}

	@GetMapping("/processDepartment")
	public String processDepartment(@RequestParam("departmentId") int departmentId, Model model) {

		DepartmentsEntity department = departmentsService.getDepartmentById(departmentId);
		model.addAttribute("selectedDepartment", department);

		return "Home";
	}

	@GetMapping("/department/{id}")
	public String displayDepartmentDetails(@PathVariable("id") int departmentId, Model model) {
//        List<String> incomeFields = budgetService.getIncomeEntityFields();
		Map<String, String> incomeFields = new HashMap<String, String>();
		Map<String, String> recurringFields = new HashMap<String, String>();
		Map<String, String> nonRecurringFields = new HashMap<String, String>();
		incomeFields.put("tuitionFee", "Total Tuition Fee");
		incomeFields.put("btechBPharmBdsPolytechnicSchool", "B.Tech/B.Pharm/BDS/Polytechnic/School (Tuition Fee)");
		incomeFields.put("mtechMpharmMdsMbaMca", "M.Tech/M.Pharm/MDS/MBA/MCA (Tuition Fee)");
		incomeFields.put("researchGrants", "Research Grants");
		incomeFields.put("hospitalRevenueClinicWise", "Hospital Revenue (Clinic Wise)");
		incomeFields.put("hostetFeeAndMessFee", "Hostel Fee and Mess Fee");
		incomeFields.put("transportationFee", "Transportation Fee");
		incomeFields.put("otherRevenueRadioVishnu904", "Other Revenue (Radio Vishnu 90.4)");
		incomeFields.put("totalIncome", "Total Income");
		recurringFields.put("physicalExpenditure", "Total Physical Expenditure");
		recurringFields.put("advertisementExpenses", "Advertisement Expenses");
		recurringFields.put("auditFee", "Audit Fee");
		recurringFields.put("bankCharges", "Bank Charges");
		recurringFields.put("booksAndPeriodicalsJournals", "Books and Periodicals Journals");
		recurringFields.put("electricityCharges", "Electricity Charges");
		recurringFields.put("financialChargesOrInterestCharges", "Financial Charges or Interest Charges");
		recurringFields.put("generalExpenses", "General Expenses");
		recurringFields.put("guestHouseMaintenance", "Guest House Maintenance");
		recurringFields.put("horticultureExpenses", "Horticulture Expenses");
		recurringFields.put("houseKeepingCharges", "House Keeping Charges");
		recurringFields.put("studentsInsuranceAndBuildingInsurance", "Students Insurance and Building Insurance");
		recurringFields.put("professionalCharges", "Professional Charges");
		recurringFields.put("ratesAndTaxesProfessionalTaxPropertyTax", "Rates and Taxes Professional Tax Property Tax");
		recurringFields.put("repairsAndMaintenance", "Total Expenditure on Repairs and Maintenance");
		recurringFields.put("buildingMaintenance", "Building Maintenance");
		recurringFields.put("vehicleMaintenance", "Vehicle Maintenance");
		recurringFields.put("electricalMaintenance", "Electrical Maintenance");
		recurringFields.put("computerMaintenance", "Computer Maintenance");
		recurringFields.put("generatorMaintenance", "Generator Maintenance");
		recurringFields.put("furnitureMaintenance", "Furniture Maintenance");
		recurringFields.put("securityCharges", "Security Charges");
		recurringFields.put("telephoneCharges", "Telephone Charges");
		recurringFields.put("transportationOfGoodsAndService", "Transportation of Goods and Service");
		recurringFields.put("waterTreatmentPlantMaintenance", "Water Treatment Plant Maintenance");
		recurringFields.put("sewageTreatmentPlantExpenses", "Sewage Treatment Plant Expenses");
		recurringFields.put("academicExpenditure", "Total Academic Expenditure");
		recurringFields.put("statutoryInspectionsAndAccreditationExpenses",
				"Statutory Inspections and Accreditation Expenses");
		recurringFields.put("nbaNaacAutonomousFfc",
				"NBA NAAC Autonomous FFC (Statutory Inspections and Accreditation Expenses)");
		recurringFields.put("affiliationFee", "Affiliation Fee");
		recurringFields.put("jntuCommonServiceFees", "JNTU Common Service Fees");
		recurringFields.put("studentsGiftsMeritPrizes", "Students Gifts Merit Prizes");
		recurringFields.put("governingBodyExpenses", "Governing Body Expenses");
		recurringFields.put("facultyCarHireCharges", "Faculty Car Hire Charges");
		recurringFields.put("facultyDevelopmentPrograms", "Faculty Development Programs");
		recurringFields.put("examinationExpensesBoardOfStudyExpenses", "Examination Expenses Board of Study Expenses");
		recurringFields.put("staffConveyanceAndTravellingExpenses", "Staff Conveyance and Travelling Expenses");
		recurringFields.put("hospitalStifundExpenses", "Hospital Stifund Expenses");
		recurringFields.put("hospitalityCharges", "Hospitality Charges");
		recurringFields.put("inspectionChargesAicteJntuNtruhs", "Inspection Charges (AICTE/JNTU/NTRUHS)");
		recurringFields.put("internetWebsiteExpenses", "Internet/Website Expenses");
		recurringFields.put("studentsExtraCoCurricularActivities",
				"Total Expenditure on Students Extra Co-curricular Activities");
		recurringFields.put("firstInductionProgram",
				"First Induction Program (Students Extra Co-curricular Activities)");
		recurringFields.put("annualDayExpenses", "Annual Day Expenses (Students Extra Co-curricular Activities)");
		recurringFields.put("specifyAndOtherFunctions",
				"Specify and Other Functions (Students Extra Co-curricular Activities)");
		recurringFields.put("labMaintenance", "Total Expenditure on Lab Maintenance");
		recurringFields.put("consumables", "Consumables (Lab Maintenance)");
		recurringFields.put("glasswares", "Glasswares (Lab Maintenance)");
		recurringFields.put("membershipCertificationExps", "Membership Certification Expenses");
		recurringFields.put("pgNewCoursesNewColleges", "PG New Courses New Colleges");
		recurringFields.put("postageAndCourierCharges", "Postage and Courier Charges");
		recurringFields.put("printingAndStationery", "Printing and Stationery");
		recurringFields.put("researchAndDevelopment", "Total Expenditure on Research and Development");
		recurringFields.put("inHouseRandD", "In-House R&D");
		recurringFields.put("consultancyIncentives", "Consultancy Incentives");
		recurringFields.put("seedFunding", "Seed Funding");
		recurringFields.put("incentivesForPaperPublication", "Incentives for Paper Publication");
		recurringFields.put("incentivesOnPatents", "Incentives on Patents");
		recurringFields.put("seminarAndWorkshops", "Seminar and Workshops");
		recurringFields.put("studentsExtraCurricularActivitiesDevelopment",
				"Students Extra Curricular Activities (Student Development Programs)");
		recurringFields.put("remunerationsToVisitingFaculty", "Remunerations to Visiting Faculty");
		recurringFields.put("placementTrainingAndRecruitmentCell", "Placement Training and Recruitment Cell");
		recurringFields.put("fmVtvMaintenance", "FM VTV Maintenance");
		recurringFields.put("studentsConcessionFee", "Students Concession Fee");
		recurringFields.put("grantsExpenditure", "Grants Expenditure");
		recurringFields.put("boardOfStudyExpenses", "Board of Study Expenses");
		recurringFields.put("personnelExpenses", "Total Personnel Expenses");
		recurringFields.put("salariesAndWages", "Salaries and Wages");
		recurringFields.put("providentFundEpfFpf", "Provident Fund (EPF+FPF)");
		recurringFields.put("staffWelfare", "Staff Welfare");
		recurringFields.put("contributionToEsi", "Contribution to ESI");
		recurringFields.put("mediclaim", "Mediclaim");
		recurringFields.put("gratuityProvisionPremium", "Gratuity Provision/Premium");
		recurringFields.put("totalRecurringExpenditure", "Total Recurring Expenditure");
		recurringFields.put("surplusBeforeCapeX", "Surplus Before CAPEX");
		nonRecurringFields.put("infrastructureRequirements", "Infrastrcture Requirements");
		nonRecurringFields.put("labEquipments", "Lab Equipments");
		nonRecurringFields.put("computersAndPeripherals", "Computers and Pheripherals");
		nonRecurringFields.put("softwaresOfAllDepartments", "Softwares of all Departments");
		nonRecurringFields.put("furnitureAndFixtures", "Furniture and Fixtures");
		nonRecurringFields.put("airConditionerProjectorsUps", "Air Conditioner / Projectors / UPS");
		nonRecurringFields.put("electricalEquipment", "Electrical Equipment");
		nonRecurringFields.put("libraryBooksAndJournals", "Library Books and Journals");
		nonRecurringFields.put("sportsEquipment", "Sports Equipment");
		nonRecurringFields.put("motorVehicles", "Motor Vehicles");
		nonRecurringFields.put("netSurplusDeficitAfterCapex", "Net Surplus/Deficit after CapeX");
		nonRecurringFields.put("totalNonRecurringExpenditure", "Total Non-Recurring Expenditure");

		DepartmentsEntity department = departmentsService.getDepartmentById(departmentId);
		model.addAttribute("name", department.getDepartmentName());
		model.addAttribute("incomeFields", incomeFields);
		model.addAttribute("recurringFields", recurringFields);
		model.addAttribute("nonRecurringFields", nonRecurringFields);
		model.addAttribute("departmentId", departmentId);

		return "template";
	}

	@PostMapping("/submit-income")
	public ResponseEntity<String> submitIncome(@RequestBody List<Map<String, String>> formData) {
		for (Map<String, String> fieldData : formData) {
			String fieldName = fieldData.get("fieldName");
			String fieldValue = fieldData.get("fieldValue");

			if ("departmentId".equals(fieldName)) {
				int departmentId = Integer.parseInt(fieldValue);
				Optional<IncomeEntity> existingIncome = incomeRepository.findById(departmentId);

				if (existingIncome.isPresent()) {
					IncomeEntity incomeEntity = existingIncome.get();
					setBigDecimalFieldIfExists(formData, "tuitionFee", incomeEntity::setTuitionFee);
					setBigDecimalFieldIfExists(formData, "btechBPharmBdsPolytechnicSchool",
							incomeEntity::setBtechBPharmBdsPolytechnicSchool);
					setBigDecimalFieldIfExists(formData, "mtechMpharmMdsMbaMca", incomeEntity::setMtechMpharmMdsMbaMca);
					setBigDecimalFieldIfExists(formData, "researchGrants", incomeEntity::setResearchGrants);
					setBigDecimalFieldIfExists(formData, "hospitalRevenueClinicWise",
							incomeEntity::setHospitalRevenueClinicWise);
					setBigDecimalFieldIfExists(formData, "hostetFeeAndMessFee", incomeEntity::setHostetFeeAndMessFee);
					setBigDecimalFieldIfExists(formData, "transportationFee", incomeEntity::setTransportationFee);
					setBigDecimalFieldIfExists(formData, "otherRevenueRadioVishnu904",
							incomeEntity::setOtherRevenueRadioVishnu904);
					setBigDecimalFieldIfExists(formData, "totalIncome", incomeEntity::setTotalIncome);
					incomeRepository.save(incomeEntity);
				} else {
					IncomeEntity incomeEntity = new IncomeEntity();
					incomeEntity.setDepartmentId(departmentId);
					setBigDecimalFieldIfExists(formData, "tuitionFee", incomeEntity::setTuitionFee);
					setBigDecimalFieldIfExists(formData, "btechBPharmBdsPolytechnicSchool",
							incomeEntity::setBtechBPharmBdsPolytechnicSchool);
					setBigDecimalFieldIfExists(formData, "mtechMpharmMdsMbaMca", incomeEntity::setMtechMpharmMdsMbaMca);
					setBigDecimalFieldIfExists(formData, "researchGrants", incomeEntity::setResearchGrants);
					setBigDecimalFieldIfExists(formData, "hospitalRevenueClinicWise",
							incomeEntity::setHospitalRevenueClinicWise);
					setBigDecimalFieldIfExists(formData, "hostetFeeAndMessFee", incomeEntity::setHostetFeeAndMessFee);
					setBigDecimalFieldIfExists(formData, "transportationFee", incomeEntity::setTransportationFee);
					setBigDecimalFieldIfExists(formData, "otherRevenueRadioVishnu904",
							incomeEntity::setOtherRevenueRadioVishnu904);
					setBigDecimalFieldIfExists(formData, "totalIncome", incomeEntity::setTotalIncome);

					incomeRepository.save(incomeEntity);
				}
			}
		}

		return ResponseEntity.ok("Income data saved/updated successfully.");
	}

	@PostMapping("/submit-nonrecurring")
	public ResponseEntity<String> submitNonRecurring(@RequestBody List<Map<String, String>> formData) {
		for (Map<String, String> fieldData : formData) {
			String fieldName = fieldData.get("fieldName");
			String fieldValue = fieldData.get("fieldValue");

			if ("departmentId".equals(fieldName)) {
				int departmentId = Integer.parseInt(fieldValue);
				Optional<ExpenditureNonRecurringEntity> existingIncome = expenditureNonRecurringRepository
						.findById(departmentId);
				if (existingIncome.isPresent()) {
					ExpenditureNonRecurringEntity incomeEntity = existingIncome.get();
					setBigDecimalFieldIfExists(formData, "labEquipments", incomeEntity::setLabEquipments);
					setBigDecimalFieldIfExists(formData, "computersAndPeripherals",
							incomeEntity::setComputersAndPeripherals);
					setBigDecimalFieldIfExists(formData, "softwaresOfAllDepartments",
							incomeEntity::setSoftwaresOfAllDepartments);
					setBigDecimalFieldIfExists(formData, "furnitureAndFixtures", incomeEntity::setFurnitureAndFixtures);
					setBigDecimalFieldIfExists(formData, "airConditionerProjectorsUps",
							incomeEntity::setAirConditionerProjectorsUps);
					setBigDecimalFieldIfExists(formData, "electricalEquipment", incomeEntity::setElectricalEquipment);
					setBigDecimalFieldIfExists(formData, "libraryBooksAndJournals",
							incomeEntity::setLibraryBooksAndJournals);
					setBigDecimalFieldIfExists(formData, "sportsEquipment", incomeEntity::setSportsEquipment);
					setBigDecimalFieldIfExists(formData, "motorVehicles", incomeEntity::setMotorVehicles);
					setBigDecimalFieldIfExists(formData, "netSurplusDeficitAfterCapex",
							incomeEntity::setNetSurplusDeficitAfterCapex);
					setBigDecimalFieldIfExists(formData, "totalNonRecurringExpenditure",
							incomeEntity::setTotalNonRecurringExpenditure);
					setBigDecimalFieldIfExists(formData, "infrastructureRequirements",
							incomeEntity::setInfrastructureRequirements);
					expenditureNonRecurringRepository.save(incomeEntity);

				} else {

					ExpenditureNonRecurringEntity incomeEntity = new ExpenditureNonRecurringEntity();
					incomeEntity.setDepartmentId(departmentId);

					setBigDecimalFieldIfExists(formData, "labEquipments", incomeEntity::setLabEquipments);
					setBigDecimalFieldIfExists(formData, "computersAndPeripherals",
							incomeEntity::setComputersAndPeripherals);
					setBigDecimalFieldIfExists(formData, "softwaresOfAllDepartments",
							incomeEntity::setSoftwaresOfAllDepartments);
					setBigDecimalFieldIfExists(formData, "furnitureAndFixtures", incomeEntity::setFurnitureAndFixtures);
					setBigDecimalFieldIfExists(formData, "airConditionerProjectorsUps",
							incomeEntity::setAirConditionerProjectorsUps);
					setBigDecimalFieldIfExists(formData, "electricalEquipment", incomeEntity::setElectricalEquipment);
					setBigDecimalFieldIfExists(formData, "libraryBooksAndJournals",
							incomeEntity::setLibraryBooksAndJournals);
					setBigDecimalFieldIfExists(formData, "sportsEquipment", incomeEntity::setSportsEquipment);
					setBigDecimalFieldIfExists(formData, "motorVehicles", incomeEntity::setMotorVehicles);
					setBigDecimalFieldIfExists(formData, "netSurplusDeficitAfterCapex",
							incomeEntity::setNetSurplusDeficitAfterCapex);
					setBigDecimalFieldIfExists(formData, "totalNonRecurringExpenditure",
							incomeEntity::setTotalNonRecurringExpenditure);
					setBigDecimalFieldIfExists(formData, "infrastructureRequirements",
							incomeEntity::setInfrastructureRequirements);
					expenditureNonRecurringRepository.save(incomeEntity);
				}
			}
		}

		return ResponseEntity.ok("Recurring data saved/updated successfully.");
	}

	@PostMapping("/submit-recurring")
	public ResponseEntity<String> submitRecurring(@RequestBody List<Map<String, String>> formData) {
		for (Map<String, String> fieldData : formData) {
			String fieldName = fieldData.get("fieldName");
			String fieldValue = fieldData.get("fieldValue");

			if ("departmentId".equals(fieldName)) {
				int departmentId = Integer.parseInt(fieldValue);
				Optional<ExpenditureRecurringEntity> existingIncome = expenditureRecurringRepository
						.findById(departmentId);
				if (existingIncome.isPresent()) {
					ExpenditureRecurringEntity incomeEntity = existingIncome.get();
					setBigDecimalFieldIfExists(formData, "physicalExpenditure", incomeEntity::setPhysicalExpenditure);
					setBigDecimalFieldIfExists(formData, "advertisementExpenses",
							incomeEntity::setAdvertisementExpenses);
					setBigDecimalFieldIfExists(formData, "auditFee", incomeEntity::setAuditFee);
					setBigDecimalFieldIfExists(formData, "bankCharges", incomeEntity::setBankCharges);
					setBigDecimalFieldIfExists(formData, "booksAndPeriodicalsJournals",
							incomeEntity::setBooksAndPeriodicalsJournals);
					setBigDecimalFieldIfExists(formData, "electricityCharges", incomeEntity::setElectricityCharges);
					setBigDecimalFieldIfExists(formData, "financialChargesOrInterestCharges",
							incomeEntity::setFinancialChargesOrInterestCharges);
					setBigDecimalFieldIfExists(formData, "generalExpenses", incomeEntity::setGeneralExpenses);
					setBigDecimalFieldIfExists(formData, "guestHouseMaintenance",
							incomeEntity::setGuestHouseMaintenance);
					setBigDecimalFieldIfExists(formData, "horticultureExpenses", incomeEntity::setHorticultureExpenses);
					setBigDecimalFieldIfExists(formData, "houseKeepingCharges", incomeEntity::setHouseKeepingCharges);
					setBigDecimalFieldIfExists(formData, "studentsInsuranceAndBuildingInsurance",
							incomeEntity::setStudentsInsuranceAndBuildingInsurance);
					setBigDecimalFieldIfExists(formData, "professionalCharges", incomeEntity::setProfessionalCharges);
					setBigDecimalFieldIfExists(formData, "ratesAndTaxesProfessionalTaxPropertyTax",
							incomeEntity::setRatesAndTaxesProfessionalTaxPropertyTax);
					setBigDecimalFieldIfExists(formData, "repairsAndMaintenance",
							incomeEntity::setRepairsAndMaintenance);
					setBigDecimalFieldIfExists(formData, "buildingMaintenance", incomeEntity::setBuildingMaintenance);
					setBigDecimalFieldIfExists(formData, "vehicleMaintenance", incomeEntity::setVehicleMaintenance);
					setBigDecimalFieldIfExists(formData, "electricalMaintenance",
							incomeEntity::setElectricalMaintenance);
					setBigDecimalFieldIfExists(formData, "computerMaintenance", incomeEntity::setComputerMaintenance);
					setBigDecimalFieldIfExists(formData, "generatorMaintenance", incomeEntity::setGeneratorMaintenance);
					setBigDecimalFieldIfExists(formData, "furnitureMaintenance", incomeEntity::setFurnitureMaintenance);
					setBigDecimalFieldIfExists(formData, "securityCharges", incomeEntity::setSecurityCharges);
					setBigDecimalFieldIfExists(formData, "telephoneCharges", incomeEntity::setTelephoneCharges);
					setBigDecimalFieldIfExists(formData, "transportationOfGoodsAndService",
							incomeEntity::setTransportationOfGoodsAndService);
					setBigDecimalFieldIfExists(formData, "waterTreatmentPlantMaintenance",
							incomeEntity::setWaterTreatmentPlantMaintenance);
					setBigDecimalFieldIfExists(formData, "sewageTreatmentPlantExpenses",
							incomeEntity::setSewageTreatmentPlantExpenses);
					setBigDecimalFieldIfExists(formData, "academicExpenditure", incomeEntity::setAcademicExpenditure);
					setBigDecimalFieldIfExists(formData, "statutoryInspectionsAndAccreditationExpenses",
							incomeEntity::setStatutoryInspectionsAndAccreditationExpenses);
					setBigDecimalFieldIfExists(formData, "nbaNaacAutonomousFfc", incomeEntity::setNbaNaacAutonomousFfc);
					setBigDecimalFieldIfExists(formData, "affiliationFee", incomeEntity::setAffiliationFee);
					setBigDecimalFieldIfExists(formData, "jntuCommonServiceFees",
							incomeEntity::setJntuCommonServiceFees);
					setBigDecimalFieldIfExists(formData, "studentsGiftsMeritPrizes",
							incomeEntity::setStudentsGiftsMeritPrizes);
					setBigDecimalFieldIfExists(formData, "governingBodyExpenses",
							incomeEntity::setGoverningBodyExpenses);
					setBigDecimalFieldIfExists(formData, "facultyCarHireCharges",
							incomeEntity::setFacultyCarHireCharges);
					setBigDecimalFieldIfExists(formData, "facultyDevelopmentPrograms",
							incomeEntity::setFacultyDevelopmentPrograms);
					setBigDecimalFieldIfExists(formData, "examinationExpensesBoardOfStudyExpenses",
							incomeEntity::setExaminationExpensesBoardOfStudyExpenses);
					setBigDecimalFieldIfExists(formData, "staffConveyanceAndTravellingExpenses",
							incomeEntity::setStaffConveyanceAndTravellingExpenses);
					setBigDecimalFieldIfExists(formData, "hospitalStifundExpenses",
							incomeEntity::setHospitalStifundExpenses);
					setBigDecimalFieldIfExists(formData, "hospitalityCharges", incomeEntity::setHospitalityCharges);
					setBigDecimalFieldIfExists(formData, "inspectionChargesAicteJntuNtruhs",
							incomeEntity::setInspectionChargesAicteJntuNtruhs);
					setBigDecimalFieldIfExists(formData, "internetWebsiteExpenses",
							incomeEntity::setInternetWebsiteExpenses);
					setBigDecimalFieldIfExists(formData, "studentsExtraCoCurricularActivities",
							incomeEntity::setStudentsExtraCoCurricularActivities);
					setBigDecimalFieldIfExists(formData, "firstInductionProgram",
							incomeEntity::setFirstInductionProgram);
					setBigDecimalFieldIfExists(formData, "annualDayExpenses", incomeEntity::setAnnualDayExpenses);
					setBigDecimalFieldIfExists(formData, "specifyAndOtherFunctions",
							incomeEntity::setSpecifyAndOtherFunctions);
					setBigDecimalFieldIfExists(formData, "labMaintenance", incomeEntity::setLabMaintenance);
					setBigDecimalFieldIfExists(formData, "consumables", incomeEntity::setConsumables);
					setBigDecimalFieldIfExists(formData, "glasswares", incomeEntity::setGlasswares);
					setBigDecimalFieldIfExists(formData, "membershipCertificationExps",
							incomeEntity::setMembershipCertificationExps);
					setBigDecimalFieldIfExists(formData, "pgNewCoursesNewColleges",
							incomeEntity::setPgNewCoursesNewColleges);
					setBigDecimalFieldIfExists(formData, "postageAndCourierCharges",
							incomeEntity::setPostageAndCourierCharges);
					setBigDecimalFieldIfExists(formData, "printingAndStationery",
							incomeEntity::setPrintingAndStationery);
					setBigDecimalFieldIfExists(formData, "researchAndDevelopment",
							incomeEntity::setResearchAndDevelopment);
					setBigDecimalFieldIfExists(formData, "inHouseRandD", incomeEntity::setInHouseRandD);
					setBigDecimalFieldIfExists(formData, "consultancyIncentives",
							incomeEntity::setConsultancyIncentives);
					setBigDecimalFieldIfExists(formData, "seedFunding", incomeEntity::setSeedFunding);
					setBigDecimalFieldIfExists(formData, "incentivesForPaperPublication",
							incomeEntity::setIncentivesForPaperPublication);
					setBigDecimalFieldIfExists(formData, "incentivesOnPatents", incomeEntity::setIncentivesOnPatents);
					setBigDecimalFieldIfExists(formData, "seminarAndWorkshops", incomeEntity::setSeminarAndWorkshops);
					setBigDecimalFieldIfExists(formData, "studentsExtraCurricularActivitiesDevelopment",
							incomeEntity::setStudentsExtraCurricularActivitiesDevelopment);
					setBigDecimalFieldIfExists(formData, "remunerationsToVisitingFaculty",
							incomeEntity::setRemunerationsToVisitingFaculty);
					setBigDecimalFieldIfExists(formData, "placementTrainingAndRecruitmentCell",
							incomeEntity::setPlacementTrainingAndRecruitmentCell);
					setBigDecimalFieldIfExists(formData, "fmVtvMaintenance", incomeEntity::setFmVtvMaintenance);
					setBigDecimalFieldIfExists(formData, "studentsConcessionFee",
							incomeEntity::setStudentsConcessionFee);
					setBigDecimalFieldIfExists(formData, "grantsExpenditure", incomeEntity::setGrantsExpenditure);
					setBigDecimalFieldIfExists(formData, "boardOfStudyExpenses", incomeEntity::setBoardOfStudyExpenses);
					setBigDecimalFieldIfExists(formData, "personnelExpenses", incomeEntity::setPersonnelExpenses);
					setBigDecimalFieldIfExists(formData, "salariesAndWages", incomeEntity::setSalariesAndWages);
					setBigDecimalFieldIfExists(formData, "providentFundEpfFpf", incomeEntity::setProvidentFundEpfFpf);
					setBigDecimalFieldIfExists(formData, "staffWelfare", incomeEntity::setStaffWelfare);
					setBigDecimalFieldIfExists(formData, "contributionToEsi", incomeEntity::setContributionToEsi);
					setBigDecimalFieldIfExists(formData, "mediclaim", incomeEntity::setMediclaim);
					setBigDecimalFieldIfExists(formData, "gratuityProvisionPremium",
							incomeEntity::setGratuityProvisionPremium);
					setBigDecimalFieldIfExists(formData, "surplusBeforeCapeX", incomeEntity::setSurplusBeforeCapeX);
					setBigDecimalFieldIfExists(formData, "totalRecurringExpenditure",
							incomeEntity::setTotalRecurringExpenditure);

					expenditureRecurringRepository.save(incomeEntity);

				}
				ExpenditureRecurringEntity incomeEntity = new ExpenditureRecurringEntity();
				incomeEntity.setDepartmentId(departmentId);
				setBigDecimalFieldIfExists(formData, "physicalExpenditure", incomeEntity::setPhysicalExpenditure);
				setBigDecimalFieldIfExists(formData, "advertisementExpenses", incomeEntity::setAdvertisementExpenses);
				setBigDecimalFieldIfExists(formData, "auditFee", incomeEntity::setAuditFee);
				setBigDecimalFieldIfExists(formData, "bankCharges", incomeEntity::setBankCharges);
				setBigDecimalFieldIfExists(formData, "booksAndPeriodicalsJournals",
						incomeEntity::setBooksAndPeriodicalsJournals);
				setBigDecimalFieldIfExists(formData, "electricityCharges", incomeEntity::setElectricityCharges);
				setBigDecimalFieldIfExists(formData, "financialChargesOrInterestCharges",
						incomeEntity::setFinancialChargesOrInterestCharges);
				setBigDecimalFieldIfExists(formData, "generalExpenses", incomeEntity::setGeneralExpenses);
				setBigDecimalFieldIfExists(formData, "guestHouseMaintenance", incomeEntity::setGuestHouseMaintenance);
				setBigDecimalFieldIfExists(formData, "horticultureExpenses", incomeEntity::setHorticultureExpenses);
				setBigDecimalFieldIfExists(formData, "houseKeepingCharges", incomeEntity::setHouseKeepingCharges);
				setBigDecimalFieldIfExists(formData, "studentsInsuranceAndBuildingInsurance",
						incomeEntity::setStudentsInsuranceAndBuildingInsurance);
				setBigDecimalFieldIfExists(formData, "professionalCharges", incomeEntity::setProfessionalCharges);
				setBigDecimalFieldIfExists(formData, "ratesAndTaxesProfessionalTaxPropertyTax",
						incomeEntity::setRatesAndTaxesProfessionalTaxPropertyTax);
				setBigDecimalFieldIfExists(formData, "repairsAndMaintenance", incomeEntity::setRepairsAndMaintenance);
				setBigDecimalFieldIfExists(formData, "buildingMaintenance", incomeEntity::setBuildingMaintenance);
				setBigDecimalFieldIfExists(formData, "vehicleMaintenance", incomeEntity::setVehicleMaintenance);
				setBigDecimalFieldIfExists(formData, "electricalMaintenance", incomeEntity::setElectricalMaintenance);
				setBigDecimalFieldIfExists(formData, "computerMaintenance", incomeEntity::setComputerMaintenance);
				setBigDecimalFieldIfExists(formData, "generatorMaintenance", incomeEntity::setGeneratorMaintenance);
				setBigDecimalFieldIfExists(formData, "furnitureMaintenance", incomeEntity::setFurnitureMaintenance);
				setBigDecimalFieldIfExists(formData, "securityCharges", incomeEntity::setSecurityCharges);
				setBigDecimalFieldIfExists(formData, "telephoneCharges", incomeEntity::setTelephoneCharges);
				setBigDecimalFieldIfExists(formData, "transportationOfGoodsAndService",
						incomeEntity::setTransportationOfGoodsAndService);
				setBigDecimalFieldIfExists(formData, "waterTreatmentPlantMaintenance",
						incomeEntity::setWaterTreatmentPlantMaintenance);
				setBigDecimalFieldIfExists(formData, "sewageTreatmentPlantExpenses",
						incomeEntity::setSewageTreatmentPlantExpenses);
				setBigDecimalFieldIfExists(formData, "academicExpenditure", incomeEntity::setAcademicExpenditure);
				setBigDecimalFieldIfExists(formData, "statutoryInspectionsAndAccreditationExpenses",
						incomeEntity::setStatutoryInspectionsAndAccreditationExpenses);
				setBigDecimalFieldIfExists(formData, "nbaNaacAutonomousFfc", incomeEntity::setNbaNaacAutonomousFfc);
				setBigDecimalFieldIfExists(formData, "affiliationFee", incomeEntity::setAffiliationFee);
				setBigDecimalFieldIfExists(formData, "jntuCommonServiceFees", incomeEntity::setJntuCommonServiceFees);
				setBigDecimalFieldIfExists(formData, "studentsGiftsMeritPrizes",
						incomeEntity::setStudentsGiftsMeritPrizes);
				setBigDecimalFieldIfExists(formData, "governingBodyExpenses", incomeEntity::setGoverningBodyExpenses);
				setBigDecimalFieldIfExists(formData, "facultyCarHireCharges", incomeEntity::setFacultyCarHireCharges);
				setBigDecimalFieldIfExists(formData, "facultyDevelopmentPrograms",
						incomeEntity::setFacultyDevelopmentPrograms);
				setBigDecimalFieldIfExists(formData, "examinationExpensesBoardOfStudyExpenses",
						incomeEntity::setExaminationExpensesBoardOfStudyExpenses);
				setBigDecimalFieldIfExists(formData, "staffConveyanceAndTravellingExpenses",
						incomeEntity::setStaffConveyanceAndTravellingExpenses);
				setBigDecimalFieldIfExists(formData, "hospitalStifundExpenses",
						incomeEntity::setHospitalStifundExpenses);
				setBigDecimalFieldIfExists(formData, "hospitalityCharges", incomeEntity::setHospitalityCharges);
				setBigDecimalFieldIfExists(formData, "inspectionChargesAicteJntuNtruhs",
						incomeEntity::setInspectionChargesAicteJntuNtruhs);
				setBigDecimalFieldIfExists(formData, "internetWebsiteExpenses",
						incomeEntity::setInternetWebsiteExpenses);
				setBigDecimalFieldIfExists(formData, "studentsExtraCoCurricularActivities",
						incomeEntity::setStudentsExtraCoCurricularActivities);
				setBigDecimalFieldIfExists(formData, "firstInductionProgram", incomeEntity::setFirstInductionProgram);
				setBigDecimalFieldIfExists(formData, "annualDayExpenses", incomeEntity::setAnnualDayExpenses);
				setBigDecimalFieldIfExists(formData, "specifyAndOtherFunctions",
						incomeEntity::setSpecifyAndOtherFunctions);
				setBigDecimalFieldIfExists(formData, "labMaintenance", incomeEntity::setLabMaintenance);
				setBigDecimalFieldIfExists(formData, "consumables", incomeEntity::setConsumables);
				setBigDecimalFieldIfExists(formData, "glasswares", incomeEntity::setGlasswares);
				setBigDecimalFieldIfExists(formData, "membershipCertificationExps",
						incomeEntity::setMembershipCertificationExps);
				setBigDecimalFieldIfExists(formData, "pgNewCoursesNewColleges",
						incomeEntity::setPgNewCoursesNewColleges);
				setBigDecimalFieldIfExists(formData, "postageAndCourierCharges",
						incomeEntity::setPostageAndCourierCharges);
				setBigDecimalFieldIfExists(formData, "printingAndStationery", incomeEntity::setPrintingAndStationery);
				setBigDecimalFieldIfExists(formData, "researchAndDevelopment", incomeEntity::setResearchAndDevelopment);
				setBigDecimalFieldIfExists(formData, "inHouseRandD", incomeEntity::setInHouseRandD);
				setBigDecimalFieldIfExists(formData, "consultancyIncentives", incomeEntity::setConsultancyIncentives);
				setBigDecimalFieldIfExists(formData, "seedFunding", incomeEntity::setSeedFunding);
				setBigDecimalFieldIfExists(formData, "incentivesForPaperPublication",
						incomeEntity::setIncentivesForPaperPublication);
				setBigDecimalFieldIfExists(formData, "incentivesOnPatents", incomeEntity::setIncentivesOnPatents);
				setBigDecimalFieldIfExists(formData, "seminarAndWorkshops", incomeEntity::setSeminarAndWorkshops);
				setBigDecimalFieldIfExists(formData, "studentsExtraCurricularActivitiesDevelopment",
						incomeEntity::setStudentsExtraCurricularActivitiesDevelopment);
				setBigDecimalFieldIfExists(formData, "remunerationsToVisitingFaculty",
						incomeEntity::setRemunerationsToVisitingFaculty);
				setBigDecimalFieldIfExists(formData, "placementTrainingAndRecruitmentCell",
						incomeEntity::setPlacementTrainingAndRecruitmentCell);
				setBigDecimalFieldIfExists(formData, "fmVtvMaintenance", incomeEntity::setFmVtvMaintenance);
				setBigDecimalFieldIfExists(formData, "studentsConcessionFee", incomeEntity::setStudentsConcessionFee);
				setBigDecimalFieldIfExists(formData, "grantsExpenditure", incomeEntity::setGrantsExpenditure);
				setBigDecimalFieldIfExists(formData, "boardOfStudyExpenses", incomeEntity::setBoardOfStudyExpenses);
				setBigDecimalFieldIfExists(formData, "personnelExpenses", incomeEntity::setPersonnelExpenses);
				setBigDecimalFieldIfExists(formData, "salariesAndWages", incomeEntity::setSalariesAndWages);
				setBigDecimalFieldIfExists(formData, "providentFundEpfFpf", incomeEntity::setProvidentFundEpfFpf);
				setBigDecimalFieldIfExists(formData, "staffWelfare", incomeEntity::setStaffWelfare);
				setBigDecimalFieldIfExists(formData, "contributionToEsi", incomeEntity::setContributionToEsi);
				setBigDecimalFieldIfExists(formData, "mediclaim", incomeEntity::setMediclaim);
				setBigDecimalFieldIfExists(formData, "gratuityProvisionPremium",
						incomeEntity::setGratuityProvisionPremium);
				setBigDecimalFieldIfExists(formData, "surplusBeforeCapeX", incomeEntity::setSurplusBeforeCapeX);
				setBigDecimalFieldIfExists(formData, "totalRecurringExpenditure",
						incomeEntity::setTotalRecurringExpenditure);

				expenditureRecurringRepository.save(incomeEntity);

			}
		}

		return ResponseEntity.ok("Income data saved/updated successfully.");
	}

	private void setBigDecimalFieldIfExists(List<Map<String, String>> formData, String fieldName,
			Consumer<BigDecimal> setter) {
		String fieldValue = formData.stream().filter(entry -> fieldName.equals(entry.get("fieldName"))).findFirst()
				.map(entry -> entry.get("fieldValue")).orElse("0");

		BigDecimal value = new BigDecimal(fieldValue);
		setter.accept(value);
	}

}
