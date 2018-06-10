package hunterpackage.hobbyhunter2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.ByteArrayInputStream;

import hunterpackage.hobbyhunter2.RestUtils.ApiService;
import hunterpackage.hobbyhunter2.RestUtils.ApiUtils;
import hunterpackage.hobbyhunter2.RestUtils.Photo;
import hunterpackage.hobbyhunter2.RestUtils.Profile;
import hunterpackage.hobbyhunter2.RestUtils.Token;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mAccount;
    private Token tokenInfo;
    private CoordinatorLayout layout;
    private ImageView mProfilePic;
    private ApiService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        layout = findViewById(R.id.main_layout);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "No messages received.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        configureLogOutButton();
        configureMyProfileButton();
        configureMyHobbiesButton();
        configureSearchButton();

        mAccount = findViewById(R.id.accountName);
        mProfilePic = findViewById(R.id.profile_pic);

        mAPIService = ApiUtils.getAPIService();

        Bundle b = getIntent().getExtras();
        if(b == null){
            return;
        }
        tokenInfo = (Token)(b.getSerializable("tokenInfo"));
        if (tokenInfo != null){
            mAccount.setText("Logged as:\n" + tokenInfo.getUser().getEmail());
        }
        getPhoto(tokenInfo.getUser().getID());
    }

    private void configureLogOutButton(){
        Button logOutButton = findViewById(R.id.logOut);
        logOutButton.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
    }

    private void configureSearchButton(){
        Button searchButton = findViewById(R.id.search);
        searchButton.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });
    }


    private void configureMyProfileButton(){
        Button logOutButton = findViewById(R.id.myProfile);
        logOutButton.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(MainActivity.this, ProfileViewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("tokenInfo", tokenInfo);
                newIntent.putExtras(bundle);
                startActivity(newIntent);
            }
        });
    }
    private void configureMyHobbiesButton(){
        Button myHobbiesButton = findViewById(R.id.myHobbies);
        myHobbiesButton.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MyHobbies.class));
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
                    Snackbar.make(layout, "No photo", Snackbar.LENGTH_LONG)
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
