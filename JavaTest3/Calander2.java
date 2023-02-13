//package JavaTest3;
//
//import java.util.Date;
//import java.util.HashMap;
//
//public class Calander2 extends Daybook {
//    HashMap<String,HashMap<String, DayObject>> calendar = new HashMap<>();
//
//    Calander2(Date start, Date end) {
//        super(start, end);
//    }
//
//    public void AddEventWithMeeting(Daybook daybook, Contact c){
//        calendar.put(GetTheDate(daybook),GetValue("Elinor",new Meeting(c)));
//    }
//
//    public void AddEventWithoutMeeting(Daybook daybook, String desc){
//        calendar.put(GetTheDate(daybook),GetValue("Elinor",new Event(desc)));
//    }
//    public String GetTheDate(Daybook daybook) {
//        return "" + daybook.start.getDay() + '/' + daybook.start.getMonth();
//    }
//    public HashMap<String, DayObject> GetValue(String time, DayObject dayObject) {
//        HashMap<String, DayObject> value = new HashMap<>();
//        value.put(time,dayObject);
//        return value;
//    }
//
//}
