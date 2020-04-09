package com.kaiguy.urbanlegends

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UrbanAdapter(private val entries: ArrayList<Entry>) :
    RecyclerView.Adapter<UrbanAdapter.EntryViewHolder>() {

    class EntryViewHolder(val entryView: EntryView) : RecyclerView.ViewHolder(entryView)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): UrbanAdapter.EntryViewHolder {
        return EntryViewHolder(EntryView(parent.context))
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        holder.entryView.setWithEntry(entries[position])
    }

    override fun getItemCount() = entries.size
}