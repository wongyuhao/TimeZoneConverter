package org.hao;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableDoubleValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import javax.security.auth.callback.ChoiceCallback;

public class SecondaryController implements Initializable{

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}