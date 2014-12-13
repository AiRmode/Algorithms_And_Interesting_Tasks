package rabbitAndTortoise;

/**
 * Created by alshevchuk on 12.12.2014.
 */
public class DataWrapper {
    private String data = "";

    public DataWrapper(String data) {
        this.data = data;
    }

    public String getData(){
        return data;
    }
}
