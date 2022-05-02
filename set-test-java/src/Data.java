import java.util.Comparator;

public class Data implements Comparator<Data> {
    String name;
    String tel;
    String bookingDate;
    String startTime;
    String endTime;
    int total;
    public Data() {}
    public Data(String name, String tel, String bookingDate, String startTime, String endTime, int total) {
        this.name = name;
        this.tel = tel;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.total = total;
    }

    public String getName() {
        return this.name;
    }

    public String getTel() {
        return this.tel;
    }

    public String getBookingDate() {
        return this.bookingDate;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public int getTotal() {
        return this.total;
    }

    @Override
    public int compare(Data o1, Data o2) {
        return 0;
    }
}
