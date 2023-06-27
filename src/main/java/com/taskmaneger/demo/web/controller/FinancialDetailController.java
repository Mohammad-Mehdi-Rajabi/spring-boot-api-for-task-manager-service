package com.taskmaneger.demo.web.controller;


import com.taskmaneger.demo.web.dto.FinancialDetailDto;
import com.taskmaneger.demo.web.dto.Response;
import com.taskmaneger.demo.web.service.FinancialDetailService;
import io.swagger.v3.oas.annotations.headers.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/financialDetail/")
public class FinancialDetailController {

    private FinancialDetailService financialDetailService;

    @Autowired
    public FinancialDetailController(FinancialDetailService financialDetailService) {
        this.financialDetailService = financialDetailService;
    }

    @GetMapping(value = "/getAll", headers = "Access-Control-Allow-Origin")
    public ResponseEntity<?> getAll() {
        Response<?> all = financialDetailService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping(value = "/addFinancialDetail", headers = "Access-Control-Allow-Origin")
    public ResponseEntity<?> addFinancialDetail(@RequestBody FinancialDetailDto financialDetailDto) {
        Response<?> response = financialDetailService.addFinancialDetail(financialDetailDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/getFinancialDetailById/{id}", headers = "Access-Control-Allow-Origin")
    public ResponseEntity<?> getFinancialDetailById(@PathVariable long id) {
        Response<?> response = financialDetailService.getFinancialDetailById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteFinancialDetailById/{id}", headers = "Access-Control-Allow-Origin")
    public ResponseEntity<?> deleteFinancialDetailById(@PathVariable long id) {
        Response<?> response = financialDetailService.deleteByID(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
