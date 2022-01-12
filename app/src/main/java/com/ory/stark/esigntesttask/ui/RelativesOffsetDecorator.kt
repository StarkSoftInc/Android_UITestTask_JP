package com.ory.stark.esigntesttask.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Oryna Starkina on 20.08.2020.
 */
class RelativesOffsetDecorator(
    private val firstItemOffsetStart: Int? = null,
    private val firstItemOffsetTop: Int? = null,
    itemOffsetStartId: Int? = null,
    itemOffsetTopId: Int? = null,
    itemOffsetEndId: Int? = null,
    itemOffsetBottomId: Int? = null
) : SpacingItemDecorator(
    itemOffsetStartId,
    itemOffsetTopId,
    itemOffsetEndId,
    itemOffsetBottomId
) {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.set(
                firstItemOffsetStart ?: itemOffsetStart ?: outRect.left,
                firstItemOffsetTop ?: itemOffsetTop ?: outRect.top,
                itemOffsetEnd ?: outRect.right,
                itemOffsetBottom ?: outRect.bottom
            )
        } else {
            super.getItemOffsets(outRect, view, parent, state)
        }
    }
}