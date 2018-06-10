package hunterpackage.hobbyhunter2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        String name = getIntent().getStringExtra("HOBBY_NAME");
        if(name != null){
            TextView searchFor = findViewById(R.id.search_for);
            searchFor.setText("Searching for " + name + " players in your vicinity.");
            TextView interests = findViewById(R.id.common_interests);
            interests.setText(name);
        }


        ImageView image = findViewById(R.id.chat);
        image.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });
    }
}
