package hunterpackage.hobbyhunter2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ProfileViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);
        configureMap();
        configureViewOthersButton();
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
        Button othersView = (Button) findViewById(R.id.profileOthers);
        othersView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileViewActivity.this, ProfileOthersActivity.class));
            }
        });
    }
}
