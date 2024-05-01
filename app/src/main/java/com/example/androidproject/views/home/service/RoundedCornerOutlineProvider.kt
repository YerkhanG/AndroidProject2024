package com.example.androidproject.views.home.service

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider

class RoundedCornerOutlineProvider(private val cornerRadius: Float): ViewOutlineProvider() {
    override fun getOutline(view: View?, outline: Outline?) {
        if (view != null && outline != null) {
            outline.setRoundRect(0, 0, view.width, view.height, cornerRadius)
        }
    }
}