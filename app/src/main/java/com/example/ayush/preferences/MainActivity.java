package com.example.ayush.preferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("Prefs",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        outputText = (TextView)findViewById(R.id.output);
    }
    public void onPutClick(View view){
        editor.putString("String","Preferences");
        editor.putBoolean("Boolean",true);
        editor.putInt("Integer",1);
        editor.commit();
    }
    public void onGetClick(View view){
        String str=sharedPreferences.getString("String","No Preferences");
        boolean bool=sharedPreferences.getBoolean("Boolean",false);
        int in =sharedPreferences.getInt("Integer",0);

        outputText.setText(str+"\n"+bool+"\n"+in);
    }
}
