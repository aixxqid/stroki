package array;

import array.FinanceReport.FinanceReport;
import array.Payment.Payment;

import java.util.Date;

import static array.FinanceReportProcessor.FinanceReportProcessor.nameBeginsWithLetter;
import static array.FinanceReportProcessor.FinanceReportProcessor.smallerPayments;


public class Payments {
    public static void main(String[] args) {
        Payment[] payments = {
                new Payment("Ыскаков Чынасыл Турарович", 19, 4, 2024, 40000),
                new Payment("Ипатий Коловратий Романович", 13, 9, 2023, 17000),
                new Payment("Хачик Мовсисян Гургенович", 27, 12, 2023, 10000),
                new Payment("Кудаспаев Ихшат Мукмамбетович", 5, 11, 2024, 20000)
        };

        Date reportDate = new Date();
        FinanceReport report = new FinanceReport(payments, "Кондратьев Иван Кириллович", reportDate);

        System.out.println("Количество платежей: " + report.getAmountOfPayments());

        FinanceReport nameBeginsWithLetter = nameBeginsWithLetter(report, payments, 'Ы');
        System.out.println("\nПервая буква Фамилии 'Ы':\n" + nameBeginsWithLetter);

        FinanceReport smallerPayments = smallerPayments(report, payments, 100);
        System.out.println("\nПлатежи, у которых сумма меньше 100:\n" + smallerPayments);
    }


    }


