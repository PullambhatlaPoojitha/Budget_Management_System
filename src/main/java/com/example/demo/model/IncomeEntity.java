package com.example.demo.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "income")
public class IncomeEntity {

    @Id
    
    @Column(name="department_id")
    private int departmentId;

    @Column(name = "tuition_fee")
    private BigDecimal tuitionFee;

    @Column(name = "BTech_BPharm_BDS_Polytechnic_School")
    private BigDecimal btechBPharmBdsPolytechnicSchool;

    @Column(name = "MTech_Mpharm_MDS_MBA_MCA")
    private BigDecimal mtechMpharmMdsMbaMca;

    @Column(name = "research_Grants")
    private BigDecimal researchGrants;

    @Column(name = "hospital_Revenue_clinic_wise")
    private BigDecimal hospitalRevenueClinicWise;

    @Column(name = "hostet_Fee_and_Mess_Fee")
    private BigDecimal hostetFeeAndMessFee;

    @Column(name = "transportation_Fee")
    private BigDecimal transportationFee;

    @Column(name = "other_Revenue_Radio_Vishnu_90_4")
    private BigDecimal otherRevenueRadioVishnu904;

    @Column(name = "total_Income")
    private BigDecimal totalIncome;

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public BigDecimal getTuitionFee() {
		return tuitionFee;
	}

	public void setTuitionFee(BigDecimal tuitionFee) {
		this.tuitionFee = tuitionFee;
	}

	public BigDecimal getBtechBPharmBdsPolytechnicSchool() {
		return btechBPharmBdsPolytechnicSchool;
	}

	public void setBtechBPharmBdsPolytechnicSchool(BigDecimal btechBPharmBdsPolytechnicSchool) {
		this.btechBPharmBdsPolytechnicSchool = btechBPharmBdsPolytechnicSchool;
	}

	public BigDecimal getMtechMpharmMdsMbaMca() {
		return mtechMpharmMdsMbaMca;
	}

	public void setMtechMpharmMdsMbaMca(BigDecimal mtechMpharmMdsMbaMca) {
		this.mtechMpharmMdsMbaMca = mtechMpharmMdsMbaMca;
	}

	public BigDecimal getResearchGrants() {
		return researchGrants;
	}

	public void setResearchGrants(BigDecimal researchGrants) {
		this.researchGrants = researchGrants;
	}

	public BigDecimal getHospitalRevenueClinicWise() {
		return hospitalRevenueClinicWise;
	}

	public void setHospitalRevenueClinicWise(BigDecimal hospitalRevenueClinicWise) {
		this.hospitalRevenueClinicWise = hospitalRevenueClinicWise;
	}

	public BigDecimal getHostetFeeAndMessFee() {
		return hostetFeeAndMessFee;
	}

	public void setHostetFeeAndMessFee(BigDecimal hostetFeeAndMessFee) {
		this.hostetFeeAndMessFee = hostetFeeAndMessFee;
	}

	public BigDecimal getTransportationFee() {
		return transportationFee;
	}

	public void setTransportationFee(BigDecimal transportationFee) {
		this.transportationFee = transportationFee;
	}

	public BigDecimal getOtherRevenueRadioVishnu904() {
		return otherRevenueRadioVishnu904;
	}

	public void setOtherRevenueRadioVishnu904(BigDecimal otherRevenueRadioVishnu904) {
		this.otherRevenueRadioVishnu904 = otherRevenueRadioVishnu904;
	}

	public BigDecimal getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(BigDecimal totalIncome) {
		this.totalIncome = totalIncome;
	}
    

    // Getters and setters, constructor, and other methods...
}



    

	