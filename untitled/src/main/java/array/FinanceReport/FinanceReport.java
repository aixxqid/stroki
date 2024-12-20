package array.FinanceReport;

import array.Payment.Payment;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class FinanceReport {
    private Payment [] payments;
    private String authorName;
    private Date reportDate;

    public FinanceReport(Payment[] payments, String authorName, Date reportDate) {
        this.payments = Arrays.copyOf(payments, payments.length);
        this.authorName = authorName;
        this.reportDate = reportDate;
    }

    public FinanceReport(FinanceReport other) {
        this(Arrays.copyOf ( other.payments, other.payments.length), other.authorName, other.reportDate);
        this.payments = other.getPayments();
    }

    public Payment[] getPayments() {
        return Arrays.copyOf(payments, payments.length);
    }

    public void setPayments(Payment[] payments) {
        this.payments = payments;
    }

    public int getAmountOfPayments () {
        return payments.length;
    }

    public Payment getIndexOfPayments(int i) {
        if (i < 0 || i >= payments.length) {
            throw new IndexOutOfBoundsException("Индекс платежа вне допустимого диапазона");
        } else {
            return payments[i];
        }
    }

    public void setIndexOfPayments(int i, Payment payment) {
        if (i < 0 || i >= payments.length) {
            throw new IndexOutOfBoundsException("Индекс платежа вне допустимого диапазона");
        }
        if (payment == null) {
            throw new NullPointerException("Платеж не может быть пустым");
        } else {
           payments [i] = payment;
        }
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[Автор: %s, дата: %s , Платежи: [", getAuthorName(), sdf.format(reportDate)));
        for (Payment p : payments) {
            sb.append(String.format("Плательщик: %s, дата: %d.%d.%d сумма: %d руб. %d коп.\n", p.getFIO(), p.getDay(), p.getMonth(), p.getYear(), p.getSum() / 100, p.getSum()));
        }
        sb.append("]]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinanceReport that = (FinanceReport) o;
        return Objects.deepEquals(payments, that.payments) && Objects.equals(authorName, that.authorName) && Objects.equals(reportDate, that.reportDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(payments), authorName, reportDate);
    }
}
