package com.hfzs.biz.sys.domain;

/**
 * Created by Administrator on 2017/8/24.
 */
public class TreeState {
    //is the node open
    private Boolean opened = true;
    //is the node disabled
    private Boolean disabled;
    //is the node selected
    private Boolean selected;

    public Boolean getOpened() {
        return opened;
    }

    public void setOpened(Boolean opened) {
        this.opened = opened;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}