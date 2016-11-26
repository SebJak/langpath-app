package com.langpath.app.model.response;

import java.util.List;

public class ChartData {

    private String label;
    private String color;
    private List<AxisValue> data;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<AxisValue> getData() {
        return data;
    }

    public void setData(List<AxisValue> data) {
        this.data = data;
    }
}
