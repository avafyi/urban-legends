package com.kaiguy.urbanlegends

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UrbanApi {

    @GET("v0/define")
    fun getEntryList(@Query("term") userId: String) : Call<EntryList>

}