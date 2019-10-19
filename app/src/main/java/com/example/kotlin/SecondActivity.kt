package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by D on 10/21/2018.
 */
class SecondActivity : AppCompatActivity() {
    private var text:String? = "";
    private lateinit var tv_1:TextView;
    private lateinit var ll_main: LinearLayout;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second);
        tv_1 = findViewById(R.id.tv_1);
        ll_main = findViewById(R.id.ll_main);

        text = GlobalConstants.AccountData.name;
        tv_1.setText(text);

        var i = -1
        try {
            i = intent.extras.getInt("OMG666")
            Log.i("Page1Activity", "getIntent: $i")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("Page1Activity", "error: $e")
        }

        val b = Bundle();
        b.putInt("OMG666", i)
        b.putString("OMGString666", "Yes888")

        val ft = fragmentManager.beginTransaction()
        ft.replace(R.id.ll_main, SecondFragment.newInstance(b))
                .commit()
    }

    override fun onResume() {
        super.onResume()
        val op = 9;
        Log.i("GODInt", "Page1Activity : " + GlobalConstants.countLogin+" i: ${test(7)} lol $op!")
    }
    fun test(i:Int):Int{
        return i;
    }
}