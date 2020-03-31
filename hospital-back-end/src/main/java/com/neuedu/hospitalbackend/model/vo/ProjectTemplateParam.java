package com.neuedu.hospitalbackend.model.vo;

import java.util.ArrayList;
import java.util.List;

public class ProjectTemplateParam {

    private Integer projectId;

    private String goal;

    private String requirement;

    List<ItemParam> items = new ArrayList<>();

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public List<ItemParam> getItems() {
        return items;
    }

    public void setItems(List<ItemParam> items) {
        this.items = items;
    }
}
