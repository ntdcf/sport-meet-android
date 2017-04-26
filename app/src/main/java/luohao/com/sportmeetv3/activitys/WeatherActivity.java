package luohao.com.sportmeetv3.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import luohao.com.sportmeetv3.R;
import luohao.com.sportmeetv3.empty.Weather;
import luohao.com.sportmeetv3.service.LinkService;

public class WeatherActivity extends AppCompatActivity {

    private TextView weather;
    private TextView tempche;
    private TextView wind;
    private ImageView weatherpic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        weather = (TextView) findViewById(R.id.weather_weather_show);
        tempche = (TextView) findViewById(R.id.weather_tempche_show);
        wind = (TextView) findViewById(R.id.weather_wind_show);

        String weatherJson = "";
        try {
            weatherJson = LinkService.link("","POST",LinkService.ADDRESS_API+"weather");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Weather showWeather = new Gson().fromJson(weatherJson, Weather.class);
        System.out.println(weatherJson);
        weather.setText(showWeather.getWeather());
        tempche.setText(showWeather.getTempche());
        wind.setText(showWeather.getDirect()+" "+showWeather.getPower());
    }
}
