package org.teraplan.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.teraplan.test.enums.Gender;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDto {

    @JsonProperty("ID")
    private Integer id;

    @JsonProperty("Gender")
    private Gender gender;

    @JsonProperty("Fleet")
    private String fleet;

    public static String getDetails() {
        return "Employee{\n" +
               "ID: Integer, \n" +
               "Gender: String, \n" +
               "Fleet: String, \n" +
               '}';
    }
}
