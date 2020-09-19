package chmnu.project.csv.tables;

public class ConvertedTable {
    private static final long serialVersionUID = 1L;

    private String Province_State; // name of state
    private String State_Region; // region of state (east, west etc)
    private Integer Confirmed;
    private Integer Deaths;
    private Integer Recovered;
    private Integer Active;
    private Integer Incident_Rate; // cases per 100k

    public ConvertedTable () {
    }

    public ConvertedTable(String province_State, String state_Region, String confirmed, String deaths, String recovered, String active, String incident_Rate) {
        Province_State = province_State;
        State_Region = state_Region;
        Confirmed = Integer.parseInt(confirmed);
        Deaths = Integer.parseInt(deaths);
        Recovered = Integer.parseInt(recovered);
        Active = Integer.parseInt(active);
        Incident_Rate = (int) Double.parseDouble(incident_Rate);
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

    public Integer getConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        Confirmed = confirmed;
    }

    public Integer getDeaths() {
        return Deaths;
    }

    public void setDeaths(Integer deaths) {
        Deaths = deaths;
    }

    public Integer getRecovered() {
        return Recovered;
    }

    public void setRecovered(Integer recovered) {
        Recovered = recovered;
    }

    public Integer getActive() {
        return Active;
    }

    public void setActive(Integer active) {
        Active = active;
    }

    public Integer getIncident_Rate() {
        return Incident_Rate;
    }

    public void setIncident_Rate(Integer incident_Rate) {
        Incident_Rate = incident_Rate;
    }
}