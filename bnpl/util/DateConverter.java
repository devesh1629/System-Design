package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter {

    public LocalDate getDateFromString(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }
}
