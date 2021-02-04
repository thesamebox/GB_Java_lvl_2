package Lesson_1;

public enum DayOfWeek {
    MONDAY(40, true),
    TUESDAY(32, true),
    WEDNESDAY(24, true),
    THURSDAY(16, true),
    FRIDAY(8, true),
    SATURDAY(0, true),
    SUNDAY(0, true);

    private int hours;
    private boolean isWorkDay;

    DayOfWeek(int hours, boolean isWorkDay) {
        this.hours = hours;
        this.isWorkDay = isWorkDay;
    }

    public int getHours() {
        return hours;
    }

    public boolean isWorkDay() {
        return isWorkDay;
    }
}
