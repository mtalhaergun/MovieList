package com.example.retrofitmovielist

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Yonetmenler(@SerializedName("yonetmen_id")
                       @Expose
                       var yonetmen_id:Int
                       ,
                       @SerializedName("yonetmen_ad")
                       @Expose
                       var yonetmen_ad:String) : Serializable {
}