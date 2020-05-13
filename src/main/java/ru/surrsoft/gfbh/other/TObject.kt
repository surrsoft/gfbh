package ru.surrsoft.gfbh.other

/**
 * //needdesc
 * <p>
 * //new//
 */
object TObject {

  /**
   * Return object (1) in form pretty JSON string
   */
  fun asString(oj: Any?): String {
    if (oj !== null) {
      val p = Aene.gsonPretty ?: return "ERR*: Aene.gsonPretty is not configured"
      return p.toJson(oj)
    }
    return "null"
  }

}