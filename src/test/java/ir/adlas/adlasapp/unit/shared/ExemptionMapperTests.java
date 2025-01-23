package ir.adlas.adlasapp.unit.shared;


import ir.adlas.adlasapp.shared.mapper.ExemptionMapper;
import ir.adlas.adlasapp.shared.publicid.PublicIdGenerator;
import ir.adlas.adlasapp.ws.model.dto.ExemptionDto;
import ir.adlas.adlasapp.ws.model.entity.ExemptionEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ExemptionMapperTests {

    private ExemptionMapper exemptionMapper;

    @BeforeEach
    public void setUp() {
        PublicIdGenerator publicIdGenerator = new PublicIdGenerator();
        exemptionMapper = new ExemptionMapper(publicIdGenerator);
    }

    @Nested
    @DisplayName("MapToEntity")
    class MapToEntityTests {

        @Test
        @DisplayName("Should map ExemptionDto to ExemptionEntity correctly")
        void testMapToEntity() {
            // Arrange
            ExemptionDto dto = ExemptionDto.builder()
                    .name("Sample Name")
                    .description("Sample Description")
                    .application("Sample Application")
                    .hostnames("PC1,PC2")
                    .build();

            // Act
            ExemptionEntity entity = exemptionMapper.mapToEntity(dto);

            // Assert
            assertNotNull(entity);
            assertNotNull(entity.getPublicId());
            assertEquals(dto.getName(), entity.getName());
            assertEquals(dto.getDescription(), entity.getDescription());
            assertEquals(dto.getApplication(), entity.getApplication());
            assertEquals(dto.getHostnames(), entity.getHostnames());
        }


    }

    @Nested
    @DisplayName("MapToDto")
    class MapToDtoTests {

        @Test
        @DisplayName("Should map ExemptionEntity to ExemptionDto correctly")
        void testMapToEntity() {
            // Arrange
            ExemptionEntity entity = ExemptionEntity.builder()
                    .name("Sample Name")
                    .description("Sample Description")
                    .application("Sample Application")
                    .hostnames("PC1,PC2")
                    .build();

            // Act
            ExemptionDto dto = exemptionMapper.mapToDto(entity);

            // Assert
            assertNotNull(dto);
            assertEquals(entity.getName(), dto.getName());
            assertEquals(entity.getDescription(), dto.getDescription());
            assertEquals(entity.getApplication(), dto.getApplication());
            assertEquals(entity.getHostnames(), dto.getHostnames());
        }


    }
}
