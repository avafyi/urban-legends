package com.kaiguy.urbanlegends

import com.google.gson.annotations.SerializedName

data class Entry(
    val definition: String,
    val permalink: String,
    @SerializedName("thumbs_up") val thumbsUp: String,
    @SerializedName("sound_urls") val soundUrls: List<String>,
    val author: String,
    val word: String,
    val defid: Int,
    @SerializedName("current_vote") val currentVote: String,
    @SerializedName("written_on") val writtenOn: String,
    val example: String,
    @SerializedName("thumbs_down") val thumbsDown: Int)