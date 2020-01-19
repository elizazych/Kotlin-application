package com.example.eliza.myexpenses

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // val context = this

        btn_add.setOnClickListener{
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        btn_show_all.setOnClickListener{
            val intent = Intent(this, ShowRecipesActivity::class.java)
            startActivity(intent)
        }

        btn_send_show.setOnClickListener{
            val intent = Intent(this, SndRecipesShowActivity::class.java)
            startActivity(intent)


        }
        btn_delete_recipe.setOnClickListener{

            val intent = Intent(this, DeleteShowActivity::class.java)
            startActivity(intent)
        }
    }
}
