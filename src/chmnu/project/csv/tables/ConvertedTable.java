package chmnu.project.csv.tables;

import com.opencsv.bean.CsvBindByName;

public class ConvertedTable {
    @CsvBindByName private String Province_State; // name of state
    @CsvBindByName private String State_Region; // region of state (east, west etc)
    @CsvBindByName private String Confirmed;
    @CsvBindByName private String Deaths;
    @CsvBindByName private String Recovered;
    @CsvBindByName private String Active;
    @CsvBindByName private String Incident_Rate; // cases per 100k

    public ConvertedTable () {
    }

    public ConvertedTable(String province_State, String state_Region, String confirmed, String deaths, String recovered, String active, String incident_Rate) {
        Province_State = province_State;
        State_Region = state_Region;
        Confirmed = confirmed;
        Deaths = deaths;
        Recovered = recovered; // double
        Active = active; // double
        Incident_Rate = incident_Rate;
    }

    public void setConfirmed(String confirmed) {
        Confirmed = confirmed;
    }

    public void setDeaths(String deaths) {
        Deaths = deaths;
    }

    public void setRecovered(String recovered) {
        Recovered = recovered;
    }

    public void setActive(String active) {
        Active = active;
    }

    public String getProvince_State() {
        return Province_State;
    }

    public void setProvince_State(String province_State) {
        Province_State = province_State;
    }

    public String getState_Region() {
        return State_Region;
    }

    public void setState_Region(String state_Region) {
        State_Region = state_Region;
    }

    public String getConfirmed() {
        return Confirmed;
    }

    public String getDeaths() {
        return Deaths;
    }

    public String getRecovered() {
        return Recovered;
    }

    public String getActive() {
        return Active;
    }

    public String getIncident_Rate() {
        return Incident_Rate;
    }

    public void setIncident_Rate(String incident_Rate) {
        Incident_Rate = incident_Rate;
    }
}