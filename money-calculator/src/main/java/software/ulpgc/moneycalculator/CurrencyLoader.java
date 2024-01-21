package software.ulpgc.moneycalculator;

import software.ulpgc.moneycalculator.Model.Currency;

import java.util.List;

public interface CurrencyLoader {
    List<Currency> load();
}
