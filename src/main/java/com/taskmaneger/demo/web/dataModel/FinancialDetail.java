package com.taskmaneger.demo.web.dataModel;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class FinancialDetail {

    @Id
    @SequenceGenerator(name = "FinancialDetail_sequence",
            initialValue = 10000, sequenceName = "FinancialDetail_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FinancialDetail_sequence")
    private long id;


    @OneToOne
    private Project project;

    private String totalCost;
    private String prepayment;
    private int numberOfInstallment;
    private String totalPayment;
    private String debit;

    @Override
    public String toString() {
        return "FinancialDetail{" +
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
