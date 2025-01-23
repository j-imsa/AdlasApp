package ir.adlas.adlasapp.ws.service.impl;

import ir.adlas.adlasapp.config.exception.AppServiceException;
import ir.adlas.adlasapp.shared.mapper.ExemptionMapper;
import ir.adlas.adlasapp.ws.model.dto.ExemptionDto;
import ir.adlas.adlasapp.ws.model.entity.ExemptionEntity;
import ir.adlas.adlasapp.ws.repository.ExemptionRepository;
import ir.adlas.adlasapp.ws.service.ExemptionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ExemptionServiceImpl implements ExemptionService {

    private final ExemptionRepository exemptionRepository;
    private final ExemptionMapper exemptionMapper;

    @Override
    public ExemptionDto createExemption(ExemptionDto exemptionDto) {
        if (exemptionDto.getPublicId() != null) {
            throw new AppServiceException("Exemption Public ID is invalid!", HttpStatus.BAD_REQUEST);
        }
        ExemptionEntity entity = exemptionMapper.mapToEntity(exemptionDto);
        entity = exemptionRepository.save(entity);
        return exemptionMapper.mapToDto(entity);
    }

    @Override
    public List<ExemptionDto> getExemptions(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size,
                Sort.by(Sort.Direction.ASC, "name"));
        Page<ExemptionEntity> exemptionEntityPage = exemptionRepository.findAll(pageable);
        return exemptionEntityPage
                .get()
                .map(exemptionMapper::mapToDto)
                .toList();
    }

    @Override
    public ExemptionDto getExemption(String publicId) {
        if (publicId == null || publicId.isEmpty()) {
            throw new AppServiceException("Exemption Public ID is invalid!", HttpStatus.BAD_REQUEST);
        }
        return exemptionRepository.findByPublicId(publicId)
                .map(exemptionMapper::mapToDto)
                .orElseThrow(() -> new AppServiceException("The resource with provided public_id not founded!", HttpStatus.NOT_FOUND));
    }

    @Override
    @Transactional
    public ExemptionDto updateExemption(String publicId, ExemptionDto exemptionDto) {
        if (publicId == null || publicId.isEmpty()) {
            throw new AppServiceException("Exemption Public ID is invalid!", HttpStatus.BAD_REQUEST);
        }

        Optional<ExemptionEntity> optionalExemptionEntity = exemptionRepository.findByPublicId(publicId);
        if (optionalExemptionEntity.isEmpty()) {
            throw new AppServiceException("The resource with provided public_id not founded!", HttpStatus.NOT_FOUND);
        } else {
            ExemptionEntity entity = optionalExemptionEntity.get();
            entity.setName(exemptionDto.getName());
            entity.setDescription(exemptionDto.getDescription());
            entity.setApplication(exemptionDto.getApplication());
            entity.setHostnames(exemptionDto.getHostnames());
            return exemptionMapper.mapToDto(exemptionRepository.save(entity));
        }
    }
}
