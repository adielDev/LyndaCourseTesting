package adiel.lyndacoursetesting.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new LocalBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("adiel","onStartCommand MyService");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        Log.e("adiel","onCreate MyService");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.e("adiel","onDestroy MyService");
        super.onDestroy();

    }
    public class LocalBinder extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }
}
