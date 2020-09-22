package com.example.level3_task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_portals.*


const val REQ_PORTAL_KEY = "req_portal"
const val BUNDLE_PORTAL_KEY = "bundle_portal"

class AddPortalsFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_portals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddPortal.setOnClickListener {
            onAddPortal()
        }
    }

    private fun onAddPortal() {
        val portalText = etName.text.toString()
        val portalUrl = etUrl.text.toString()

        if (portalText.isNotBlank()) {
            //set the data as fragmentResult, we are listening for REQ_PORTAL_KEY in PortalsFragment!
            setFragmentResult(REQ_PORTAL_KEY, bundleOf(Pair(BUNDLE_PORTAL_KEY, portalText)))

            //"pop" the backstack, this means we destroy
            //this fragment and go back to the PortalsFragment
            findNavController().popBackStack()
        }
//        } else {
//            Toast.makeText(
//                activity,
//                R.string.not_valid_portal, Toast.LENGTH_SHORT
//            ).show()
//        }
    }
}