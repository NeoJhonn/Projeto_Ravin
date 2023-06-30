package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HandleDates {

    public HandleDates() {

    }

    public static Date criarDataAniverssario(String data) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;

        try {
            date = dateFormat.parse(data);
        } catch (ParseException e) {
            System.out.println("Erro ao analisar a data: " + e.getMessage());
            e.printStackTrace();
        }

        return date;
    }
}
