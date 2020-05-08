package ru.surrsoft.gfbh.units

/**
 * //needdesc
 * <p>
 * //new//
 */
object TUnit {

  private const val X1 = 0.029529983f
  private const val X2 = 0.75006158f
  private const val X3 = 100f

  fun convert(fromValue: Float, fromUnit: EUnit, toUnit: EUnit): Float {
    when (fromUnit) {

      // --- temperatures
      EUnit.CELSIUS -> {
        if (toUnit == EUnit.KELVIN) return fromValue + 273.15f
        if (toUnit == EUnit.FAHRENHEIT) return 9f / 5f * fromValue + 32
      }
      EUnit.KELVIN -> {
        if (toUnit == EUnit.CELSIUS) return fromValue - 273.15f
        if (toUnit == EUnit.FAHRENHEIT) {
          val celsius = convert(fromValue, EUnit.KELVIN, EUnit.CELSIUS)
          return convert(celsius, EUnit.CELSIUS, EUnit.FAHRENHEIT)
        }
      }
      EUnit.FAHRENHEIT -> {
        if (toUnit == EUnit.CELSIUS) return 5f / 9f * (fromValue - 32)
        if (toUnit == EUnit.KELVIN) {
          val celsius = convert(fromValue, EUnit.FAHRENHEIT, EUnit.CELSIUS)
          return convert(celsius, EUnit.CELSIUS, EUnit.KELVIN)
        }
      }

      // --- pressure
      EUnit.H_PASCAL -> {
        if (toUnit == EUnit.IN_HG) return fromValue * X1
        if (toUnit == EUnit.MM_HG) return fromValue * X2
        if (toUnit == EUnit.PASCAL) return fromValue * X3
      }
      EUnit.IN_HG -> {
        if (toUnit == EUnit.H_PASCAL) return fromValue / X1
        if (toUnit == EUnit.PASCAL) {
          val hPa = convert(fromValue, EUnit.IN_HG, EUnit.H_PASCAL)
          return convert(hPa, EUnit.H_PASCAL, EUnit.PASCAL)
        }
        if (toUnit == EUnit.MM_HG) {
          val hPa = convert(fromValue, EUnit.IN_HG, EUnit.H_PASCAL)
          return convert(hPa, EUnit.H_PASCAL, EUnit.MM_HG)
        }
      }
      EUnit.MM_HG -> {
        if (toUnit == EUnit.H_PASCAL) return fromValue / X2
        if (toUnit == EUnit.PASCAL) {
          val hPa = convert(fromValue, EUnit.MM_HG, EUnit.H_PASCAL)
          return convert(hPa, EUnit.H_PASCAL, EUnit.PASCAL)
        }
      }
      EUnit.PASCAL -> {
        if (toUnit == EUnit.H_PASCAL) return fromValue / X3
      }

      // --- time
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

}