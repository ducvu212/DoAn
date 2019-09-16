package pp.facerecognizer.data.source;

import io.reactivex.Single;
import pp.facerecognizer.data.model.LoginResponseModel;

/**
 * Created by CuD HniM on 18/10/03.
 */
public interface UserDataSource {

    /**
     * Local
     */

    interface UserLocalDataSource {

    }

    /**
     * Remote
     */
    interface UserRemoteDataSource {
      Single<LoginResponseModel> login(String name, String code, String password,
                                       boolean isUseFirstCode);
    }
}
