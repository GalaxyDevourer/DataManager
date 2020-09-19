package chmnu.project.config;

import chmnu.project.config.entity.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SettingsManager {
    private YAMLFactory yaml = new YAMLFactory();
    private ObjectMapper mapper = new ObjectMapper(yaml);

    private final String SETTINGS_PATH = "src/chmnu/resources/settings.yml";
    private final String SETTINGS_NAME = "settings.yml";
    private final String REGIONS_PATH = "src/chmnu/resources/regions.yml";
    private final String REGIONS_NAME = "regions.yml";

    public MainSettings getSettings() throws IOException {
        MainSettings settings = new MainSettings();
        File cfg = getFile(SETTINGS_PATH, SETTINGS_NAME);

        settings = mapper.readValue(cfg, settings.getClass());

        return settings;
    }

    public void setDefaultSettings (String name) throws IOException {
        File cfg = new File(SETTINGS_PATH);

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

        mapper.writeValue(cfg, settings);
    }

    public void saveSettings (MainSettings settings) throws IOException {
        File cfg = new File(SETTINGS_PATH);
        mapper.writeValue(cfg, settings);
    }

    private MainRegions getRegions() throws IOException {
        MainRegions regions = new MainRegions();
        File cfg = getFile(REGIONS_PATH, REGIONS_NAME);

        regions = mapper.readValue(cfg, regions.getClass());

        return regions;
    }

    public HashMap<String, String> getMapRegions () throws IOException {
        MainRegions regions = getRegions();
        HashMap<String, String> states = new HashMap<>();

        regions.getRegions().forEach(x -> x.getStates().forEach(y -> {
            states.put(x.getRegionName(), y.getStateName());
        }));

        return states;
    }

    private File getFile(String path, String filename) {
        File file = new File(path);

        try (
                InputStream in = new BufferedInputStream(
                        Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(filename)));
                OutputStream out = new BufferedOutputStream(
                        new FileOutputStream(file))) {

            byte[] buffer = new byte[2048];
            int lengthRead;

            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

}
