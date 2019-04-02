package com.example.dbflow;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDatabase.class)
public class LaunchImages extends BaseModel {


    @Column
    @PrimaryKey
    int id;

    @Column
    String lunchesSmallImageUrl;

    @Column
    String lunchesBigImageUrl;
    public int getId() {
        return id;
    }
    public void setLunchesSmallImageUrl(String lunchesSmallImageUrl) {
        this.lunchesSmallImageUrl = lunchesSmallImageUrl;
    }

    public void setLunchesBigImageUrl(String lunchesBigImageUrl) {
        this.lunchesBigImageUrl = lunchesBigImageUrl;
    }



    public String getLunchesSmallImageUrl() {
        return lunchesSmallImageUrl;
    }

    public String getLunchesBigImageUrl() {
        return lunchesBigImageUrl;
    }
}
