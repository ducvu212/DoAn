package pp.facerecognizer.login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import pp.facerecognizer.R;
import pp.facerecognizer.data.repository.LoginRepository;
import pp.facerecognizer.data.source.local.UserLocalDataSource;
import pp.facerecognizer.data.source.remote.UserRemoteDataSource;
import pp.facerecognizer.databinding.ActivityLoginBinding;
import pp.facerecognizer.utils.rx.SchedulerProvider;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel mLoginViewModel;
    private ActivityLoginBinding mActivityLoginBinding;
    private boolean mUserFirstCode;

    @Override
    protected void onStart() {
        super.onStart();
        mLoginViewModel.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        mLoginViewModel = new LoginViewModel(new LoginRepository(UserRemoteDataSource.getsInstance(), UserLocalDataSource.getsInstance(this)));
        mLoginViewModel.setSchedulerProvider(SchedulerProvider.getInstance());
        mActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mActivityLoginBinding.setViewModel(mLoginViewModel);
        mActivityLoginBinding.executePendingBindings();
//        mActivityLoginBinding.setHandler(new LoginHandler());
    }


    @Override
    protected void onStop() {
        mLoginViewModel.onStop();
        super.onStop();
    }


    public class LoginHandler {


    }
}

