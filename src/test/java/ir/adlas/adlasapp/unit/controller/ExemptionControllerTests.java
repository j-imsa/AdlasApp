package ir.adlas.adlasapp.unit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.adlas.adlasapp.ws.model.dto.ExemptionDto;
import ir.adlas.adlasapp.ws.service.ExemptionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExemptionControllerTests.class)
public class ExemptionControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExemptionService exemptionService;

    @Autowired
    private ObjectMapper objectMapper;


    @Nested
    @DisplayName("CreateExemption")
    class CreateExemptionTests {

        @Test
        @DisplayName("should return status 5XX")
        void shouldReturnStatus403Auth() throws Exception {
            // Arrange
            ExemptionDto exemptionDto = ExemptionDto.builder()
                    .name("name")
                    .description("description")
                    .publicId("publicId")
                    .build();

            when(exemptionService.createExemption(any(ExemptionDto.class))).thenReturn(exemptionDto);

            // Act & Assert
            mockMvc.perform(post("/exemption")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(exemptionDto)))
                    .andExpect(status().is5xxServerError());
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


}
