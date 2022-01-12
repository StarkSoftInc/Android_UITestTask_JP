package com.ory.stark.esigntesttask.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Oryna Starkina on 20.08.2020.
 */
open class SpacingItemDecorator(
    protected val itemOffsetStart: Int? = null,
    protected val itemOffsetTop: Int? = null,
    protected val itemOffsetEnd: Int? = null,
    protected val itemOffsetBottom: Int? = null
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.set(
            itemOffsetStart ?: outRect.left,
            itemOffsetTop ?: outRect.top,
            itemOffsetEnd ?: outRect.right,
            itemOffsetBottom ?: outRect.bottom
        )
    }
}