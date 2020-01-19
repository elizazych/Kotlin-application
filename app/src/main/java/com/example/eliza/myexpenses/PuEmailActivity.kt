package com.example.eliza.myexpenses

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.support.v4.content.ContextCompat.startActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_present_one_recipe.*
import kotlinx.android.synthetic.main.activity_pu_email.*
import android.support.v4.content.ContextCompat.startActivity



class PuEmailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pu_email)
        val context = this
        var db = DataBaseHandler(context)

        var data = db.readData()

        val idRecipe = intent.getStringExtra("id")


        var oneRecipe1 : String = ""
        var name : String = ""

        for (i in 0..(data.size-1)) {

            if (data.get(i).id.toString() == idRecipe) {
                name = data.get(i).name
                oneRecipe1 = data.get(i).name + "\n\n" +
                        "Ingredients: \n" + data.get(i).ingredients + "\n\n" +
                        "Description:\n" + data.get(i).desc
            }
        }
            btn_send_email.setOnClickListener {
                if (txt_email.text.toString().length > 0) {

                    val email : String = txt_email.text.toString()
                    val address = arrayOf(email)

                    val intent = Intent(Intent.ACTION_SENDTO)
                    intent.data = Uri.parse("mailto:")
                    intent.putExtra(Intent.EXTRA_SUBJECT, name)
                    intent.putExtra(Intent.EXTRA_TEXT,oneRecipe1)
                    intent.putExtra(Intent.EXTRA_EMAIL, address)
                    startActivity(Intent.createChooser(intent,"kk"))


                }
            }
        }
    }


