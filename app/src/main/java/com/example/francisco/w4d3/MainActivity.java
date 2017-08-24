package com.example.francisco.w4d3;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.francisco.w4d3.model.Dishes;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends Activity {

    private static final String PROVIDER_NAME = "androidcontentproviderdemo.androidcontentprovider.dishes";
    private static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/food");
    private static final String TAG = "MainActivity";

    @BindView(R.id.recyclerDishes)
    RecyclerView recyclerDishes;

    @BindView(R.id.etName)
    TextView etName;

    @BindView(R.id.etRegion)
    TextView etRegion;

    @BindView(R.id.etType)
    TextView etType;

    @BindView(R.id.etURL)
    TextView etURL;

    @BindView(R.id.etDesc)
    TextView edtDishDesc;

    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    DishesListAdapter dishesListAdapter;

    ArrayList<Dishes> dishesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);


        recyclerDishes.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        layoutManager = new LinearLayoutManager(getApplicationContext());
        itemAnimator = new DefaultItemAnimator();
        recyclerDishes.setLayoutManager(layoutManager);
        recyclerDishes.setItemAnimator(itemAnimator);

        refreshValuesFromContentProvider();
        
        //initialize the adapter
        dishesListAdapter = new DishesListAdapter(dishesList);
        recyclerDishes.setAdapter(dishesListAdapter);

        dishesListAdapter.notifyDataSetChanged();

    }

    private void refreshValuesFromContentProvider() {

        Cursor cursor = getContentResolver().query(CONTENT_URI,null,null,null,null);

        int hasPhone = 0;

        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){

                String DISH_NAME = cursor.getString(cursor.getColumnIndex("DISH_NAME"));
                String DISH_REGION = cursor.getString(cursor.getColumnIndex("DISH_REGION"));
                String DISH_TYPE = cursor.getString(cursor.getColumnIndex("DISH_TYPE"));
                String DISH_URL = cursor.getString(cursor.getColumnIndex("DISH_URL"));
                String DISH_DESC = cursor.getString(cursor.getColumnIndex("DISH_DESC"));

                dishesList.add(new Dishes(
                        DISH_NAME,
                        DISH_REGION,
                        DISH_TYPE,
                        DISH_URL,
                        DISH_DESC
                ));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onClickAddDish(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("DISH_NAME", etName.getText().toString());
        contentValues.put("DISH_REGION", etRegion.getText().toString());
        contentValues.put("DISH_TYPE", etType.getText().toString());
        contentValues.put("DISH_URL" , etURL.getText().toString());
        contentValues.put("DISH_DESC", edtDishDesc.getText().toString());
        Uri uri = getContentResolver().insert(CONTENT_URI, contentValues);
        Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();


        dishesList.add(new Dishes(
                etName.getText().toString(),
                etRegion.getText().toString(),
                etType.getText().toString(),
                etURL.getText().toString(),
                edtDishDesc.getText().toString()
                ));
        dishesListAdapter.notifyItemInserted(dishesList.size()-1);


        cleanValues();
    }

    protected void cleanValues(){
        etName.setText("");
        etRegion.setText("");
        etType.setText("");
        etURL.setText("");
        edtDishDesc.setText("");
    }
}