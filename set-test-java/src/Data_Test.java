import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Data_Test {

    @Test
    public void testGetName_ShouldEqualJohnWhenCallGetName() {
        Data data = new Data("John", "0987654321", "2020-04-01", "20.00", "21.00", 4);
        assertEquals("John",data.getName());
    }

    @Test
    public void testGetTel_ShouldEqual0987654321WhenCallGetTel() {
        Data data = new Data("John", "0987654321", "2020-04-01", "20.00", "21.00", 4);
        assertEquals("0987654321",data.getTel());
    }

    @Test
    public void testGetBookingDate_ShouldEqual20200401WhenCallGetBookingDate() {
        Data data = new Data("John", "0987654321", "2020-04-01", "20.00", "21.00", 4);
        assertEquals("2020-04-01",data.getBookingDate());
    }

    @Test
    public void testGetStartTime_ShouldEqual2000WhenCallGetStartTime() {
        Data data = new Data("John", "0987654321", "2020-04-01", "20.00", "21.00", 4);
        assertEquals("20.00",data.getStartTime());
    }

    @Test
    public void testGetEndTime_ShouldEqual2100WhenCallGetEndTime() {
        Data data = new Data("John", "0987654321", "2020-04-01", "20.00", "21.00", 4);
        assertEquals("21.00",data.getEndTime());
    }

    @Test
    public void testGetTotal_ShouldEqual4WhenCallGetTotal() {
        Data data = new Data("John", "0987654321", "2020-04-01", "20.00", "21.00", 4);
        assertEquals(4,data.getTotal());
    }

    @Test
    public void testGetTotal_ShouldEqual0WhenCallGetTotal() {
        Data data = new Data();
        assertEquals(0,data.getTotal());
    }
}