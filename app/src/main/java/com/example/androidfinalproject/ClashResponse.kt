package com.example.androidfinalproject

import com.squareup.moshi.Json

class ClashResponse {
    @Json(name = "name")
    lateinit var clashName: String

    @Json(name = "expLevel")
    lateinit var clashLevel: String

    @Json(name = "wins")
    lateinit var clashWins: String

    @Json(name = "losses")
    lateinit var clashLosses: String

    @Json(name = "trophies")
    lateinit var clashTrophies: String

    @Json(name = "bestTrophies")
    lateinit var clashMaxTrophies: String
}
