package com.example.fragmentsviewpager.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.fragmentsviewpager.R;

import java.io.IOException;
import java.io.PrintStream;

public class AddItemActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinner;
    private EditText etItemName, etItemPrice, etItemDesc;
    private Button btnAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        getSupportActionBar().setTitle("Add Item");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinner = findViewById(R.id.spinner);
        btnAddItem = findViewById(R.id.btnAddItem);
        etItemDesc = findViewById(R.id.etItemDesc);
        etItemName = findViewById(R.id.etItemName);
        etItemPrice = findViewById(R.id.etItemPrice);

        btnAddItem.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        String itemName = etItemName.getText().toString();
        String itemPrice = etItemPrice.getText().toString();
        String itemDesc = etItemDesc.getText().toString();
        String imageName = spinner.getSelectedItem().toString();

        try {
            PrintStream printStream = new PrintStream(openFileOutput("items.txt", MODE_PRIVATE | MODE_APPEND));
            printStream.println(itemName + "->" + itemPrice + "->" + itemDesc + "->" + imageName);
            Toast.makeText(this, "Item Saved", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this, "Failed to save item.", Toast.LENGTH_SHORT).show();
        }
    }
}
