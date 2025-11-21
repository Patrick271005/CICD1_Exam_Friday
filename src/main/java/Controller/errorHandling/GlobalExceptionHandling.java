package Controller.errorHandling;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.swing.text.View;
import java.util.ArrayList;

@RestControllerAdvice
public class GlobalExceptionHandling {

    private final View error;
    public GlobalExceptionHandling(View view){ this.error = error; }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionDetails>>ShowErrorDetails(MethodArgumentNotValidException mae){
        List <ExceptionDetails> errorList = new ArrayList<>();
        for(fieldError fieldError : mae.getBindingResult().getFieldError())
        {
            ExceptionDetails exceptionDetails = new ExceptionDetails();
            exceptionDetails.setFieldName(fieldError.getField());
            exceptionDetails.setFieldValue(fieldError.getDefaultMessage());
            errorList.add(e)

        }
    }




}
