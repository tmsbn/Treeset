import java.util.Iterator;

/**
 * Created by tmsbn on 11/28/16.
 */
public class CustomTest {

    public static void main(String args[]) {

        HpTreeSet<String> hpTreeSet = new HpTreeSet<String>();
        hpTreeSet.add("Tom");
        hpTreeSet.add("Sav");
        hpTreeSet.add("Joe");
        hpTreeSet.add("Kra");
        hpTreeSet.add("Bls");
        hpTreeSet.add("Abu");

        // Iterator test
        Iterator iterator1 = hpTreeSet.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        // TreeSet
        if(hpTreeSet.contains(1)){
            System.out.println("Contains works");
        }

        // TreeSet
        if(!hpTreeSet.add("Kra")){
            System.out.println("Add works!");
        }

        // TreeSet
        if(!hpTreeSet.remove("Bla")){
            System.out.println("Remove works!");
        }


        // Iterator test
        Iterator iterator2 = hpTreeSet.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        System.out.println(hpTreeSet.size());




    }
}
