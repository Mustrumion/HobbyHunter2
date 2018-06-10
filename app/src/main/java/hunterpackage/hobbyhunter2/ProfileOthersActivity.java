package hunterpackage.hobbyhunter2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;

import hunterpackage.hobbyhunter2.RestUtils.ApiService;
import hunterpackage.hobbyhunter2.RestUtils.ApiUtils;
import hunterpackage.hobbyhunter2.RestUtils.Photo;
import hunterpackage.hobbyhunter2.RestUtils.Token;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileOthersActivity extends AppCompatActivity {

    private ImageView mProfilePic;
    private ApiService mAPIService;
    private Token tokenInfo;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_others);

        mProfilePic = findViewById(R.id.profile_pic);
        layout = findViewById(R.id.layout_others_profile);
        mAPIService = ApiUtils.getAPIService();

        Bundle b = getIntent().getExtras();
        if(b == null){
            return;
        }
        tokenInfo = (Token)(b.getSerializable("tokenInfo"));
        getPhoto(tokenInfo.getUser().getID());
    }


    public void getPhoto(int id) {
        mAPIService.getPhoto(id).enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                if(response.isSuccessful()) {
                    byte[] decodedString = Base64.decode(response.body().getPhotoBase64(), Base64.DEFAULT);
                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                    mProfilePic.setImageBitmap(decodedByte);
                }
                else{
                    Snackbar.make(layout, "Not authorized.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
                Snackbar.make(layout, "Pulling profile data from server failed, are you online?", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
