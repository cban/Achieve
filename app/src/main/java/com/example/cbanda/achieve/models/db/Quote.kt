package com.example.cbanda.achieve.models.db


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Quote {

    @SerializedName("quoteText")
    @Expose
    var quoteText: String? = null
    @SerializedName("quoteAuthor")
    @Expose
    var quoteAuthor: String? = null
    @SerializedName("senderName")
    @Expose
    var senderName: String? = null
    @SerializedName("senderLink")
    @Expose
    var senderLink: String? = null
    @SerializedName("quoteLink")
    @Expose
    var quoteLink: String? = null
}