package com.kaiguy.urbanlegends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_go.setOnClickListener {
            if (et_search.text.isNotBlank()) {
                val i = Intent(this, SearchActivity::class.java)
                i.putExtra("search", et_search.text.toString())
                startActivity(i)
            }
        }
    }


}
