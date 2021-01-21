package com.ivione93

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ivione93.deals.DealsFragment
import com.ivione93.owned.TopOwnedFragment
import com.ivione93.rated.TopRatedFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val defaultOption = R.id.action_deals
    }

    private val fragments: HashMap<Int, Fragment> = hashMapOf(
        Pair(R.id.action_deals, DealsFragment()),
        Pair(R.id.action_top_rated, TopRatedFragment()),
        Pair(R.id.action_most_owned, TopOwnedFragment())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        navigationView.selectedItemId = defaultOption
        navigationView.setOnNavigationItemSelectedListener { item ->
            val fragment : Fragment? = fragments[item.itemId]

            if(fragment != null)
                replaceFragment(fragment)

            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun initView() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if(currentFragment == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, fragments[defaultOption]!!)
                .commit()
        }
    }
}