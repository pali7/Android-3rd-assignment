package com.example.fragmentsviewpager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.fragmentsviewpager.R;
import com.example.fragmentsviewpager.adapters.RecyclerViewAdapter;
import com.example.fragmentsviewpager.models.ItemModel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ItemModel> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        getSupportActionBar().setTitle("Dashboard");

        recyclerView = findViewById(R.id.recyclerView);

        listItems = new ArrayList<>();
        readFromFile();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, listItems);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }

    private void readFromFile() {
        try {
            FileInputStream fileInputStream = openFileInput("items.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("->");
                String itemName = parts[0];
                int itemPrice = Integer.parseInt(parts[1]);
                String itemDesc = parts[2];
                String imageName = parts[3];
                ItemModel model = new ItemModel(itemName, itemPrice, imageName, itemDesc);
                listItems.add(model);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openAddItem(View view) {
        startActivity(new Intent(this, AddItemActivity.class));
    }
}
