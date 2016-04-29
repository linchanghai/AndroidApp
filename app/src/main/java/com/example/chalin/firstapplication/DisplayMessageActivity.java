package com.example.chalin.firstapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    public final String TAG = "DisplayMessageActivity";

    public EditText editText, editText2, editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);

        String name = intent.getStringExtra("name");
        Bundle bundle = intent.getBundleExtra("bundle");
        Integer age = bundle.getInt("age");

        textView.setText(message + "--" + name + "(" + age + ")");

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);
    }

    public void calculate(View view) {
        Intent intent = new Intent();

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        intent.putExtra("editText", editText.getText().toString().trim());
        intent.putExtra("editText2", editText2.getText().toString().trim());
        intent.putExtra("editText3", editText3.getText().toString().trim());

        setResult(1001, intent);
        finish();
    }
}