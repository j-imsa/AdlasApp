package ir.adlas.adlasapp.shared.mapper;

import ir.adlas.adlasapp.shared.publicid.PublicIdGenerator;
import ir.adlas.adlasapp.ws.model.dto.ExemptionDto;
import ir.adlas.adlasapp.ws.model.entity.ExemptionEntity;
import ir.adlas.adlasapp.ws.model.enums.ExemptionStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static ir.adlas.adlasapp.shared.constant.ProjectConstants.PUBLIC_ID_DEFAULT_LENGTH;

@Component
@AllArgsConstructor
public class ExemptionMapper {
    private final PublicIdGenerator idGenerator;

    public ExemptionEntity mapToEntity(ExemptionDto exemptionDto) {
        return ExemptionEntity.builder()
                .name(exemptionDto.getName())
                .description(exemptionDto.getDescription())
                .application(exemptionDto.getApplication())
                .hostnames(exemptionDto.getHostnames())
                .publicId(idGenerator.generatePublicId(PUBLIC_ID_DEFAULT_LENGTH))
                .status(ExemptionStatus.UNDEPLOYED)
                .build();
    }

    public ExemptionDto mapToDto(ExemptionEntity exemptionEntity) {
        return ExemptionDto.builder()
                .name(exemptionEntity.getName())
                .description(exemptionEntity.getDescription())
                .application(exemptionEntity.getApplication())
                .hostnames(exemptionEntity.getHostnames())
                .publicId(exemptionEntity.getPublicId())
                .status(exemptionEntity.getStatus())
                .build();
    }
}
