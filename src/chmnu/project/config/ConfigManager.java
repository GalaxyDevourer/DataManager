package chmnu.project.config;

import chmnu.project.config.entity.CorruptSettings;
import chmnu.project.config.entity.MainSettings;
import chmnu.project.config.entity.SaveSettings;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConfigManager {
    private YAMLFactory yaml = new YAMLFactory();
    private ObjectMapper mapper = new ObjectMapper(yaml);

    private final String SETTINGS_PATH = "src/chmnu/resources/settings.yml";
    private final String SETTINGS_NAME = "settings.yml";

    public MainSettings getSettings() throws IOException {
        MainSettings settings = new MainSettings();

        File cfg = new File(SETTINGS_PATH);
        try (
                InputStream in = new BufferedInputStream(
                        Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(SETTINGS_NAME)));
                OutputStream out = new BufferedOutputStream(
                        new FileOutputStream(cfg))) {

            byte[] buffer = new byte[2048];
            int lengthRead;

            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapper.readValue(cfg, settings.getClass());
    }

    public void setDefaultSettings () throws IOException {
        CorruptSettings region = new CorruptSettings("Region", false, 0);
        CorruptSettings confirmed = new CorruptSettings("Confirmed", false, 0);
        CorruptSettings death = new CorruptSettings("Death", false, 0);
        CorruptSettings recovered = new CorruptSettings("Recovered", false, 0);
        CorruptSettings active = new CorruptSettings("Active", false, 0);
        CorruptSettings rate = new CorruptSettings("Rate", false, 0);
        List<CorruptSettings> corruptSettingsList = Arrays.asList(region, confirmed, death, recovered, active, rate);

        SaveSettings save = new SaveSettings("G:\\_ИНСТИТУТ\\3 КУРС\\Предмети\\MatLab\\DataManager\\initFolder",
                "G:\\_ИНСТИТУТ\\3 КУРС\\Предмети\\MatLab\\DataManager\\processedFolder");

        MainSettings settings = new MainSettings();
        settings.setSource("https://github.com/CSSEGISandData/COVID-19/tree/master/csse_covid_19_data/csse_covid_19_daily_reports_us");
        settings.setSaveSettings(save);
        settings.setCorruption(corruptSettingsList);

        mapper.writeValue(new File(SETTINGS_PATH), settings);
    }

    public void saveSettings (MainSettings settings) throws IOException {
        mapper.writeValue(new File(SETTINGS_PATH), settings);
    }

}
