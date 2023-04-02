package org.teraplan.test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.teraplan.test.dto.FlightDto;
import org.teraplan.test.dto.RosterDto;
import org.teraplan.test.service.AssignmentService;
import org.teraplan.test.service.PairingService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rosters", produces = MediaType.APPLICATION_JSON_VALUE)
public class RosterController {

    private final AssignmentService assignmentService;

    private final PairingService pairingService;

    @PostMapping
    @ResponseBody
    public RosterDto saveAll(@RequestBody RosterDto dto) {
        pairingService.saveAll(dto.getPairings());
        assignmentService.saveAll(dto.getAssignments());
        return dto;
    }
}
