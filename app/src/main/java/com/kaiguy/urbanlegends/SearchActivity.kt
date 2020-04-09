package com.kaiguy.urbanlegends

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchActivity : AppCompatActivity() {
    companion object {
        private val TAG = this::class.qualifiedName
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    val entries = ArrayList<Entry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setSupportActionBar(toolbar)

        // setup RecyclerView

        viewManager = LinearLayoutManager(this)
        viewAdapter = UrbanAdapter(entries)

        recyclerView = findViewById(R.id.recycle)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        // setup Retrofit

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.urbandictionary.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(UrbanApi::class.java)

        // GET

        val searchWord : String? = intent.getStringExtra("search")
        if (searchWord != null) {
            val call = api.getEntryList(searchWord)
            // enqueue to avoid exception for running network call on main thread!
            call.enqueue(object : Callback<EntryList> {
                override fun onResponse(call: Call<EntryList>, response: Response<EntryList>) {
                    if (!response.isSuccessful) {
                        Log.e(TAG, "onResponse Error: ${response.code()}")
                        val toast = Toast.makeText(
                            applicationContext,
                            "Error: ${response.code()}", Toast.LENGTH_LONG
                        )
                        return
                    }

                    // update RecyclerView data
                    val entryList = response.body()
                    if (entryList != null) {
                        for (entry in entryList.list) {
                            entries.add(entry)
                        }
                    }
                    viewAdapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<EntryList>, t: Throwable) {
                    Log.e(TAG, "onFailure Error: ${t.message}")
                    val toast = Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG)
                    toast.show()
                }
            })
        }


    }
}
