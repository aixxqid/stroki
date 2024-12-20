package array.Payment;

import java.util.Objects;

public class Payment {
    private String FIO;
    private int day;
    private int month;
    private int year;
    private int sum;

    public Payment(String FIO, int data, int month, int year, int sum) {
        this.FIO = FIO;
        this.day = data;
        this.month = month;
        this.year = year;
        this.sum = sum;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return day == payment.day && month == payment.month && year == payment.year && sum == payment.sum && Objects.equals(FIO, payment.FIO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FIO, day, month, year, sum);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "FIO='" + FIO + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", sum=" + sum +
                '}';
    }
}
