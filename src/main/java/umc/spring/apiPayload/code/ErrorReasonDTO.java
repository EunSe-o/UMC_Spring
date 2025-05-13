package umc.spring.apiPayload.code;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import lombok.Builder;

@Getter
@Builder
public class ErrorReasonDTO {

    private HttpStatus httpStatus;

    private final boolean isSuccess;
    private final String code;
    private final String message;

    public boolean getIsSuccess(){return isSuccess;}
}