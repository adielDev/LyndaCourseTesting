package adiel.lyndacoursetesting.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import adiel.lyndacoursetesting.R;
import adiel.lyndacoursetesting.services.MyService;

public class SimpleBoundAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_bound);
        Intent serIntent = new Intent(SimpleBoundAct.this, MyService.class);
        startService(serIntent);
    }
}
