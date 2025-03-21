import java.util.Scanner;

public class LengthOfLastWrd {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String val = read.nextLine();
        System.out.println(lenOLastWrd(val));
    }

    static int lenOLastWrd(String str)
    {
        if(str.isEmpty())
        {
            return 0;
        }

        int count =0;
        str= str.stripTrailing();
        int j=1;
        while(str.charAt(str.length()-j) != ' ')
        {
            count++;
            j=j+1;
        }
        return count;
    }
}
