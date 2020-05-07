package ru.surrsoft.gfbh.other

import org.junit.Test

import org.junit.Assert.*
import org.threeten.bp.Instant

/**
 * //needdesc
 *
 *
 * //new//
 */
class KrDateTest {

  @Test
  fun fromYata() {
    val yata = 1460266975856L
    val krDate = KrDate().fromYata(yata)
    println(krDate)
  }
}