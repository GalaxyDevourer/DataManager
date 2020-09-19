package chmnu.project.controllers;

import chmnu.project.config.SettingsManager;
import chmnu.project.config.entity.CorruptSettings;
import chmnu.project.config.entity.MainSettings;
import chmnu.project.config.entity.SaveSettings;
import chmnu.project.utils.PageParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @FXML private Map<String,CheckBox> checkBoxHashMap = new HashMap<>();

    @FXML TextField region_value;
    @FXML TextField confirmed_value;
    @FXML TextField death_value;
    @FXML TextField recovered_value;
    @FXML TextField rate_value;
    @FXML TextField active_value;
    @FXML private Map<String, TextField> textFieldHashMap = new HashMap<>();

    @FXML TextField init_data_field;
    @FXML TextField processed_data_field;
    @FXML Button start_button;

    @FXML private MainSettings settings = new MainSettings();
    @FXML private SettingsManager manager = new SettingsManager();

    public void initialize () throws IOException, InterruptedException {
        ObservableList<String> sources = FXCollections.observableArrayList("github", "gitlab", "test");
        source_box.setItems(sources);
        source_box.setValue("github");

        List<String> files = new PageParser().getListFileNames();
        ObservableList<String> file_names = FXCollections.observableArrayList(files);
        file_names_box.setItems(file_names);
        file_names_box.setValue(files.get(0));

        initMaps();

        settings = manager.getSettings();
        setSettings();
    }

    @FXML
    public void onChangeSource() {
        if (source_box.getValue().equals("github")) {
            link_field.setText("https://github.com/CSSEGISandData/COVID-19/tree/master/csse_covid_19_data/csse_covid_19_daily_reports_us");
        }
        else link_field.setText("This sources was not implemented yet");
    }

    @FXML
    public void setYourConfig () {
        setSettings();
    }

    @FXML
    public void setDefaultConfig () throws IOException {
        manager.setDefaultSettings();
        settings = manager.getSettings();
        setSettings();
    }

    @FXML
    public void saveConfig () throws IOException {
        settings = getSettings();
        manager.saveSettings(settings);
    }

    private void initMaps () {
        checkBoxHashMap.put("Region", region_check);
        checkBoxHashMap.put("Confirmed", confirmed_check);
        checkBoxHashMap.put("Death", death_check);
        checkBoxHashMap.put("Recovered", recovered_check);
        checkBoxHashMap.put("Active", active_check);
        checkBoxHashMap.put("Rate", rate_check);

        textFieldHashMap.put("Region", region_value);
        textFieldHashMap.put("Confirmed", confirmed_value);
        textFieldHashMap.put("Death", death_value);
        textFieldHashMap.put("Recovered", recovered_value);
        textFieldHashMap.put("Active", active_value);
        textFieldHashMap.put("Rate", rate_value);
    }

    private void setSettings () {
        link_field.setText(settings.getSource());

        settings.getCorruption().forEach(x -> {
            checkBoxHashMap.get(x.getNameAttribute()).setSelected(x.getEnable());
            textFieldHashMap.get(x.getNameAttribute()).setText(x.getValue().toString());
        });

        init_data_field.setText(settings.getSaveSettings().getInitFolder());
        processed_data_field.setText(settings.getSaveSettings().getProcessedFolder());
    }

    private MainSettings getSettings () {
        MainSettings this_settings = new MainSettings();

        CorruptSettings region = new CorruptSettings("Region", region_check.isSelected(), Integer.parseInt(region_value.getText()));
        CorruptSettings confirmed = new CorruptSettings("Confirmed", confirmed_check.isSelected(), Integer.parseInt(confirmed_value.getText()));
        CorruptSettings death = new CorruptSettings("Death", death_check.isSelected(), Integer.parseInt(death_value.getText()));
        CorruptSettings recovered = new CorruptSettings("Recovered", recovered_check.isSelected(), Integer.parseInt(recovered_value.getText()));
        CorruptSettings active = new CorruptSettings("Active", active_check.isSelected(), Integer.parseInt(active_value.getText()));
        CorruptSettings rate = new CorruptSettings("Rate", rate_check.isSelected(), Integer.parseInt(rate_value.getText()));
        List<CorruptSettings> corruptSettingsList = Arrays.asList(region, confirmed, death, recovered, active, rate);

        SaveSettings save = new SaveSettings("G:\\_ИНСТИТУТ\\3 КУРС\\Предмети\\MatLab\\DataManager\\initFolder",
                "G:\\_ИНСТИТУТ\\3 КУРС\\Предмети\\MatLab\\DataManager\\processedFolder");

        this_settings.setSource("https://github.com/CSSEGISandData/COVID-19/tree/master/csse_covid_19_data/csse_covid_19_daily_reports_us");
        this_settings.setSaveSettings(save);
        this_settings.setCorruption(corruptSettingsList);

        return this_settings;
    }
}
