package ru.surrsoft.gfbh.other

import kotlin.math.roundToInt

/**
 * Universal functions
 */
object U {
  /**
   * If [b] TRUE then throw exception with text [t] (with prefix)
   */
  fun se(b: Boolean, t: String = "") {
    if (b) {
      throw RuntimeException("ERR*: $t")
    }
  }

  /**
   * Converts dip ([dp]) to px
   */
  fun px(dp: Float): Int {
    if (dp == 0f) return 0
    // ---
    val i = (dp * Aene.density!!).roundToInt()
    if (i < 1) return 1
    return i
  }

  /**
   * Converts dip ([dp]) to px
   */
  fun px(dp: Int): Int {
    return px(dp.toFloat())
  }

  /**
   * Convert [px] to dip
   */
  fun dp(px: Int): Int {
    if (px == 0) return 0
    val i = (px / Aene.density!!).roundToInt()
    if (i < 1) return 1
    return i
  }

}