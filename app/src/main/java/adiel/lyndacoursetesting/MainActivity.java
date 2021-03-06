package adiel.lyndacoursetesting;

import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;

import adiel.lyndacoursetesting.logs.MyLogger;

public class MainActivity extends AppCompatActivity {
    Map<String,String> classMap;
    String[] entries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.isLoggable("d")

        ListView lv = (ListView) findViewById(R.id.lv);
        final String[] entries = getResources().getStringArray(R.array.mainlist);
        final Map<String,String>  classMap = getHashMapResource(getApplicationContext(),R.xml.confgs);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                String className = entries[position];
                String classString = classMap.get(className);
                try {
                    Class<?> activity = Class.forName(classString);
                    intent.setClass(getApplicationContext(), activity);
                    startActivity(intent);
                }catch (Exception e){
                    if(e instanceof NullPointerException){
                        Log.e("adiel","className or classString is null");
                    }else  if(e instanceof ClassNotFoundException){
                        Log.e("adiel","activity not exist or not declare in manifest");
                    }else {
                        Log.e("adiel","not expected exception");
                    }
                    e.printStackTrace();

                }


            }
        });
        Log.e("adiel","MainActivity:onCReate");
        MyLogger.log("onCReate");
    }


    public static Map<String,String> getHashMapResource(Context c, int hashMapResId) {
        Map<String,String> map = null;
        XmlResourceParser parser = c.getResources().getXml(hashMapResId);

        String key = null, value = null;

        try {
            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_DOCUMENT) {
                    Log.d("utils","Start document");
                } else if (eventType == XmlPullParser.START_TAG) {
                    if (parser.getName().equals("map")) {
                        boolean isLinked = parser.getAttributeBooleanValue(null, "linked", false);

                        map = isLinked ? new LinkedHashMap<String, String>() : new HashMap<String, String>();
                    } else if (parser.getName().equals("entry")) {
                        key = parser.getAttributeValue(null, "key");

                        if (null == key) {
                            parser.close();
                            return null;
                        }
                    }
                } else if (eventType == XmlPullParser.END_TAG) {
                    if (parser.getName().equals("entry")) {
                        map.put(key, value);
                        key = null;
                        value = null;
                    }
                } else if (eventType == XmlPullParser.TEXT) {
                    if (null != key) {
                        value = parser.getText();
                    }
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return map;
    }



    @Override
    protected void onDestroy() {
        MyLogger.log("MainActivity:onDestroy");
        Log.d("adiel","MainActivity:onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
       // Log.isLoggable("d", Log.DEBUG);
        MyLogger.log("onResume");
        Log.d("adiel","MainActivity:onResume ,IS LOGGABLE");
        //registerReceiver(broadcastReceiver,intentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        MyLogger.log("onPause");
        Log.d("adiel","MainActivity:onPause");
    }
}
