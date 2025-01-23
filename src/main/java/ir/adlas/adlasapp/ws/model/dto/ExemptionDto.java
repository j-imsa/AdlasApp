package ir.adlas.adlasapp.ws.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import ir.adlas.adlasapp.config.validation.annotation.publicid.ValidPublicId;
import ir.adlas.adlasapp.ws.model.enums.ExemptionStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import static ir.adlas.adlasapp.shared.constant.ProjectConstants.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Exemption", description = "This is the 'ExemptionDto' object")
public class ExemptionDto {

    @JsonProperty("public_id")
    @ValidPublicId(groups = {Read.class, Delete.class})
    @Null(message = "The PUBLIC_ID will setup by the Application!", groups = {Create.class, Update.class})
    @Schema(type = PUBLIC_ID_TYPE, description = PUBLIC_ID_DESCRIPTION, example = PUBLIC_ID_EXAMPLE_1)
    private String publicId;

    @NotBlank(groups = {Create.class, Read.class, Update.class, Delete.class})
    private String name;

    private String description;

    @NotBlank(groups = {Create.class, Read.class, Update.class, Delete.class})
    private String application;

    @NotBlank(groups = {Create.class, Read.class, Update.class, Delete.class})
    @Pattern(regexp = "^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)*$", message = "Hostnames must contain only English letters, numbers, and commas")
    private String hostnames;

    @Null(message = "The ExemptionStatus will setup by the Application!", groups = {Create.class})
    @NotNull(groups = {Read.class, Delete.class})
    @Pattern(regexp = "DEPLOYED|UNDEPLOYED", message = "ExemptionStatus must be either 'DEPLOYED', or 'UNDEPLOYED'", groups = {Read.class})
    private ExemptionStatus status;

    public interface Create {
    }

    public interface Read {
    }

    public interface Update {
    }

    public interface Delete {
    }
}
