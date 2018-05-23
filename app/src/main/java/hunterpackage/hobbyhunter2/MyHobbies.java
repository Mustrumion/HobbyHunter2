package hunterpackage.hobbyhunter2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class MyHobbies extends Activity {

    private ListView list ;
    private ArrayAdapter<String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_hobbies);

        list = (ListView) findViewById(R.id.hobbyListView);

        String cars[] = {"Board Games", "Role play games", "Decoupage", "Skydiving"};

        ArrayList<String> carL = new ArrayList<String>();
        carL.addAll( Arrays.asList(cars) );

        adapter = new ArrayAdapter<String>(this, R.layout.hobby_list_layout, carL);

        list.setAdapter(adapter);
    }
}
