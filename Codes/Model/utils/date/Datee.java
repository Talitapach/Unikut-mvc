package Codes.Model.utils.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Datee {
    public static String calendar(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  HH:mm");
        Date date = new Date();
        return sdf.format(date);
    }
}
