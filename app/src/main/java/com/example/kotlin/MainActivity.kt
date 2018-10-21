package com.example.kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    lateinit var b_1:Button ;
    lateinit var text:String;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var acData:AccountData = AccountData("Sam","123",99);
        text = acData.name;


        b_1 = findViewById(R.id.b_1);
        b_1.setOnClickListener(View.OnClickListener {
            GlobalConstants.AccountData = acData;
            nextPage();
            startActivity(Intent(baseContext,SecondActivity::class.java));

        })


    }

    fun nextPage() {
        Toast.makeText(this,"next Page",Toast.LENGTH_SHORT).show();
    }
}
