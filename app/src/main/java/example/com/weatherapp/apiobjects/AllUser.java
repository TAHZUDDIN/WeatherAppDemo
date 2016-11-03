package example.com.weatherapp.apiobjects;

import android.content.Context;

import com.android.volley.Request;

import example.com.weatherapp.extras.Constants;
import example.com.weatherapp.vollyserverapis.AppRequestListener;
import example.com.weatherapp.vollyserverapis.GetWeatherDetails;


public class AllUser extends BaseObject implements Constants {

    private static AllUser sInstance;

    @Override
    public void clear(Context context) {

    }

    public static AllUser getInstance() {
        if (sInstance == null)
            sInstance = new AllUser();
        return sInstance;
    }



    public void getWeatherBangaluruGET(String url, AppRequestListener appRequestListener, Context context)
    {
        AppNetworkError appNetworkError = new AppNetworkError();
        GetWeatherDetails request = new GetWeatherDetails(Request.Method.GET, url, appNetworkError, Constants.ID_GET_WEATHER_BANGALURU, appRequestListener);
        sendRequest(context, appNetworkError, request, appRequestListener);
    }

    public void getWeatherKolkataGET(String url, AppRequestListener appRequestListener, Context context)
    {
        AppNetworkError appNetworkError = new AppNetworkError();
        GetWeatherDetails request = new GetWeatherDetails(Request.Method.GET, url, appNetworkError, Constants.ID_GET_WEATHER_KOLKATA, appRequestListener);
        sendRequest(context, appNetworkError, request, appRequestListener);
    }


    public void getWeatherMumbaiGET(String url, AppRequestListener appRequestListener, Context context)
    {
        AppNetworkError appNetworkError = new AppNetworkError();
        GetWeatherDetails request = new GetWeatherDetails(Request.Method.GET, url, appNetworkError, Constants.ID_GET_WEATHER_MUMBAI, appRequestListener);
        sendRequest(context, appNetworkError, request, appRequestListener);
    }



}
