package com.indra.passwordchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView password;
    TextView breached;
    Keccak512Hasher keccak=new Keccak512Hasher();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void init(){
        breached=findViewById(R.id.showBreach);
        password=findViewById(R.id.password_text);
    }
    public void loadData(){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        String token=keccak.generateKECCAK512Hash(password.getText().toString()).substring(0,10);
        String url="https://passwords.xposedornot.com/api/v1/pass/anon/"+token;
        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, url,null,  new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response.toString());
                Gson son=new Gson();
                PwdChecker pwdChecker= son.fromJson(response.toString(),PwdChecker.class);
                int count=Integer.parseInt(pwdChecker.getSearchPassAnon().getCount());
                if(count>0){
                    breached.setText("Your Password has been breached! " +"\n"+
                            "Please change it Immidiately");
                    System.out.println("Oh shit");
                }
                else{


                }


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                breached.setText("Your Password is safe.. till now!");
                System.out.println("Oh ok then");
            }
        });
        requestQueue.add(request);
    }
    public void hasBreached(View view) {

        init();
        loadData();

    }
}