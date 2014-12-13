package rabbitAndTortoise;

/**
 * Created by alshevchuk on 13.12.2014.
 */
public class Test {
    private static final int COLLECTION_SIZE = 85;
    private static final int COLLECTION_START_INDEX = 0;
    private static final int BROKEN_ENTRY_NEXT_INDEX = 60;
    private static final int BROKEN_ENTRY_PREV_INDEX = 6;
    private static final int BROKEN_ENTRY_INDEX = 70;
    private static DataCollection.Entry brokenEntry;

    public static void main(String[] args) {
        validateIndexes();

        performSimpleTest();//few tests for verification, if collection provide expected result or not.
        prepareBrokenEntry();//prepare and set broken entry

        LoopDetector loopDetector = new LoopDetector(brokenEntry);
    }

    private static void validateIndexes() {
        /**
         COLLECTION_SIZE
         COLLECTION_START_INDEX
         BROKEN_ENTRY_NEXT_INDEX
         BROKEN_ENTRY_PREV_INDEX
         BROKEN_ENTRY_INDEX
         */

        if (COLLECTION_SIZE < COLLECTION_START_INDEX)
            throw new ArrayIndexOutOfBoundsException();
        if (COLLECTION_SIZE < BROKEN_ENTRY_NEXT_INDEX)
            throw new ArrayIndexOutOfBoundsException();
        if (BROKEN_ENTRY_INDEX < BROKEN_ENTRY_NEXT_INDEX)
            throw new ArrayIndexOutOfBoundsException();

    }

    private static void performSimpleTest() {
        DataCollection<String> dataCollection = new DataCollection<>();
        DataCollection.Entry entry;
        DataCollection.Entry firstEntry = null;
        DataCollection.Entry lastEntry = null;
        DataCollection.Entry middleEntry = null;
        for (int i = COLLECTION_START_INDEX; i < COLLECTION_SIZE; i++) {
            entry = dataCollection.add("" + i);
            if (i == COLLECTION_START_INDEX) {
                firstEntry = entry;
            } else if (i == COLLECTION_SIZE - 1) {
                lastEntry = entry;
            } else if (i == COLLECTION_SIZE / 2) {
                middleEntry = entry;
            }
        }

        System.out.println("Iterate forward");
        for (int i = COLLECTION_START_INDEX; i < COLLECTION_SIZE; i++) {
//            System.out.println(firstEntry.getEntry());
            firstEntry = firstEntry.getNextEntry();
        }

        System.out.println("Iterate backward");
        for (int i = COLLECTION_START_INDEX; i < COLLECTION_SIZE; i++) {
//            System.out.println(lastEntry.getEntry());
            lastEntry = lastEntry.getPrevEntry();
        }

        System.out.println("Iterate from middle element");
        System.out.println("Case: 1: <<<");
        for (int i = COLLECTION_START_INDEX; i < COLLECTION_SIZE / 2 + 1; i++) {
//            System.out.println(middleEntry.getEntry());
            if (middleEntry.getPrevEntry() != null) {
                middleEntry = middleEntry.getPrevEntry();
            }
        }
        System.out.println("\nCase 2 ->>>");
        for (int i = COLLECTION_START_INDEX; i < COLLECTION_SIZE / 2 + 1; i++) {
//            System.out.println(middleEntry.getEntry());
            if (middleEntry.getNextEntry() != null)
                middleEntry = middleEntry.getNextEntry();
        }

        System.out.println("------End of normal test------\n");
    }

    private static void prepareBrokenEntry() {
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