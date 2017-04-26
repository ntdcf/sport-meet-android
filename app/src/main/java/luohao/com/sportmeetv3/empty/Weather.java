package luohao.com.sportmeetv3.empty;

/**
 * Created by luohao3 on 2017/4/26.
 */

public class Weather {
    private String weather;
    private String tempche;
    private String direct;
    private String power;
    private String image;

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTempche() {
        return tempche;
    }

    public void setTempche(String tempche) {
        this.tempche = tempche;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "weather='" + weather + '\'' +
                ", tempche='" + tempche + '\'' +
                ", direct='" + direct + '\'' +
                ", power='" + power + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
