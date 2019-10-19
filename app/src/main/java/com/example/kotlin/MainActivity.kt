package com.example.kotlin

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.kotlin.GlobalConstants.Companion.countedLogin

class MainActivity : AppCompatActivity() {


    private lateinit var b_1:Button ;
    private var name:String? = "";
    private var pwd:String? = "";
    private lateinit var dialog:ProgressDialog ;
    private lateinit var sharedPreferences: SharedPreferences;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var acData:AccountData = AccountData("Sam",null,99);
        if(!GlobalConstants.countedLogin){
            sharedPreferences = getSharedPreferences("GOD666", Context.MODE_PRIVATE);
            val editor = sharedPreferences.edit()
            var countLogin = sharedPreferences.getInt("GODInt", 0)
            editor.putInt("GODInt", countLogin)
            GlobalConstants.countLogin = countLogin
            editor.commit()
            GlobalConstants.countedLogin = true

        }

        name = acData.name;
        pwd = acData.pwd;
        Log.i("acData","name: "+name+" pwd: "+pwd);


        b_1 = findViewById(R.id.b_1);
        b_1.setOnClickListener(View.OnClickListener {
            GlobalConstants.AccountData = acData;
            nextPage();
            val intent = Intent()
            intent.putExtra("OMG666",666);
            intent.setClass(baseContext,SecondActivity::class.java)
            startActivity(intent);

        })


    }

    fun nextPage() {
        Toast.makeText(this,"next Page",Toast.LENGTH_SHORT).show();
    }
}
