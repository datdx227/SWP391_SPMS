/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author quang
 */
public class Setting {

    private int settingId;
    private int order;
    private String settingName;
    private String value;
    private int status;
    private String description;
    private int typeId;

    public Setting() {
    }

    public Setting(int settingId, int order, String settingName, String value, int status, String description) {
        this.settingId = settingId;
        this.order = order;
        this.settingName = settingName;
        this.value = value;
        this.status = status;
        this.description = description;
    }

    public Setting(int settingId, String settingName, String value, int typeId, int order) {
        this.settingId = settingId;
        this.order = order;
        this.settingName = settingName;
        this.value = value;
        this.typeId = typeId;
    }

    public int getSettingId() {
        return settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }

    public String getSettingName() {
        return settingName;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "setting{" + "settingId=" + settingId + ", settingName=" + settingName + ", value=" + value + ", order=" + order + ", status=" + status + ", description=" + description + '}';
    }
}
