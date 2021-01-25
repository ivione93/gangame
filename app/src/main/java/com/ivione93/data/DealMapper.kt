package com.ivione93.data

import com.ivione93.Deal

object DealMapper {

    fun fromSdk(deal: com.example.sdk.Deal) : Deal {
        return Deal(deal.title,
                    deal.salePrice,
                    deal.normalPrice,
                    deal.metacriticScore,
                    deal.steamRating,
                    deal.thumb)
    }
}