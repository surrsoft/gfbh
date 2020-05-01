package ru.surrsoft.gfbh.widgets

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

/**
 * //needdesc
 * <p>
 * //new//
 */
class BuLayLinear(private val context: Context) {
  private var bgColor: Int = Color.TRANSPARENT
  private var mActy: Activity? = null
  private var mParent: ViewGroup? = null
  private val childs = ArrayList<View>()
  private var orientHorizontal = true

  fun buAddTo(lay: ViewGroup): BuLayLinear {
    mParent = lay;
    return this
  }

  fun buAsContentView(acty: Activity): BuLayLinear {
    mActy = acty
    return this
  }

  fun buAddChild(child: View): BuLayLinear {
    childs.add(child)
    return this
  }

  fun buVertical(v: Boolean = true): BuLayLinear {
    orientHorizontal = !v
    return this
  }

  fun buHorizontal(v: Boolean = true): BuLayLinear {
    orientHorizontal = v
    return this
  }

  fun buBgColor(v: Int): BuLayLinear {
    bgColor = v
    return this
  }

  fun build(): LinearLayout {
    val lay = LinearLayout(context)
    // --- layout params
    val lp = LinearLayout.LayoutParams(
      LinearLayout.LayoutParams.MATCH_PARENT,
      LinearLayout.LayoutParams.WRAP_CONTENT
    )
    lay.layoutParams = lp
    // --- bg color
    lay.setBackgroundColor(bgColor)
    // --- orientation
    lay.orientation = if (orientHorizontal) LinearLayout.HORIZONTAL else LinearLayout.VERTICAL
    // ---
    if (childs.size > 0) {
      for (child in childs) {
        lay.addView(child)
      }
    }
    // ---
    if (mActy != null) {
      mActy!!.setContentView(lay)
    }
    return lay
  }
}