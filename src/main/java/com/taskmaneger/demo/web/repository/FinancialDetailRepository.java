package com.taskmaneger.demo.web.repository;


import com.taskmaneger.demo.web.dataModel.FinancialDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialDetailRepository extends JpaRepository<FinancialDetail, Long> {
}
