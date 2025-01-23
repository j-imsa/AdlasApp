package ir.adlas.adlasapp.config.validation.annotation.publicid;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static ir.adlas.adlasapp.shared.constant.ProjectConstants.VALIDATION_PUBLIC_ID_DEFAULT_MESSAGE;

@Target({ ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PublicIdValidator.class)
public @interface ValidPublicId {
    String message() default VALIDATION_PUBLIC_ID_DEFAULT_MESSAGE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}