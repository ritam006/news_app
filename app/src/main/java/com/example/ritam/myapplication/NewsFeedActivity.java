package com.example.ritam.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NewsFeedActivity extends AppCompatActivity {

    private static final String url ="https://newsapi.org/v2/top-headlines?country=in&apiKey=dafe84df59ff49b6ac60758549584cbd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);
        final ArrayList<String> list=new ArrayList<>();
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.list_entry,list);
        final ListView lv=findViewById(R.id.list);
        RequestQueue queue= Volley.newRequestQueue(this);
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArr=response.getJSONArray("articles");
                            for(int i=0;i<jsonArr.length();i++)
                            {
                                list.add(jsonArr.getJSONObject(i).getString("title"));
                            }
                        }
                        catch (JSONException e)
                        {

                        }
                        lv.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });
        queue.add(jsObjRequest);
    }
}
