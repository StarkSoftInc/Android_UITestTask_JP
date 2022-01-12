package com.ory.stark.esigntesttask.ui.home

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
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
    ): View {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        _binding?.homePageUpgradeBtn?.setOnClickListener {
            crossfadeSignRequestsView()
        }

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

    private fun crossfadeSignRequestsView() {

        val shortAnimationDuration = resources.getInteger(android.R.integer.config_shortAnimTime)
        binding.homePageSignRequests.apply {
            // Set the content view to 0% opacity but visible, so that it is visible
            // (but fully transparent) during the animation.
            alpha = 1f
            visibility = View.VISIBLE

            // Animate the content view to 100% opacity, and clear any animation
            // listener set on the view.
            animate()
                .alpha(0f)
                .setDuration(shortAnimationDuration.toLong())
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        binding.homePageSignRequests.visibility = View.GONE
                    }
                })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}