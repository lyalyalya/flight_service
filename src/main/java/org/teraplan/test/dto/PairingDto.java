package org.teraplan.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PairingDto {

    @JsonProperty("ID")
    private Integer id;

    @JsonProperty("Fleet")
    private String fleet;

    @JsonProperty("DateTimeStart")
    private String startTime;

    @JsonProperty("DateTimeEnd")
    private String endTime;

    @JsonProperty("Duties")
    private Set<DutyDto> duties;

    public static String getDetails() {
        return "Pairing{\n" +
               "ID: Integer, \n" +
               "Fleet: String, \n" +
               "DateTimeStart: String, \n" +
               "DateTimeEnd: String, \n" +
               "Duties: \n" +
               "[" +
               DutyDto.getDetails() +
               "]\n" +
               '}';
    }
}
