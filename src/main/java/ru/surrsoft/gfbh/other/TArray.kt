package ru.surrsoft.gfbh.other

/**
 * Unitlity to work with Arrays
 *
 * @see <a href="https://bit.ly/3fG3ELk">https://bit.ly/3fG3ELk</a>
 */
object TArray {

  /**
   * Represents [arr] as String
   */
  fun <T> toStringA(arr: Array<T>): String {
    return arr.contentToString()
  }

}