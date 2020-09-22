package com.example.level3_task2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.*
import kotlinx.android.synthetic.main.fragment_portals.*
import android.app.PendingIntent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PortalsFragment : Fragment() {

    private val portals = arrayListOf<Portal>()
    private val portalAdapter = PortalAdapter(portals, { portal : Portal -> portalClicked(portal) })

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        // Initialize the recycler view with a linear layout manager, adapter
        rvPortals.layoutManager =
            GridLayoutManager(context, 2)
        rvPortals.adapter = portalAdapter
        rvPortals.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
        observeAddPortalResult()
    }

    private fun observeAddPortalResult() {
        setFragmentResultListener(REQ_PORTAL_KEY) { key, bundle ->
            bundle.getParcelable<Portal>(BUNDLE_PORTAL_KEY).let {
                if (it is Portal){
                    portals.add(it)
                    portalAdapter.notifyDataSetChanged()
                }
            } ?: Log.e("PortalFragment", "Request triggered, but empty portal text!")
        }
    }

    private fun portalClicked(portal : Portal) {
        Toast.makeText(context, portal.portalName, Toast.LENGTH_LONG).show()
    }
}