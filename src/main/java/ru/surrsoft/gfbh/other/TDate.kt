package ru.surrsoft.gfbh.other

import tech.units.indriya.unit.Units.SECOND
import javax.measure.MetricPrefix
import javax.measure.quantity.Time
import javax.measure.Unit as Unit2

/**
 * //needdesc
 * <p>
 * //new//
 */
object TDate {
    
    /**
     * Return current dateTime as 'unixtime millisecons' ({yata}-format)
     */
    fun currentAsYataGet(): Long {
        return System.currentTimeMillis()
    }
    
    /**
     * Synonym for [currentAsYataGet]
     */
    fun currentAsMillisecGet(): Long {
        return currentAsYataGet()
    }
    
    /**
     * {IN WORK}
     *
     * Current time
     * @param format example 'MetricPrefix.MILLI(SECOND)'
     */
    fun currentGet_tmp(format: Unit2<Time>): Long {
        // --- return as {yata}-format (unixtime milliseconds)
        if (format == MetricPrefix.MILLI(SECOND)) {
            return System.currentTimeMillis()
        }
        throw Exception("ERR*: wrong format; format [${format}] {200516104400}")
    }
    
    fun durationGet(yata: Long): Long {
        return currentAsYataGet() - yata
    }
}