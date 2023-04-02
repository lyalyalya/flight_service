package org.teraplan.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LegDto {

    @JsonProperty
    private Integer id;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("FlightID")
    private Integer flightId;

    public static String getDetails() {
        return "Leg{\n" +
               "id: Integer, \n" +
               "Type: String, \n" +
               "FlightID: Integer, \n" +
               '}';
    }
}
