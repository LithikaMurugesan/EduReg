public class Schedule {
    private String day;
    private String startTime;
    private String endTime;

    public Schedule(String day, String startTime, String endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getDay() { return day; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }

    public boolean conflictsWith(Schedule other) {

        if (!this.day.equalsIgnoreCase(other.day)) return false;


        return !(this.endTime.compareTo(other.startTime) <= 0 ||
                other.endTime.compareTo(this.startTime) <= 0);
    }
}
