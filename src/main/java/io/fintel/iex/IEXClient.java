package io.fintel.iex;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.fintel.iex.model.StockChartItem;
import io.fintel.iex.model.Symbol;

public class IEXClient {

    private static final String ROOT_URL = "https://api.iextrading.com/1.0";

    private final Gson gson = new Gson();

    HttpClientUtil httpClientUtil = new HttpClientUtil();

    /**
     * This gets a list of securities from IEX
     * @return
     */
    public List<Symbol> getSymbols() {

        JsonElement json = httpClientUtil.getJson(ROOT_URL + "/ref-data/symbols");

        Type listType = new TypeToken<ArrayList<Symbol>>(){}.getType();
        return gson.fromJson(json, listType);
    }

    /**
     * This gets a chart
     * @return
     */
    public List<StockChartItem> getStockChart(String symbol) {

        JsonElement json = httpClientUtil.getJson(ROOT_URL + "/stock/" + symbol.toLowerCase() + "/chart");

        Type listType = new TypeToken<ArrayList<StockChartItem>>(){}.getType();
        return gson.fromJson(json, listType);
    }

}
