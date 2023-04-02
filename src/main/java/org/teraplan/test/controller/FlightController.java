package org.teraplan.test.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.teraplan.test.dto.EmployeeDto;
import org.teraplan.test.dto.FlightDto;
import org.teraplan.test.dto.FlightsWrapperDto;
import org.teraplan.test.service.FlightService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "flights", produces = MediaType.APPLICATION_JSON_VALUE)
public class FlightController {

    private final FlightService service;

    @GetMapping("details")
    @ResponseBody
    public String getDetails() {
        return FlightDto.getDetails();
    }

    @GetMapping
    @ResponseBody
    public List<FlightDto> findByEmployeeId(@RequestParam Integer employeeId) {
        return service.findByEmployeeId(employeeId);
    }

    @PostMapping
    @ResponseBody
    public List<FlightDto> saveAll(@Valid @RequestBody FlightsWrapperDto flightsWrapper) {
        return service.saveAll(flightsWrapper.getFlights());
    }
}
