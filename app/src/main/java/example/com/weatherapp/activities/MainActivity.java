package example.com.weatherapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import example.com.weatherapp.R;
import example.com.weatherapp.apiobjects.AllUser;
import example.com.weatherapp.extras.Constants;
import example.com.weatherapp.pojos.WeatherClass;
import example.com.weatherapp.vollyserverapis.AppRequestListener;
import example.com.weatherapp.vollyserverapis.BaseTask;
import example.com.weatherapp.vollyserverapis.GetWeatherDetails;

public class MainActivity extends AppCompatActivity implements AppRequestListener, Constants {

    TextView CityBan,CityKol, CityMu;
    TextView TempBan,TempKol, TempMu;
    TextView WindSpeedBan,WindSpeedKol, WindSpeedMu;
    TextView HumidityBan,HumidityKol, HumidityMu;
    TextView PressureBan,PressureKol, PressureMu;
    TextView DateBan,DateKol, DateMu;

     WeatherClass weatherClassBangalore,weatherClassKolkata, weatherClassMumbai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        CityBan = (TextView)findViewById(R.id.id_textView_City_Ban);
        TempBan = (TextView)findViewById(R.id.id_textView_Temp_Ban);
        WindSpeedBan = (TextView)findViewById(R.id.id_textView_WindSpeed_Ban);
        HumidityBan = (TextView)findViewById(R.id.id_textView_Humid_Ban);
        PressureBan = (TextView)findViewById(R.id.id_textView_Pressure_Ban);
        DateBan = (TextView)findViewById(R.id.id_textView_Date_Ban);



        CityKol = (TextView)findViewById(R.id.id_textView_City_Kol);
        TempKol= (TextView)findViewById(R.id.id_textView_Temp_Kol);
        WindSpeedKol = (TextView)findViewById(R.id.id_textView_WindSpeed_Kol);
        HumidityKol = (TextView)findViewById(R.id.id_textView_Humid_Kol);
        PressureKol = (TextView)findViewById(R.id.id_textView_Pressure_Kol);
        DateKol = (TextView)findViewById(R.id.id_textView_Date_Kol);



        CityMu = (TextView)findViewById(R.id.id_textView_City_Mum);
        TempMu= (TextView)findViewById(R.id.id_textView_Temp_Mum);
        WindSpeedMu = (TextView)findViewById(R.id.id_textView_WindSpeed_Mum);
        HumidityMu = (TextView)findViewById(R.id.id_textView_Humid_Mum);
        PressureMu = (TextView)findViewById(R.id.id_textView_Pressure_Mum);
        DateMu = (TextView)findViewById(R.id.id_textView_Date_Mum);


        String url = "https://query.yahooapis.com/v1/public/yql?";
        String query = "select wind from weather.forecast where woeid=2460286";
        url = url + null + "&format=json";


        getWeatherBangaloreAPI();
        getWeatherKolkataAPI();
        getWeatherMumbaiAPI();





    }

    @Override
    public <T> void onRequestStarted(BaseTask<T> request)
    {

    }

    @Override
    public <T> void onRequestCompleted(BaseTask<T> request)
    {

        if (request.getRequestTag().equalsIgnoreCase(ID_GET_WEATHER_BANGALURU))
        {
            if (((GetWeatherDetails) request).getDataObject() != null)
            {
               Log.d("MAinActivity","REQUEST COMPLETED WEATHER_BANGALURU");
                weatherClassBangalore = ((GetWeatherDetails) request).getDataObject();
                inflateValuesInBangalore();



            }
        }

        if (request.getRequestTag().equalsIgnoreCase(ID_GET_WEATHER_KOLKATA))
        {
            if (((GetWeatherDetails) request).getDataObject() != null)
            {
                Log.d("MAinActivity","REQUEST COMPLETED WEATHER_KOLKATA");
                weatherClassKolkata = ((GetWeatherDetails) request).getDataObject();

                inflateValuesInKolkata();
            }
        }


        if (request.getRequestTag().equalsIgnoreCase(ID_GET_WEATHER_MUMBAI))
        {
            if (((GetWeatherDetails) request).getDataObject() != null)
            {
                Log.d("MAinActivity","REQUEST COMPLETED WEATHER_MUMBAI");
                weatherClassMumbai = ((GetWeatherDetails) request).getDataObject();
                inflateValuesInMumbai();
            }
        }

    }

    @Override
    public <T> void onRequestFailed(BaseTask<T> request) {

    }



    public void getWeatherBangaloreAPI()
    {
        Log.d("getWeatherKolkataAPI","=======getWeatherBangaloreAPI");
        String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22Bangaluru%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        AllUser.getInstance().getWeatherBangaluruGET(url, this, MainActivity.this);
    }

    public void getWeatherKolkataAPI()
    {
        Log.d("getWeatherKolkataAPI","=======getWeatherKolkataAPI");
        String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22Kolkata%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        AllUser.getInstance().getWeatherKolkataGET(url, this, MainActivity.this);
    }


    public void getWeatherMumbaiAPI()
    {
        Log.d("getWeatherMumbaiAPI","=======getWeatherMumbaiAPI");
        String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22Mumbai%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        AllUser.getInstance().getWeatherMumbaiGET(url, this, MainActivity.this);
    }



    public void inflateValuesInBangalore()
    {
        CityBan.setText(weatherClassBangalore.getQuery().getResults().getChannel().getLocation().getCity());
        TempBan.setText(weatherClassBangalore.getQuery().getResults().getChannel().getItem().getCondition().getTemp());
        WindSpeedBan.setText(weatherClassBangalore.getQuery().getResults().getChannel().getWind().getSpeed());
        HumidityBan.setText(weatherClassBangalore.getQuery().getResults().getChannel().getAtmosphere().getHumidity());
        PressureBan.setText(weatherClassBangalore.getQuery().getResults().getChannel().getAtmosphere().getPressure());
        DateBan.setText(weatherClassBangalore.getQuery().getResults().getChannel().getItem().getCondition().getDate());


    }





    public void inflateValuesInKolkata()
    {
        CityKol.setText(weatherClassKolkata.getQuery().getResults().getChannel().getLocation().getCity());
        TempKol.setText(weatherClassKolkata.getQuery().getResults().getChannel().getItem().getCondition().getTemp());
        WindSpeedKol.setText(weatherClassKolkata.getQuery().getResults().getChannel().getWind().getSpeed());
        HumidityKol.setText(weatherClassKolkata.getQuery().getResults().getChannel().getAtmosphere().getHumidity());
        PressureKol.setText(weatherClassKolkata.getQuery().getResults().getChannel().getAtmosphere().getPressure());
        DateKol.setText(weatherClassKolkata.getQuery().getResults().getChannel().getItem().getCondition().getDate());


    }



    public void inflateValuesInMumbai()
    {
        CityMu.setText(weatherClassMumbai.getQuery().getResults().getChannel().getLocation().getCity());
        TempMu.setText(weatherClassMumbai.getQuery().getResults().getChannel().getItem().getCondition().getTemp());
        WindSpeedMu.setText(weatherClassMumbai.getQuery().getResults().getChannel().getWind().getSpeed());
        HumidityMu.setText(weatherClassMumbai.getQuery().getResults().getChannel().getAtmosphere().getHumidity());
        PressureMu.setText(weatherClassMumbai.getQuery().getResults().getChannel().getAtmosphere().getPressure());
        DateMu.setText(weatherClassMumbai.getQuery().getResults().getChannel().getItem().getCondition().getDate());


    }
}
