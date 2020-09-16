package chmnu.project.config.entity;

import java.util.List;

public class MainSettings {
    private String source;
    private List<CorruptSettings> corruption;
    private SaveSettings saveSettings;

    public MainSettings () {
    }

    public MainSettings(String source, List<CorruptSettings> corruption, SaveSettings saveSettings) {
        this.source = source;
        this.corruption = corruption;
        this.saveSettings = saveSettings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<CorruptSettings> getCorruption() {
        return corruption;
    }

    public void setCorruption(List<CorruptSettings> corruption) {
        this.corruption = corruption;
    }

    public SaveSettings getSaveSettings() {
        return saveSettings;
    }

    public void setSaveSettings(SaveSettings saveSettings) {
        this.saveSettings = saveSettings;
    }
}
