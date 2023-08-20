package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.IncomeEntity;

import jakarta.transaction.Transactional;

public interface IncomeRepository extends JpaRepository<IncomeEntity, Integer> {

//    IncomeEntity findByDepartmentId(int departmentId);
    Optional<IncomeEntity> findByDepartmentId(int departmentId);

//    @Modifying
//    @Transactional
//    @Query("INSERT INTO IncomeEntity (departmentId, tuitionFee, btechBPharmBdsPolytechnicSchool, mtechMpharmMdsMbaMca, researchGrants, hospitalRevenueClinicWise, hostetFeeAndMessFee, transportationFee, otherRevenueRadioVishnu904, totalIncome) " +
//            "VALUES (:departmentId, :tuitionFee, :btechBPharmBdsPolytechnicSchool, :mtechMpharmMdsMbaMca, :researchGrants, :hospitalRevenueClinicWise, :hostetFeeAndMessFee, :transportationFee, :otherRevenueRadioVishnu904, :totalIncome)")
//    void customInsert(
//            @Param("departmentId") int departmentId,
//            @Param("tuitionFee") BigDecimal tuitionFee,
//            @Param("btechBPharmBdsPolytechnicSchool") BigDecimal btechBPharmBdsPolytechnicSchool,
//            @Param("mtechMpharmMdsMbaMca") BigDecimal mtechMpharmMdsMbaMca,
//            @Param("researchGrants") BigDecimal researchGrants,
//            @Param("hospitalRevenueClinicWise") BigDecimal hospitalRevenueClinicWise,
//            @Param("hostetFeeAndMessFee") BigDecimal hostetFeeAndMessFee,
//            @Param("transportationFee") BigDecimal transportationFee,
//            @Param("otherRevenueRadioVishnu904") BigDecimal otherRevenueRadioVishnu904,
//            @Param("totalIncome") BigDecimal totalIncome
//    );
}
