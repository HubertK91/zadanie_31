package pl.hk.zadanie_31;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(DataNotAvailableException.class)
    public String handleException(){
        return "nodata";
    }
}
