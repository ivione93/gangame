package com.example.sdk.serializer

import com.example.sdk.TopGame
import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class TopGameDeserializer: JsonDeserializer<TopGame> {

    companion object {
        const val BASE_IMG_URL = "https://cdn.cloudflare.steamstatic.com/steam/apps/%s/capsule_sm_120.jpg?t=1579204284"
    }

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): TopGame {
        val gson = Gson()
        val topGame = gson.fromJson(json, TopGame::class.java)
        val appId = json.asJsonObject["appid"].asInt.toString()
        val thumb = String.format(BASE_IMG_URL, appId)
        topGame.thumb = thumb
        topGame.price = topGame.price / 100

        return topGame
    }
}