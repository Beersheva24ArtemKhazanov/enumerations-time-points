package telran.time;

public enum TimeUnit {
    SECOND(1), MINUTE(60), HOUR(3600);
    private int valueOfSeconds;
    TimeUnit(int valueOfSeconds) {
        this.valueOfSeconds = valueOfSeconds;
    }

    public int getValueOfSeconds() {
        return valueOfSeconds;
    }

    public float between(TimePoint p1, TimePoint p2) {
        float amountBetween = -1;

        switch (this) {
            case SECOND -> {
                amountBetween = p1.convert(TimeUnit.SECOND).getAmount() - p2.convert(TimeUnit.SECOND).getAmount();
            }
            case MINUTE -> {
                amountBetween = p1.convert(TimeUnit.MINUTE).getAmount() - p2.convert(TimeUnit.MINUTE).getAmount();
            }
            case HOUR -> {
                amountBetween = p1.convert(TimeUnit.HOUR).getAmount() - p2.convert(TimeUnit.HOUR).getAmount();
            }
        }
        return amountBetween;
    }
}
