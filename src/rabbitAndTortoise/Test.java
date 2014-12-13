package rabbitAndTortoise;

/**
 * Created by alshevchuk on 13.12.2014.
 */
public class Test {

    public static void main(String[] args) {
        DataCollection<String> dataCollection = new DataCollection<>();
        for (int i = 0; i < 10; i++) {
            dataCollection.add("" + i);
        }

        DataCollection<DataWrapper> dataCollection2 = new DataCollection<>();
        for (int i = 0; i < 10; i++) {
            dataCollection2.add(new DataWrapper(""+i));
        }

        System.out.println(dataCollection);
    }
}
