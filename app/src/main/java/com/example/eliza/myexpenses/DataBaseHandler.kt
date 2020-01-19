package com.example.eliza.myexpenses

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.util.ArrayList

val DATABASE_NAME = "MyDB"
val TABLE_NAME = "recipes"
val COL_NAME = "name"
val COL_INGREDIENTS = "ingredients"
val COL_ID = "id"
val COL_DESC = "desc"


class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME + " VARCHAR(256)," +
                COL_INGREDIENTS + " VARCHAR(256)," +
                COL_DESC + " VARCHAR(256))"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(recipe : Recipe){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_NAME, recipe.name)
        cv.put(COL_INGREDIENTS, recipe.ingredients)
        cv.put(COL_DESC,recipe.desc)
        var result = db.insert(TABLE_NAME,null, cv)

        if(result == -1.toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }

    fun deleteData(id : Int){
        val db = this.writableDatabase
        db.delete(TABLE_NAME,COL_ID + "=?", arrayOf(id.toString()))
        db.close()
    }

    fun readData() : MutableList<Recipe>{
        var list : MutableList<Recipe> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query, null)

        if(result.moveToFirst()){
            do{
                var recipe = Recipe()
                recipe.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                recipe.name = result.getString(result.getColumnIndex(COL_NAME))
                recipe.ingredients = result.getString(result.getColumnIndex(COL_INGREDIENTS))
                recipe.desc = result.getString(result.getColumnIndex(COL_DESC))
                list.add(recipe)
            }while(result.moveToNext())
        }

        result.close()
        db.close()

        return list
    }


}