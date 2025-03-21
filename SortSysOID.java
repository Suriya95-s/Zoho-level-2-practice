import java.util.ArrayList;
import java.util.List;

public class SortSysOID {
    public static void main(String[] args) {
//        List<String> sysoidList = new ArrayList<>();
//        sysoidList.add(".1.2.3.4.2.4.6.2.5");
//        sysoidList.add(".1.2.3.1.2.5.6.2.5");
//        sysoidList.add(".1.2.3.1.2.4.6.1");
//        sysoidList.add(".1.2.3.1.2.1.6.2.5");

        List<String> sysoidList = new ArrayList<>(List.of(
                ".4.1.6.5.4.6.3",
                ".4.1.6.5.2.6.1.6",
                ".4.1.6.5.2.6",
                ".4.1.6.5.2.6.2"
        ));

        List<String> sortedListval = sortList(sysoidList);
        System.out.println(sortedListval);
    }

    static List<String> sortList(List<String> sysoidList)
    {
        for(int i=0;i<sysoidList.size();i++)
        {
            for (int j=i+1;j<sysoidList.size();j++)
            {
                if(compareCharVal(sysoidList.get(i),sysoidList.get(j)) >0 )
                {
                    String temp = sysoidList.get(i);
                    sysoidList.set(i,sysoidList.get(j));
                    sysoidList.set(j,temp);
                }
            }
        }
        return sysoidList;
        }

    static int compareCharVal(String oid1,String oid2)
    {
        int i=0,j=0;

        int num1=0,num2=0;

        while(i<oid1.length() && j<oid2.length()) {
            if(oid1.charAt(i) == '.') i++;
            if(oid2.charAt(j) == '.') j++;

            while(i < oid1.length() && oid1.charAt(i) != '.') {
                num1 = num1 * 10 + (oid1.charAt(i) - '0');
                i++;
            }

            while (j < oid2.length() && oid2.charAt(j) != '.') {
                num2 = num2 * 10 + (oid2.charAt(j) - '0');
                j++;
            }

            if (num1 != num2) {
                return num1 - num2;
            }
        }

        return (oid1.length() - i) - (oid2.length() -j );
    }

}



