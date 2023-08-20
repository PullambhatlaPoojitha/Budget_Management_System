package com.example.demo.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="non_recurring_expenditure")
public class ExpenditureNonRecurringEntity {
	@Id

    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "lab_equipments")
    private BigDecimal labEquipments;

    @Column(name = "computers_and_peripherals")
    private BigDecimal computersAndPeripherals;

    @Column(name = "softwares_of_all_departments")
    private BigDecimal softwaresOfAllDepartments;

    @Column(name = "furniture_and_fixtures")
    private BigDecimal furnitureAndFixtures;

    @Column(name = "air_conditioner_projectors_ups")
    private BigDecimal airConditionerProjectorsUps;

    @Column(name = "electrical_equipment")
    private BigDecimal electricalEquipment;

    @Column(name = "library_books_and_journals")
    private BigDecimal libraryBooksAndJournals;

    @Column(name = "sports_equipment")
    private BigDecimal sportsEquipment;

    @Column(name = "motor_vehicles")
    private BigDecimal motorVehicles;

    @Column(name = "total_non_recurring_expenditure")
    private BigDecimal totalNonRecurringExpenditure;

    @Column(name = "infrastructure_requirements")
    private BigDecimal infrastructureRequirements;
    
    @Column(name="net_surplus_deficit_after_capex")
    private BigDecimal netSurplusDeficitAfterCapex;

	public BigDecimal getNetSurplusDeficitAfterCapex() {
		return netSurplusDeficitAfterCapex;
	}

	public void setNetSurplusDeficitAfterCapex(BigDecimal netSurplusDeficitAfterCapex) {
		this.netSurplusDeficitAfterCapex = netSurplusDeficitAfterCapex;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public BigDecimal getLabEquipments() {
		return labEquipments;
	}

	public void setLabEquipments(BigDecimal labEquipments) {
		this.labEquipments = labEquipments;
	}

	public BigDecimal getComputersAndPeripherals() {
		return computersAndPeripherals;
	}

	public void setComputersAndPeripherals(BigDecimal computersAndPeripherals) {
		this.computersAndPeripherals = computersAndPeripherals;
	}

	public BigDecimal getSoftwaresOfAllDepartments() {
		return softwaresOfAllDepartments;
	}

	public void setSoftwaresOfAllDepartments(BigDecimal softwaresOfAllDepartments) {
		this.softwaresOfAllDepartments = softwaresOfAllDepartments;
	}

	public BigDecimal getFurnitureAndFixtures() {
		return furnitureAndFixtures;
	}

	public void setFurnitureAndFixtures(BigDecimal furnitureAndFixtures) {
		this.furnitureAndFixtures = furnitureAndFixtures;
	}

	public BigDecimal getAirConditionerProjectorsUps() {
		return airConditionerProjectorsUps;
	}

	public void setAirConditionerProjectorsUps(BigDecimal airConditionerProjectorsUps) {
		this.airConditionerProjectorsUps = airConditionerProjectorsUps;
	}

	public BigDecimal getElectricalEquipment() {
		return electricalEquipment;
	}

	public void setElectricalEquipment(BigDecimal electricalEquipment) {
		this.electricalEquipment = electricalEquipment;
	}

	public BigDecimal getLibraryBooksAndJournals() {
		return libraryBooksAndJournals;
	}

	public void setLibraryBooksAndJournals(BigDecimal libraryBooksAndJournals) {
		this.libraryBooksAndJournals = libraryBooksAndJournals;
	}

	public BigDecimal getSportsEquipment() {
		return sportsEquipment;
	}

	public void setSportsEquipment(BigDecimal sportsEquipment) {
		this.sportsEquipment = sportsEquipment;
	}

	public BigDecimal getMotorVehicles() {
		return motorVehicles;
	}

	public void setMotorVehicles(BigDecimal motorVehicles) {
		this.motorVehicles = motorVehicles;
	}

	public BigDecimal getTotalNonRecurringExpenditure() {
		return totalNonRecurringExpenditure;
	}

	public void setTotalNonRecurringExpenditure(BigDecimal totalNonRecurringExpenditure) {
		this.totalNonRecurringExpenditure = totalNonRecurringExpenditure;
	}

	public BigDecimal getInfrastructureRequirements() {
		return infrastructureRequirements;
	}

	public void setInfrastructureRequirements(BigDecimal infrastructureRequirements) {
		this.infrastructureRequirements = infrastructureRequirements;
	}
    

    // Constructors, getters, setters, and other methods can be added here.
}
