package hunterpackage.hobbyhunter2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

public class MyHobby extends AppCompatActivity {

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_hobby);
        TextView hobbyName = findViewById(R.id.hobbyNameTextView);
        hobbyName.setText(getIntent().getStringExtra("HOBBY_NAME"));
        name =  getIntent().getStringExtra("HOBBY_NAME");
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyHobby.this, SearchActivity.class);
                intent.putExtra("HOBBY_NAME", name);
                startActivity(intent);
            }
        });
    }
}
