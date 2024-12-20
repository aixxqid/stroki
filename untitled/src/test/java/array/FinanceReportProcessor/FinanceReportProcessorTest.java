package array.FinanceReportProcessor;
import array.Payment.Payment;
import array.FinanceReport.FinanceReport;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.*;

public class FinanceReportProcessorTest {

    @Test
    public void fullNameBeginsWithMaxLetter() {
        Payment[] payments = {
                new Payment("Ыскаков Чынасыл Турарович", 19, 4, 2024, 40000),
                new Payment("Ипатий Коловратий Романович", 13, 9, 2023, 17000),
                new Payment("Хачик Мовсисян Гургенович", 27, 12, 2023, 10000),
                new Payment("Кудаспаев Ихшат Мукмамбетович", 5, 11, 2024, 20000)
        };
        Payment[] payment = {
                new Payment("Ипатий Коловратий Романович", 13, 9, 2023, 17000)
        };
        FinanceReport fr = new FinanceReport(payment, "Кондратьев Иван Кириллович", new Date());
        FinanceReport fr1 = new FinanceReport(payments, "Кондратьев Иван Кириллович", new Date());
        assertEquals(fr, FinanceReportProcessor.nameBeginsWithLetter(fr1, payments, 'И'));
    }

    @Test
    public void fullNameBeginsWithMinLetter() {
        Payment[] payments = {
                new Payment("Ыскаков Чынасыл Турарович", 19, 4, 2024, 40000),
                new Payment("Ипатий Коловратий Романович", 13, 9, 2023, 17000),
                new Payment("Хачик Мовсисян Гургенович", 27, 12, 2023, 10000),
                new Payment("Кудаспаев Ихшат Мукмамбетович", 5, 11, 2024, 20000)
        };
        Payment[] payment = {
                new Payment("Ипатий Коловратий Романович", 13, 9, 2023, 17000)
        };
        FinanceReport fr = new FinanceReport(payment, "Кондратьев Иван Кириллович", new Date());
        FinanceReport fr1 = new FinanceReport(payments, "Кондратьев Иван Кириллович", new Date());
        assertEquals(fr, FinanceReportProcessor.nameBeginsWithLetter(fr1, payments, 'и'));
    }

    @Test
    public void fullNameBeginsWithLetterException() {
        Payment[] payments = {
                new Payment("Ыскаков Чынасыл Турарович", 19, 4, 2024, 40000),
                new Payment("Ипатий Коловратий Романович", 13, 9, 2023, 17000),
                new Payment("Хачик Мовсисян Гургенович", 27, 12, 2023, 10000),
                new Payment("Кудаспаев Ихшат Мукмамбетович", 5, 11, 2024, 20000)
        };
        Payment[] payment = {
        };
        FinanceReport fr = new FinanceReport(payment, "Кондратьев Иван Кириллович", new Date());
        FinanceReport fr1 = new FinanceReport(payments, "Кондратьев Иван Кириллович", new Date());
        assertEquals(fr, FinanceReportProcessor.nameBeginsWithLetter(fr1, payments, ' '));
    }

    @Test
    public void smallerPayments() {
        Payment[] payments = {
                new Payment("Ыскаков Чынасыл Турарович", 19, 4, 2024, 40000),
                new Payment("Ипатий Коловратий Романович", 13, 9, 2023, 17000),
                new Payment("Хачик Мовсисян Гургенович", 27, 12, 2023, 10000),
                new Payment("Кудаспаев Ихшат Мукмамбетович", 5, 11, 2024, 20000)
        };

        Date date = new Date();
        FinanceReport fr1 = new FinanceReport(payments, "Кондратьев Иван Кириллович", date);
        Payment[] expectedPayments = {
                new Payment("Ипатий Коловратий Романович", 13, 9, 2023, 17000),
                new Payment("Хачик Мовсисян Гургенович", 27, 12, 2023, 10000),
                new Payment("Кудаспаев Ихшат Мукмамбетович", 5, 11, 2024, 20000)
        };
        FinanceReport expected = new FinanceReport(expectedPayments, "Кондратьев Иван Кириллович", date);
        FinanceReport filtered = FinanceReportProcessor.smallerPayments(fr1, payments, 25000);

        assertEquals(expected, filtered);

    }

    @Test
    public void smallerPaymentsException() {
        Payment[] payments = {
                new Payment("Ыскаков Чынасыл Турарович", 19, 4, 2024, 40000),
                new Payment("Ипатий Коловратий Романович", 13, 9, 2023, 17000),
                new Payment("Хачик Мовсисян Гургенович", 27, 12, 2023, 10000),
                new Payment("Кудаспаев Ихшат Мукмамбетович", 5, 11, 2024, 20000)
        };

        Date date = new Date();
        FinanceReport fr1 = new FinanceReport(payments, "Кондратьев Иван Кириллович", date);
        assertThrows(IllegalArgumentException.class, () -> {
            FinanceReportProcessor.smallerPayments(fr1, payments, -100);
        });
    }
}
