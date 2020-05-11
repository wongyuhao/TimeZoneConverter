package org.hao;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.util.Duration;


public class PrimaryController implements Initializable {
    TimeController timeController = new TimeController();

    TimeClass homeTime;
    TimeClass targetTime;

    Timeline timeline;

    @FXML Label homeLabel = new Label();
    @FXML Label targetLabel = new Label();
    @FXML Label homeZoneLabel = new Label();
    @FXML Label targetZoneLabel = new Label();


    @FXML ComboBox<String> homeComboBox = new ComboBox<>();
    @FXML ComboBox<String> targetComboBox = new ComboBox<>();

    private void loadData(){
        //populate choice boxes
        homeComboBox.getItems().addAll(timeController.loadTZDB());
        targetComboBox.getItems().addAll(timeController.loadTZDB());
        //new AutoCompleteBox(homeComboBox);
        //new AutoCompleteBox(targetComboBox);
        homeTime = new TimeClass();
        targetTime = new TimeClass();

    }



    private void updateClock(){
        this.timeline = new Timeline(
            new KeyFrame(
                    Duration.seconds( 1 ),
                    event -> {
                        homeZoneLabel.setText(homeTime.getTimeZoneAsString());
                        targetZoneLabel.setText(targetTime.getTimeZoneAsString());
                        homeLabel.setText(homeTime.getTime());
                        targetLabel.setText(targetTime.getTime());
                    }
            )

    );
        timeline.setCycleCount( Animation.INDEFINITE );
        timeline.play();
    }


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
        updateClock();

       homeComboBox.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                targetTime.setTimeZone(newValue);
            }
        });
        targetComboBox.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                homeTime.setTimeZone(newValue);
            }
        });



    }








    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
