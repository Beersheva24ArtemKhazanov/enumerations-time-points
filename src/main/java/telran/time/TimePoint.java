package telran.time;

public class TimePoint implements Comparable<TimePoint> {
    private float amount;
    private TimeUnit timeUnit;

    public TimePoint(float amount, TimeUnit timeUnit) {
        this.amount = amount;
        this.timeUnit = timeUnit;
    }

    @Override
    public int compareTo(TimePoint o) {
        return Float.compare(this.convert(TimeUnit.SECOND).getAmount(), o.convert(TimeUnit.SECOND).getAmount());
    }

    public float getAmount() {
        return amount;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TimePoint && amount - ((TimePoint)obj).amount == 0 && timeUnit == ((TimePoint)obj).timeUnit;
    }

    public TimePoint convert (TimeUnit timeUnit) {
        float newAmount = amount;
        switch (timeUnit) {
            case SECOND -> {
                switch (this.timeUnit) {
                    case SECOND ->  newAmount = amount;
                    case MINUTE -> newAmount = amount * 60;
                    case HOUR -> newAmount = amount * 3600;
                }
            }
            case MINUTE -> {
                switch (this.timeUnit) {
                    case SECOND ->  newAmount = amount / 60;
                    case MINUTE -> newAmount = amount;
                    case HOUR -> newAmount = amount * 60;
                }
            }
            case HOUR -> {
                switch (this.timeUnit) {
                    case SECOND ->  newAmount = amount/ 3600;
                    case MINUTE -> newAmount = amount / 60;
                    case HOUR -> newAmount = amount;
                }
            }
        }
        TimePoint newTimePoint = new TimePoint(newAmount, timeUnit);
        return newTimePoint;
    }

    public TimePoint with(TimePointAdjuster adjuster) {
        return adjuster.adjust(this);
    }

}
