package example.com.weatherapp.vollyserverapis;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import example.com.weatherapp.pojos.WeatherClass;
import example.com.weatherapp.utils.JSONUtils;


public class GetWeatherDetails extends BaseTask<JSONObject> {

    public String TAG = "GetWeatherDetails";

    public GetWeatherDetails(int method, String url, Response.ErrorListener listener, String requestTag, AppRequestListener requestListener) {
        super(method, url, listener, requestTag, requestListener);
        headers = new HashMap<String, String>();
    }

    @Override
    public void processData() {
        sendMessage();
    }


    WeatherClass weatherClass;


    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        statusCode = response.statusCode;
        String responseString = new String(response.data);
        Log.i(TAG, "response:" + responseString);
        weatherClass = new Gson().fromJson(responseString, WeatherClass.class);
        return Response.success(
                JSONUtils.getJSONObject(responseString),
                getCacheEntry());
    }


    public WeatherClass getDataObject() {
        return weatherClass;
    }


    @Override
    protected void deliverResponse(JSONObject response) {

        this.setResponse(response);
        RequestPoolManager.getInstance().executeRequest(this);

    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }
}