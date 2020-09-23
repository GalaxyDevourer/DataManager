package chmnu.project.config.entity;

public class SaveSettings {
    private String initFolder;
    private String processedFolder;
    private String corruptedFolder;

    public SaveSettings () {
    }

    public SaveSettings(String initFolder, String processedFolder, String corruptedFolder) {
        this.initFolder = initFolder;
        this.processedFolder = processedFolder;
        this.corruptedFolder = corruptedFolder;
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

    public String getCorruptedFolder() {
        return corruptedFolder;
    }

    public void setCorruptedFolder(String corruptedFolder) {
        this.corruptedFolder = corruptedFolder;
    }
}
