package com.jx372.getresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CallerActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_DIALOGACTIVITY = 2;
    private static final int REQUEST_CODE_CALLEEACTIVITY = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caller);

        findViewById(R.id.btnCallee).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CallerActivity.this,CalleeActivity.class);
                startActivityForResult(intent,REQUEST_CODE_CALLEEACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode == REQUEST_CODE_CALLEEACTIVITY){
            if(resultCode == Activity.RESULT_OK){
                int dataNumber = intent.getIntExtra("data-number",-1);
                String dataString = intent.getStringExtra("data-string");

                String data = "data number: " + dataNumber + "\ndata-string: " + dataString;
                ((TextView)findViewById(R.id.tvData)).setText(data);
            }
        }else if( requestCode == REQUEST_CODE_DIALOGACTIVITY){

        }else{

        }
    }
}
