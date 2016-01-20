package com.demo.hqinterviewdemo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shivang on 19/1/16.
 */
public class DataBeanList {

    List<DataBean> dataBeanList = new ArrayList<>();

    public List<DataBean> getDataBeanList() {
        return dataBeanList;
    }

    public void setDataBeanList(List<DataBean> dataBeanList) {
        this.dataBeanList = dataBeanList;
    }

    public DataBean getDataBean(int index) {
        return dataBeanList.get(index);
    }

    public void setDataBeanList(DataBean dataBeanList) {
        this.dataBeanList.add(dataBeanList);
    }

    public void addDataBean(DataBean dataBean) {
        this.dataBeanList.add(dataBean);
    }
}
