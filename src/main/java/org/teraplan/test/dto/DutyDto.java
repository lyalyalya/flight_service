package org.teraplan.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class DutyDto {

    @JsonProperty
    private Integer id;

    @JsonProperty("DateTimeStart")
    private String startTime;

    @JsonProperty("DateTimeEnd")
    private String endTime;

    @JsonProperty("Legs")
    private Set<LegDto> legs;

    public static String getDetails() {
        return "Duty{\n" +
               "id: Integer, \n" +
               "DateTimeStart: String, \n" +
               "DateTimeEnd: String, \n" +
               "Legs: \n" +
               "[" +
               LegDto.getDetails() +
               "]\n" +
               '}';
    }
}
