package loopedTrain;

/**
 * Created by Alexey on 24.10.2014.
 *
 * This class represents source data type for testing purposes
 */
public class SrcData {

//    private int[] data = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//    private int[] data = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//    private int[] data = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//    private int[] data = new int[]{0, 1, 0};
//    private int[] data = new int[]{1, 0, 1};
    private int[] data = new int[]{1, 1, 1};
//    private int[] data = new int[]{1, 1};
//    private int[] data = new int[]{1, 0};
//    private int[] data = new int[]{1};
    private int pointer = -1;

    public SrcData() {
        System.out.println("Hint: src.data.length = " + (data.length));
    }

    public int getNext() {
        return (++pointer >= 0 && pointer < data.length) ? data[pointer] : data[(pointer = 0)];
    }

    public int getPrev() {
        return (--pointer >= 0 && pointer < data.length) ? data[pointer] : data[pointer = data.length - 1];
    }

    public int invertThisValue() {
        return data[pointer] == 0 ? (data[pointer] = 1) : (data[pointer] = 0);
    }
}