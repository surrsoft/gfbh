package ru.surrsoft.gfbh.widgets

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/**
 * //needdesc
 * <p>
 * //new//
 */
class BuButton(private val context: Context) {

  private var mOnclick: View.OnClickListener? = null
  private var mParent: ViewGroup? = null
  private var text: String = "button";

  fun buText(value: String): BuButton {
    text = value;
    return this
  }

  fun buAddTo(v: ViewGroup): BuButton {
    mParent = v
    return this
  }

  fun buOnclick(v: View.OnClickListener): BuButton {
    mOnclick = v;
    return this
  }

  fun build(): Button {
    val btn = Button(context)
    // --- text
    btn.text = text
    // --- onclick
    if (mOnclick != null) {
      btn.setOnClickListener(mOnclick)
    }
    // --- parent
    mParent?.addView(btn)
    // ---
    return btn
  }
}