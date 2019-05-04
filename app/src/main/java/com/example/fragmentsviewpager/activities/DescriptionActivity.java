package com.example.fragmentsviewpager.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmentsviewpager.R;

public class DescriptionActivity extends AppCompatActivity {

    private TextView tvItemName, tvItemPrice, tvItemDesc;
    private ImageView imgItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        getSupportActionBar().setTitle("Description");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvItemName = findViewById(R.id.tvItemName);
        tvItemPrice = findViewById(R.id.tvItemPrice);
        tvItemDesc = findViewById(R.id.tvItemDesc);
        imgItem = findViewById(R.id.imgItem);

        tvItemName.setText(getIntent().getStringExtra("name"));
        tvItemPrice.setText("Rs."+getIntent().getIntExtra("price", 0));
        tvItemDesc.setText(getIntent().getStringExtra("desc"));

        String imageName = getIntent().getStringExtra("imgName");
        imgItem.setImageResource(getResources().getIdentifier(imageName , "drawable", getPackageName()));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
