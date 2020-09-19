package chmnu.project.csv.tables;

public class InitialTable {
    private static final long serialVersionUID = 1L;

    private String Province_State;
    private String Country_Region;
    private String Last_Update;
    private String Lat;
    private String Long_;
    private String Confirmed;
    private String Deaths;
    private String Recovered;
    private String Active;
    private String FIPS;
    private String Incident_Rate;
    private String People_Tested;
    private String People_Hospitalized;
    private String Mortality_Rate;
    private String UID;
    private String ISO3;
    private String Testing_Rate;
    private String Hospitalization_Rate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getProvince_State() {
        return Province_State;
    }

    public void setProvince_State(String province_State) {
        Province_State = province_State;
    }

    public String getCountry_Region() {
        return Country_Region;
    }

    public void setCountry_Region(String country_Region) {
        Country_Region = country_Region;
    }

    public String getLast_Update() {
        return Last_Update;
    }

    public void setLast_Update(String last_Update) {
        Last_Update = last_Update;
    }

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public String getLong_() {
        return Long_;
    }

    public void setLong_(String long_) {
        Long_ = long_;
    }

    public String getConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(String confirmed) {
        Confirmed = confirmed;
    }

    public String getDeaths() {
        return Deaths;
    }

    public void setDeaths(String deaths) {
        Deaths = deaths;
    }

    public String getRecovered() {
        return Recovered;
    }

    public void setRecovered(String recovered) {
        Recovered = recovered;
    }

    public String getActive() {
        return Active;
    }

    public void setActive(String active) {
        Active = active;
    }

    public String getFIPS() {
        return FIPS;
    }

    public void setFIPS(String FIPS) {
        this.FIPS = FIPS;
    }

    public String getIncident_Rate() {
        return Incident_Rate;
    }

    public void setIncident_Rate(String incident_Rate) {
        Incident_Rate = incident_Rate;
    }

    public String getPeople_Tested() {
        return People_Tested;
    }

    public void setPeople_Tested(String people_Tested) {
        People_Tested = people_Tested;
    }

    public String getPeople_Hospitalized() {
        return People_Hospitalized;
    }

    public void setPeople_Hospitalized(String people_Hospitalized) {
        People_Hospitalized = people_Hospitalized;
    }

    public String getMortality_Rate() {
        return Mortality_Rate;
    }

    public void setMortality_Rate(String mortality_Rate) {
        Mortality_Rate = mortality_Rate;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getISO3() {
        return ISO3;
    }

    public void setISO3(String ISO3) {
        this.ISO3 = ISO3;
    }

    public String getTesting_Rate() {
        return Testing_Rate;
    }

    public void setTesting_Rate(String testing_Rate) {
        Testing_Rate = testing_Rate;
    }

    public String getHospitalization_Rate() {
        return Hospitalization_Rate;
    }

    public void setHospitalization_Rate(String hospitalization_Rate) {
        Hospitalization_Rate = hospitalization_Rate;
    }
}