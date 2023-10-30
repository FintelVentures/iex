package io.fintel.iex;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import io.fintel.iex.model.ShortInterestItem;
import io.fintel.iex.model.StockChartItem;
import io.fintel.iex.model.Symbol;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class IEXClient {

    private static final String ROOT_URL = "https://api.iextrading.com/1.0";
    private static final String ROOT_URL_BETA = "https://cloud.iexapis.com/beta";
    private static final String ROOT_URL_V1 = "https://cloud.iexapis.com/v1";
    private static final String ROOT_URL_STABLE = "https://cloud.iexapis.com/stable";

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

    protected JsonElement getAuthJson(String url)  {
        return httpClientUtil.getJson(url
                + (this.secret != null ? "?token=" + this.secret : ""));
    }

    protected String getAuthContent(String url) {
        return httpClientUtil.getContent(url
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
        String encodedSymbol = symbol.toLowerCase();
        try {
            encodedSymbol = URLEncoder.encode(symbol.toLowerCase(), StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String url = ROOT_URL + "/stock/" + encodedSymbol + "/chart";
        JsonElement json = httpClientUtil.getJson(url);

        Type listType = new TypeToken<ArrayList<StockChartItem>>() {
        }.getType();
        return gson.fromJson(json, listType);
    }

    public List<ShortInterestItem> getShortInterest(String symbol) {

        String encodedSymbol = symbol.toLowerCase();
        try {
            encodedSymbol = URLEncoder.encode(symbol.toLowerCase(), StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String url = ROOT_URL + "/stock/market/short-interest/" + encodedSymbol;
        JsonElement json = httpClientUtil.getJson(url);

        Type listType = new TypeToken<ArrayList<ShortInterestItem>>() {
        }.getType();
        return gson.fromJson(json, listType);

    }

    public JsonElement getKeyStatsJson(String symbol) {
        String encodedSymbol = symbol.toLowerCase();
        try {
            encodedSymbol = URLEncoder.encode(symbol.toLowerCase(), StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String url = ROOT_URL_V1 + "/stock/" + encodedSymbol + "/stats";
        return this.getAuthJson(url);
    }

    public JsonElement getNews(String symbol) {
        String encodedSymbol = symbol.toLowerCase();
        try {
            encodedSymbol = URLEncoder.encode(symbol.toLowerCase(), StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String url = ROOT_URL_V1 + "/stock/" + encodedSymbol + "/news/last/50";
        return this.getAuthJson(url);
    }

    public String getEODSplitStock(String symbol, String range) {
        String encodedsymbol = symbol.toLowerCase();
        try {
            encodedsymbol = URLEncoder.encode(symbol.toLowerCase(), StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String url = ROOT_URL_STABLE + "/stock/" + encodedsymbol + "/splits/"+range;

        return this.getAuthJson(url).toString();
    }

    public String getExchange() {
        return this.getAuthJson(ROOT_URL_STABLE + "/ref-data/exchanges").toString();
    }

    public String getStockPrices(String symbol, String range) {
        String encodedSymbol = symbol.toLowerCase();
        try {
            encodedSymbol = URLEncoder.encode(symbol.toLowerCase(), StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String url = ROOT_URL_STABLE + "/stock/" + encodedSymbol + "/chart/"+range;
        return this.getAuthJson(url).toString();
    }

    public String getRegionSymbol(String region) {
        String encodedSymbol = region.toLowerCase();
        try {
            encodedSymbol = URLEncoder.encode(region.toLowerCase(), StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String url = ROOT_URL_STABLE + "/ref-data/region/" + encodedSymbol + "/symbols";

        return this.getAuthJson(url).toString();
    }

    public JsonObject getDataPoint(String symbol, String key) {

        String content = null;
        try {
            String encodedSymbol = symbol.toLowerCase();
            try{
                encodedSymbol = URLEncoder.encode(symbol.toLowerCase(), StandardCharsets.UTF_8.name());
            } catch (UnsupportedEncodingException e){
                throw new RuntimeException(e);
            }

            String url = ROOT_URL_STABLE + "/data-points/" + encodedSymbol + "/" + key;

            content = this.getAuthContent(url);
        } catch (Exception e) {
            if ( e.getMessage().contains("404")) {
                return null;
            }
            throw e;
        }

        /*
         * try to return a numeric primitive if possible
         */
        try {
            double d = Double.parseDouble(content);

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(key, d);
            return jsonObject;

        } catch (Exception e) {

        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(key, content);
        return jsonObject;
    }

    public String getDividendBasic(String symbol, String range) {
        String encodedSymbol = symbol.toLowerCase();
        try {
            encodedSymbol = URLEncoder.encode(symbol.toLowerCase(), StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String url = ROOT_URL_STABLE + "/stock/"+encodedSymbol+"/dividends/"+range;

        return this.getAuthJson(url).toString();
    }

    public String getCompanyDetails(String symbol) {
        String encodedSymbol = symbol.toLowerCase();
        try {
            encodedSymbol = URLEncoder.encode(symbol.toLowerCase(), StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String url = ROOT_URL_STABLE + "/stock/"+encodedSymbol+"/company";
        return this.getAuthJson(url).toString();
    }
}
