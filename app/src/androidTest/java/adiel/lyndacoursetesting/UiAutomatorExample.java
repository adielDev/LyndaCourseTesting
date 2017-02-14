package adiel.lyndacoursetesting;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by recntrek7 on 12/02/17.
 */

@RunWith(AndroidJUnit4.class)
public class UiAutomatorExample {

    @Test
    public void initApp() throws UiObjectNotFoundException, InterruptedException {
        UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        UiSelector selector = new UiSelector().text("WishTrip Staging");
        UiObject uiObject = device.findObject(selector);
            uiObject.clickAndWaitForNewWindow();
            Thread.sleep(2000);
            device.pressBack();
            selector = new UiSelector().text("ok");
            uiObject=device.findObject(selector);
            uiObject.click();


    }
}
