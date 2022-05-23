package com.bosta.task.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacesItemDecorationUtil(space: Int) : RecyclerView.ItemDecoration() {

    private val top: Int = space
    private val right: Int = space
    private val bottom: Int = space
    private val left: Int = space

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.left = left
        outRect.right = right
        outRect.bottom = bottom

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildAdapterPosition(view) in 0..2) {
            outRect.top = top
        }
    }
}