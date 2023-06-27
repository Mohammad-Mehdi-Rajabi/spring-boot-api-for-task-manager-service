package com.taskmaneger.demo.web.dto.mapper;

import com.taskmaneger.demo.web.dataModel.FinancialDetail;
import com.taskmaneger.demo.web.dto.FinancialDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FinancialDetailDtoMapper implements Mapper<FinancialDetailDto, FinancialDetail> {

    private ProjectDtoForReqMapper projectDtoForReqMapper;

    @Autowired
    public FinancialDetailDtoMapper(ProjectDtoForReqMapper projectDtoForReqMapper) {
        this.projectDtoForReqMapper = projectDtoForReqMapper;
    }

    @Override
    public FinancialDetailDto modelToDto(FinancialDetail model) {
        FinancialDetailDto financialDetailDto = new FinancialDetailDto();
        financialDetailDto.setDebit(model.getDebit());
        financialDetailDto.setId(model.getId());
        financialDetailDto.setNumberOfInstallment(model.getNumberOfInstallment());
        financialDetailDto.setPrepayment(model.getPrepayment());
        financialDetailDto.setProject(projectDtoForReqMapper.modelToDto(model.getProject()));
        financialDetailDto.setTotalCost(model.getTotalCost());
        financialDetailDto.setTotalPayment(model.getTotalPayment());
        return financialDetailDto;
    }

    @Override
    public FinancialDetail DtoToModel(FinancialDetailDto dto) {
        FinancialDetail financialDetail = new FinancialDetail();
        financialDetail.setDebit(dto.getDebit());
        financialDetail.setId(dto.getId());
        financialDetail.setNumberOfInstallment(dto.getNumberOfInstallment());
        financialDetail.setPrepayment(dto.getPrepayment());
        financialDetail.setProject(projectDtoForReqMapper.DtoToModel(dto.getProject()));
        financialDetail.setTotalCost(dto.getTotalCost());
        financialDetail.setTotalPayment(dto.getTotalPayment());
        return financialDetail;
    }
}
