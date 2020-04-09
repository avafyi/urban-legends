package com.kaiguy.urbanlegends

import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView

class EntryView(context: Context) : LinearLayout(context) {
    var mTitle: TextView
    var mDesc: TextView
    var mUsage: TextView

    init {
        inflate(context, R.layout.view_entry, this)

        mTitle = findViewById(R.id.entry_title)
        mDesc = findViewById(R.id.entry_desc)
        mUsage = findViewById(R.id.entry_usage)
    }

    fun setWithEntry(entry: Entry) {
        mTitle.text = entry.word
        mDesc.text = entry.definition
        mUsage.text = entry.example
    }

    fun setStrings(title: String, desc: String, usage: String) {
        this.mTitle.text = title
        this.mDesc.text = desc
        this.mUsage.text = usage
    }
}