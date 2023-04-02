package org.teraplan.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightDto {

    @JsonProperty("ID")
    private Integer id;

    @JsonProperty("FlightNum")
    private Integer number;

    @JsonProperty("StationDeparture")
    private String departureStation;

    @JsonProperty("StationArrival")
    private String arrivalStation;

    @JsonProperty("DateTimeDeparture")
    private String departureTime;

    @JsonProperty("DateTimeArrival")
    private String arrivalTime;

    public static String getDetails() {
        return "Flight{\n" +
               "ID: Integer, \n" +
               "FlightNum: Integer, \n" +
               "StationDeparture: String, \n" +
               "StationArrival: String, \n" +
               "DateTimeDeparture: String, \n" +
               "DateTimeArrival: String, \n" +
               '}';
    }
}
