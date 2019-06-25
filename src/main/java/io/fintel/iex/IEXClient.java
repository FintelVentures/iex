package io.fintel.iex;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.fintel.iex.model.ShortInterestItem;
import io.fintel.iex.model.StockChartItem;
import io.fintel.iex.model.Symbol;

public class IEXClient {

    private static final String ROOT_URL = "https://api.iextrading.com/1.0";
    private static final String ROOT_URL_BETA = "https://cloud.iexapis.com/beta";
    private static final String ROOT_URL_V1 = "https://cloud.iexapis.com/v1";

    private static final String ROOT_URL_SANDBOX = "https://sandbox.iexapis.com/v1";

    private final Gson gson = new Gson();

    private final HttpClientUtil httpClientUtil = new HttpClientUtil();

    private final String secret;

    public IEXClient() {
        this.secret = null;
    }

    public IEXClient(String secret) {
        this.secret = secret;
    }

    protected JsonElement getAuthJson(String url) {
        return httpClientUtil.getJson(url
                + (this.secret != null ? "?token=" + this.secret : ""));

    }

    /**
     * This gets a list of securities from IEX
     *
     * @return
     */
    public List<Symbol> getSymbols() {

        JsonElement json = getAuthJson(ROOT_URL_V1 + "/ref-data/symbols");
        Type listType = new TypeToken<ArrayList<Symbol>>() {}.getType();
        return gson.fromJson(json, listType);
    }


    /**
     * This gets a chart
     *
     * @return
     */
    public List<StockChartItem> getStockChart(String symbol) {

        JsonElement json = httpClientUtil.getJson(ROOT_URL + "/stock/" + symbol.toLowerCase() + "/chart");

        Type listType = new TypeToken<ArrayList<StockChartItem>>() {
        }.getType();
        return gson.fromJson(json, listType);
    }

    public List<ShortInterestItem> getShortInterest(String symbol) {

        JsonElement json = httpClientUtil.getJson(ROOT_URL + "/stock/market/short-interest/" + symbol.toLowerCase());

        Type listType = new TypeToken<ArrayList<ShortInterestItem>>() {
        }.getType();
        return gson.fromJson(json, listType);

    }

    public JsonElement getKeyStatsJson(String symbol) {
        return this.getAuthJson(ROOT_URL + "/stock/" + symbol.toLowerCase() + "/stats");
    }

}
