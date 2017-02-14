package adiel.lyndacoursetesting;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityUnitTestCase;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.model.Statement;

import java.lang.reflect.Field;

import adiel.lyndacoursetesting.activities.Calculator;
import adiel.lyndacoursetesting.activities.InstruTestExample;

/**
 * Created by recntrek7 on 09/02/17.
 */
@RunWith(AndroidJUnit4.class)
public class MyActivityTest {

    public class InstruTestExampleRule<A extends Activity> extends ActivityTestRule<A> {


        public InstruTestExampleRule(Class<A> activityClass) {
            super(activityClass);
            Log.e("adiel","InstruTestExampleRule ");
        }

        public InstruTestExampleRule(Class<A> activityClass, boolean initialTouchMode) {
            super(activityClass, initialTouchMode);
            Log.e("adiel","InstruTestExampleRule2 ");
        }

        public InstruTestExampleRule(Class<A> activityClass, boolean initialTouchMode, boolean launchActivity) {
            super(activityClass, initialTouchMode, launchActivity);
        }

        @Override
        protected Intent getActivityIntent() {
            Log.e("adiel"," getActivityIntent");
            Intent activityIntent = super.getActivityIntent();
            activityIntent.putExtra("fromTest","fromTest");
            return activityIntent;
        }

        @Override
        protected boolean shouldRunOnUiThread(Description description) {
            return super.shouldRunOnUiThread(description);
        }

        @Override
        public void runOnUiThread(Runnable runnable) throws Throwable {
            super.runOnUiThread(runnable);
        }

        @Override
        protected void beforeActivityLaunched() {
            Log.e("adiel","beforeActivityLaunched ");
            super.beforeActivityLaunched();



        }

        @Override
        protected void afterActivityLaunched() {
            Log.e("adiel","afterActivityLaunched ");
            super.afterActivityLaunched();
            InstruTestExample activity1 = activityTest.getActivity();
            try {
                Field privateVar = activity1.getClass().getDeclaredField("privateVar");
                privateVar.setAccessible(true);
                privateVar.set(activity1,2);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void afterActivityFinished() {
            Log.e("adiel","afterActivityFinished ");
            super.afterActivityFinished();
        }

        @Override
        public A getActivity() {
            Log.e("adiel","getActivity ");
            return super.getActivity();
        }

        @Override
        public Statement apply(Statement base, Description description) {
            Log.e("adiel","apply ");
            return super.apply(base, description);
        }

        @Override
        public A launchActivity(@Nullable Intent startIntent) {
            Log.e("adiel","launchActivity ");
            return super.launchActivity(startIntent);
        }
    }

    @Rule
    public InstruTestExampleRule<InstruTestExample> activityTest = new InstruTestExampleRule<InstruTestExample>(InstruTestExample.class);

    @Test
    public void initActivity  (){
        Log.e("adiel","inside initActivity ???????????????");
        final Instrumentation instr = InstrumentationRegistry.getInstrumentation();
    //    activityTest.launchActivity(new Intent());
//        Looper mainLooper = activityTest.getActivity().getMainLooper();
//        Handler handler = new Handler(mainLooper);
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                //instr.callActivityOnResume(activityTest.getActivity());
//               // instr.callActivityOnCreate(activityTest.getActivity(),null);
//            }
//        });

    }
  @Test
    public void afterInitActivity  (){

    }

}
