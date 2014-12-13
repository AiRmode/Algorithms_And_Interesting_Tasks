package rabbitAndTortoise;

/**
 * Created by alshevchuk on 13.12.2014.
 */
public class Test {

    private static final int COLLECTION_SIZE = 85;
    private static final int COLLECTION_START_INDEX = 0;
    private static final int BROKEN_ENTRY_NEXT_INDEX = 70;
    private static final int BROKEN_ENTRY_PREV_INDEX = 6;
    private static final int BROKEN_ENTRY_INDEX = 75;
    private static DataCollection.Entry brokenEntry;

    public static void main(String[] args) {
        validateIndexes();

        //few tests for verification, if collection give expected result or not.
        normalTestCollection();
        brokenCaseTest();//test for broken scenario

        detectLoop();
    }

    private static void validateIndexes() {
        /**
         private static final int COLLECTION_SIZE =85;
         private static final int COLLECTION_START_INDEX = 0;
         private static final int BROKEN_ENTRY_NEXT_INDEX = 81;
         private static final int BROKEN_ENTRY_PREV_INDEX = 6;
         private static final int BROKEN_ENTRY_INDEX = 80
         */

        if (COLLECTION_SIZE < COLLECTION_START_INDEX)
            throw new ArrayIndexOutOfBoundsException();
        if (COLLECTION_SIZE < BROKEN_ENTRY_NEXT_INDEX)
            throw new ArrayIndexOutOfBoundsException();
        if (BROKEN_ENTRY_INDEX < BROKEN_ENTRY_NEXT_INDEX)
            throw new ArrayIndexOutOfBoundsException();

    }

    private static void detectLoop() {
        System.out.println("startSearchLoopedRecords..:");
        DataCollection.Entry rabbit = brokenEntry;
        DataCollection.Entry tortoise = brokenEntry;
        int lap = 0;
        while (true) {
            lap++;
            tortoise = tortoise.getNextEntry().getNextEntry();
            rabbit = rabbit.getNextEntry();
            if (tortoise.equals(rabbit)) {
                System.out.println("Loop was founded!");
                System.out.println("Tortoise: " + tortoise);
                System.out.println("Rabbit: " + rabbit);
                System.out.println("Lap: " + lap);
                break;
            }
        }
    }

    private static void normalTestCollection() {
        DataCollection<String> dataCollection = new DataCollection<>();
        DataCollection.Entry n;
        DataCollection.Entry nFirst = null;
        DataCollection.Entry nLast = null;
        DataCollection.Entry nMiddle = null;
        for (int i = COLLECTION_START_INDEX; i < COLLECTION_SIZE; i++) {
            n = dataCollection.add("" + i);
            if (i == COLLECTION_START_INDEX) {
                nFirst = n;
            } else if (i == COLLECTION_SIZE - 1) {
                nLast = n;
            } else if (i == COLLECTION_SIZE / 2) {
                nMiddle = n;
            }
        }

        System.out.println("Iterate forward");
        for (int i = COLLECTION_START_INDEX; i < COLLECTION_SIZE; i++) {
//            System.out.println(nFirst.getEntry());
            nFirst = nFirst.getNextEntry();
        }

        System.out.println("Iterate backward");
        for (int i = COLLECTION_START_INDEX; i < COLLECTION_SIZE; i++) {
//            System.out.println(nLast.getEntry());
            nLast = nLast.getPrevEntry();
        }

        System.out.println("Iterate from middle element");
        System.out.println("Case: 1: <<<");
        for (int i = COLLECTION_START_INDEX; i < COLLECTION_SIZE / 2 + 1; i++) {
//            System.out.println(nMiddle.getEntry());
            if (nMiddle.getPrevEntry() != null) {
                nMiddle = nMiddle.getPrevEntry();
            }
        }
        System.out.println("\nCase 2 ->>>");
        for (int i = COLLECTION_START_INDEX; i < COLLECTION_SIZE / 2 + 1; i++) {
//            System.out.println(nMiddle.getEntry());
            if (nMiddle.getNextEntry() != null)
                nMiddle = nMiddle.getNextEntry();
        }

        System.out.println("------End of normal test------\n");
    }

    private static void brokenCaseTest() {
        DataCollection<String> dataCollection = new DataCollection<>();
        DataCollection.Entry targetPrev = null;
        DataCollection.Entry targetNext = null;
        DataCollection.Entry targetToBreak = null;
        for (int i = COLLECTION_START_INDEX; i < COLLECTION_SIZE; i++) {
            if (i == BROKEN_ENTRY_NEXT_INDEX) {
                targetNext = dataCollection.add("" + i);
            } else if (i == BROKEN_ENTRY_PREV_INDEX) {
                targetPrev = dataCollection.add("" + i);
            } else if (i == BROKEN_ENTRY_INDEX) {
                targetToBreak = dataCollection.add("" + i);
            } else {
                dataCollection.add("" + i);
            }
        }

        DataCollection.Entry brokenEntry = dataCollection.addBrokenEntry(targetToBreak, targetPrev, targetNext);
        setBrokenEntry(brokenEntry);

        System.out.println("Hint: broken entry is: " + brokenEntry);
    }

    public static void setBrokenEntry(DataCollection.Entry brokenEntry) {
        Test.brokenEntry = brokenEntry;
    }
}
