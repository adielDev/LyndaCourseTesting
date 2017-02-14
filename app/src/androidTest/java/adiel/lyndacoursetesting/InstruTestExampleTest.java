package adiel.lyndacoursetesting;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import adiel.lyndacoursetesting.activities.Calculator;
import adiel.lyndacoursetesting.activities.InstruTestExample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by recntrek7 on 06/02/17.
 */

@RunWith(AndroidJUnit4.class)
public class InstruTestExampleTest {
    @Rule
    public InstruTestExampleRule<InstruTestExample> activityTest = new InstruTestExampleRule<InstruTestExample>(InstruTestExample.class);

    @Test
    public void testUI(){//3680  3679
     //   InstruTestExample activity = activityTest.getActivity();
     //   assertNotNull(activity);
        //activity.onCreate(new Bundle());
        //activity.onCreate();
//        InstruTestExample instruTestExample = activity;
//        //instruTestExample.showToast();
//        Context appContext = InstrumentationRegistry.getTargetContext();
//        //Toast.makeText(appContext, "aaaaa", Toast.LENGTH_SHORT).show();
//        assertNotNull(activity.findViewById(R.id.helloTv));
//        TextView textView = (TextView) activity.findViewById(R.id.helloTv);
//        assertEquals("hello world",textView.getText());
    }
    @Test
    @Ignore
    public void testWithUiAutomator() throws UiObjectNotFoundException, InterruptedException {
        UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        //uiDevice.pressHome();
        openApp(uiDevice);
        Thread.sleep(200);
        startRecord(uiDevice);
        Thread.sleep(2000);
    }

    private void startRecord(UiDevice uiDevice) {
        UiSelector recBtnSelector = new UiSelector();
        recBtnSelector.index(2);
        UiObject recBtn = uiDevice.findObject(recBtnSelector);
        try {
            recBtn.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void openApp(UiDevice uiDevice){
        UiSelector uiSelector = new UiSelector();
        uiSelector.index(0);
        UiObject uiObject = uiDevice.findObject(uiSelector);
        boolean exists = uiObject.exists();
        assertEquals(true,exists);
        try {
            uiObject.clickAndWaitForNewWindow();
            String text = uiObject.getText();
            Log.e("adiel","btn1-text :"+text+" exist:"+exists);

        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    @Ignore
    public void mockTest(){
        //Calculator calculator =Mockito.Mock(Calculator.class);
        Calculator mock = Mockito.mock(Calculator.class);
        int add = mock.add(3, 4);
        assertEquals(7,add);
    }
}
