package adiel.lyndacoursetesting;

import android.content.Intent;
import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

import adiel.lyndacoursetesting.services.MyService;

/**
 * Created by recntrek7 on 06/02/17.
 */


@RunWith(AndroidJUnit4.class)
public class MyServiceTest {

    @Rule
    public ServiceTestRule myServiceRule = new ServiceTestRule();

    @Test
    public void testService() throws TimeoutException {
        myServiceRule.startService(new Intent(InstrumentationRegistry.getTargetContext(), MyService.class));
    }

    @Test
    public void testBoundService() throws TimeoutException {
        IBinder binder = myServiceRule.bindService(new Intent(InstrumentationRegistry.getTargetContext(),MyService.class));
        MyService.LocalBinder localBinder = (MyService.LocalBinder) binder;
        MyService service = localBinder.getService();

        assertNotNull("bound service is null",service);

    }
}
