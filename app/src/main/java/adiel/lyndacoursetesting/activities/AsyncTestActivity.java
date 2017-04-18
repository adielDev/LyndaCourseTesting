package adiel.lyndacoursetesting.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import adiel.lyndacoursetesting.R;

public class AsyncTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_test);
    }

    public void startAsync(View view) {

        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();
    }

    private class MyAsyncTask extends AsyncTask<Void,Integer,Void>{


        @Override
        protected Void doInBackground(Void... params) {

            int cycles = 10;

            for (int i = 0; i < cycles; i++) {
                try {
                    Thread.sleep(1000);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Toast.makeText(AsyncTestActivity.this, "values:"+values[0], Toast.LENGTH_SHORT).show();
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
