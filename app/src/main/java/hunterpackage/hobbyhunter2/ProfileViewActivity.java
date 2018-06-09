package hunterpackage.hobbyhunter2;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.InvocationTargetException;

import hunterpackage.hobbyhunter2.RestUtils.ApiService;
import hunterpackage.hobbyhunter2.RestUtils.Profile;
import hunterpackage.hobbyhunter2.RestUtils.Token;
import hunterpackage.hobbyhunter2.RestUtils.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.apache.commons.beanutils.BeanUtils.copyProperties;

public class ProfileViewActivity extends AppCompatActivity {

    private ApiService mAPIService;
    private Token tokenInfo;
    private Profile profile;
    private TextView mEmail;
    private EditText mNick;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);
        configureMap();
        configureViewOthersButton();
        configureSaveButton();

        layout = findViewById(R.id.edit_profile_layout);

        mEmail = findViewById(R.id.email);
        mNick = findViewById(R.id.nick);
        profile = new Profile();

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



    public void getProfile(int id) {
        mAPIService.getProfile(id).enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if(response.isSuccessful()) {
                    mNick.setText(response.body().getNick());
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

    public void postProfile(int id, Profile profile) {
        mAPIService.postProfile(id, profile).enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if(response.isSuccessful()) {
                    try {
                        copyProperties(response.body(), profile);
                    } catch (Exception e) {
                        Snackbar.make(layout, "Exception copying data from response.", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                    mNick.setText(profile.getNick());
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
