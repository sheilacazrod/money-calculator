package software.ulpgc.moneycalculator.Model;

import software.ulpgc.moneycalculator.Model.Currency;

public record Money(long amount, Currency currency) {
    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
