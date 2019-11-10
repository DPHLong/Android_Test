package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView2 = findViewById(R.id.textView2);

        // Nachricht erhalten
        Intent receivedIntent = getIntent();
        Bundle bund = receivedIntent.getExtras();
        String str = "";
        if (bund != null){
            str = (String) bund.get("location");
            Toast.makeText(getApplicationContext(), "Location is " + str, Toast.LENGTH_LONG).show();
        }else{
            str = "No message was received!";
            Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
        }

        // Liste erstellen:
        ListView listViewAct2 = findViewById(R.id.listViewAct2);
        final ArrayList<String> myItems = new ArrayList<String>();

        // Ich setze eine random index bis 100
        Random rand = new Random();
        int itemIdex = rand.nextInt(100);
        String str2 = (String) textView2.getText();
        textView2.setText(str2 + "\nNumber of items is: " + Integer.toString(itemIdex));

        // fügen die Items hinzu
        for (int i=0; i<itemIdex; i++){
            myItems.add("item " + Integer.toString(i));
        }

        // fügen die Items in ListView hinzu:
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myItems);
        listViewAct2.setAdapter(myAdapter);

        // für jedes Click on Item, mache ich ein kleine Nachricht:
        listViewAct2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "This is " + myItems.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
