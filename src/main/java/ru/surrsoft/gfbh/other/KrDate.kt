package ru.surrsoft.gfbh.other

import org.threeten.bp.Instant

/**
 * Date incarnation.
 *
 * Main field is mDateTime.
 * If value not setted that [isSetted] returns FALSE.
 *
 * Concepts:
 * {yata} - unixtime milliseconds, example 1460266975856
 * {eavv} - unixtime seconds, example 1460266975
 */
class KrDate {

  // {yata} (unixtime millisec)
  private var mDateTime: Long = 0

  private var mDateTimeInstant: Instant = Instant.now()

  // FALSE if value yet not setted
  private var bSetted: Boolean = false

  // ---

  /**
   * @param yata unixtime milliseconds, example 1460266975856
   */
  fun fromYata(yata: Long) {
    bSetted = true
    mDateTime = yata
    mDateTimeInstant = Instant.ofEpochMilli(yata)
  }

  fun fromYataB(yata: String) {
    try {
      val yataLong = yata.toLong()
      fromYata(yataLong)
    } catch (e: NumberFormatException) {
      Ub.exAsStringAndToLog(e)
    }
  }

  /**
   * @param eavv unixtime seconds, example 1460266975
   */
  fun fromEavv(eavv: Long) {
    try {
      val yata = eavv * 1000
      fromYata(yata)
    } catch (e: Exception) {
      Ub.exAsStringAndToLog(e)
    }
  }

  fun fromEavvB(eavv: String) {
    try {
      val eavvLong = eavv.toLong()
      fromEavv(eavvLong)
    } catch (e: Exception) {
      Ub.exAsStringAndToLog(e)
    }
  }

  fun isSetted(): Boolean = bSetted

  override fun toString(): String {
    return "KrDate(mDateTime=$mDateTime, mDateTimeInstant=$mDateTimeInstant, bSetted=$bSetted)"
  }


}