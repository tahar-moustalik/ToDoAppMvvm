package com.moustalik.tahar.todoappmvvm;

import android.os.Bundle;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView tachesView;
    private BottomSheetBehavior sheetBehavior;
    private LinearLayout bottom_sheet;
    private TacheAdapter mTacheAdapter;
    private EditText mTacheEditText;
    private Button mAddTacheBtn;
    private TacheViewModel tacheViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAddTacheBtn = findViewById(R.id.btn_save_tache);
        bottom_sheet = findViewById(R.id.bottom_sheet);
        mTacheEditText = bottom_sheet.findViewById(R.id.et_tache);
        sheetBehavior = BottomSheetBehavior.from(bottom_sheet);
        tacheViewModel = TacheViewModel.getInstance(getApplication());
        tachesView = findViewById(R.id.taches_list);
        tachesView.setHasFixedSize(true);
        ArrayList<Tache> ts = new ArrayList<>();
        ts.add(new Tache(0,"T1",false));
        tachesView.setLayoutManager(new LinearLayoutManager(this));
        for (Tache t : tacheViewModel.getTaches().getValue()) {
            Log.i("TACHELT", t.getTache());
        }
        mTacheAdapter = new TacheAdapter(getApplicationContext(),ts);
        tachesView.setAdapter(mTacheAdapter);
        FloatingActionButton fab = findViewById(R.id.btn_add_tache);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                } else {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

                }
            }

        });

        tacheViewModel.getTaches().observe(this, new Observer<List<Tache>>() {
            @Override
            public void onChanged(List<Tache> taches) {
                mTacheAdapter.setTaches(taches);
                mTacheAdapter.notifyDataSetChanged();
            }
        });

        mAddTacheBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"ADded" + mTacheEditText.getText().toString(),Toast.LENGTH_LONG).show();
                tacheViewModel.insert(new Tache(0,mTacheEditText.getText().toString(),false));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
