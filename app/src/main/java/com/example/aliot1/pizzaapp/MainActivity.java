package com.example.aliot1.pizzaapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import Adapters.CaptionImageAdapter;
import realmClasses.CostRealmObject;
import realmClasses.RealmObjectConstructor;

public class MainActivity extends AppCompatActivity {

    private  int []captions={R.string.circule_pizza_fat, R.string.square_pizza_fat,
                            R.string.rectangle_pizza_fat, R.string.circule_pizza_tiny,
                            R.string.square_pizza_tiny, R.string.rectangle_pizza_tiny};
    private int[] images={R.drawable.circule_fat, R.drawable.square,
                        R.drawable.rectungle_fat, R.drawable.slaid2pizza,
                        R.drawable.rabstol_net_pizza_15, R.drawable.rectungle};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        testBD();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        CaptionImageAdapter adapter=new CaptionImageAdapter(captions, images);
        recyclerView.setAdapter(adapter);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.choose_basis_for_pizza, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

//    private void testBD(){
//        RealmObjectConstructor objectConstructor = new RealmObjectConstructor(this.getBaseContext());
//        objectConstructor.setCostToDatbase(4);
//        objectConstructor.setCostToDatbase(6);
//       // RealmList<CostRealmObject> list = objectConstructor.getDayCostList();
//        List<CostRealmObject> list =   objectConstructor.getDayCostList();//Realm.getInstance(getApplicationContext()).allObjects(CostRealmObject.class);
//        for (CostRealmObject cost : list){
//            System.out.print(cost.getCost());
//            Log.i("SQLite", cost.getCost().toString());
//        }
//        objectConstructor.closeRealm();
//    }


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
