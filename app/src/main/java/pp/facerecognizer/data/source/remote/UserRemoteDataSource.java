package pp.facerecognizer.data.source.remote;

import android.util.Log;

import io.reactivex.Single;
import pp.facerecognizer.data.api.ApiClient;
import pp.facerecognizer.data.api.ApiInterface;
import pp.facerecognizer.data.model.LoginResponseModel;
import pp.facerecognizer.data.source.UserDataSource;

/**
 * Created by CuD HniM on 18/09/25.
 */
public class UserRemoteDataSource implements UserDataSource.UserRemoteDataSource {

    private static final int NUMBER_RANDOM = 10;
    private static UserRemoteDataSource sInstance;

    public static synchronized UserRemoteDataSource getsInstance() {
        if (sInstance == null) {
            synchronized (UserRemoteDataSource.class) {
                if (sInstance == null) {
                    sInstance = new UserRemoteDataSource();
                }
            }
        }
        return sInstance;
    }


    @Override
    public Single<LoginResponseModel> login(String name, String code, String password,
                                            boolean isUseFirstCode) {
        return createApiInterface().login(name,code,password,isUseFirstCode);
    }


    private ApiInterface createApiInterface() {
        return ApiClient.getInstance().create(ApiInterface.class);
    }
}
