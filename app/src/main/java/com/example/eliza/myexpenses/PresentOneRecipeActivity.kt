package com.example.eliza.myexpenses

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import kotlinx.android.synthetic.main.activity_present_one_recipe.*

class PresentOneRecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_present_one_recipe)

        val context = this
        var db = DataBaseHandler(context)

        var data = db.readData()

        val idRecipe = intent.getStringExtra("id")


        for (i in 0..(data.size-1)){

            if(data.get(i).id.toString() == idRecipe) {
                text_one_recipe.append(data.get(i).name + "\n\n" +
                "Ingredients: \n" + data.get(i).ingredients + "\n\n" +
                "Description:\n" + data.get(i).desc)
            }
        }

    }
}
