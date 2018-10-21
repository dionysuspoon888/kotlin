package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

/**
 * Created by D on 10/21/2018.
 */
class SecondActivity : AppCompatActivity() {
    lateinit var text:String;
    lateinit var tv_1:TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second);

        text = GlobalConstants.AccountData.name;

        tv_1 = findViewById(R.id.tv_1);
       tv_1.setText(text);



    }
}