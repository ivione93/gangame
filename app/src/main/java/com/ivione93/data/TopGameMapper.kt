package com.ivione93.data

import com.ivione93.TopGame

object TopGameMapper {

    fun fromSdk(topGame: com.example.sdk.TopGame, position: Int) : TopGame {
        return TopGame(topGame.title,
                        topGame.owners,
                        topGame.steamRating,
                        topGame.publisher,
                        topGame.price,
                        position,
                        topGame.thumb)
    }
}