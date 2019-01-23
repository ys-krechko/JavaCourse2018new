package homework.task06_22;

public class Time {
    private int second;
    private int minute;
    private int hour;

    public Time(int hour, int minute, int second) { // конструктор с 3 параметрами (внутри него сразу перевожу излишние секунды в минуты, а минуты в часы)
        minute += second / 60;
        this.hour = hour + minute / 60;
        this.minute = minute % 60;
        this.second = second % 60;
    }

    public Time(int second) { // конструктор с 1 параметром (внутри него сразу перевожу секунды в минуты и часы)
        this.hour = second / 3600;
        second %= 3600;
        this.minute = second / 60;
        this.second = second % 60;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int toSeconds() {
        return (hour * 3600) + (minute * 60) + second;
    }

    /*public int compareTo(Time time) {
        int hourCompare = Integer.compare(hour, time.hour);
        if (hourCompare != 0) {
            return hourCompare;
        }
        int minuteCompare = Integer.compare(minute, time.minute);
        if (minuteCompare != 0) {
            return minuteCompare;
        }
        return Integer.compare(second, time.second);
    }*/

    public int compareTo(Time o) {
        if (this.toSeconds() < o.toSeconds()) {
            return -1;
        } else if (this.toSeconds() > o.toSeconds()) {
            return 1;
        } else
            return 0;
    }

    public String compareToText(int compareTo) {
        if (compareTo == 0) {
            return "равны";
        } else {
            return "не равны";
        }
    }

    public String displayData() {
        return String.format("%dh%dm%ds", hour, minute, second);
    }
}
