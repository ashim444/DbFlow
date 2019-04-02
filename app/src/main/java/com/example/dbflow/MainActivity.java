package com.example.dbflow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.dbflow.databinding.ActivityMainBinding;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.saveMe.setOnClickListener(this);
        mainBinding.showDetail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.saveMe:
                LaunchImages lImage = new LaunchImages();
                lImage.setLunchesBigImageUrl("ImgSmlUrl");
                lImage.setLunchesSmallImageUrl("ImgBigUrl");
                lImage.save();
                Launches launches = new Launches();
                launches.setLunchesFlightNumber(1);
                launches.setLunchesMissionName("Ashim");
                launches.setLaunchImages(lImage);
                launches.save();
                break;

            case R.id.showDetail:    showData(); break;
        }
    }

    private void showData() {
        List<Launches> launches = SQLite.select().from(Launches.class).queryList();
        mainBinding.dataText.setText("");
        for(Launches launche : launches){
            String content = "";
            content += "ID" + launche.getId() + "\n";
            content += "flight Num" + launche.getLunchesFlightNumber() + "\n";
            content += "Flight name" + launche.getLunchesMissionName() + "\n";
            content += "small url" + launche.getLaunchImages().getLunchesSmallImageUrl() + "\n";
            content += "Big url" + launche.getLaunchImages().getLunchesBigImageUrl() + "\n";
            mainBinding.dataText.append(content);
        }
    }
}
