package pp.facerecognizer.data.repository;

import io.reactivex.Single;
import pp.facerecognizer.data.model.LoginResponseModel;
import pp.facerecognizer.data.source.local.UserLocalDataSource;
import pp.facerecognizer.data.source.remote.UserRemoteDataSource;

/**
 * Created by CuD HniM on 18/10/03.
 */
public class LoginRepository {

    private static LoginRepository sInstance;
    private UserRemoteDataSource mRemoteDataSource;
    private UserLocalDataSource mLocalDataSource;

    public LoginRepository(UserRemoteDataSource remoteDataSource,
                           UserLocalDataSource localDataSource) {
        mRemoteDataSource = remoteDataSource;
        mLocalDataSource = localDataSource;
    }

    public static synchronized LoginRepository getsInstance(
            UserRemoteDataSource imageRemoteDataSource,
            UserLocalDataSource imageLocalDataSource) {
        if (sInstance == null) {
            synchronized (UserRemoteDataSource.class) {
                if (sInstance == null) {
                    sInstance = new LoginRepository(imageRemoteDataSource, imageLocalDataSource);
                }
            }
        }
        return sInstance;
    }

    public Single<LoginResponseModel> login(String name, String code, String password,
                                            boolean isUseFirstCode) {
        return mRemoteDataSource.login(name, code, password, isUseFirstCode);
    }

}
