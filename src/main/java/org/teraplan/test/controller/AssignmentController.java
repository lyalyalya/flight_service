package org.teraplan.test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.teraplan.test.dto.AssignmentDto;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "assignments", produces = MediaType.APPLICATION_JSON_VALUE)
public class AssignmentController {

    @GetMapping("details")
    @ResponseBody
    public String getDetails() {
        return AssignmentDto.getDetails();
    }
}
