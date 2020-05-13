package ru.surrsoft.gfbh.units

import si.uom.NonSI.INCH_OF_MERCURY
import si.uom.NonSI.MILLIMETRE_OF_MERCURY
import systems.uom.common.USCustomary.FAHRENHEIT
import tech.units.indriya.unit.Units.*
import javax.measure.MetricPrefix
import javax.measure.Quantity
import javax.measure.UnitConverter

/**
 * Utility functions to Units convert on base "indriya"-library
 */
object TUnitB {


  /**
   *
   */
  fun convert(fromValue: Float, fromUnit: EUnit, toUnit: EUnit): Float {

    when (fromUnit) {
      // --- temperature
      EUnit.CELSIUS -> {
        if (toUnit == EUnit.KELVIN) return fn1(CELSIUS.getConverterTo(KELVIN), fromValue)
        if (toUnit == EUnit.FAHRENHEIT) return fn1(CELSIUS.getConverterTo(FAHRENHEIT), fromValue)
      }
      EUnit.KELVIN -> {
        if (toUnit == EUnit.CELSIUS) return fn1(KELVIN.getConverterTo(CELSIUS), fromValue)
        if (toUnit == EUnit.FAHRENHEIT) return fn1(KELVIN.getConverterTo(FAHRENHEIT), fromValue)
      }
      EUnit.FAHRENHEIT -> {
        if (toUnit == EUnit.CELSIUS) return fn1(FAHRENHEIT.getConverterTo(CELSIUS), fromValue)
        if (toUnit == EUnit.KELVIN) return fn1(FAHRENHEIT.getConverterTo(KELVIN), fromValue)
      }

      // --- pressure
      EUnit.PASCAL -> {
        if (toUnit == EUnit.HECTO_PASCAL) {
          return fn1(PASCAL.getConverterTo(MetricPrefix.HECTO(PASCAL)), fromValue)
        }
        if (toUnit == EUnit.MM_HG) {
          return fn1(PASCAL.getConverterTo(MILLIMETRE_OF_MERCURY), fromValue)
        }
        if (toUnit == EUnit.IN_HG) {
          return fn1(PASCAL.getConverterTo(INCH_OF_MERCURY), fromValue)
        }
      }
      EUnit.HECTO_PASCAL -> {
        val hPa = MetricPrefix.HECTO(PASCAL)
        // ---
        if (toUnit == EUnit.MM_HG) return fn1(hPa.getConverterTo(MILLIMETRE_OF_MERCURY), fromValue)
        if (toUnit == EUnit.IN_HG) return fn1(hPa.getConverterTo(INCH_OF_MERCURY), fromValue)
        if (toUnit == EUnit.PASCAL) return fn1(hPa.getConverterTo(PASCAL), fromValue)
      }
      EUnit.MM_HG -> {
        if (toUnit == EUnit.HECTO_PASCAL) {
          return fn1(MILLIMETRE_OF_MERCURY.getConverterTo(MetricPrefix.HECTO(PASCAL)), fromValue)
        }
        if (toUnit == EUnit.PASCAL) {
          return fn1(MILLIMETRE_OF_MERCURY.getConverterTo(PASCAL), fromValue)
        }
        if (toUnit == EUnit.IN_HG) {
          return fn1(MILLIMETRE_OF_MERCURY.getConverterTo(INCH_OF_MERCURY), fromValue)
        }
      }
      EUnit.IN_HG -> {
        if (toUnit == EUnit.HECTO_PASCAL) {
          return fn1(INCH_OF_MERCURY.getConverterTo(MetricPrefix.HECTO(PASCAL)), fromValue)
        }
        if (toUnit == EUnit.PASCAL) {
          return fn1(INCH_OF_MERCURY.getConverterTo(PASCAL), fromValue)
        }
        if (toUnit == EUnit.MM_HG) {
          return fn1(INCH_OF_MERCURY.getConverterTo(MILLIMETRE_OF_MERCURY), fromValue)
        }
      }

      // ---
      EUnit.SECOND -> TODO()
      EUnit.HOUR -> TODO()
      EUnit.METER -> TODO()
      EUnit.KILOMETER -> TODO()
      EUnit.METER_PER_SECOND -> TODO()
    }
    // ---
    throw Exception(
      "ERR*: error convert; fromValue [$fromValue], fromUnit [$fromUnit]; " +
          "toUnit [$toUnit]; {200508090500}"
    )
  }

  /**
   *
   */
  private fun fn1(uc: UnitConverter, value: Float): Float {
    return uc.convert(value).toFloat()
  }


}