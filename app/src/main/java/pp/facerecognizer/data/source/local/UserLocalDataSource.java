package pp.facerecognizer.data.source.local;

import android.content.Context;

import pp.facerecognizer.data.source.UserDataSource;

/**
 * Created by CuD HniM on 18/10/03.
 */
public class UserLocalDataSource implements UserDataSource.UserLocalDataSource {
    private static UserLocalDataSource sInstance;
    private Context mContext;
    private ImageDAO mImageDAO;

    private UserLocalDataSource(Context context) {
        mContext = context;
//        mImageDAO = imageDAO;
    }

    public static synchronized UserLocalDataSource getsInstance(
            Context context) {
        if (sInstance == null) {
            synchronized (UserLocalDataSource.class) {
                if (sInstance == null) {
                    sInstance = new UserLocalDataSource(context);
                }
            }
        }
        return sInstance;
    }

}
