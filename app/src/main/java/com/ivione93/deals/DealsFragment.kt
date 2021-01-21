package com.ivione93.deals

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.commons.BaseListFragment
import com.example.commons.DataBindingRecyclerAdapter
import com.ivione93.Deal
import com.ivione93.R
import com.ivione93.BR

class DealsFragment : BaseListFragment() {
    override fun getAdapter(): RecyclerView.Adapter<*> {
        return  DataBindingRecyclerAdapter<Deal>(BR.deal, R.layout.item_deal)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (listAdapter as DataBindingRecyclerAdapter<Deal>)
            .items.addAll(getDummyDeals())
        listAdapter.notifyDataSetChanged()

    }
    fun getDummyDeals() : ArrayList<Deal> {
        return arrayListOf(
            Deal("Counter Strike",
                0.99F,
                9.99F,
                80,
                82,
                "https://upload.wikimedia.org/wikipedia/en/7/76/Counter-Strike_Global_Offensive_icon.jpg")
        )
    }
}