package hunterpackage.hobbyhunter2.RestUtils;

public class ApiUtils {

    private ApiUtils() {}

    //public static final String BASE_URL = "http://localhost:6666/";
    //    public static final String BASE_URL = "http://192.168.172.2:6666/";
    //    public static final String BASE_URL = "http://192.168.0.11:6666/";
    public static final String BASE_URL = "http://192.168.0.101:8080/";
    //public static final String BASE_URL = "http://10.160.34.182:6666/";
    public static final long TIMEOUT = 120; //timeout, set high for debugging purpose

    public static ApiService getAPIService() {

        return RetrofitClient.getClient(BASE_URL,TIMEOUT).create(ApiService.class);
    }
}
