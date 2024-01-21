package software.ulpgc.moneycalculator;

import software.ulpgc.moneycalculator.Model.Currency;
import software.ulpgc.moneycalculator.Model.ExchangeRate;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to);
}
