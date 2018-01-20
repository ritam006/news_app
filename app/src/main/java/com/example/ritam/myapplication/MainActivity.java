package com.example.ritam.myapplication;

import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements KeywordDialog.KeywordDialogListener{
    private static final String TAG = "MainActivity";
    private static final String url = "http://192.168.0.117:5000/student";
    private String url_str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button national_button = findViewById(R.id.national);
        Button health_button = findViewById(R.id.health);
        Button sports_button = findViewById(R.id.sports);
        Button business_button = findViewById(R.id.business);
        Button technology_button = findViewById(R.id.technology);
        Button keyword_button = findViewById(R.id.keyword);
        //final RequestQueue requestQueue = Volley.newRequestQueue(this);
        national_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(view.getContext(), "Button Clicked", Toast.LENGTH_SHORT).show();
                Uri.Builder builder=new Uri.Builder();
                builder.scheme("https").authority("newsapi.org").appendEncodedPath("v2").appendEncodedPath("top-headlines").appendQueryParameter("country","in").appendQueryParameter("apiKey","dafe84df59ff49b6ac60758549584cbd");
                url_str=builder.build().toString();
                Intent intent = new Intent(MainActivity.this, NewsFeedActivity.class);
                intent.putExtra("url",url_str);
                startActivity(intent);
                //finish();
                /*JSONObject jsonobject_student = new JSONObject();
                try {
                    jsonobject_student.put("name", tv.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, jsonobject_student,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.d(TAG, response.toString());
                                //hideProgressDialog();
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        //hideProgressDialog();
                    }
                }) {

                    /*
                     * Passing some request headers
                     * */
                    /*@Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        headers.put("Content-Type", "application/json; charset=utf-8");
                        return headers;
                    }
                };
                requestQueue.add(jsonObjReq);*/
            }
        });
        health_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri.Builder builder=new Uri.Builder();
                builder.scheme("https").authority("newsapi.org").appendEncodedPath("v2").appendEncodedPath("top-headlines").appendQueryParameter("country","in").appendQueryParameter("category","health").appendQueryParameter("apiKey","dafe84df59ff49b6ac60758549584cbd");
                url_str=builder.build().toString();
                Intent intent = new Intent(MainActivity.this, NewsFeedActivity.class);
                intent.putExtra("url",url_str);
                startActivity(intent);
            }
        });

        sports_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri.Builder builder=new Uri.Builder();
                builder.scheme("https").authority("newsapi.org").appendEncodedPath("v2").appendEncodedPath("top-headlines").appendQueryParameter("country","in").appendQueryParameter("category","sports").appendQueryParameter("apiKey","dafe84df59ff49b6ac60758549584cbd");
                url_str=builder.build().toString();
                Intent intent = new Intent(MainActivity.this, NewsFeedActivity.class);
                intent.putExtra("url",url_str);
                startActivity(intent);
            }
        });

        business_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri.Builder builder=new Uri.Builder();
                builder.scheme("https").authority("newsapi.org").appendEncodedPath("v2").appendEncodedPath("top-headlines").appendQueryParameter("country","in").appendQueryParameter("category","business").appendQueryParameter("apiKey","dafe84df59ff49b6ac60758549584cbd");
                url_str=builder.build().toString();
                Intent intent = new Intent(MainActivity.this, NewsFeedActivity.class);
                intent.putExtra("url",url_str);
                startActivity(intent);
            }
        });

        technology_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri.Builder builder=new Uri.Builder();
                builder.scheme("https").authority("newsapi.org").appendEncodedPath("v2").appendEncodedPath("top-headlines").appendQueryParameter("country","in").appendQueryParameter("category","technology").appendQueryParameter("apiKey","dafe84df59ff49b6ac60758549584cbd");
                url_str=builder.build().toString();
                Intent intent = new Intent(MainActivity.this, NewsFeedActivity.class);
                intent.putExtra("url",url_str);
                startActivity(intent);
            }
        });

        keyword_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"Keyword Button",Toast.LENGTH_SHORT).show();
                confirmKeywordSearch();
            }
        });

    }

    public void confirmKeywordSearch(){
        DialogFragment dialog = new KeywordDialog();
        dialog.show(getFragmentManager(),"keyword");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        EditText text = dialog.getDialog().findViewById(R.id.textField);
        Uri.Builder builder=new Uri.Builder();
        builder.scheme("https").authority("newsapi.org").appendEncodedPath("v2").appendEncodedPath("everything").appendQueryParameter("language","en").appendQueryParameter("q",text.getText().toString()).appendQueryParameter("apiKey","dafe84df59ff49b6ac60758549584cbd");
        url_str=builder.build().toString();
        Intent intent = new Intent(MainActivity.this,NewsFeedActivity.class);
        intent.putExtra("url",url_str);
        startActivity(intent);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
}



