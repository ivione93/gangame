package com.example.sdk

import com.example.sdk.serializer.TopGameDeserializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.junit.Assert
import org.junit.Test

class ModelUnitTest {

    val JSON_DEAL = "{\n" +
            "        \"internalName\": \"TOMCLANCYSSPLINTERCELLCOLLECTIONSPLINTERCELLCOLLECTION\",\n" +
            "        \"title\": \"Tom Clancys Splinter Cell Collection Splinter Cell Collection\",\n" +
            "        \"metacriticLink\": null,\n" +
            "        \"dealID\": \"kkYZiDrW6Kh20sU5somxFa2O0r3Y6kJgXlaTu8svBo4%3D\",\n" +
            "        \"storeID\": \"13\",\n" +
            "        \"gameID\": \"194558\",\n" +
            "        \"salePrice\": \"18.00\",\n" +
            "        \"normalPrice\": \"89.99\",\n" +
            "        \"isOnSale\": \"1\",\n" +
            "        \"savings\": \"79.997778\",\n" +
            "        \"metacriticScore\": \"0\",\n" +
            "        \"steamRatingText\": null,\n" +
            "        \"steamRatingPercent\": \"0\",\n" +
            "        \"steamRatingCount\": \"0\",\n" +
            "        \"steamAppID\": null,\n" +
            "        \"releaseDate\": 0,\n" +
            "        \"lastChange\": 1611221490,\n" +
            "        \"dealRating\": \"10.0\",\n" +
            "        \"thumb\": \"https://store.ubi.com/dw/image/v2/ABBS_PRD/on/demandware.static/-/Sites-masterCatalog/default/dw2612299f/images/large/58eb8edd88a7e338398b4567.jpg?sw=197&amp;sh=261&amp;sm=fit\"\n" +
            "    }"

    val JSON_TOP_GAME = "{\n" +
            "        \"appid\": 570,\n" +
            "        \"name\": \"Dota 2\",\n" +
            "        \"developer\": \"Valve\",\n" +
            "        \"publisher\": \"Valve\",\n" +
            "        \"score_rank\": 88,\n" +
            "        \"positive\": 1217418,\n" +
            "        \"negative\": 224587,\n" +
            "        \"userscore\": 0,\n" +
            "        \"owners\": \"10,000,000 .. 20,000,000\",\n" +
            "        \"average_forever\": 34494,\n" +
            "        \"average_2weeks\": 1668,\n" +
            "        \"median_forever\": 1175,\n" +
            "        \"median_2weeks\": 635,\n" +
            "        \"price\": \"0\",\n" +
            "        \"initialprice\": \"0\",\n" +
            "        \"discount\": \"0\",\n" +
            "        \"ccu\": 589531\n" +
            "    }"

    @Test
    fun dealParsingTest() {
        val gson = Gson()
        val deal = gson.fromJson(JSON_DEAL, Deal::class.java)

        Assert.assertEquals(deal.title, "Tom Clancys Splinter Cell Collection Splinter Cell Collection")
        Assert.assertEquals(deal.metacriticScore, 0)
        Assert.assertEquals(deal.steamRating, 0)
        Assert.assertEquals(deal.salePrice, 18.00F)
        Assert.assertEquals(deal.normalPrice, 89.99F)
        Assert.assertEquals(deal.thumb, "https://store.ubi.com/dw/image/v2/ABBS_PRD/on/demandware.static/-/Sites-masterCatalog/default/dw2612299f/images/large/58eb8edd88a7e338398b4567.jpg?sw=197&amp;sh=261&amp;sm=fit")
    }

    @Test
    fun topGameParsingTest() {
        val gson = GsonBuilder()
            .registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
            .create()

        val topGame = gson.fromJson(JSON_TOP_GAME, TopGame::class.java)

        Assert.assertEquals(topGame.title, "Dota 2")
        Assert.assertEquals(topGame.steamRating, 88)
        Assert.assertEquals(topGame.owners, "10,000,000 .. 20,000,000")
        Assert.assertEquals(topGame.publisher, "Valve")
        Assert.assertEquals(topGame.thumb, "https://cdn.cloudflare.steamstatic.com/steam/apps/570/capsule_sm_120.jpg?t=1579204284")
    }
}