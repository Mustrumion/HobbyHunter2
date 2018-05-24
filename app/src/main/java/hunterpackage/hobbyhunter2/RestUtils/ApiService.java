package hunterpackage.hobbyhunter2.RestUtils;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @POST("/users")
    Call<User> saveUser(@Body User user);
}
