import java.util.Iterator;

/**
 * Created by tmsbn on 11/28/16.
 */
public class CustomTest {

    public static void main(String args[]) {

        TSTreeSet<String> tsTreeSet = new TSTreeSet<String>();
        tsTreeSet.add("Tom");
        tsTreeSet.add("Sav");
        tsTreeSet.add("Joe");
        tsTreeSet.add("Kra");
        tsTreeSet.add("Bls");
        tsTreeSet.add("Abu");

        // Iterator test
        Iterator iterator1 = tsTreeSet.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        // TreeSet
        if(tsTreeSet.contains(1)){
            System.out.println("Contains works");
        }

        // TreeSet
        if(!tsTreeSet.add("Kra")){
            System.out.println("Add works!");
        }

        // TreeSet
        if(!tsTreeSet.remove("Bla")){
            System.out.println("Remove works!");
        }


        // Iterator test
        Iterator iterator2 = tsTreeSet.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        System.out.println(tsTreeSet.size());




    }
}
