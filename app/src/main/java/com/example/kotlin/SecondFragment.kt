package com.example.kotlin

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList


/**
 * Created by D on 10/18/2019.
 */
class SecondFragment : Fragment(), JsonAdapter.OnItemClickListener {
    private lateinit var tv1: TextView
    private lateinit var tv2: TextView

    private lateinit var rv_1: RecyclerView
    private lateinit var adapter: JsonAdapter
    private lateinit var list: ArrayList<JsonItem>

    private lateinit var requestQueue: RequestQueue

    private lateinit var ctx: Context

    private lateinit var listener: JsonAdapter.OnItemClickListener
    var i:Int = 0

    companion object {
        fun newInstance(b: Bundle): SecondFragment {
            val fragment = SecondFragment()
            fragment.setArguments(b)
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            i = arguments.getInt("OMG666")
            val y = arguments.getString("OMGString666")
            Log.i("Page1Fragment", "getArguments i: $i text: $y")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("Page1Fragment", "error: $e")
        }


        //Volley queue
        requestQueue = Volley.newRequestQueue(activity)
        ctx = activity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.fragment_second, container, false)
        tv1 = v.findViewById(R.id.tv_1)
        tv2 = v.findViewById(R.id.tv_2)
        rv_1 = v.findViewById(R.id.rv_1)

        tv1.text = "OMG666 is $i"

        //RecyclerView setting
        //better performance
        rv_1.setHasFixedSize(true)
        //grid view
        rv_1.layoutManager = GridLayoutManager(activity, 2)

        list = ArrayList()


        //Volley queue
        parseJson()
        return v
    }
    fun parseJson(){
        //JSON Link,q for search,type=photo
        val url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=car&image_type=photo"
        //JSONRequest for later use

        val request = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener { response ->
                    try {
                        //array that stores all the object in API Documentation
                        val jsonArray = response.getJSONArray("hits")
                        //Loop all the object of hit array
                      for(i in 0 until jsonArray.length() step 1){
                            val hit = jsonArray.getJSONObject(i)

                            //Extrieve what we want by Keys
                            val creatorName = hit.getString("user")
                            val imageUrl = hit.getString("webformatURL")
                            val likeCount = hit.getInt("likes")
                            val viewCount = hit.getInt("views")

                          Log.i("JsonObjectRequest","start: creatorName: "+creatorName);

                            list.add(JsonItem(imageUrl, creatorName, likeCount, viewCount))
                        }
                        Log.i("JsonObjectRequest","list: creatorName: "+list.get(0).creator);

                        adapter = JsonAdapter(ctx, list)
                        rv_1.adapter = adapter
                        adapter.setOnItemClickListener(this)

                    } catch (e: JSONException) {
                        e.printStackTrace()
                        Log.i("parseJson", "Json error: $e")
                    }
                }, Response.ErrorListener { error ->
            error.printStackTrace()
            Log.i("parseJson", "Volley error: $error")
        })
        //Start the request through Volley
        requestQueue.add(request)
    }
    override fun onItemClick(position: Int) {
     Toast.makeText(activity,"Hellow World "+position,Toast.LENGTH_SHORT).show()
    }
}