import java.util.TreeMap;

class MyCalendarI {
    TreeMap<Integer,Integer> calendar;
    MyCalendarI()
    {
        calendar = new TreeMap<>();
    }

    boolean book(int start,int end)
    {
        //check for the values less than start using floorEntry and the checl whether there is range less les than start and also start greater than end value if not return false
        if(calendar.floorEntry(start) != null && start < calendar.floorEntry(start).getValue())
        {
            return false;
        }
        if(calendar.ceilingEntry(start)!= null && end > calendar.ceilingEntry(start).getKey())
        {
            return false;
        }
        calendar.put(start,end);
        return true;
    }
}

 class main{
     public static void main(String[] args) {
         MyCalendarI cal = new MyCalendarI();

         System.out.println(cal.book(10,20));
         System.out.println(cal.book(15,25));
         System.out.println(cal.book(20,30));
         System.out.println(cal.book(10,15));
     }
}