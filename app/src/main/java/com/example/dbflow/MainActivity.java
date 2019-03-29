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
                Organization organization = new Organization();
                organization.setName(mainBinding.mainName.getText().toString());
                organization.setCountry(mainBinding.mainCountry.getText().toString());
                organization.save();
                break;

            case R.id.showDetail:    showData(); break;
        }
    }

    private void showData() {
        List<Organization> organizations = SQLite.select().from(Organization.class).queryList();

        for(Organization organization : organizations){
            String content = "";
            content += "ID" + organization.getId() + "\n";
            content += "Name" + organization.getCountry() + "\n";
            content += "Country" + organization.getName() + "\n";
            mainBinding.dataText.append(content);
        }
    }
}
