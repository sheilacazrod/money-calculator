package software.ulpgc.moneycalculator;

import software.ulpgc.moneycalculator.Model.Currency;
import software.ulpgc.moneycalculator.Model.Money;

import java.util.List;

public interface MoneyDialog {
    MoneyDialog define(List<Currency> currencies);
    Money get();
}
