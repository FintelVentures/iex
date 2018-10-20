package io.fintel.iex;

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

}
