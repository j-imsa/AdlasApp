package ir.adlas.adlasapp.ws.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import ir.adlas.adlasapp.config.document.annotation.exemption.CreateExemptionDocument;
import ir.adlas.adlasapp.config.document.annotation.publicid.PublicIdParameterDocument;
import ir.adlas.adlasapp.config.validation.annotation.publicid.ValidPublicId;
import ir.adlas.adlasapp.ws.model.dto.ExemptionDto;
import ir.adlas.adlasapp.ws.model.dto.ResponseDto;
import ir.adlas.adlasapp.ws.service.ExemptionService;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/exemption", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
@Tag(name = "Exemption endpoint", description = "The restful API endpoints, Exemption details")
public class ExemptionController {

    private final ExemptionService exemptionService;

    @PostMapping
    @CreateExemptionDocument
    public ResponseEntity<ResponseDto> createNewExemption(
            @Validated(ExemptionDto.Create.class)
            @RequestBody ExemptionDto exemptionDto
    ) {
        ExemptionDto savedExemptionDto = exemptionService.createExemption(exemptionDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ResponseDto.builder()
                                .action(true)
                                .timestamp(LocalDateTime.now())
                                .result(savedExemptionDto)
                                .build()
                );
    }

    @GetMapping
    // @GetExemptionsDocument
    public ResponseEntity<ResponseDto> getExemptions(
            @Positive(message = "page must be a positive number")
            @RequestParam(defaultValue = "1")
            @Parameter(example = "3")
            int page,

            @Positive(message = "size must be a positive number")
            @RequestParam(defaultValue = "10")
            @Parameter(example = "30")
            int size
    ) {
        List<ExemptionDto> exemptionDtos = exemptionService.getExemptions(page, size);
        return ResponseEntity
                .ok(
                        ResponseDto.builder()
                                .action(true)
                                .timestamp(LocalDateTime.now())
                                .result(exemptionDtos)
                                .build()
                );
    }

    @GetMapping("/{public_id}")
    // @GetExemptionDocument
    public ResponseEntity<ResponseDto> getExemption(
            @PublicIdParameterDocument
            @ValidPublicId
            @PathVariable("public_id") String publicId
    ) {
        ExemptionDto exemptionDto = exemptionService.getExemption(publicId);
        return ResponseEntity
                .ok(
                        ResponseDto.builder()
                                .action(true)
                                .timestamp(LocalDateTime.now())
                                .result(exemptionDto)
                                .build()
                );
    }

    @PutMapping("/{public_id}")
    // @UpdateExemptionDocument
    public ResponseEntity<ResponseDto> updateExemption(
            @PublicIdParameterDocument
            @ValidPublicId
            @PathVariable("public_id") String publicId,

            @Validated(ExemptionDto.Update.class)
            @RequestBody ExemptionDto exemptionDto
    ) {
        ExemptionDto updatedExemption = exemptionService.updateExemption(publicId, exemptionDto);
        return ResponseEntity
                .ok(
                        ResponseDto.builder()
                                .action(true)
                                .timestamp(LocalDateTime.now())
                                .result(updatedExemption)
                                .build()
                );
    }


}
