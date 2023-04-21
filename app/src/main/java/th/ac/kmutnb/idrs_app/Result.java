package th.ac.kmutnb.idrs_app;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    TextView textView1,textView2,textView3,textView4,textView5 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView1 = findViewById(R.id.textView22);
        textView2 = findViewById(R.id.textView21);
        textView3 = findViewById(R.id.textView20);
        textView4 = findViewById(R.id.textView19);
        textView5 = findViewById(R.id.textView23);


        fetchData();

    }

    public void fetchData(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://run.mocky.io/v3/fba93c88-a04a-4d43-990f-60011630a4d4";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        parseJson(response);
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView1.setText("dont work");
            }
        });
        queue.add(stringRequest);
    }

    public void parseJson(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray  jsonArray = jsonObject.getJSONArray("item");
            for(int i = 0 ;i < jsonArray.length();i++){
                String nameVar,percentvar,gradeVar,somthing1;
                String somthing;
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                nameVar = jsonObject2.getString("FirstName");
                percentvar = jsonObject2.getString("LastName");
                gradeVar = jsonObject2.getString("Pronouns");
                somthing  = jsonObject2.getString("Phone Number");
                somthing1  = jsonObject2.getString("Nationality");
                textView1.append(nameVar);
                textView2.append(percentvar);
                textView3.append(gradeVar);
                textView5.append(somthing.toString());
                textView4.append(somthing1);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            //textView1.setText("dont work1");
        }


    }

}
