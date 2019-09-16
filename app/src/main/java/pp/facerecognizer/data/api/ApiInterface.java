package pp.facerecognizer.data.api;

import io.reactivex.Single;
import pp.facerecognizer.data.model.LoginResponseModel;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("users/loginStudent")
    Single<LoginResponseModel> login (@Field("name") String name, @Field("code") String code,
                                      @Field("password") String password,
                                      @Field("use_first_code") boolean userFirstCode);
//
//    @GET("collections")
//    Single<List<Collection>> getCollections(@Query("page") int page, @Query("client_id") String apiKey);
//
//    @GET("photos")
//    Single<List<Image>> getNewImage(@Query("page") int page, @Query("client_id") String apiKey);
//
//    @GET("collections/{id}/photos")
//    Single<List<Image>> getCollectionDetails(@Path("id") int id, @Query("page") int page, @Query("client_id") String apiKey);
//
//    @GET("search/collections")
//    Single<SearchRespond> searchCollection(@Query("page") int page, @Query("query") String query, @Query("client_id") String apiKey);
}
