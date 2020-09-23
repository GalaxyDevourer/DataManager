package chmnu.project.utils;

import chmnu.project.csv.tables.ConvertedTable;

import java.util.*;
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

    public DataMiningProcessor () {
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
        convertedTableList.forEach( x -> System.out.println(x.getProvince_State()));

        // restore region
        convertedTableList.forEach(x -> {
            if (x.getState_Region() == null || x.getState_Region().equals("")) {
                x.setState_Region(findCorrectState(convertedTableList));
            }
        });

        // restore confirm


        // restore death


        // restore recovery


        // restore active


        // restore rate


        return convertedTableList;
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