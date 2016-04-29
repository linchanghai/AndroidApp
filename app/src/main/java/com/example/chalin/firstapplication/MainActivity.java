package com.example.chalin.firstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.chalin.firstapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == 1001)
        {
            EditText editText = (EditText) findViewById(R.id.edit_message);
            String message = data.getStringExtra("editText") + data.getStringExtra("editText2");
            editText.setText(message);
        }
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra("name", "Chunk");
        Bundle bundle = new Bundle();
        bundle.putInt("age", 25);
        intent.putExtra("bundle", bundle);
//        startActivity(intent);
        startActivityForResult(intent, 1000);
    }
}
