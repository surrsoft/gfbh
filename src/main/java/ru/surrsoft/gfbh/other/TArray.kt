package ru.surrsoft.gfbh.other

/**
 * Unitlity to work with Arrays
 */
object TArray {

  /**
   * Represents [arr] as String
   */
  fun <T> toStringA(arr: Array<T>): String {
    return arr.contentToString()
  }

}