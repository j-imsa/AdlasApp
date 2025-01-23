package ir.adlas.adlasapp.ws.model.entity;

import ir.adlas.adlasapp.ws.model.enums.ExemptionStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exemptions")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ExemptionEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "public_id", nullable = false, unique = true)
    private String publicId;

    private String name;
    private String description;
    private String application;
    private String hostnames;
    private ExemptionStatus status;

}
