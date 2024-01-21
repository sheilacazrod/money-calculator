package software.ulpgc.moneycalculator;

import software.ulpgc.moneycalculator.Model.Currency;

import java.util.List;

public interface CurrencyDialog {
    CurrencyDialog define(List<Currency> currencies);
    Currency get();
}
