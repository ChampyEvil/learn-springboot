import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingTable_Test {

    BookingTable booking = new BookingTable();

    Data firstBooking = new Data("John", "0987654321", "2020-04-01", "20.00", "21.00", 3);
    Data secondBooking = new Data("Jame", "0987654322", "2020-04-01", "20.00", "20.30", 3);
    Data thirdBooking = new Data("Jammy", "0987654323", "2020-04-01", "21.00", "21.30", 3);
    Data fourthBooking = new Data("Jammy", "0987654323", "2020-04-01", "20.30", "21.30", 3);
    Data fifthBooking = new Data("Mocca", "0987654325", "2020-04-02", "20.00", "21.30", 6);
    Data sixthBooking = new Data("Gary", "0987654326", "2020-04-02", "20.00", "21.30", 6);
    Data seventhBooking = new Data("Thaicool", "0987654327", "2020-04-02", "19.00", "20.00", 3);
    Data eighthBooking = new Data("Hotter", "0987654328", "2020-04-03", "20.00", "21.30", 6);
    Data ninthBooking = new Data("Hacker", "0987654329", "2020-04-03", "20.00", "21.30", 1);
    Data tenthBooking = new Data("Nococa", "0987654320", "2020-04-03", "21.00", "21.30", 10);
    Data eleventhBooking = new Data("Nico", "0987654331", "2020-04-02", "19.30", "20.00", 20);
    Data twelfthBooking = new Data("Milk", "0987654332", "2020-04-03", "21.00", "22.00", 40);
    Data thirteenthBooking = new Data("Milky", "0987654333", "2020-04-03", "21.30", "22.00", 40);

    @Test
    public void testCase_ShouldEqual2TableWhenSelectDateAndHaveTwoBookingAndTwoGroupBookingSameTime() {
        String date = "2020-04-01";
        Data[] bookingList = {firstBooking, secondBooking};
        int totalTable = booking.booking(date, bookingList);
        assertEquals(2,totalTable);
    }

    @Test
    public void testCase_ShouldEqual1TableWhenSelectDateAndHaveTwoBookingAndTwoGroupBookingDifferentTimeAndStartTimeGroupTwoEqualOrAfterEndTimeGroupOne() {
        String date = "2020-04-01";
        Data[] bookingList = {firstBooking, thirdBooking};
        int totalTable = booking.booking(date, bookingList);
        assertEquals(1,totalTable);
    }

    @Test
    public void testCase_ShouldEqual2TableWhenSelectDateAndHaveTwoBookingAndTwoGroupBookingDifferentTimeAndStartTimeGroupTwoBeforeEndTimeGroupOne() {
        String date = "2020-04-01";
        Data[] bookingList = {firstBooking, fourthBooking};
        int totalTable = booking.booking(date, bookingList);
        assertEquals(2,totalTable);
    }

    @Test
    public void testCase_ShouldEqual2TableWhenSelectDateAndHaveOneBookingAndMoreThanFourSeat() {
        String date = "2020-04-02";
        Data[] bookingList = {fifthBooking};
        int totalTable = booking.booking(date, bookingList);
        assertEquals(2,totalTable);
    }

    @Test
    public void testCase_ShouldEqual4TableWhenSelectDateAndHaveThreeBookingAndHaveTwoGroupBookingSameTimeAndOneGroupBookingDifferentTimeAndStartTimeTwoGroupAfterEndTimeOtherGroup() {
        String date = "2020-04-02";
        Data[] bookingList = {fifthBooking, sixthBooking, seventhBooking};
        int totalTable = booking.booking(date, bookingList);
        assertEquals(4,totalTable);
    }

    @Test
    public void testCase_ShouldEqual5TableWhenSelectDateAndHaveThreeBookingAndHaveTwoGroupBookingSameTimeAndOneGroupBookingDifferentTimeAndStartTimeTwoGroupAfterEndTimeOtherGroupAndOneGroupUseTableMoreThanTwoGroup() {
        String date = "2020-04-02";
        Data[] bookingList = {fifthBooking, sixthBooking, eleventhBooking};
        int totalTable = booking.booking(date, bookingList);
        assertEquals(5,totalTable);
    }

    @Test
    public void testCase_ShouldEqual16TableWhenSelectDateAndHaveFourBookingAndHaveTwoGroupBookingSameTimeAndOtherTwoGroupBookingSameTimeButDifferentTimeFromFirstSetAndStartTimeSecondSetBeforeEndTimeFirstSet() {
        String date = "2020-04-03";
        Data[] bookingList = {eighthBooking, ninthBooking, tenthBooking, twelfthBooking};
        int totalTable = booking.booking(date, bookingList);
        assertEquals(16,totalTable);
    }

    @Test
    public void testCase_ShouldEqual20TableWhenSelectDateAndHaveFiveBookingAndHaveTwoGroupBookingSameTimeAndOtherTwoGroupBookingSameTimeButDifferentTimeFromFirstSetAndLastGroupBookingDifferentTimeAndStartTimeSecondSetBeforeEndTimeFirstSet() {
        String date = "2020-04-03";
        Data[] bookingList = {eighthBooking, ninthBooking, tenthBooking, twelfthBooking, thirteenthBooking};
        int totalTable = booking.booking(date, bookingList);
        assertEquals(20,totalTable);
    }

    @Test
    public void testCase_ShouldEqual0TableSelectDateWhenHaveNotBooking() {
        String date = "2020-04-02";
        Data[] bookingList = {firstBooking, secondBooking, thirdBooking};
        int totalTable = booking.booking(date, bookingList);
        assertEquals(0,totalTable);
    }

    Data[] bookingList = {firstBooking, secondBooking, thirdBooking, fourthBooking, fifthBooking, sixthBooking, seventhBooking, eighthBooking, ninthBooking, tenthBooking, eleventhBooking, twelfthBooking, thirteenthBooking};
    @Test
    public void testSelectDataWithDate_ShouldEqual4WhenCallSelectDataWithDateWithInput20200402() {
        String date = "2020-04-02";
        Data[] selectData = booking.selectDataWithDate(date, bookingList);
        assertEquals(4,selectData.length);
    }

    @Test
    public void testSelectDataWithDate_ShouldEqual0WhenCallSelectDataWithDateWithInput20200405() {
        String date = "2020-04-05";
        Data[] selectData = booking.selectDataWithDate(date, bookingList);
        assertEquals(0,selectData.length);
    }

    @Test
    public void testSortWithStartTime_StartTimeShouldEqual1900WhenCallSortWithStartTimeWithSelectedDataAfterCallSelectDataWithDateWithInput20200402AndChooseIndex0() {
        String date = "2020-04-02";
        Data[] selectData = booking.selectDataWithDate(date, bookingList);
        selectData = booking.sortWithStartTime(selectData);
        assertEquals("19.00",selectData[0].getStartTime());
    }

    @Test
    public void testCheckTotalOfUsedTable_ShouldEqual2WhenCallCheckTotalOfUsedTableWithInputIndex1AndSelectedDataAfterCallSelectDataWithDateWithInput20200401AndSortWithStartTime() {
        String date = "2020-04-01";
        Data[] selectData = booking.selectDataWithDate(date, bookingList);
        selectData = booking.sortWithStartTime(selectData);
        int usedTable = booking.checkTotalOfUsedTable(1, selectData);
        assertEquals(2, usedTable);
    }

    @Test
    public void testCheckTotalOfUsedTable_ShouldEqual16WhenCallCheckTotalOfUsedTableWithInputLastIndexAndSelectedDataAfterCallSelectDataWithDateWithInput20200403AndSortWithStartTime() {
        String date = "2020-04-03";
        Data[] selectData = booking.selectDataWithDate(date, bookingList);
        selectData = booking.sortWithStartTime(selectData);
        int usedTable = booking.checkTotalOfUsedTable(selectData.length-1, selectData);
        assertEquals(20, usedTable);
    }

    @Test
    public void testCheckMostTableInGroup_ShouldEqual1WhenCallCheckMostTableInGroupWithInputMostTable0AndSelectedDataIndex1AfterCallSelectDataWithDateWithInput20200401AndSortWithStartTime() {
        String date = "2020-04-01";
        Data[] selectData = booking.selectDataWithDate(date, bookingList);
        selectData = booking.sortWithStartTime(selectData);
        int mostTable = booking.checkMostTableInGroup(0, selectData[0]);
        assertEquals(1, mostTable);
    }

    @Test
    public void testCheckMostTableInGroup_ShouldEqual5WhenCallCheckMostTableInGroupWithInputMostTable5AndSelectedDataIndex1AfterCallSelectDataWithDateWithInput20200401AndSortWithStartTime() {
        String date = "2020-04-01";
        Data[] selectData = booking.selectDataWithDate(date, bookingList);
        selectData = booking.sortWithStartTime(selectData);
        int mostTable = booking.checkMostTableInGroup(5, selectData[0]);
        assertEquals(5, mostTable);
    }

    @Test
    public void testCalculateTable_ShouldEqual1WhenCallCalculateTableWithInput1() {
        int totalTable = booking.calculateTable(1);
        assertEquals(1, totalTable);
    }

    @Test
    public void testCalculateTable_ShouldEqual1WhenCallCalculateTableWithInput3() {
        int totalTable = booking.calculateTable(3);
        assertEquals(1, totalTable);
    }

    @Test
    public void testCalculateTable_ShouldEqual2WhenCallCalculateTableWithInput6() {
        int totalTable = booking.calculateTable(6);
        assertEquals(2, totalTable);
    }

    @Test
    public void testCalculateTable_ShouldEqual5WhenCallCalculateTableWithInput20() {
        int totalTable = booking.calculateTable(20);
        assertEquals(5, totalTable);
    }

    @Test
    public void testCalculateTable_ShouldEqual10WhenCallCalculateTableWithInput40() {
        int totalTable = booking.calculateTable(40);
        assertEquals(10, totalTable);
    }

    @Test
    public void testIsNotTimeOut_ShouldEqualTrueWhenIsNotTimeOutWithInput2000And1900() {
        boolean isnotTimeOut = booking.isNotTimeOut("20.00", "19.00");
        assertEquals(true, isnotTimeOut);
    }

    @Test
    public void testIsNotTimeOut_ShouldEqualFalseWhenIsNotTimeOutWithInput1900And2000() {
        boolean isnotTimeOut = booking.isNotTimeOut("19.00", "20.00");
        assertEquals(false, isnotTimeOut);
    }
}
