package pp.facerecognizer.login;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import io.reactivex.disposables.CompositeDisposable;
import pp.facerecognizer.base.BaseViewModel;
import pp.facerecognizer.utils.rx.BaseSchedulerProvider;

public class LoginViewModel extends BaseViewModel implements LifecycleOwner {

    private BaseSchedulerProvider mSchedulerProvider;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private LifecycleRegistry mLifecycleRegistry;

    LoginViewModel() {
        mLifecycleRegistry = new LifecycleRegistry(this);
        mLifecycleRegistry.markState(Lifecycle.State.CREATED);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }

    @Override
    protected void onStart() {
        mLifecycleRegistry.markState(Lifecycle.State.STARTED);
    }

    @Override
    protected void onStop() {
        mCompositeDisposable.clear();
    }

    void setSchedulerProvider(BaseSchedulerProvider schedulerProvider) {
        mSchedulerProvider = schedulerProvider;
    }
}

