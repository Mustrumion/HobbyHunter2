package hunterpackage.hobbyhunter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MyHobby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_hobby);
        TextView hobbyName = findViewById(R.id.hobbyNameTextView);
        hobbyName.setText(getIntent().getStringExtra("HOBBY_NAME"));
    }
}
