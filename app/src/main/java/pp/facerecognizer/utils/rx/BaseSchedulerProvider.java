package pp.facerecognizer.utils.rx;


import androidx.annotation.NonNull;
import io.reactivex.Scheduler;

/**
 * Created by le.quang.dao on 29/03/2017.
 * Allow providing different types of {@link Scheduler}.
 */

public interface BaseSchedulerProvider {

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}
