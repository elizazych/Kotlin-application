package com.example.eliza.myexpenses

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class DeleteShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_show)

        val context = this
        var db = DataBaseHandler(context)



        var data = db.readData()


        val layout = findViewById(R.id.layout_btns2) as LinearLayout
        for (i in 0..(data.size-1)) {
            val button = Button(this)
            button.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
            button.setTag(data.get(i).name)
            button.text = data.get(i).name
            layout.addView(button)
            button.setOnClickListener{

                db.deleteData(data.get(i).id)
                Toast.makeText(context, "Recipe was deletetd!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

    }
}
