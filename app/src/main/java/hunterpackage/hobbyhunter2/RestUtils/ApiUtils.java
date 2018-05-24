package hunterpackage.hobbyhunter2.RestUtils;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://192.168.172.2:6666/"; //IP address of your computer for emulator
    public static final long TIMEOUT = 120; //timeout, set high for debugging purpose

    public static ApiService getAPIService() {

        return RetrofitClient.getClient(BASE_URL,TIMEOUT).create(ApiService.class);
    }
}
