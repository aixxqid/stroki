package array.FinanceReport;

import array.Payment.Payment;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class FinanceReportTest {

    @Test
    public void getIndexOfPayments() {
        Payment [] payments = {
                new Payment("Ыскаков Чынасыл Турарович", 19, 4, 2024, 40000),
                new Payment("Ипатий Коловратий Романович", 13, 9, 2023, 17000),
                new Payment("Хачик Мовсисян Гургенович", 27, 12, 2023, 10000),
                new Payment("Кудаспаев Ихшат Мукмамбетович", 5, 11, 2024, 20000)
        };
        FinanceReport fr = new FinanceReport(payments, "Test Author", new Date());
        Payment payment = new Payment("Ипатий Коловратий Романович", 13, 9, 2023, 17000);
        assertEquals(payment, fr.getIndexOfPayments(2));
    }


    @Test
    public void getIndexOfPaymentException() {
        Payment [] payments = {
                new Payment("Ыскаков Чынасыл Турарович", 19, 4, 2024, 40000),
                new Payment("Ипатий Коловратий Романович", 13, 9, 2023, 17000),
                new Payment("Хачик Мовсисян Гургенович", 27, 12, 2023, 10000),
                new Payment("Кудаспаев Ихшат Мукмамбетович", 5, 11, 2024, 20000)
        };
        FinanceReport fr = new FinanceReport(payments, "Test Author", new Date());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            fr.getIndexOfPayments(-2);
        });
    }

    @Test
    public void getIndexOfPaymentExceptionMoreLenght() {
        Payment[] payments = {
                new Payment("Ыскаков Чынасыл Турарович", 19, 4, 2024, 40000),
                new Payment("Ипатий Коловратий Романович", 13, 9, 2023, 17000),
                new Payment("Хачик Мовсисян Гургенович", 27, 12, 2023, 10000),
                new Payment("Кудаспаев Ихшат Мукмамбетович", 5, 11, 2024, 20000)
        };
        FinanceReport fr = new FinanceReport(payments, "Ыскаков Чынасыл Турарович", new Date());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            fr.getIndexOfPayments(5);
        });
    }

    @Test
    public void setIndexOfPayments() {
        Payment[] payments = {new Payment("Ыскаков Чынасыл Турарович", 19, 4, 2024, 40000)};
        Payment newPayment = new Payment("Бекмомбетов Ык Жуждубаевич", 20, 3, 2024, 75000);
        FinanceReport fr = new FinanceReport(payments, "Test Author", new Date());
        fr.setIndexOfPayments(0, newPayment);
        assertEquals(newPayment, fr.getIndexOfPayments(0));
    }

    @Test
    public void setIndexOfPaymentsException() {
        Payment[] payments = {new Payment("Ыскаков Чынасыл Турарович", 19, 4, 2024, 40000)};
        Payment newPayment = new Payment("Бекмомбетов Ык Жуждубаевич", 20, 3, 2024, 75000);
        FinanceReport fr = new FinanceReport(payments, "Test Author", new Date());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            fr.setIndexOfPayments(-1, newPayment);
        });
    }


    @Test
    public void setIndexOfPaymentsExceptionMoreLenght() {
        Payment[] payments = {new Payment("Ыскаков Чынасыл Турарович", 19, 4, 2024, 40000)};
        Payment newPayment = new Payment("Бекмомбетов Ык Жуждубаевич", 20, 3, 2024, 75000);
        FinanceReport fr = new FinanceReport(payments, "Test Author", new Date());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            fr.setIndexOfPayments(3, newPayment);
        });
    }
}