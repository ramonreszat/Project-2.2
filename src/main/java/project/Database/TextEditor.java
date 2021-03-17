package project.Database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TextEditor {

    private final static String[] weekdays = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
    public static String inquiry;

    public static String inquire(String message) {
        message.toLowerCase(Locale.ENGLISH);
        if(message.contains("time") && message.contains("course")) {
            inquiry += "time ";
            String[] split = message.split(" ");
            int index = 0;
            for(String s : split) {
                if(s.equals("course"))
                    break;
                index++;
            }
            inquiry+= split[index+1] + ' ';
            index=0;
            for (String ss:split){
                if(ss.equals("on"))
                    break;
                index++;
            }
            inquiry+= split[index+1]+' ';
        } else if(message.contains("courses") && message.contains("date")){
            inquiry+="course ";
            String[] split = message.split(" ");
            int index=0;
            for(String s:split){
                if(s.equals("date"))
                    break;
                index++;
            }
            if(isValidDate(split[index + 1])) {
                inquiry+= split[index+1]+"_date_ ";
            }
        } else if(message.contains("course") && !message.contains("date")) {
            inquiry += "course ";
            for(String s:weekdays){
                if(message.contains(s))
                    inquiry+= s+"_weekday_ ";
            }
        }
        return inquiry;
    }

    public static boolean isValidDate(String inDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try {
            format.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

}
