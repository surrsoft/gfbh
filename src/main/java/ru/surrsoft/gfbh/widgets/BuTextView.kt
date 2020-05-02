package ru.surrsoft.gfbh.widgets

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import ru.surrsoft.gfbh.other.TConsts
import ru.surrsoft.gfbh.other.U

/**
 * //needdesc
 * <p>
 * //new//
 */
class BuTextView(private val context: Context) {

  private var mW_px: Int = TConsts.WC
  private var mH_px: Int = TConsts.WC
  private var mLayParamClass: Class<Any>? = null
  private var mGravitySelfConst: Int = 0
  private var mGravityInConst: Int = 0
  private var mPaddingL_px: Int = 0
  private var mPaddingT_px: Int = 0
  private var mPaddingR_px: Int = 0
  private var mPaddingB_px: Int = 0
  private var textColor: Int = Color.BLACK
  private var bgColor: Int = Color.TRANSPARENT
  private var mOnclick: View.OnClickListener? = null
  private var mParent: ViewGroup? = null
  private var text: String = "";

  fun buText(value: String): BuTextView {
    text = value;
    return this
  }

  fun buAddTo(v: ViewGroup): BuTextView {
    mParent = v
    return this
  }

  fun buOnclick(v: View.OnClickListener): BuTextView {
    mOnclick = v;
    return this
  }

  fun buBgColor(color: Int): BuTextView {
    bgColor = color;
    return this
  }

  fun buTextColor(color: Int): BuTextView {
    textColor = color
    return this
  }

  fun buPaddings(l_dp: Int, t_dp: Int, r_dp: Int, b_dp: Int): BuTextView {
    mPaddingL_px = U.px(l_dp)
    mPaddingT_px = U.px(t_dp)
    mPaddingR_px = U.px(r_dp)
    mPaddingB_px = U.px(b_dp)
    return this
  }

  fun buPaddings(dp: Int): BuTextView {
    mPaddingL_px = U.px(dp)
    mPaddingT_px = U.px(dp)
    mPaddingR_px = U.px(dp)
    mPaddingB_px = U.px(dp)
    return this
  }

  /**
   * Set gravity TextView relative it container
   * @param gravityConst -- example Gravity.CENTER_VERTICAL
   */
  fun buGravitySelf(gravityConst: Int): BuTextView {
    mGravitySelfConst = gravityConst
    return this
  }

  /**
   * @param gravityConst -- example Gravity.CENTER_VERTICAL
   */
  fun buGravityIn(gravityConst: Int): BuTextView {
    mGravityInConst = gravityConst
    return this
  }


  fun buLayParamCclass(cls: Class<Any>): BuTextView {
    this.mLayParamClass = cls
    return this
  }

  fun buW(dp: Int): BuTextView {
    mW_px = U.px(dp)
    return this
  }

  fun buH(dp: Int): BuTextView {
    mH_px = U.px(dp)
    return this
  }

  public fun buWMP(): BuTextView {
    mW_px = TConsts.MP
    return this
  }

  public fun buWWC(): BuTextView {
    mW_px = TConsts.WC
    return this
  }

  public fun buHMP(): BuTextView {
    mH_px = TConsts.MP
    return this
  }

  public fun buHWC(): BuTextView {
    mH_px = TConsts.WC
    return this
  }

  // ---

  fun build(): TextView {
    val tv = TextView(context)
    // --- text
    tv.text = text
    // --- bgColor
    tv.setBackgroundColor(bgColor)
    // --- text color
    tv.setTextColor(textColor)
    // --- onclick
    if (mOnclick != null) {
      tv.setOnClickListener(mOnclick)
    }
    // ---
    tv.setPadding(mPaddingL_px, mPaddingT_px, mPaddingR_px, mPaddingB_px)
    // --- parent
    mParent?.addView(tv)
    // ---
    val lp = mtGetLP(tv)
    // ---
    lp.width = mW_px
    lp.height = mH_px
    // --- gravity self
    if (mGravitySelfConst != 0) {
      if (lp::class == LinearLayout.LayoutParams::class) {
        (lp as LinearLayout.LayoutParams).gravity = mGravitySelfConst
      } else if (lp::class == FrameLayout.LayoutParams::class) {
        (lp as FrameLayout.LayoutParams).gravity = mGravitySelfConst
      }
    }
    // --- gravity in
    if(mGravityInConst != 0){
      tv.gravity = mGravityInConst
    }
    // ---
    return tv
  }

  private fun mtGetLP(tv: TextView): ViewGroup.LayoutParams {
    var lp = tv.layoutParams
    if (lp !== null) return lp
    // ---
    if (mLayParamClass != null) {
      if (mLayParamClass!! == RelativeLayout.LayoutParams::class) {
        lp = RelativeLayout.LayoutParams(mW_px, mH_px)
      } else if (mLayParamClass!! == FrameLayout.LayoutParams::class) {
        lp = FrameLayout.LayoutParams(mW_px, mH_px)
      }
    }
    if (lp == null) {
      lp = LinearLayout.LayoutParams(mW_px, mH_px)
    }
    return lp
  }


}