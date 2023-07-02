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
            if(data.equals("")){
                data = "00-00-0000";
            } else {
                date = dateFormat.parse(data.replace('/', '-'));
            }
        } catch (ParseException e) {
            System.out.println("Erro ao analisar a data: " + e.getMessage());
            e.printStackTrace();
        }

        return date;
    }

    public static String formatarData(Date date) {
        // Create a SimpleDateFormat object with the desired format
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = "";

        // Format the date to a string
        if(date == null){
            dataFormatada = "00-00-0000";
        } else {
            dataFormatada = formato.format(date);
        }

        return dataFormatada;
    }
}
