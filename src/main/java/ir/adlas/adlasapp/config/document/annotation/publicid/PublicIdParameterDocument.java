package ir.adlas.adlasapp.config.document.annotation.publicid;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ExampleObject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static ir.adlas.adlasapp.shared.constant.ProjectConstants.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Parameter(
        description = DOCUMENT_PUBLIC_ID_DESCRIPTION,
        example = DOCUMENT_PUBLIC_ID_EXAMPLE,
        examples = {
                @ExampleObject(
                        name = DOCUMENT_PUBLIC_ID_EXAMPLE_1_NAME,
                        value = DOCUMENT_PUBLIC_ID_EXAMPLE_1_VALUE,
                        summary = DOCUMENT_PUBLIC_ID_EXAMPLE_1_SUMMERY
                ),
                @ExampleObject(
                        name = DOCUMENT_PUBLIC_ID_EXAMPLE_2_NAME,
                        value = DOCUMENT_PUBLIC_ID_EXAMPLE_2_VALUE,
                        summary = DOCUMENT_PUBLIC_ID_EXAMPLE_2_SUMMERY
                )
        }
)
public @interface PublicIdParameterDocument {
}