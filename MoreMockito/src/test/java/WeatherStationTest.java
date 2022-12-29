import instruments.Anemometer;
import instruments.Barometer;
import instruments.Hygrometer;
import instruments.Thermometer;
import instruments.satellite.SatelliteUplink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class WeatherStationTest {

    // WeatherStation test object
    private WeatherStation testStation;

    // Classes needed for the testing
    Anemometer anemometer;
    Barometer barometer;
    Hygrometer hygrometer;
    Thermometer thermometer;
    SatelliteUplink uplinkSpy;

    @BeforeEach
    public void setup () {
        // Mock out weather station tools
        anemometer = Mockito.mock(Anemometer.class);
        barometer = Mockito.mock(Barometer.class);
        hygrometer = Mockito.mock(Hygrometer.class);
        thermometer = Mockito.mock(Thermometer.class);

        // Create instance of uplink and spy on it
        SatelliteUplink s = new SatelliteUplink();
        uplinkSpy = Mockito.spy(s);

        // Initialize testStation with everything
        testStation = new WeatherStation();
        testStation.setAnemometer(anemometer);
        testStation.setBarometer(barometer);
        testStation.setHygrometer(hygrometer);
        testStation.setThermometer(thermometer);
        testStation.setSatelliteUplink(uplinkSpy);
    }

    @Test
    @DisplayName("Anemometer Calibration Check")
    public void anemometerCalibrationCheck () {
        // Mockito when statements
        Mockito.when(anemometer.getWindSpeed()).thenReturn(10.0).thenReturn(12.0);
        Mockito.when(anemometer.getWindDirInDegrees()).thenReturn(10.0, 12.0);

        // Assertions
        Assertions.assertFalse(testStation.anemometerCalibrationCheck());
    }

    @Test
    @DisplayName("Storm Warning Check")
    public void stormWarningCheck () {
        // Mockito when statements
        Mockito.when(hygrometer.getCurrentHumidity()).thenReturn(40.0); //true
        Mockito.when(barometer.getAtmosphericPressure()).thenReturn(800.0); //false
        Mockito.when(thermometer.getCurrentTemperature()).thenReturn(75.0); //true

        Assertions.assertTrue(testStation.runStormWarningCheck());

        Mockito.when(hygrometer.getCurrentHumidity()).thenReturn(30.0);
        Mockito.when(barometer.getAtmosphericPressure()).thenReturn(1100.0); //false
        Mockito.when(thermometer.getCurrentTemperature()).thenReturn(75.0); //true

        Assertions.assertTrue(testStation.runStormWarningCheck());

        Mockito.verify(uplinkSpy, Mockito.times(1)).runStormCheckForArea(40.0, 800.0, 75.0);
        Mockito.verify(uplinkSpy, Mockito.times(1)).checkNearbyAreaStorms();


    }

    @Test
    @DisplayName("Tornado Warning Check")
    public void tornadoWarningCheck () {
        // Mockito when statements
        Mockito.when(hygrometer.getCurrentHumidity()).thenReturn(35.0);
        Mockito.when(anemometer.getWindSpeed()).thenReturn(15.0);
        Mockito.when(barometer.getAtmosphericPressure()).thenReturn(900.0);

        Assertions.assertTrue(testStation.runTornadoWarningCheck());

        Mockito.verify(uplinkSpy, Mockito.times(1)).runTornadoCheckForArea(35.0, 900.0, 15.0);
        Mockito.verify(uplinkSpy, Mockito.times(1)).checkNearbyAreaTornadoes();

        Mockito.when(hygrometer.getCurrentHumidity()).thenReturn(45.0);
        Mockito.when(anemometer.getWindSpeed()).thenReturn(20.0);
        Mockito.when(barometer.getAtmosphericPressure()).thenReturn(1200.0);

        Assertions.assertTrue(testStation.runTornadoWarningCheck());

    }

    @Test
    @DisplayName("Temperature Calibration Check")
    public void temperatureCalibrationCheck () {
        // Mockito when statements
        Mockito.when(thermometer.getCurrentTemperature()).thenReturn(12.0, 10.0);

        Assertions.assertFalse(testStation.temperatureCalibrationTest());

        Mockito.when(thermometer.getCurrentTemperature()).thenReturn(11.0, 10.0);

        Assertions.assertTrue(testStation.temperatureCalibrationTest());
    }

}
