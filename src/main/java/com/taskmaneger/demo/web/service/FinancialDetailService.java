package com.taskmaneger.demo.web.service;


import com.taskmaneger.demo.web.dataModel.FinancialDetail;
import com.taskmaneger.demo.web.dto.FinancialDetailDto;
import com.taskmaneger.demo.web.dto.Response;
import com.taskmaneger.demo.web.dto.mapper.FinancialDetailDtoMapper;
import com.taskmaneger.demo.web.repository.FinancialDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinancialDetailService {

    private FinancialDetailRepository financialDetailRepository;
    private FinancialDetailDtoMapper financialDetailDtoMapper;


    @Autowired
    public FinancialDetailService(FinancialDetailRepository financialDetailRepository, FinancialDetailDtoMapper financialDetailDtoMapper) {
        this.financialDetailRepository = financialDetailRepository;
        this.financialDetailDtoMapper = financialDetailDtoMapper;
    }

    public Response<?> getAll() {
        List<FinancialDetail> all = financialDetailRepository.findAll();
        return new Response<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), all);
    }

    public Response<?> addFinancialDetail(FinancialDetailDto financialDetailDto) {
        FinancialDetail save = financialDetailRepository.save(financialDetailDtoMapper.DtoToModel(financialDetailDto));
        return new Response<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), save);
    }

    public Response<?> getFinancialDetailById(long id) {
        Optional<FinancialDetail> byId = financialDetailRepository.findById(id);
        return new Response<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), byId.orElse(null));
    }

    public Response<?> deleteByID(long id) {
        financialDetailRepository.deleteById(id);
        return new Response<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), null);
    }

}
