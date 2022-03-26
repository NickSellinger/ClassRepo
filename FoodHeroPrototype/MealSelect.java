package com.example.projectprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.HashMap;

public class MealSelect extends AppCompatActivity implements AdapterView.OnItemClickListener,
        AdapterView.OnItemSelectedListener {

    private Spinner mealSpinner;
    private ListView recipeList;

    private MealDB db;
    ArrayList<Recipe> recipes;

    private SharedPreferences prefs;
    private int spinnerTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_select);

        mealSpinner = (Spinner) findViewById(R.id.mealTypeSpinner);
        recipeList = (ListView) findViewById(R.id.mealList);

        mealSpinner.setOnItemSelectedListener(this);
        recipeList.setOnItemClickListener(this);

        db = new MealDB(this);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        mealSpinner.setSelection(0);

        updateDisplay();


    }

    private void updateDisplay() {

        if(mealSpinner.getSelectedItemPosition() == 0){
            recipes = db.getBreakfast();
        }
       else if(mealSpinner.getSelectedItemPosition() == 1){
           recipes = db.getLunch();
        }
       else if(mealSpinner.getSelectedItemPosition() == 2){
           recipes = db.getDinner();
        }
       else if (mealSpinner.getSelectedItemPosition() == 3){
           recipes = db.getDessert();
        }
       else{
           recipes = db.getBreakfast();
        }


        ArrayList<HashMap<String, String>> data =
                new ArrayList<>();
        for (Recipe recipe : recipes){
            HashMap<String, String> map = new HashMap<>();
            map.put("name", recipe.getName());
            data.add(map);
        }

        int resource = android.R.layout.simple_list_item_1;
        String[] from = {"name"};
        int[] to = {android.R.id.text1};

        SimpleAdapter adapter =
                new SimpleAdapter(this, data, resource, from, to);
        recipeList.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(getBaseContext(),RecipeSelect.class);
        intent.putExtra("sliderPos", spinnerTracker);

        startActivity(intent);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        spinnerTracker = position;
        updateDisplay();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}