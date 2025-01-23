package ir.adlas.adlasapp.config.exception;

import ir.adlas.adlasapp.ws.model.dto.ResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static ir.adlas.adlasapp.shared.constant.ProjectConstants.*;


@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = AppServiceException.class)
    public ResponseEntity<ResponseDto> handleAppServiceExceptions(AppServiceException ex, HttpServletRequest webRequest) {
        Map<String, String> error = new HashMap<>();
        error.put(EXCEPTION_MESSAGE, ex.getMessage());
        error.put(EXCEPTION_PATH, String.format(EXCEPTION_PATTERN, webRequest.getMethod(), webRequest.getRequestURI()));
        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(
                        ResponseDto.builder()
                                .action(false)
                                .timestamp(LocalDateTime.now())
                                .result(error)
                                .build()
                );
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseDto> handleExceptions(Exception ex, HttpServletRequest webRequest) {
        Map<String, String> error = new HashMap<>();
        error.put(EXCEPTION_MESSAGE, ex.getMessage());
        error.put(EXCEPTION_PATH, String.format(EXCEPTION_PATTERN, webRequest.getMethod(), webRequest.getRequestURI()));
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        ResponseDto.builder()
                                .action(false)
                                .timestamp(LocalDateTime.now())
                                .result(error)
                                .build()
                );
    }

}
