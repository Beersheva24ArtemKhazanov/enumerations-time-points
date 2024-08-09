package telran.time;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TimePointTest {
    @Test
    public void convertTest() {
        //60 seconds to 1 minute
        TimePoint timePoint1 = new TimePoint(60, TimeUnit.SECOND);
        TimePoint convertedTimePoint1 = timePoint1.convert(TimeUnit.MINUTE);
        assertEquals(1, convertedTimePoint1.getAmount());
        assertEquals(TimeUnit.MINUTE, convertedTimePoint1.getTimeUnit());

        //60 minutes to 1 hour
        TimePoint timePoint2 = new TimePoint(60, TimeUnit.MINUTE);
        TimePoint convertedTimePoint2 = timePoint2.convert(TimeUnit.HOUR);
        assertEquals(1, convertedTimePoint2.getAmount());
        assertEquals(TimeUnit.HOUR, convertedTimePoint2.getTimeUnit());

        //90 seconds to 1.5 minute
        TimePoint timePoint3 = new TimePoint(90, TimeUnit.SECOND);
        TimePoint convertedTimePoint3 = timePoint3.convert(TimeUnit.MINUTE);
        assertEquals(1.5, convertedTimePoint3.getAmount());
        assertEquals(TimeUnit.MINUTE, convertedTimePoint3.getTimeUnit());
    }

    @Test
    public void equalsTest() {
        // are equals
        TimePoint p1 = new TimePoint(90, TimeUnit.SECOND);
        TimePoint p2 = new TimePoint(90, TimeUnit.SECOND);
        assertTrue(p1.equals(p2));

        // are not equals
        TimePoint p3 = new TimePoint(90, TimeUnit.SECOND);
        TimePoint p4 = new TimePoint(30, TimeUnit.HOUR);
        assertFalse(p3.equals(p4));
    }

    @Test
    public void compareToTest() {
        // 90 seconds > 30 seconds
        TimePoint p1 = new TimePoint(90, TimeUnit.SECOND);
        TimePoint p2 = new TimePoint(30, TimeUnit.SECOND);
        assertEquals(1, p1.compareTo(p2));

        // 30 minutes > 2 hours
        TimePoint p3 = new TimePoint(35, TimeUnit.MINUTE);
        TimePoint p4 = new TimePoint(2, TimeUnit.HOUR);
        assertEquals(-1, p3.compareTo(p4));
    }

    @Test
    public void futureProximityAdjusterTest() {
        TimePoint p1 = new TimePoint(90, TimeUnit.SECOND);
        TimePoint p2 = new TimePoint(30, TimeUnit.MINUTE);
        TimePoint p3 = new TimePoint(1, TimeUnit.HOUR);
        TimePoint p4 = new TimePoint(3, TimeUnit.HOUR);
        TimePoint[] timePoints = {p2,p1,p4,p3};

        FutureProximityAdjuster fpa = new FutureProximityAdjuster(timePoints);
        assertEquals(p4, fpa.adjust(new TimePoint(2, TimeUnit.HOUR)));
        assertEquals(p2, fpa.adjust(new TimePoint(20, TimeUnit.MINUTE)));
        assertEquals(p1, fpa.adjust(new TimePoint(30, TimeUnit.SECOND)));
        assertEquals(null, fpa.adjust(new TimePoint(5648, TimeUnit.MINUTE)));
    }
 }
