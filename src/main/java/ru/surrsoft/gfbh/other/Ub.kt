package ru.surrsoft.gfbh.other

import android.util.Log
import ru.surrsoft.gfbh.other.U.exAsString

/**
 * Universal functions with depends on Android
 */
object Ub {

  fun exAsStringAndToLog(e: Throwable?) {
    Log.w(Aene.projectNameForLog, exAsString(e))
  }

}