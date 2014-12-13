package rabbitAndTortoise;

/**
 * Created by alshevchuk on 13.12.2014.
 */
public class LoopDetector {

    public LoopDetector(DataCollection.Entry entry){
        detectLoop(entry);
    }

    private void detectLoop(DataCollection.Entry entry) {
        System.out.println("startSearchLoopedRecords..:");
        DataCollection.Entry rabbit = entry;
        DataCollection.Entry tortoise = entry;
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

}
