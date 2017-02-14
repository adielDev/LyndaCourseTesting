package adiel.lyndacoursetesting.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import adiel.lyndacoursetesting.R;

public class InstruTestExample extends AppCompatActivity implements View.OnClickListener {
    private int privateVar=1;
    public int publicVar;
    protected int protectedVar;

    Button btn1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("adiel","inside onCreate privateVar ="+privateVar);
        setContentView(R.layout.activity_instru_test_example);
        Intent intent = getIntent();
        String fromTest = intent.getStringExtra("fromTest");
        if(fromTest!=null){
            Log.e("adiel","fromExtra = "+fromTest);
        }else {
            Log.e("adiel","fromExtra is null ");
        }
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        Log.e("adiel","on create *********************");
        Looper mainLooper = getMainLooper();
        MessageQueue messageQueue = mainLooper.myQueue();
        messageQueue.addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                Log.e("adiel","handler is empty");
                return false;
            }
        });
        String strMsgQ = messageQueue.toString();
        Log.d("adiel","message q "+strMsgQ);
        Handler handler = getWindow().getDecorView().getHandler();

    }

    @Override
    protected void onResume() {
        Log.e("adiel","inside onResume privateVar ="+privateVar);
        Log.e("adiel","before super on resume");
        super.onResume();
        Log.e("adiel","after super on resume");
    }

    @Override
    protected void onPause() {
        Log.e("adiel","inside onPause privateVar ="+privateVar);
        Log.e("adiel","before super on pause");
        super.onPause();
        Log.e("adiel","after super on pause");
    }

    public void showToast(){
        Toast.makeText(this, "4532432432", Toast.LENGTH_SHORT).show();
    }

    public void btn1(View view) {
        //helloTv.setText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Aaaaa", Toast.LENGTH_SHORT).show();
        TextView helloTv = (TextView) findViewById(R.id.helloTv);
        helloTv.setText("aaaaaaaaaaaaaa");
        //Calculator calculator =null;
        //calculator.add(1,2);

    }
}
