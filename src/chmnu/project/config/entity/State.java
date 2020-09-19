package chmnu.project.config.entity;

public class State {
    private String stateName;

    public State () {
    }

    public State(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
