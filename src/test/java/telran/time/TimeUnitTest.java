package telran.time;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TimeUnitTest {
    @Test
    public void betweenTest() {
        //amount between 37 minutes and 27 minutes in minutes
        TimePoint p1 = new TimePoint(37, TimeUnit.MINUTE);
        TimePoint p2 = new TimePoint(27, TimeUnit.MINUTE);
        assertEquals(10, TimeUnit.MINUTE.between(p1, p2));

        //amount between 2 hours and 27 minutes in seconds
        TimePoint p3 = new TimePoint(2, TimeUnit.HOUR);
        TimePoint p4 = new TimePoint(27, TimeUnit.MINUTE);
        assertEquals(5580, TimeUnit.SECOND.between(p3, p4));

        //amount between 15 seconds and 1 hour in minutes
        TimePoint p5 = new TimePoint(15, TimeUnit.SECOND);
        TimePoint p6 = new TimePoint(1, TimeUnit.HOUR);
        assertEquals(-59.75, TimeUnit.MINUTE.between(p5, p6));
    }

}
