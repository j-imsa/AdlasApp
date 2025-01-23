package ir.adlas.adlasapp.unit.repository;

import ir.adlas.adlasapp.ws.model.entity.ExemptionEntity;
import ir.adlas.adlasapp.ws.repository.ExemptionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
public class ExemptionRepositoryTests {

    @Autowired
    private ExemptionRepository exemptionRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Nested
    @DisplayName("Save")
    class SaveTests {

    }

    @Nested
    @DisplayName("FindByPublicId")
    class FindByPublicIdTests {

        @Test
        @DisplayName("with valid info, should return valid entity")
        void testFindByPublicIdWithValidInfo() {
            ExemptionEntity entity = exemptionRepository.save(
                    ExemptionEntity.builder()
                            .publicId("publicId")
                            .name("name")
                            .description("description")
                            .application("application")
                            .hostnames("hostnames")
                            .publicId("publicId")
                            .build()
            );

            Optional<ExemptionEntity> optionalExemptionEntity = exemptionRepository.findByPublicId(entity.getPublicId());

            assertThat(optionalExemptionEntity)
                    .isPresent()
                    .contains(entity)
                    .hasValueSatisfying(sql -> {
                        assertThat(sql).isNotNull();
                        assertThat(sql.getPublicId()).isEqualTo(entity.getPublicId());
                        assertThat(sql.getId()).isGreaterThan(0L);
                        assertThat(sql)
                                .hasFieldOrPropertyWithValue("name", sql.getName())
                                .hasFieldOrPropertyWithValue("application", sql.getApplication())
                                .hasFieldOrPropertyWithValue("hostnames", sql.getHostnames())
                                .hasFieldOrPropertyWithValue("description", sql.getDescription());
                    });
        }

    }

    @Nested
    @DisplayName("FindAll")
    class FindAllTests {

    }
}
