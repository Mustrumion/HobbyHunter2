package hunterpackage.hobbyhunter2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import hunterpackage.hobbyhunter2.RestUtils.ApiService;
import hunterpackage.hobbyhunter2.RestUtils.ApiUtils;
import hunterpackage.hobbyhunter2.RestUtils.Photo;
import hunterpackage.hobbyhunter2.RestUtils.Profile;
import hunterpackage.hobbyhunter2.RestUtils.Token;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileOthersActivity extends AppCompatActivity {

    private ImageView mProfilePic;
    private ApiService mAPIService;
    private Token tokenInfo;
    private ConstraintLayout layout;
    private TextView mNick;
    private TextView mInterests;
    private TextView mName;
    private TextView mSurname;
    private TextView mDescription;
    private TextView mInterestsLabel;
    private TextView mNameLabel;
    private TextView mSurnameLabel;
    private TextView mDescriptionLabel;
    private final Profile profile = new Profile();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_others);

        mProfilePic = findViewById(R.id.profile_pic);
        layout = findViewById(R.id.layout_others_profile);
        mAPIService = ApiUtils.getAPIService();


        mNick = findViewById(R.id.nick);
        mInterestsLabel = findViewById(R.id.interests_label);
        mInterests = findViewById(R.id.interests);
        mNameLabel = findViewById(R.id.name_label);
        mName = findViewById(R.id.name);
        mSurnameLabel = findViewById(R.id.surname_label);
        mSurname = findViewById(R.id.surname);
        mDescriptionLabel = findViewById(R.id.description_label);
        mDescription = findViewById(R.id.description);

        Bundle b = getIntent().getExtras();
        if(b == null){
            return;
        }
        tokenInfo = (Token)(b.getSerializable("tokenInfo"));
        getProfile(tokenInfo.getUser().getID());
        getPhoto(tokenInfo.getUser().getID());
    }

    private void setProfileForm(Profile newProfile){
        profile.copyDataFrom(newProfile);
        mNick.setText(newProfile.getNick());
        mDescription.setText(newProfile.getDescription());
        if(!newProfile.getDescriptionVisible()){
            mDescription.setVisibility(View.GONE);
            mDescriptionLabel.setVisibility(View.GONE);
        }
        mInterests.setText(newProfile.getInterests());
        if(!newProfile.getInterestsVisible()){
            mInterests.setVisibility(View.GONE);
            mInterestsLabel.setVisibility(View.GONE);
        }
        mName.setText(newProfile.getName());
        if(!newProfile.getNameVisible()){
            mName.setVisibility(View.GONE);
            mNameLabel.setVisibility(View.GONE);
        }
        mSurname.setText(newProfile.getSurname());
        if(!newProfile.getSurnameVisible()){
            mSurname.setVisibility(View.GONE);
            mSurnameLabel.setVisibility(View.GONE);
        }
    }

    public void getProfile(int id) {
        mAPIService.getProfile(id).enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if(response.isSuccessful()) {
                    setProfileForm(response.body());
                }
                else{
                    Snackbar.make(layout, "No profile data.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                Snackbar.make(layout, "Pulling profile data from server failed, are you online?", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
                    Snackbar.make(layout, "No photo.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
                Snackbar.make(layout, "Pulling picture from server failed, are you online?", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
