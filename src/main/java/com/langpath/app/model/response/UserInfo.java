package com.langpath.app.model.response;

import java.util.List;

public class UserInfo {

    private List<ChartData> chartDatas;

    private String firstName;

    private int countWordGroup;

    private int countMessages;

    public List<ChartData> getChartDatas() {
        return chartDatas;
    }

    public void setChartDatas(List<ChartData> chartDatas) {
        this.chartDatas = chartDatas;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getCountWordGroup() {
        return countWordGroup;
    }

    public void setCountWordGroup(int countWordGroup) {
        this.countWordGroup = countWordGroup;
    }

    public int getCountMessages() {
        return countMessages;
    }

    public void setCountMessages(int countMessages) {
        this.countMessages = countMessages;
    }
}
