package org.teraplan.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignmentDto {

    @JsonProperty
    private Integer id;

    @JsonProperty("EmployeeID")
    private Integer employeeId;

    @JsonProperty("PairingID")
    private Integer pairingId;

    @JsonProperty("Rank")
    private String rank;

    public static String getDetails() {
        return "Assignment{\n" +
               "id: Integer, \n" +
               "EmployeeID: Integer, \n" +
               "PairingID: Integer, \n" +
               "Rank: String \n" +
               '}';
    }
}
