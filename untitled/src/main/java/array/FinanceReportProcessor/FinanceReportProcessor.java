package array.FinanceReportProcessor;

import array.Payment.Payment;
import array.FinanceReport.FinanceReport;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.toLowerCase;

public class FinanceReportProcessor {
    public static FinanceReport nameBeginsWithLetter( FinanceReport fr, Payment[] payments, char letter) {
        List<Payment> payment = new ArrayList<>();
        for (Payment p : payments) {
            if (p.getFIO().trim().toLowerCase().charAt(0) == toLowerCase(letter)) {
                payment.add(p);
            }
        }
        return new FinanceReport(payment.toArray(new Payment[0]), fr.getAuthorName(), fr.getReportDate());
    }
    public static FinanceReport smallerPayments( FinanceReport fr, Payment[] payments, int value) {
        List<Payment> payment = new ArrayList<>();
        if (value<0) {
            throw new IllegalArgumentException("Сумма платежа меньше нуля");
        }
            for (Payment p : payments) {
                if (p.getSum() < value) {
                    payment.add(p);
                }
            }
        return new FinanceReport(payment.toArray(new Payment[0]), fr.getAuthorName(), fr.getReportDate());
    }

}
