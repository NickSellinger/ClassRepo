package com.example.projectprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class RecipeSelect extends AppCompatActivity implements View.OnClickListener {

    private ListView directionList;
    private TextView titleText;
    private Button pass;
    private Button fail;

    private MealDB db;
    ArrayList<Recipe> recipeArray;

    private SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_select);

        directionList = (ListView) findViewById(R.id.directionList);
        titleText = (TextView) findViewById(R.id.recipeTitle);
        pass = (Button) findViewById(R.id.yumButton);
        fail = (Button) findViewById(R.id.yuckButton);

        pass.setOnClickListener(this);
        fail.setOnClickListener(this);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        db = new MealDB(this);

        updateDisplay();
    }
    @Override
    public void onResume() {
        super.onResume();
        updateDisplay();
    }

    public void updateDisplay(){

        int mealType = getIntent().getIntExtra("sliderPos", 0);
        switch(mealType){
            case 0:
                recipeArray = db.getBreakfast();
                break;
            case 1:
                recipeArray = db.getLunch();
                break;
            case 2:
                recipeArray = db.getDinner();
                break;
            case 3:
                recipeArray = db.getDessert();
                break;
        }



        ArrayList<HashMap<String, String>> data =
                new ArrayList<HashMap<String, String>>();
        for (Recipe recipe : recipeArray) {
            HashMap<String, String> map = new HashMap<String, String>();
            titleText.setText(recipe.getName());
            map.put("Ingredient1", recipe.getIngredient1());
            map.put("Ingredient2", recipe.getIngredient2());
            map.put("Ingredient3", recipe.getIngredient3());
            map.put("Ingredient4", recipe.getIngredient4());
            data.add(map);
        }


        int resource = R.layout.direction_layout;
        String[] from = {"Ingredient1", "Ingredient2", "Ingredient3", "Ingredient4"};
        int[] to = {R.id.ingredientView1, R.id.ingredientView2, R.id.ingredientView3,
        R.id.ingredientView4};

        SimpleAdapter adapter =
                new SimpleAdapter(this, data, resource, from, to);
        directionList.setAdapter(adapter);



    }

    @Override
    public void onClick(View v) {

        Intent mealSuccess = new Intent(getBaseContext(), MainTitle.class);
        mealSuccess.putExtra("progress", 1);
        Intent mealFail = new Intent(getBaseContext(), MainTitle.class);
        mealFail.putExtra("progress", 0);

        switch(v.getId()) {
            case R.id.yumButton:
                this.startActivity(mealSuccess);
                break;
            case R.id.yuckButton:
                this.startActivity(mealFail);
                break;
        }


    }
}