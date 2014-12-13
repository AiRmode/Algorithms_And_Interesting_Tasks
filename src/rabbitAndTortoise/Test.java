package rabbitAndTortoise;

/**
 * Created by alshevchuk on 13.12.2014.
 */
public class Test {

    private static DataCollection.Entry brokenEntry;

    public static void main(String[] args) {
        //few tests for verification, if collection give expected result or not.
        brokenCaseTest();//test for broken scenario
        normalCaseTest();

        startSearchLoopedRecords();
    }

    private static void startSearchLoopedRecords() {
        System.out.println("startSearchLoopedRecords..:");
        DataCollection.Entry rabbit = brokenEntry;
        DataCollection.Entry tortoise = brokenEntry;
        for (int i = 0; i < 150; i++) {
            tortoise = tortoise.getNextEntry().getNextEntry();
            rabbit = rabbit.getNextEntry();
            if (tortoise.equals(rabbit)) {
                System.out.println("Loop was founded!");
                System.out.println("Tortoise: " + tortoise);
                System.out.println("Rabbit: " + rabbit);
                System.out.println("Lap: " + i);
                break;
            }
        }
    }

    private static void normalCaseTest() {
        DataCollection<String> dataCollection = new DataCollection<>();
        for (int i = 0; i < 10; i++) {
            dataCollection.add("" + i);
        }

        DataCollection<DataWrapper> dataCollection2 = new DataCollection<>();
        DataCollection.Entry n;
        DataCollection.Entry nFirst = null;
        DataCollection.Entry nLast = null;
        DataCollection.Entry nRandom = null;
        for (int i = 0; i < 10; i++) {
            n = dataCollection2.add(new DataWrapper("" + i));
            if (i == 0) {
                nFirst = n;
            } else if (i == 9) {
                nLast = n;
            } else if (i == 5) {
                nRandom = n;
            }
        }

        System.out.println("Iterate forward");
        for (int i = 0; i < 10; i++) {
            System.out.println(nFirst.getEntry());
            nFirst = nFirst.getNextEntry();
        }

        System.out.println("Iterate backward");
        for (int i = 0; i < 10; i++) {
            System.out.println(nLast.getEntry());
            nLast = nLast.getPrevEntry();
        }

        System.out.println("Iterate from random element");
        for (int i = 0; i < 6; i++) {
            System.out.println(nRandom.getEntry());
            if (nRandom.getPrevEntry() != null)
                nRandom = nRandom.getPrevEntry();
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(nRandom.getEntry());
            nRandom = nRandom.getNextEntry();
        }

        System.out.println("-------------\n" + dataCollection);
    }

    private static void brokenCaseTest() {
        DataCollection<String> dataCollection = new DataCollection<>();
        DataCollection.Entry targetPrev = null;
        DataCollection.Entry targetNext = null;
        DataCollection.Entry targetToBreak = null;
        for (int i = 1; i < 100; i++) {
            if (i == 77) {
                targetNext = dataCollection.add("" + i);
            } else if (i == 6) {
                targetPrev = dataCollection.add("" + i);
            } else if (i == 80) {
                targetToBreak = dataCollection.add("" + i);
            } else {
                dataCollection.add("" + i);
            }
        }
        DataCollection.Entry brokenEntry = dataCollection.addBrokenEntry(targetToBreak, targetPrev, targetNext);
        setBrokenEntry(brokenEntry);

        System.out.println(brokenEntry);
    }

    public static void setBrokenEntry(DataCollection.Entry brokenEntry) {
        Test.brokenEntry = brokenEntry;
    }
}
