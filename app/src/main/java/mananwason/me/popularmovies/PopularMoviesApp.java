package mananwason.me.popularmovies;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;

/**
 * Created by Manan Wason on 16/09/16.
 */
public class PopularMoviesApp extends Application {
    static Handler handler;

    private static Bus eventBus;

    public static Bus getEventBus() {
        if (eventBus == null) {
            eventBus = new Bus();
        }
        return eventBus;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler(Looper.getMainLooper());
        getEventBus().register(this);

    }

    public static void postEventOnUIThread(final Object event) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                getEventBus().post(event);
            }
        });
    }

}
