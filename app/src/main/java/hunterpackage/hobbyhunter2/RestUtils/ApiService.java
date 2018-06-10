package hunterpackage.hobbyhunter2.RestUtils;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @POST("/users")
    Call<User> saveUser(@Body User user);
    @POST("/login")
    Call<Token> logIn(@Body User user);

    @GET("/users/{id}/profile")
    Call<Profile> getProfile(@Path("id") int id);
    @POST("/users/{id}/profile")
    Call<Profile> postProfile(@Path("id") int id, @Body Profile profile);

    @GET("/users/{id}/photo")
    Call<Photo> getPhoto(@Path("id") int id);
    @POST("/users/{id}/photo")
    Call<Photo> postPhoto(@Path("id") int id, @Body Photo photo);
}
