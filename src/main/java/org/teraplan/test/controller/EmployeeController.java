package org.teraplan.test.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.teraplan.test.dto.EmployeeDto;
import org.teraplan.test.dto.EmployeesWrapperDto;
import org.teraplan.test.service.EmployeeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("details")
    @ResponseBody
    public String getDetails() {
        return EmployeeDto.getDetails();
    }

    @PostMapping
    @ResponseBody
    public List<EmployeeDto> saveAll(@Valid @RequestBody EmployeesWrapperDto employeesWrapper) {
        return service.saveAll(employeesWrapper.getEmployees());
    }
}
