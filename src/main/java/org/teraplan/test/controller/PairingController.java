package org.teraplan.test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.teraplan.test.dto.FlightDto;
import org.teraplan.test.dto.PairingDto;
import org.teraplan.test.service.PairingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "pairings", produces = MediaType.APPLICATION_JSON_VALUE)
public class PairingController {

    private final PairingService service;

    @GetMapping("details")
    @ResponseBody
    public String getDetails() {
        return PairingDto.getDetails();
    }

    @GetMapping
    @ResponseBody
    public List<PairingDto> findByEmployeeId(@RequestParam Integer employeeId) {
        return service.findByEmployeeId(employeeId);
    }
}
