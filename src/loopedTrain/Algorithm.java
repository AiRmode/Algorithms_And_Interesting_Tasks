package loopedTrain;

/**
 * Created by Alexey on 24.10.2014.
 */
public class Algorithm {

    public static void main(String[] args) {
        SrcData srcData = new SrcData();//prepare source data
        calcWagonQuantity(srcData);
    }

    private static void calcWagonQuantity(SrcData srcData) {
        int fwCounter = 0;//forward counter
        int startValue = srcData.getNext();
        while (true) {
            fwCounter++;
            int nextValue = srcData.getNext();
            if (startValue != nextValue) {
                continue;
            } else {//means, that it can be possible, that we found the beginning
                int tempThisValue = srcData.invertThisValue();
                int tempFirstValue = goNStepsBack(srcData, fwCounter);
                if (tempThisValue == tempFirstValue) {//if true - it means, that we found the beginning
                    System.out.println("Finished, train length = " + fwCounter);
                    break;
                } else {
                    goNStepsForward(srcData, fwCounter);
                }
            }
        }
    }

    private static int goNStepsBack(SrcData srcData, int fwCounter) {
        int res = -1;
        for (int i = 0; i < fwCounter; i++) {
            res = srcData.getPrev();
        }
        if (res == -1)
            throw new IllegalStateException("Not acceptable value received: " + fwCounter);
        return res;
    }

    private static int goNStepsForward(SrcData srcData, int fwCounter) {
        int res = -1;
        for (int i = 0; i < fwCounter; i++) {
            res = srcData.getNext();
        }
        if (res == -1)
            throw new IllegalStateException("Not acceptable value received: " + fwCounter);
        return res;
    }

}
