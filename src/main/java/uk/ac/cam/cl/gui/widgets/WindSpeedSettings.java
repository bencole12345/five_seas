package uk.ac.cam.cl.gui.widgets;

import javafx.scene.control.*;
import uk.ac.cam.cl.data.AppSettings;
import uk.ac.cam.cl.data.Unit;

import java.util.ArrayList;
import java.util.List;

public class WindSpeedSettings extends Settings {
    private AppSettings settings = AppSettings.getInstance();



    public WindSpeedSettings() {
        SETTING_NAME = WindSpeedGraph.WIND_SPEED_GRAPH_UNIT_SETTINGS;

        setTitle("Wind Speed Settings");

        ToggleGroup group = new ToggleGroup();
        RadioButton kph = new RadioButton();
        kph.getStyleClass().add("radio-btn");
        kph.setText("KM/H");
        kph.setToggleGroup(group);
        kph.setOnAction((action) -> {
            setUnit(Unit.KILOMETERS_PER_HOUR);
        });

        RadioButton mph = new RadioButton();
        mph.getStyleClass().add("radio-btn");
        mph.setText("MPH");
        mph.setToggleGroup(group);
        mph.setOnAction((action) -> {
            setUnit(Unit.MILES_PER_HOUR);
        });

        Unit curr = getUnit();
        if (curr == Unit.KILOMETERS_PER_HOUR) {
            kph.setSelected(true);
        } else {
            mph.setSelected(true);
        }

        this.add(kph, 0, 1);
        this.add(mph, 0, 2);
    }

    @Override
    public Unit getUnit() {
        return Unit.fromString(settings.getOrDefault(SETTING_NAME, Unit.KILOMETERS_PER_HOUR.toString()));
    }
}
