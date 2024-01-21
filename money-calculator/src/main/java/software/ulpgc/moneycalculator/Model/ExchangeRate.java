package software.ulpgc.moneycalculator.Model;

import software.ulpgc.moneycalculator.Model.Currency;

import java.time.LocalDate;

public record ExchangeRate(Currency from, Currency to, LocalDate date, double rate) {
}
