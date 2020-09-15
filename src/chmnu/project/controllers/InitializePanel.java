package chmnu.project.controllers;

import chmnu.project.utils.PageParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.List;

public class InitializePanel {
    @FXML AnchorPane init_main_layout;
    @FXML ComboBox<String> source_box;
    @FXML TextField link_field;
    @FXML ComboBox<String> file_names_box;

    @FXML CheckBox region_check;
    @FXML CheckBox confirmed_check;
    @FXML CheckBox death_check;
    @FXML CheckBox recovered_check;
    @FXML CheckBox rate_check;
    @FXML CheckBox active_check;
    @FXML TextField region_value;
    @FXML TextField confirmed_value;
    @FXML TextField death_value;
    @FXML TextField recovered_value;
    @FXML TextField rate_value;
    @FXML TextField active_value;

    @FXML TextField init_data_field;
    @FXML TextField processed_data_field;
    @FXML Button start_button;

    public void initialize () throws IOException {
        ObservableList<String> sources = FXCollections.observableArrayList("github", "gitlab", "test");
        source_box.setItems(sources);
        source_box.setValue("github");

        List<String> files = new PageParser().getListFileNames();
        ObservableList<String> file_names = FXCollections.observableArrayList(files);
        file_names_box.setItems(file_names);
        file_names_box.setValue(files.get(0));
    }

    @FXML
    public void onChangeSource() {
        if (source_box.getValue().equals("github")) {
            link_field.setText("https://github.com/CSSEGISandData/COVID-19/tree/master/csse_covid_19_data/csse_covid_19_daily_reports_us");
        }
        else link_field.setText("This sources was not implemented yet");
    }
}
