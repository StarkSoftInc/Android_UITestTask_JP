package com.ory.stark.esigntesttask.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ory.stark.esigntesttask.databinding.FragmentMyDocsBinding

class MyDocsFragment : Fragment() {

    private lateinit var myDocsViewModel: MyDocsViewModel
    private var _binding: FragmentMyDocsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myDocsViewModel =
            ViewModelProvider(this).get(MyDocsViewModel::class.java)

        _binding = FragmentMyDocsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        myDocsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}