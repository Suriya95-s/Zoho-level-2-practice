import java.util.ArrayList;

public class DiceThrow {
    public static void main(String[] args) {
        combOfDice("",4);
        System.out.println(combOfListDice("",6));
    }

    static void combOfDice(String proc,int target)
    {
        if(target == 0)
        {
            System.out.println(proc);
            return;
        }

        for(int i=1;i<=6 && i<=target;i++)
        {

            combOfDice(proc+i,target-i);
        }
    }

    //return as list

    static ArrayList<String> combOfListDice(String proc, int target)
    {
        if(target == 0)
        {
            ArrayList<String> list = new ArrayList<>();
            list.add(proc);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        for(int i=1;i<=6 && i<=target;i++)
        {

            list.addAll(combOfListDice(proc+i,target-i));
        }
        return list;
    }
}
