package com.example.dbflow;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDatabase.class)
public class Launches extends BaseModel {

    @Column
    @PrimaryKey
    int id;


    @Column
    int lunchesFlightNumber;

    @ForeignKey(saveForeignKeyModel = false)
    LaunchImages launchImages;

    @Column
    String lunchesMissionName;

    public int getId() {
        return id;
    }

    public void setLunchesFlightNumber(int lunchesFlightNumber) {
        this.lunchesFlightNumber = lunchesFlightNumber;
    }

    public void setLunchesMissionName(String lunchesMissionName) {
        this.lunchesMissionName = lunchesMissionName;
    }

    public void setLaunchImages(LaunchImages launchImages) {
        this.launchImages = launchImages;
    }






    public LaunchImages getLaunchImages() {
        return launchImages;
    }

    public int getLunchesFlightNumber() {
        return lunchesFlightNumber;
    }

    public String getLunchesMissionName() {
        return lunchesMissionName;
    }
}
