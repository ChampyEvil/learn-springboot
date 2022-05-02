import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Data> bookingList = new ArrayList<Data>();
        Scanner input = new Scanner(System.in);
        Data firstBooking = new Data("John", "0987654321", "2020-04-01", "20.00", "21.00", 3);
        Data secondBooking = new Data("Jame", "0987654322", "2020-04-01", "20.00", "20.30", 3);
        Data thirdBooking = new Data("Jammy", "0987654323", "2020-04-01", "21.00", "21.30", 3);
        Data fourthBooking = new Data("Jaco", "0987654324", "2020-04-01", "20.20", "21.30", 3);
        Data fifthBooking = new Data("Mocca", "0987654325", "2020-04-02", "20.00", "21.30", 6);
        Data sixthBooking = new Data("Gary", "0987654326", "2020-04-02", "20.00", "21.30", 6);
        Data seventhBooking = new Data("Thaicool", "0987654327", "2020-04-02", "19.00", "20.00", 3);
        Data eighthBooking = new Data("Hotter", "0987654328", "2020-04-03", "20.00", "21.30", 6);
        Data ninthBooking = new Data("Hacker", "0987654329", "2020-04-03", "20.00", "21.30", 1);
        Data tenthBooking = new Data("Nococa", "0987654320", "2020-04-03", "21.00", "21.30", 10);
        Data eleventhBooking = new Data("Nico", "0987654331", "2020-04-02", "19.30", "20.00", 20);
        Data twelfthBooking = new Data("Milk", "0987654332", "2020-04-03", "21.00", "22.00", 40);
        Data thirteenthBooking = new Data("Milky", "0987654333", "2020-04-03", "21.30", "22.00", 40);


        Data[] bookingData = {firstBooking, secondBooking, thirdBooking, fourthBooking, fifthBooking, sixthBooking, seventhBooking, eighthBooking, ninthBooking, tenthBooking, eleventhBooking, twelfthBooking, thirteenthBooking};
        String selectedDate = "2020-04-03";
        BookingTable bookingTable = new BookingTable();
        System.out.println("Minimum of table required is " + bookingTable.booking(selectedDate, bookingData) + " table");

    }
}
