package ir.adlas.adlasapp.config.document.annotation.exemption;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import ir.adlas.adlasapp.ws.model.dto.ExemptionDto;
import ir.adlas.adlasapp.ws.model.dto.ResponseDto;
import org.springframework.http.MediaType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Operation(
        responses = {
                @ApiResponse(
                        responseCode = "201",
                        description = "Creating an exemption with the provided info was successful",
                        content = @Content(
                                examples = @ExampleObject("""
                                        """),
                                schema = @Schema(implementation = ResponseDto.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Creating an exemption with the provided info was NOT successful",
                        content = @Content(
                                examples = @ExampleObject("""
                                        """),
                                schema = @Schema(implementation = ResponseDto.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "500",
                        description = "Internal server error has occurred",
                        content = @Content(
                                examples = @ExampleObject("""
                                        {
                                          "action": false,
                                          "timestamp": "10/09/2024 10:20:30 PM",
                                          "result": {
                                            "path": "{METHOD} /{PATH}/{PATH-PID-...}",
                                            "message": "Internal service error!"
                                          }
                                        }
                                        """),
                                schema = @Schema(implementation = ResponseDto.class)
                        )
                )
        },
        requestBody = @RequestBody(
                description = "This request comes with valid data!",
                required = true,
                content = @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(
                                        name = "",
                                        summary = "",
                                        value = ""
                                ),
                        },
                        schema = @Schema(implementation = ExemptionDto.class)
                )
        )
)
public @interface CreateExemptionDocument {
    String summary() default "Creating an exemption";

    String description() default "Creating an exemption...";
}
