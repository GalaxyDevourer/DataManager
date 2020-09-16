package chmnu.project.config.entity;

public class SaveSettings {
    private String initFolder;
    private String processedFolder;

    public SaveSettings () {
    }

    public SaveSettings(String initFolder, String processedFolder) {
        this.initFolder = initFolder;
        this.processedFolder = processedFolder;
    }

    public String getInitFolder() {
        return initFolder;
    }

    public void setInitFolder(String initFolder) {
        this.initFolder = initFolder;
    }

    public String getProcessedFolder() {
        return processedFolder;
    }

    public void setProcessedFolder(String processedFolder) {
        this.processedFolder = processedFolder;
    }
}
