package com.ivione93.deals

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.commons.BaseListFragment
import com.example.commons.DataBindingRecyclerAdapter
import com.google.android.material.snackbar.Snackbar
import com.ivione93.Deal
import com.ivione93.R
import com.ivione93.BR
import com.ivione93.data.GangameDataSource

class DealsFragment : BaseListFragment() {
    override fun getAdapter(): RecyclerView.Adapter<*> {
        return  DataBindingRecyclerAdapter<Deal>(BR.deal, R.layout.item_deal)
    }

    override fun onResume() {
        super.onResume()
        showDeals()
    }

    @SuppressLint("CheckResult")
    private fun showDeals() {
        GangameDataSource.getDeals()
            .subscribe({ list ->
                replaceItems(list)
            }, { error ->
                showError(error)
            })
    }

    private fun replaceItems(list: List<Deal>) {
        with(listAdapter as DataBindingRecyclerAdapter<Deal>) {
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }
    }

    private fun showError(error: Throwable) {
        error.printStackTrace()

        view?.let {
            Snackbar.make(view as View, R.string.error_request, Snackbar.LENGTH_LONG)
                .setAction(R.string.label_retry, { _: View -> showDeals()})
                .show()
        }
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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
                "https://upload.wikimedia.org/wikipedia/en/7/76/Counter-Strike_Global_Offensive_icon.jpg"),
            Deal("Tom Clancys The Division",
                9.90F,
                29.99F,
                79,
                69,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/365590/capsule_sm_120.jpg?t=1602605518"),
            Deal("Tom Clancy's Ghost Recon Wildlands",
                15.99F,
                49.99F,
                69,
                78,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/460930/capsule_sm_120.jpg?t=1602605434"),
            Deal("Tom Clancys The Division 2 Warlords of New York Edition",
                18.00F,
                59.99F,
                70,
                78,
                "https://store.ubi.com/dw/image/v2/ABBS_PRD/on/demandware.static/-/Sites-masterCatalog/default/dw11557a2f/images/large/5e15ad495cdf9a1ec45ad835.jpg?sw=197&amp;sh=261&amp;sm=fit"),
            Deal("Assassins Creed Origins",
                59.99F,
                59.99F,
                84,
                85,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/582160/capsule_sm_120.jpg?t=1603213581"),
            Deal("Assassins Creed Valhalla Ultimate Edition",
                119.99F,
                119.99F,
                85,
                87,
                "https://store.ubi.com/dw/image/v2/ABBS_PRD/on/demandware.static/-/Sites-masterCatalog/en_US/dwbb6c0932/images/large/5e84a5065cdf9a21c0b4e737.jpg?sw=197&amp;sh=261&amp;sm=fit"),
            Deal("Tom Clancys Ghost Recon Breakpoint",
                9.00F,
                59.99F,
                58,
                0,
                "https://images.greenmangaming.com/8ce6b832d0e74a17971595575f99cddc/697bf4a26aa344e1b3c0c03e69af43b5.jpg")
        )
    }*/
}