package adiel.lyndacoursetesting;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by recntrek7 on 06/02/17.
 */

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
        return super.getActivityIntent();
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
