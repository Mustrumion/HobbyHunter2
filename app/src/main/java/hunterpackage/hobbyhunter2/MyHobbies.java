package hunterpackage.hobbyhunter2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import hunterpackage.hobbyhunter2.RestUtils.ApiService;
import hunterpackage.hobbyhunter2.RestUtils.ApiUtils;


public class MyHobbies extends Activity {

    private ListView list ;
    private ArrayAdapter<String> adapter ;
    private ApiService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_hobbies);
        mAPIService = ApiUtils.getAPIService();

        list = (ListView) findViewById(R.id.hobbyListView);

        String hobbies[] = {"Dungeons and Dragons", "Munchkin", "Chess", "Warhammer 40000"};

        ArrayList<String> hobbyL = new ArrayList<String>();
        hobbyL.addAll( Arrays.asList(hobbies) );

        adapter = new ArrayAdapter<String>(this, R.layout.hobby_list_layout, hobbyL);

        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                //ListEntry entry= (ListEntry) parent.getAdapter().getItem(position);
                Intent intent = new Intent(MyHobbies.this, MyHobby.class);
                intent.putExtra("HOBBY_NAME", hobbies[position]);
                startActivity(intent);
            }
        });
    }
}
