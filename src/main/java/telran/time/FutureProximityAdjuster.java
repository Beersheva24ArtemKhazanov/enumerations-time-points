package telran.time;

import java.util.Arrays;

public class FutureProximityAdjuster implements TimePointAdjuster {
    TimePoint[] timePoints;
    public FutureProximityAdjuster(TimePoint[] timePoints) {
        TimePoint[] newTimePoints = Arrays.copyOf(timePoints, timePoints.length);
        Arrays.sort(newTimePoints);
        this.timePoints = newTimePoints;
    }
    @Override
    public TimePoint adjust(TimePoint timePoint) {
        int indexTimePoint =  Arrays.binarySearch(timePoints, timePoint);
        int posTimePoint = indexTimePoint < 0 ? -indexTimePoint - 1 : indexTimePoint++;
        return posTimePoint < timePoints.length ? timePoints[posTimePoint] : null;
    }
}
