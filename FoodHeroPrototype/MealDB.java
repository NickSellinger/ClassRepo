package com.example.projectprototype;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;

public class MealDB {
    // database constants
    public static final String DB_NAME = "meals.db";
    public static final int    DB_VERSION = 1;
    // breakfast table constants
    public static final String BREAKFAST_TABLE = "breakfast";
    public static final String BREAKFAST_ID = "_id";
    public static final int    BREAKFAST_ID_COL = 0;
    public static final String BREAKFAST_NAME = "breakfast_name";
    public static final int    BREAKFAST_NAME_COL = 1;
    public static final String BREAKFAST_PRIMARY_INGREDIENT = "primary_ingredient";
    public static final int    BREAKFAST_PRIMARY_COL = 2;
    public static final String BREAKFAST_SECONDARY_INGREDIENT = "secondary_ingredient";
    public static final int    BREAKFAST_SECONDARY_COL = 3;
    public static final String BREAKFAST_TERTIARY_INGREDIENT = "tertiary_ingredient";
    public static final int    BREAKFAST_TERTIARY_COL = 4;
    public static final String BREAKFAST_QUATERNARY_INGREDIENT = "quaternary_ingredient";
    public static final int    BREAKFAST_QUATERNARY_COL = 5;

    // lunch table constants
    public static final String LUNCH_TABLE = "lunch";
    public static final String LUNCH_ID = "_id";
    public static final int    LUNCH_ID_COL = 0;
    public static final String LUNCH_NAME = "lunch_name";
    public static final int    LUNCH_NAME_COL = 1;
    public static final String LUNCH_PRIMARY_INGREDIENT = "primary_ingredient";
    public static final int    LUNCH_PRIMARY_COL = 2;
    public static final String LUNCH_SECONDARY_INGREDIENT = "secondary_ingredient";
    public static final int    LUNCH_SECONDARY_COL = 3;
    public static final String LUNCH_TERTIARY_INGREDIENT = "tertiary_ingredient";
    public static final int    LUNCH_TERTIARY_COL = 4;
    public static final String LUNCH_QUATERNARY_INGREDIENT = "quaternary_ingredient";
    public static final int    LUNCH_QUATERNARY_COL = 5;

    // dinner table constants
    public static final String DINNER_TABLE = "dinner";
    public static final String DINNER_ID = "_id";
    public static final int    DINNER_ID_COL = 0;
    public static final String DINNER_NAME = "dinner_name";
    public static final int    DINNER_NAME_COL = 1;
    public static final String DINNER_PRIMARY_INGREDIENT = "primary_ingredient";
    public static final int    DINNER_PRIMARY_COL = 2;
    public static final String DINNER_SECONDARY_INGREDIENT = "secondary_ingredient";
    public static final int    DINNER_SECONDARY_COL = 3;
    public static final String DINNER_TERTIARY_INGREDIENT = "tertiary_ingredient";
    public static final int    DINNER_TERTIARY_COL = 4;
    public static final String DINNER_QUATERNARY_INGREDIENT = "quaternary_ingredient";
    public static final int    DINNER_QUATERNARY_COL = 5;

    // dessert table constants
    public static final String DESSERT_TABLE = "dessert";
    public static final String DESSERT_ID = "_id";
    public static final int    DESSERT_ID_COL = 0;
    public static final String DESSERT_NAME = "dessert_name";
    public static final int    DESSERT_NAME_COL = 1;
    public static final String DESSERT_PRIMARY_INGREDIENT = "primary_ingredient";
    public static final int    DESSERT_PRIMARY_COL = 2;
    public static final String DESSERT_SECONDARY_INGREDIENT = "secondary_ingredient";
    public static final int    DESSERT_SECONDARY_COL = 3;
    public static final String DESSERT_TERTIARY_INGREDIENT = "tertiary_ingredient";
    public static final int    DESSERT_TERTIARY_COL = 4;
    public static final String DESSERT_QUATERNARY_INGREDIENT = "quaternary_ingredient";
    public static final int    DESSERT_QUATERNARY_COL = 5;

    // CREATE and DROP TABLE statements
    public static final String CREATE_BREAKFAST_TABLE =
            "CREATE TABLE " + BREAKFAST_TABLE + " (" +
                    BREAKFAST_ID         + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    BREAKFAST_NAME       + " TEXT    NOT NULL, " +
                    BREAKFAST_PRIMARY_INGREDIENT       + " TEXT, " +
                    BREAKFAST_SECONDARY_INGREDIENT     + " TEXT, " +
                    BREAKFAST_TERTIARY_INGREDIENT      + " TEXT, " +
                    BREAKFAST_QUATERNARY_INGREDIENT    + " TEXT);";

    public static final String CREATE_LUNCH_TABLE =
            "CREATE TABLE " + LUNCH_TABLE + " (" +
                    LUNCH_ID         + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    LUNCH_NAME       + " TEXT    NOT NULL, " +
                    LUNCH_PRIMARY_INGREDIENT       + " TEXT, " +
                    LUNCH_SECONDARY_INGREDIENT     + " TEXT, " +
                    LUNCH_TERTIARY_INGREDIENT      + " TEXT, " +
                    LUNCH_QUATERNARY_INGREDIENT    + " TEXT);";


    public static final String CREATE_DINNER_TABLE =
            "CREATE TABLE " + DINNER_TABLE + " (" +
                    DINNER_ID         + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DINNER_NAME       + " TEXT    NOT NULL, " +
                    DINNER_PRIMARY_INGREDIENT       + " TEXT, " +
                    DINNER_SECONDARY_INGREDIENT     + " TEXT, " +
                    DINNER_TERTIARY_INGREDIENT      + " TEXT, " +
                    DINNER_QUATERNARY_INGREDIENT    + " TEXT);";


    public static final String CREATE_DESSERT_TABLE =
            "CREATE TABLE " + DESSERT_TABLE + " (" +
                    DESSERT_ID         + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DESSERT_NAME       + " TEXT    NOT NULL, " +
                    DESSERT_PRIMARY_INGREDIENT       + " TEXT, " +
                    DESSERT_SECONDARY_INGREDIENT     + " TEXT, " +
                    DESSERT_TERTIARY_INGREDIENT      + " TEXT, " +
                    DESSERT_QUATERNARY_INGREDIENT    + " TEXT);";

    public static final String DROP_BREAKFAST_TABLE =
            "DROP TABLE IF EXISTS " + BREAKFAST_TABLE;
    public static final String DROP_LUNCH_TABLE =
            "DROP TABLE IF EXISTS " + LUNCH_TABLE;
    public static final String DROP_DINNER_TABLE =
            "DROP TABLE IF EXISTS " + DINNER_TABLE;
    public static final String DROP_DESSERT_TABLE =
            "DROP TABLE IF EXISTS " + DESSERT_TABLE;

    private static class DBHelper extends SQLiteOpenHelper{
        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version){
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_BREAKFAST_TABLE);
            db.execSQL(CREATE_LUNCH_TABLE);
            db.execSQL(CREATE_DINNER_TABLE);
            db.execSQL(CREATE_DESSERT_TABLE);
            //insert recipes
            db.execSQL("INSERT INTO breakfast VALUES(1, 'Fried Egg', '1 tablespoon Olive Oil'," +
                    " '1 Large Egg', '1 Teaspoon of Salt', 'Pepper to Taste' )");
            db.execSQL("INSERT INTO lunch VALUES(1, 'BLT', '2 Slices of Bread'," +
                    " 'Applewood Smoked Bacon', '1 Small Tomato', 'Romaine Lettuce')");
            db.execSQL("INSERT INTO dinner VALUES(1, 'Aglio Olio', '1 Box Spaghetti', " +
                    "'1/2 Cup Olive Oil', '6 Cloves of Garlic', '1 cup Parmigian Cheese')");
            db.execSQL("INSERT INTO dessert VALUES(1, 'Fruit Parfait'," +
                    " '3 cups Vanilla nonfat yogurt', '1 Cup Fresh or Frozen Strawberries', " +
                    "'1 Cup Fresh or Frozen Blueberries', '1 Cup Granola')");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            Log.d("Recipe Selector", "Upgrading db from version " + oldVersion + " to "
            + newVersion);
            Log.d("Recipe Selector", "Deleting all data!");
            db.execSQL(MealDB.DROP_BREAKFAST_TABLE);
            db.execSQL(MealDB.DROP_LUNCH_TABLE);
            db.execSQL(MealDB.DROP_DINNER_TABLE);
            db.execSQL(MealDB.DROP_DESSERT_TABLE);
            onCreate(db);

        }
    }

    //database object and database helper object
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public MealDB(Context context) {
        dbHelper = new DBHelper(context, DB_NAME, null, DB_VERSION);
    }

    // private methods
    private void openReadableDB() {
        db = dbHelper.getReadableDatabase();
    }

    private void openWriteableDB() {
        db = dbHelper.getWritableDatabase();
    }

    private void closeDB() {
        if (db != null)
            db.close();
    }

    public ArrayList<Recipe> getBreakfast(){
        ArrayList<Recipe> breakfast = new ArrayList<>();
        openReadableDB();
        Cursor cursor = db.query(BREAKFAST_TABLE, null, null, null,
                null, null, null);
        while (cursor.moveToNext()){
            breakfast.add(getBreakfastFromCursor(cursor));
        }
        cursor.close();
        closeDB();
        return breakfast;
    }
    public Recipe getBreakfast(String name){
        String where = BREAKFAST_NAME + "= ?";
        String[] whereArgs = { name };

        // handle exceptions?
        this.openReadableDB();
        Cursor cursor = db.query(BREAKFAST_TABLE,
                null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        Recipe task = getBreakfastFromCursor(cursor);
        if (cursor != null)
            cursor.close();
        this.closeDB();

        return task;
    }

    public ArrayList<Recipe> getLunch(){
        ArrayList<Recipe> lunch = new ArrayList<>();
        openReadableDB();
        Cursor cursor = db.query(LUNCH_TABLE, null, null, null,
                null, null, null);
        while (cursor.moveToNext()){
            lunch.add(getLunchFromCursor(cursor));
        }
        cursor.close();
        closeDB();
        return lunch;
    }
    public Recipe getLunch(String name){
        String where = LUNCH_NAME + "= ?";
        String[] whereArgs = { name };

        // handle exceptions?
        this.openReadableDB();
        Cursor cursor = db.query(LUNCH_TABLE,
                null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        Recipe task = getLunchFromCursor(cursor);
        if (cursor != null)
            cursor.close();
        this.closeDB();

        return task;
    }

    public ArrayList<Recipe> getDinner(){
        ArrayList<Recipe> dinner = new ArrayList<>();
        openReadableDB();
        Cursor cursor = db.query(DINNER_TABLE, null, null, null,
                null, null, null);
        while (cursor.moveToNext()){
            dinner.add(getDinnerFromCursor(cursor));
        }
        cursor.close();
        closeDB();
        return dinner;
    }
    public Recipe getDinner(String name){
        String where = DINNER_NAME + "= ?";
        String[] whereArgs = { name };

        // handle exceptions?
        this.openReadableDB();
        Cursor cursor = db.query(DINNER_TABLE,
                null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        Recipe task = getDinnerFromCursor(cursor);
        if (cursor != null)
            cursor.close();
        this.closeDB();

        return task;
    }

    public ArrayList<Recipe> getDessert(){
        ArrayList<Recipe> dessert = new ArrayList<>();
        openReadableDB();
        Cursor cursor = db.query(DESSERT_TABLE, null, null, null,
                null, null, null);
        while (cursor.moveToNext()){
            dessert.add(getDessertFromCursor(cursor));
        }
        cursor.close();
        closeDB();
        return dessert;
    }
    public Recipe getDessert(String name){
        String where = DESSERT_NAME + "= ?";
        String[] whereArgs = { name };

        // handle exceptions?
        this.openReadableDB();
        Cursor cursor = db.query(DESSERT_TABLE,
                null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        Recipe task = getDessertFromCursor(cursor);
        if (cursor != null)
            cursor.close();
        this.closeDB();

        return task;
    }

    private static Recipe getBreakfastFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0){
            return null;
        }
        else {
            try {
                Recipe breakfast = new Recipe();
                breakfast.setId(cursor.getInt(BREAKFAST_ID_COL));
                breakfast.setName(cursor.getString(BREAKFAST_NAME_COL));
                breakfast.setIngredient1(cursor.getString(BREAKFAST_PRIMARY_COL));
                breakfast.setIngredient2(cursor.getString(BREAKFAST_SECONDARY_COL));
                breakfast.setIngredient3(cursor.getString(BREAKFAST_TERTIARY_COL));
                breakfast.setIngredient4(cursor.getString(BREAKFAST_QUATERNARY_COL));
                return breakfast;
            }
            catch(Exception e) {
                return null;
            }
        }
    }

    private static Recipe getLunchFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0){
            return null;
        }
        else {
            try {
                Recipe lunch = new Recipe();
                lunch.setId(cursor.getInt(LUNCH_ID_COL));
                lunch.setName(cursor.getString(LUNCH_NAME_COL));
                lunch.setIngredient1(cursor.getString(LUNCH_PRIMARY_COL));
                lunch.setIngredient2(cursor.getString(LUNCH_SECONDARY_COL));
                lunch.setIngredient3(cursor.getString(LUNCH_TERTIARY_COL));
                lunch.setIngredient4(cursor.getString(LUNCH_QUATERNARY_COL));
                return lunch;
            }
            catch(Exception e) {
                return null;
            }
        }
    }

    private static Recipe getDinnerFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0){
            return null;
        }
        else {
            try {
                Recipe dinner = new Recipe();
                dinner.setId(cursor.getInt(DINNER_ID_COL));
                dinner.setName(cursor.getString(DINNER_NAME_COL));
                dinner.setIngredient1(cursor.getString(DINNER_PRIMARY_COL));
                dinner.setIngredient2(cursor.getString(DINNER_SECONDARY_COL));
                dinner.setIngredient3(cursor.getString(DINNER_TERTIARY_COL));
                dinner.setIngredient4(cursor.getString(DINNER_QUATERNARY_COL));
                return dinner;
            }
            catch(Exception e) {
                return null;
            }
        }
    }

    private static Recipe getDessertFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0){
            return null;
        }
        else {
            try {
                Recipe dessert = new Recipe();
                dessert.setId(cursor.getInt(DESSERT_ID_COL));
                dessert.setName(cursor.getString(DESSERT_NAME_COL));
                dessert.setIngredient1(cursor.getString(DESSERT_PRIMARY_COL));
                dessert.setIngredient2(cursor.getString(DESSERT_SECONDARY_COL));
                dessert.setIngredient3(cursor.getString(DESSERT_TERTIARY_COL));
                dessert.setIngredient4(cursor.getString(DESSERT_QUATERNARY_COL));
                return dessert;
            }
            catch(Exception e) {
                return null;
            }
        }
    }


}
