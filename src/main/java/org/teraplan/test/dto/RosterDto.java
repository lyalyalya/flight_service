package org.teraplan.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RosterDto {

    @JsonProperty("Pairings")
    private List<PairingDto> pairings;

    @JsonProperty("Assignments")
    private List<AssignmentDto> assignments;
}
