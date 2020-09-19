package chmnu.project.config.entity;

import java.util.List;

public class MainRegions {
    private List<Regions> regions;

    public MainRegions () {
    }

    public MainRegions(List<Regions> regions) {
        this.regions = regions;
    }

    public List<Regions> getRegions() {
        return regions;
    }

    public void setRegions(List<Regions> regions) {
        this.regions = regions;
    }
}
