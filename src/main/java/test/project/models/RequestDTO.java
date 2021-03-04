package test.project.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RequestDTO {
    @JsonProperty("id")
    private Integer id;
}
