package pp.facerecognizer.login;

import androidx.annotation.NonNull;
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
    public MutableLiveData<String> mName = new MutableLiveData<>();
    public MutableLiveData<String> mCode = new MutableLiveData<>();
    public MutableLiveData<String> mPassword = new MutableLiveData<>();
    public MutableLiveData<Boolean> mUserFirstCode = new MutableLiveData<>();

    LoginViewModel(LoginRepository repository) {
        mLifecycleRegistry = new LifecycleRegistry(this);
        mLifecycleRegistry.markState(Lifecycle.State.CREATED);
        mLoginRepository = repository;
        mUserFirstCode.setValue(false);
    }

    public void login(String name, String code, String password, boolean isUseFirstCode) {
        Disposable disposable = mLoginRepository
                .login(name, code, password, isUseFirstCode)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(images -> {

        }, throwable -> {

        });
        mCompositeDisposable.add(disposable);
    }

    public void onCheckedChanged(boolean isCheck) {
        mUserFirstCode.setValue(isCheck);
    }

    public void onClickLoginButtonListener() {
        login(mName.getValue(), mCode.getValue(), mPassword.getValue(),
                mUserFirstCode.getValue());
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

