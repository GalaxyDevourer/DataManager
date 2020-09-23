package chmnu.project.utils;

import chmnu.project.csv.tables.ConvertedTable;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class DataMiningProcessor {
    private Boolean State_Region;
    private Boolean Confirmed;
    private Boolean Deaths;
    private Boolean Recovered;
    private Boolean Active;
    private Boolean Incident_Rate;

    private Integer State_Region_count;
    private Integer Confirmed_count;
    private Integer Deaths_count;
    private Integer Recovered_count;
    private Integer Active_count;
    private Integer Incident_Rate_count;

    private HashMap<Pair<Integer, Integer>, String> rate_value = new HashMap<>();

    public DataMiningProcessor () {
        rate_value.put(new Pair<>(0, 1500), "Low");
        rate_value.put(new Pair<>(1500, 3000), "Medium");
        rate_value.put(new Pair<>(3000, 5000), "High");
    }

    public DataMiningProcessor(Boolean state_Region, Boolean confirmed, Boolean deaths, Boolean recovered, Boolean active,
                               Boolean incident_Rate, Integer state_Region_count, Integer confirmed_count, Integer deaths_count,
                               Integer recovered_count, Integer active_count, Integer incident_Rate_count) {

        State_Region = state_Region;
        Confirmed = confirmed;
        Deaths = deaths;
        Recovered = recovered;
        Active = active;
        Incident_Rate = incident_Rate;
        State_Region_count = state_Region_count;
        Confirmed_count = confirmed_count;
        Deaths_count = deaths_count;
        Recovered_count = recovered_count;
        Active_count = active_count;
        Incident_Rate_count = incident_Rate_count;
    }

    /*
    public List<ConvertedTable> corruptData () {

    }
    */

    public List<ConvertedTable> processData (List<ConvertedTable> convertedTableList) {
        // restore region
        convertedTableList.forEach(x -> {
            if (x.getState_Region() == null || x.getState_Region().equals("")) {
                x.setState_Region(findCorrectState(convertedTableList));
            }
        });

        // restore confirm
        List<String> confirm_values = convertedTableList.stream().map(ConvertedTable::getConfirmed).collect(Collectors.toList());
        int middleConfirm =  findMiddleIntValue(confirm_values, 1000000);

        convertedTableList.forEach( x -> {
            x.setConfirmed(fixInsaneData(x.getConfirmed(), 1000000, middleConfirm));
        });
        int newMiddleConfirm = findMiddleIntValue(confirm_values, 1000000);

        convertedTableList.forEach( x -> {
            if (x.getConfirmed() == null || x.getConfirmed().equals("")) {
                x.setConfirmed("" + newMiddleConfirm);
            }
        });

        // restore death
        List<String> death_values = convertedTableList.stream().map(ConvertedTable::getDeaths).collect(Collectors.toList());
        int middleDeath =  findMiddleIntValue(death_values, 100000);

        convertedTableList.forEach( x -> {
            x.setDeaths(fixInsaneData(x.getDeaths(), 100000, middleDeath));
        });
        int newMiddleDeath = findMiddleIntValue(death_values, 100000);

        convertedTableList.forEach( x -> {
            if (x.getDeaths() == null || x.getDeaths().equals("")) {
                x.setDeaths("" + newMiddleDeath);
            }
        });

        // restore recovery
        convertedTableList.forEach( x -> {
            if (!x.getRecovered().equals("")) {
                x.setRecovered( ((int) Double.parseDouble(x.getRecovered())) + "");
            }
        });
        List<String> recovery_values = convertedTableList.stream().map(ConvertedTable::getRecovered).collect(Collectors.toList());
        int middleRecovery =  findMiddleIntValue(recovery_values, 1000000);

        convertedTableList.forEach( x -> {
            x.setRecovered(fixInsaneData(x.getRecovered(), 1000000, middleRecovery));
        });
        int newMiddleRecovery = findMiddleIntValue(recovery_values, 1000000);

        convertedTableList.forEach( x -> {
            if (x.getRecovered() == null || x.getRecovered().equals("")) {
                x.setRecovered("" + newMiddleRecovery);
            }
        });

        // restore active
        convertedTableList.forEach( x ->
        {
            if (!x.getActive().equals("")) {
                x.setActive( ((int) Double.parseDouble(x.getActive())) + "");
            }
        });
        List<String> active_values = convertedTableList.stream().map(ConvertedTable::getActive).collect(Collectors.toList());
        int middleActive =  findMiddleIntValue(active_values, 1000000);

        convertedTableList.forEach( x -> {
            x.setActive(fixInsaneData(x.getActive(), 1000000, middleActive));
        });
        int newMiddleActive = findMiddleIntValue(active_values, 1000000);

        convertedTableList.forEach( x -> {
            if (x.getActive() == null || x.getActive().equals("")) {
                x.setActive("" + newMiddleActive);
            }
        });

        // restore rate
        convertedTableList.forEach( x -> {
            if (!x.getIncident_Rate().equals("")) {
                x.setIncident_Rate( ((int) Double.parseDouble(x.getIncident_Rate())) + "");
            }
        });
        List<String> rate_values = convertedTableList.stream().map(ConvertedTable::getIncident_Rate).collect(Collectors.toList());
        int middleRate =  findMiddleIntValue(rate_values, 5000);

        convertedTableList.forEach( x -> {
            x.setIncident_Rate(fixInsaneData(x.getIncident_Rate(), 5000, middleRate));
        });
        int newMiddleRate = findMiddleIntValue(rate_values, 5000);

        convertedTableList.forEach( x -> {
            if (x.getIncident_Rate() == null || x.getIncident_Rate().equals("")) {
                x.setIncident_Rate(findRateValue(newMiddleRate));
            }
        });

        return convertedTableList;
    }

    private String fixInsaneData (String data, Integer max_value, Integer middle) {
        if (!data.equals("")) {
            if (Integer.parseInt(data) > max_value) {
                return middle + "";
            }
            return data;
        }
        else return data;
    }

    private String findRateValue (Integer value) {

        AtomicReference<String> value_ = new AtomicReference<>("");
        rate_value.forEach( (x,y) -> {
            if (existInRange(x.getKey(), x.getValue(), value)) {
                value_.set(y);
            }
        });

        return value_.get();
    }

    private Boolean existInRange (Integer left, Integer right, Integer value) {
        return value >= left && value <= right;
    }

    private int findMiddleIntValue (List<String> value_list, Integer max_value) {
        return value_list.stream().filter( x -> !x.equals("") && Integer.parseInt(x) < max_value).mapToInt(Integer::parseInt).sum() / value_list.size();
    }

    private String findCorrectState (List<ConvertedTable> new_list) {
        List<String> states = new_list.stream().map(ConvertedTable::getState_Region).collect(Collectors.toList());
        HashMap<String, Integer> frequency = new HashMap<>();

        new_list.forEach( x -> frequency.put(x.getState_Region(), Collections.frequency(states, x.getState_Region())));

        return Collections.max(frequency.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    public Boolean getState_Region() {
        return State_Region;
    }

    public void setState_Region(Boolean state_Region) {
        State_Region = state_Region;
    }

    public Boolean getConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        Confirmed = confirmed;
    }

    public Boolean getDeaths() {
        return Deaths;
    }

    public void setDeaths(Boolean deaths) {
        Deaths = deaths;
    }

    public Boolean getRecovered() {
        return Recovered;
    }

    public void setRecovered(Boolean recovered) {
        Recovered = recovered;
    }

    public Boolean getActive() {
        return Active;
    }

    public void setActive(Boolean active) {
        Active = active;
    }

    public Boolean getIncident_Rate() {
        return Incident_Rate;
    }

    public void setIncident_Rate(Boolean incident_Rate) {
        Incident_Rate = incident_Rate;
    }

    public Integer getState_Region_count() {
        return State_Region_count;
    }

    public void setState_Region_count(Integer state_Region_count) {
        State_Region_count = state_Region_count;
    }

    public Integer getConfirmed_count() {
        return Confirmed_count;
    }

    public void setConfirmed_count(Integer confirmed_count) {
        Confirmed_count = confirmed_count;
    }

    public Integer getDeaths_count() {
        return Deaths_count;
    }

    public void setDeaths_count(Integer deaths_count) {
        Deaths_count = deaths_count;
    }

    public Integer getRecovered_count() {
        return Recovered_count;
    }

    public void setRecovered_count(Integer recovered_count) {
        Recovered_count = recovered_count;
    }

    public Integer getActive_count() {
        return Active_count;
    }

    public void setActive_count(Integer active_count) {
        Active_count = active_count;
    }

    public Integer getIncident_Rate_count() {
        return Incident_Rate_count;
    }

    public void setIncident_Rate_count(Integer incident_Rate_count) {
        Incident_Rate_count = incident_Rate_count;
    }
}