package pp.facerecognizer.login;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import pp.facerecognizer.base.BaseViewModel;
import pp.facerecognizer.data.repository.LoginRepository;
import pp.facerecognizer.utils.rx.BaseSchedulerProvider;

public class LoginViewModel extends BaseViewModel implements LifecycleOwner {

    private BaseSchedulerProvider mSchedulerProvider;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private LifecycleRegistry mLifecycleRegistry;
    private LoginRepository mLoginRepository;
    private Context mContext;
    public MutableLiveData<String> mName = new MutableLiveData<>();
    public MutableLiveData<String> mCode = new MutableLiveData<>();
    public MutableLiveData<String> mPassword = new MutableLiveData<>();
    public MutableLiveData<Boolean> mUserFirstCode = new MutableLiveData<>();
    public ObservableField<Boolean> mIsLoading = new ObservableField<>();

    LoginViewModel(Context context, LoginRepository repository) {
        mLifecycleRegistry = new LifecycleRegistry(this);
        mLifecycleRegistry.markState(Lifecycle.State.CREATED);
        mLoginRepository = repository;
        mIsLoading.set(false);
        mUserFirstCode.setValue(false);
        mContext = context;
    }

    public void login(String name, String code, String password, boolean isUseFirstCode) {
        Disposable disposable = mLoginRepository.login(name, code, password, isUseFirstCode)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe( user -> {
                    Log.d("DATAAAAAAAAAA", user + "");
                    mIsLoading.set(false);
                    enableTouch();
                }, throwable -> {
                    mIsLoading.set(false);
                    enableTouch();
                });
        mCompositeDisposable.add(disposable);
    }

    public void onCheckedChanged(boolean isCheck) {
        mUserFirstCode.setValue(isCheck);
    }

    public void onClickLoginButtonListener() {
        mIsLoading.set(true);
        disableTouch();
        login(mName.getValue(), mCode.getValue(), mPassword.getValue(), mUserFirstCode.getValue());
    }

    private void disableTouch() {
        ((Activity) mContext).getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    private void enableTouch() {
        ((Activity) mContext).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
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

