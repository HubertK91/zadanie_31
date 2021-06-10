package pl.hk.zadanie_31;

public class DataNotAvailableException extends RuntimeException{

    public DataNotAvailableException() {
        super("Nie udało się pobrać pogody dla danego miasta");
    }
}
