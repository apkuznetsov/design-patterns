package kuznetsov.observer.display;

import kuznetsov.observer.Observer;
import kuznetsov.observer.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private final Subject weatherData;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update() {
//        this.temperature = weatherData.getTemperature();
//        this.humidity = weatherData.getHumidity();
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }
}