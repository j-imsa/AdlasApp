package ir.adlas.adlasapp.unit.service;

import ir.adlas.adlasapp.config.exception.AppServiceException;
import ir.adlas.adlasapp.shared.mapper.ExemptionMapper;
import ir.adlas.adlasapp.ws.model.dto.ExemptionDto;
import ir.adlas.adlasapp.ws.repository.ExemptionRepository;
import ir.adlas.adlasapp.ws.service.impl.ExemptionServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ExemptionServiceTests {

    @InjectMocks
    private ExemptionServiceImpl exemptionService;

    @Mock
    private ExemptionRepository exemptionRepository;

    @Mock
    private ExemptionMapper exemptionMapper;

    @Nested
    @DisplayName("CreateExemption")
    class CreateExemptionTests {

        @Test
        @DisplayName("with invalid public_id, should throw AppServiceException")
        void testCreateExemptionWithInvalidPublicId() {
            ExemptionDto exemptionDto = new ExemptionDto();
            exemptionDto.setPublicId("null"); // Setting publicId is an invalid action!

            assertThatThrownBy(() -> exemptionService.createExemption(exemptionDto))
                    .isInstanceOf(AppServiceException.class)
                    .hasMessageContaining("Exemption Public ID is invalid!");
            verify(exemptionRepository, times(0)).findAll();
            verify(exemptionMapper, times(0)).mapToEntity(any(ExemptionDto.class));
        }

    }

    @Nested
    @DisplayName("ReadExemption")
    class ReadExemptionTests {
    }

    @Nested
    @DisplayName("UpdateExemption")
    class UpdateExemptionTests {
    }

    @Nested
    @DisplayName("DeleteExemption")
    class DeleteExemptionTests {
    }

}
