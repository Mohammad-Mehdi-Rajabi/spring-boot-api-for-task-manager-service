package com.taskmaneger.demo.web.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FinancialDetailDto {
    private long id;



    private ProjectDtoForReq project;

    private String totalCost;
    private String prepayment;
    private int numberOfInstallment;
    private String totalPayment;
    private String debit;

    @Override
    public String toString() {
        return "FinancialDetailDto{" +
                "id=" + id +
                ", project=" + project +
                ", totalCost='" + totalCost + '\'' +
                ", prepayment='" + prepayment + '\'' +
                ", numberOfInstallment=" + numberOfInstallment +
                ", totalPayment='" + totalPayment + '\'' +
                ", debit='" + debit + '\'' +
                '}';
    }
}
