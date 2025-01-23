package ir.adlas.adlasapp.ws.repository;

import ir.adlas.adlasapp.ws.model.entity.ExemptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExemptionRepository extends JpaRepository<ExemptionEntity, Long> {
}
