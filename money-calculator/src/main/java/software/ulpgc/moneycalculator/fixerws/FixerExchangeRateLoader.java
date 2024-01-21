package software.ulpgc.moneycalculator.fixerws;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import software.ulpgc.moneycalculator.Model.Currency;
import software.ulpgc.moneycalculator.Model.ExchangeRate;
import software.ulpgc.moneycalculator.ExchangeRateLoader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Map;

public class FixerExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public ExchangeRate load(Currency from, Currency to) {
        String currencyFrom = from.toString().split("-")[0];
        String currencyTo = to.toString().split("-")[0];
        try {
            return new ExchangeRate(from, to,  LocalDate.now(), getExchangeRate(loadJson(currencyTo, currencyFrom)));
        } catch (IOException e) {
            return new ExchangeRate(from, to, LocalDate.now(), 0);
        }
    }

    private double getExchangeRate(String json) {
        Map<String, JsonElement> info = new Gson().fromJson(json, JsonObject.class).get("info").getAsJsonObject().asMap();
        return info.get("rate").getAsDouble();
    }
    private String loadJson(String currencyTo, String currencyFrom) throws IOException {
        URL url = new URL("https://api.apilayer.com/exchangerates_data/convert?to="  + currencyTo + "&from=" + currencyFrom + "&amount=1");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("apiKey", FixerAPI.key);

        try (InputStream is = connection.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            StringBuilder response = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return response.toString();
        }
    }
}
