package chmnu.project.config.entity;

public class CorruptSettings {
    private String nameAttribute;
    private Boolean enable;
    private Integer value;

    public CorruptSettings() {
    }

    public CorruptSettings(String nameAttribute, Boolean enable, Integer value) {
        this.nameAttribute = nameAttribute;
        this.enable = enable;
        this.value = value;
    }

    public String getNameAttribute() {
        return nameAttribute;
    }

    public void setNameAttribute(String nameAttribute) {
        this.nameAttribute = nameAttribute;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
