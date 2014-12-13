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
        DataCollection.Entry n = null;
        DataCollection.Entry nFirst = null;
        DataCollection.Entry nLast = null;
        DataCollection.Entry nRandom = null;
        for (int i = 0; i < 10; i++) {
            n = dataCollection2.add(new DataWrapper("" + i));
            if (i == 0) {
                nFirst = n;
            } else if (i == 9) {
                nLast = n;
            } else if(i==5){
                nRandom = n;
            }
        }

        for (int i = 0; i < 6; i++) {
            System.out.println(nRandom.getEntry());
            nRandom = nRandom.getPrevEntry();
        }

        System.out.println(dataCollection);
    }
}
