package com.example.sharedprefcomp_201b283;
import com.google.gson.Gson;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    SharedPreferences sharedPreferences;
    String []winnersArrays={"Rahul","Rohan", "Priya"};
    public void storePreference(View view){
        sharedPreferences.edit().putString("players",new Gson().toJson(winnersArrays)).apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        sharedPreferences=this.getSharedPreferences("com.example.sharedprefcomp_201b283", Context.MODE_PRIVATE);
        String[] temp=new Gson().fromJson(sharedPreferences.getString("players",null),winnersArrays.getClass());
        textView.setText(Arrays.toString(temp));
    }
}