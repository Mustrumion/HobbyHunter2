package hunterpackage.hobbyhunter2;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import hunterpackage.hobbyhunter2.RestUtils.ApiService;
import hunterpackage.hobbyhunter2.RestUtils.ApiUtils;
import hunterpackage.hobbyhunter2.RestUtils.Profile;
import hunterpackage.hobbyhunter2.RestUtils.Token;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileViewActivity extends AppCompatActivity {

    private ApiService mAPIService;
    private Token tokenInfo;
    private final Profile profile = new Profile();
    private TextView mEmail;
    private EditText mNick;
    private EditText mInterests;
    private CheckBox mInterestsVisible;
    private EditText mDescription;
    private CheckBox mDescriptionVisible;
    private EditText mName;
    private CheckBox mNameVisible;
    private EditText mSurname;
    private CheckBox mSurnameVisible;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);
        configureMap();
        configureViewOthersButton();
        configureSaveButton();
        mAPIService = ApiUtils.getAPIService();

        layout = findViewById(R.id.edit_profile_layout);

        mEmail = findViewById(R.id.email);
        mNick = findViewById(R.id.nick);
        mInterests = findViewById(R.id.interests);
        mInterestsVisible = findViewById(R.id.interestsVisible);
        mName = findViewById(R.id.name);
        mNameVisible = findViewById(R.id.nameVisible);
        mSurname = findViewById(R.id.surname);
        mSurnameVisible = findViewById(R.id.surnameVisible);
        mDescription = findViewById(R.id.description);
        mDescriptionVisible = findViewById(R.id.descriptionVisible);

        Bundle b = getIntent().getExtras();
        if(b == null){
            return;
        }
        tokenInfo = (Token)(b.getSerializable("tokenInfo"));
        if (tokenInfo != null){
            mEmail.setText(tokenInfo.getUser().getEmail());
        }
        getProfile(tokenInfo.getUser().getID());
    }


    private void configureSaveButton(){
        Button saveProfile = findViewById(R.id.save_profile);
        saveProfile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(tokenInfo != null){
                    profile.setUserID(tokenInfo.getUser().getID());
                    profile.setNick(mNick.getText().toString());
                    profile.setSurname(mSurname.getText().toString());
                    profile.setSurnameVisible(mSurnameVisible.isChecked());
                    profile.setName(mName.getText().toString());
                    profile.setNameVisible(mNameVisible.isChecked());
                    profile.setInterests(mInterests.getText().toString());
                    profile.setInterestsVisible(mInterestsVisible.isChecked());
                    profile.setDescription(mDescription.getText().toString());
                    profile.setDescriptionVisible(mDescriptionVisible.isChecked());
                    postProfile(tokenInfo.getUser().getID(), profile);
                }
            }
        });
    }


    private void configureMap(){
        ImageView map = (ImageView) findViewById(R.id.miniMap);
        map.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileViewActivity.this, MapActivity.class));
            }
        });
    }

    private void configureViewOthersButton(){
        Button othersView = (Button) findViewById(R.id.profile_others);
        othersView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileViewActivity.this, ProfileOthersActivity.class));
            }
        });
    }


    private void setProfileForm(Profile newProfile){
        profile.copyDataFrom(newProfile);
        mNick.setText(newProfile.getNick());
        mDescription.setText(newProfile.getDescription());
        mDescriptionVisible.setChecked(newProfile.getDescriptionVisible());
        mInterests.setText(newProfile.getInterests());
        mInterestsVisible.setChecked(newProfile.getInterestsVisible());
        mName.setText(newProfile.getName());
        mNameVisible.setChecked(newProfile.getNameVisible());
        mSurname.setText(newProfile.getSurname());
        mSurnameVisible.setChecked(newProfile.getSurnameVisible());
    }


    public void getProfile(int id) {
        mAPIService.getProfile(id).enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if(response.isSuccessful()) {
                    setProfileForm(response.body());
                }
                else{
                    Snackbar.make(layout, "Not authorized.", Snackbar.LENGTH_LONG)
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

    public void postProfile(int id, final Profile profile) {
        mAPIService.postProfile(id, profile).enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if(response.isSuccessful()) {
                    setProfileForm(response.body());
                }
                else{
                    Snackbar.make(layout, "Not authorized to save this profile.", Snackbar.LENGTH_LONG)
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
}
