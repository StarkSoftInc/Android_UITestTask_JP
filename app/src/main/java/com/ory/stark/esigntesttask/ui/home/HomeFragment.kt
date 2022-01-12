package com.ory.stark.esigntesttask.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ory.stark.esigntesttask.R
import com.ory.stark.esigntesttask.databinding.FragmentHomeBinding
import com.ory.stark.esigntesttask.ui.RelativesOffsetDecorator

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val recentActionsAdapter = RecentActionsAdapter(
        arrayListOf(
            RecentAction("Lease Agreement.pdf", DocumentStatus.Signed),
            RecentAction("Durable Power of Attorney.pdf", DocumentStatus.Voided),
            RecentAction("Motor Vehicle Bill of Sale Form.docx", DocumentStatus.Waiting),
            RecentAction("Residential Month-to-Month to…pdf", DocumentStatus.Signed)
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        _binding?.homePageRecentActions?.run {
            hasFixedSize()
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL, false
            )
            setHasFixedSize(false)

            adapter = recentActionsAdapter

            addItemDecoration(
                RelativesOffsetDecorator(
                    itemOffsetTopId = resources.getDimensionPixelSize(R.dimen.dp_4),
                    itemOffsetBottomId = resources.getDimensionPixelSize(R.dimen.dp_4)
                )
            )
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}