package ir.adlas.adlasapp.ws.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@Schema(name = "Response", description = "This is the 'ResponseDto' object")
public class ResponseDto {

    @Schema(description = "What is the final result? It will be true if the process is finished without any faults, otherwise, it is false.", example = "true")
    private boolean action;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    @Schema(description = "The time of response", example = "16/09/2024 23:11:14 PM")
    private LocalDateTime timestamp;

    @Schema(description = "The result of the response, including boolean, object, list, and so on")
    private Object result;
}
