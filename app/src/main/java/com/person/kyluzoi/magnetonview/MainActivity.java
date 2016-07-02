package com.person.kyluzoi.magnetonview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.person.kyluzoi.magnetonview.view.MagnetonView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.test_view)
    MagnetonView testView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        testView.addSubView();
        testView.addSubView();
        testView.addSubView();
        testView.addSubView();
        testView.addSubView();
    }
}
