package com.example.eliza.myexpenses

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_desc.*

class AddDescActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_desc)

        val list : ArrayList<String> =  intent.getStringArrayListExtra("list")

        val context = this

           // text_desc.append(list.get(0).toString() + "\n")

        var desc : String = ""
        var count : Int = 1
        var flag : Boolean = false
        btn_add_desc.setOnClickListener{
            flag = false
            if(text_add_desc.text.toString().length > 0){

                var oneDesc : String = count.toString() + ". " + text_add_desc.text.toString() + "\n"
                desc += oneDesc

                text_desc.append(oneDesc)
                count++
                text_add_desc.setText("")
                flag = true
            }else{
                Toast.makeText(context, "Please Fill the description", Toast.LENGTH_SHORT).show()
            }

        }

        btn_insert.setOnClickListener{

            if(flag==true) {
                list.add(2, desc)

                var recipe = Recipe(list.get(0), list.get(1), list.get(2))
                var db = DataBaseHandler(context)
                db.insertData(recipe)

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(context, "Please clack Add button first", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
