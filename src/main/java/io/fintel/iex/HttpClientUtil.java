package io.fintel.iex;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;


/**
 * Created by wilton on 9/9/16.
 */
public class HttpClientUtil {

    private final Gson gson = new Gson();

    public JsonElement getJson(final String url) {

        return getJson(url, null);
    }


    public JsonElement getJson(final String url, final List<NameValuePair> params) {

        /*
         * if there are params, add a query string to the url
         */
        String urlWithParams = params != null && params.size() > 0 ?
                url + '?' + URLEncodedUtils.format(params, "UTF-8") :
                url;


        /*
         * Place open of httpClient in try/catch resource block so it is automatically closed
         */
        try (CloseableHttpClient httpClient = HttpClients.createMinimal()) {

            /*
             * prepare the get request
             */
            HttpGet request = new HttpGet(urlWithParams);
            request.addHeader("accept", "application/json");

            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Status: " + response.getStatusLine().getStatusCode() + " calling " +
                        urlWithParams + " with msg: " + response.getEntity().getContent().toString());
            }

            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);

            request.releaseConnection(); // release http connection

            return gson.fromJson(content, JsonElement.class);

        } catch (IOException ioe) {

            ioe.printStackTrace();
            throw new RuntimeException(ioe);

        } finally {

            /*
             * Explicit closing of httpClient is not necessary since it's
             * enclosed in the try/catch/resource block
             */
        }
    }

    public JsonObject postJson(final String url, final JsonObject json) {

        /*
         * Place open of httpClient in try/catch resource block so it is automatically closed
         */
        try (CloseableHttpClient httpClient = HttpClients.createMinimal()) {

            /*
             * prepare the get request
             */
            HttpPost request = new HttpPost(url);
            request.addHeader("accept", "application/json");
            request.setEntity(new StringEntity(json.toString()));

            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Status: " + response.getStatusLine().getStatusCode() + " calling " +
                        url + " with msg: " + response.getEntity().getContent().toString());
            }

            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);

            request.releaseConnection(); // release http connection

            return gson.fromJson(content, JsonObject.class);

        } catch (IOException ioe) {

            ioe.printStackTrace();
            throw new RuntimeException(ioe);

        } finally {

            /*
             * Explicit closing of httpClient is not necessary since it's
             * enclosed in the try/catch/resource block
             */
        }
    }
}
