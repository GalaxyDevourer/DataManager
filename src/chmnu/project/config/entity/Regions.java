package chmnu.project.config.entity;

import java.util.List;

public class Regions {
    private String regionName;
    private List<State> states;

    public Regions () {
    }

    public Regions(String regionName, List<State> states) {
        this.regionName = regionName;
        this.states = states;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }
}
