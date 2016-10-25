package work.vuong.oktober;

import android.app.Application;
import android.util.Log;

import io.realm.Realm;
import io.realm.log.AndroidLogger;
import io.realm.log.RealmLog;

/**
 * Created by oberon (vuongpham) on 25/10/2016.
 */

public class OkApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmLog.add(new AndroidLogger(Log.VERBOSE));
    }
}
