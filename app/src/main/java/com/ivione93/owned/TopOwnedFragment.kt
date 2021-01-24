package com.ivione93.owned

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.commons.BaseListFragment
import com.example.commons.DataBindingRecyclerAdapter
import com.ivione93.BR
import com.ivione93.Deal
import com.ivione93.R
import com.ivione93.TopGame

class TopOwnedFragment : BaseListFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<TopGame>(BR.topGame, R.layout.item_top_game)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (listAdapter as DataBindingRecyclerAdapter<TopGame>)
            .items.addAll(getDummyTopGames())
        listAdapter.notifyDataSetChanged()
    }

    fun getDummyTopGames() : ArrayList<TopGame> {
        return arrayListOf(
            TopGame("Tom Clancys Ghost Recon Breakpoint",
                "12345678",
                0,
                "Ubisoft",
                59.99F,
                1,
                "https://images.greenmangaming.com/8ce6b832d0e74a17971595575f99cddc/697bf4a26aa344e1b3c0c03e69af43b5.jpg"),
            TopGame("Assassins Creed Origins",
                "12345678",
                85,
                "Ubisoft",
                59.99F,
                2,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/582160/capsule_sm_120.jpg?t=1603213581"),
            TopGame("Tom Clancys The Division",
                "12345678",
                69,
                "Ubisoft",
                29.99F,
                3,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/365590/capsule_sm_120.jpg?t=1602605518"),
            TopGame("Assassins Creed Valhalla Ultimate Edition",
                "12345678",
                87,
                "Ubisoft",
                119.99F,
                4,
                "https://store.ubi.com/dw/image/v2/ABBS_PRD/on/demandware.static/-/Sites-masterCatalog/en_US/dwbb6c0932/images/large/5e84a5065cdf9a21c0b4e737.jpg?sw=197&amp;sh=261&amp;sm=fit"),
            TopGame("Tom Clancys The Division 2 Warlords of New York Edition",
                "12345678",
                78,
                "Ubisoft",
                59.99F,
                5,
                "https://store.ubi.com/dw/image/v2/ABBS_PRD/on/demandware.static/-/Sites-masterCatalog/default/dw11557a2f/images/large/5e15ad495cdf9a1ec45ad835.jpg?sw=197&amp;sh=261&amp;sm=fit"),
            TopGame("Counter Strike",
                "12345678",
                80,
                "ivione93",
                9.99F,
                6,
                "https://upload.wikimedia.org/wikipedia/en/7/76/Counter-Strike_Global_Offensive_icon.jpg")
        )
    }
}