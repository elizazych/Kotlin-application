package com.example.eliza.myexpenses

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_ingr.*

class AddIngrActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_ingr)

        val list : ArrayList<String> = ArrayList()

        val name = intent.getStringExtra("name")
        val context = this
        list.add(0, name)

        var ingr : String = ""
        var flag : Boolean = false
        btn_add_ingr.setOnClickListener{

            if(text_add_ingr.text.toString().length > 0){
                var oneIngr : String = "- " + text_add_ingr.text.toString() + "\n"
                ingr += oneIngr
                text_ingredients.append(oneIngr)
                text_add_ingr.setText("")
                flag = true
            }else{
                Toast.makeText(context, "Please Fill the ingredients", Toast.LENGTH_SHORT).show()
            }
        }

        btn_go_desc.setOnClickListener{
            if(flag==true) {
                list.add(1, ingr)
                val intent = Intent(this, AddDescActivity::class.java)
                intent.putStringArrayListExtra("list", list)
                startActivity(intent)
            }else{
                Toast.makeText(context, "Please click ADD button first!", Toast.LENGTH_SHORT).show()
            }

        }



    }
}
