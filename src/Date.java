import java.io.Serializable;

public class Date implements Serializable {
    private String year;
    private String month;
    private String day;

    public Date(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "/" + month + "/" + day;
    }
}
