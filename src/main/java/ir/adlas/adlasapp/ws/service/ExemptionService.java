package ir.adlas.adlasapp.ws.service;

import ir.adlas.adlasapp.ws.model.dto.ExemptionDto;
import jakarta.validation.constraints.Positive;

import java.util.List;

public interface ExemptionService {
    ExemptionDto createExemption(ExemptionDto exemptionDto);

    List<ExemptionDto> getExemptions(int page, int size);

    ExemptionDto getExemption(String publicId);

    ExemptionDto updateExemption(String publicId, ExemptionDto exemptionDto);
}
