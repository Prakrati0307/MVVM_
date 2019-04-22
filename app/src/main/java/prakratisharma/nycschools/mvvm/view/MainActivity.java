package prakratisharma.nycschools.mvvm.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import prakratisharma.nycschools.mvvm.R;
import prakratisharma.nycschools.mvvm.model.SchoolDetails;
import prakratisharma.nycschools.mvvm.viewmodel.SchoolViewModel;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SchoolAdapter adapter;


     TextView schoolNameTV;
    String schoolStr;
    private static final String TAG = "MainActivity";
    public static String SCHOOL_DETAILS_INTENT_KEY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SchoolViewModel  model = ViewModelProviders.of(this).get(SchoolViewModel.class);

        model.getSchoolDetail().observe(this, new Observer<List<SchoolDetails>>() {
            @Override
            public void onChanged(@Nullable final List<SchoolDetails> schoolDetailsList) {
                adapter = new SchoolAdapter(MainActivity.this, schoolDetailsList);
                recyclerView.setAdapter(adapter);
                adapter.setClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                       schoolNameTV = v.findViewById(R.id.school_name);
                        schoolStr = schoolNameTV.getText().toString();
                        Log.d(TAG, "onClick: "+schoolDetailsList.get(0));
                        ///
                       // makeSchoolDetailActivityCall();
                        SchoolDetails schoolDetail = schoolDetailsList.get(0);
                        Intent intent = new Intent(MainActivity.this, SchoolDetailActivity.class);
                        intent.putExtra(SCHOOL_DETAILS_INTENT_KEY, (Serializable) schoolDetail);
                        startActivity(intent);

                    }
                });
            }
        });

    }



}
