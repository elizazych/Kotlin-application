package com.example.eliza.myexpenses

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_adding.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding)
        val context = this


        /*btn_insert.setOnClickListener{

            if(etvName.text.toString().length > 0 &&
                    etvIngredients.text.toString().length > 0 &&
                    etvDesc.text.toString().length > 0){
                var recipe = Recipe(etvName.text.toString(), etvIngredients.text.toString(), etvDesc.text.toString())
                var db = DataBaseHandler(context)
                db.insertData(recipe)
            }else{
                Toast.makeText(context, "Please Fill all Data's", Toast.LENGTH_SHORT).show()
            }

        }*/

        btn_go_ingredients.setOnClickListener{
            if(etvName.text.toString().length > 0){
                var name : String = etvName.text.toString()
                val intent = Intent(this, AddIngrActivity::class.java)
                intent.putExtra("name", name)
                startActivity(intent)
            }else{
                Toast.makeText(context, "Please Fill the name", Toast.LENGTH_SHORT).show()
            }

        }


    }



}
