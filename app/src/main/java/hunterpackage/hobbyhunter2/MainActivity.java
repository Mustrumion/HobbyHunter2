package hunterpackage.hobbyhunter2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        configureLogOutButton();
        configureMyProfileButton();
        configureMyHobbiesButton();
    }

    private void configureLogOutButton(){
        Button logOutButton = (Button) findViewById(R.id.logOut);
        logOutButton.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
    }
    private void configureMyProfileButton(){
        Button logOutButton = (Button) findViewById(R.id.myProfile);
        logOutButton.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileViewActivity.class));
            }
        });
    }
    private void configureMyHobbiesButton(){
        Button myHobbiesButton = (Button) findViewById(R.id.myHobbies);
        myHobbiesButton.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MyHobbies.class));
            }
        });
    }

}
