package io.fintel.iex;

import com.google.gson.JsonElement;
import io.fintel.iex.model.ShortInterestItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import io.fintel.iex.model.StockChartItem;
import io.fintel.iex.model.Symbol;

public class TestRefData {

    IEXClient client;

    @Before
    public void setup() {

        if ( client == null) {
            if (System.getenv("TOKEN") != null) {
                client = new IEXClient(System.getenv("TOKEN"));
                return;
            }
            client = new IEXClient();
        }
    }

    @Test
    public void testSymbols() {
        List<Symbol> symbols = client.getSymbols();
        Assert.assertNotNull(symbols);
        Assert.assertFalse("Symbol list is empty", symbols.isEmpty());
    }

    @Test
    public void testStockChart() {

        List<StockChartItem> chartList = client.getStockChart("AAPL");
        Assert.assertNotNull(chartList);
        Assert.assertFalse("Chart is empty", chartList.isEmpty());
    }

    @Test
    public void testShortInterest() {

        List<ShortInterestItem> list = client.getShortInterest("IBKR");
        Assert.assertNotNull(list);
    }

    @Test
    public void testKeyStatsJson() {

        JsonElement json = client.getKeyStatsJson("AAPL");
        Assert.assertNotNull(json);
        Assert.assertTrue("Key stats json is not an object", json.isJsonObject());
        Assert.assertNotNull(json.getAsJsonObject().get("companyName"));
    }

}
