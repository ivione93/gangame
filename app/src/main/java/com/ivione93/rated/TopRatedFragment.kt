package com.ivione93.rated

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.commons.BaseListFragment
import com.example.commons.DataBindingRecyclerAdapter
import com.ivione93.BR
import com.ivione93.R
import com.ivione93.TopGame

class TopRatedFragment : BaseListFragment() {

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
            TopGame("Counter Strike",
                "12345678",
                80,
                "ivione93",
                9.99F,
                1,
                "https://upload.wikimedia.org/wikipedia/en/7/76/Counter-Strike_Global_Offensive_icon.jpg")
        )
    }
}