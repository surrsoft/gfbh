package ru.surrsoft.gfbh.other

import android.app.Application
import android.content.SharedPreferences
import android.content.res.AssetManager
import android.content.res.Resources
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.threetenabp.AndroidThreeTen

/**
 * Аналог {bysa}.
 * Следует использовать в корневом App путём вызова Aene.initDefault(..)
 * <p>
 * //new//
 */
object Aene {
  var projectNameForLog = "@dfl@"
  var assets: AssetManager? = null
  var confLanguagesList: Array<String> = arrayOf()
  var gsonPretty: Gson? = null
  var gson: Gson? = null
  var sharprefCommon: SharedPreferences? = null
  var density: Float? = null
  var scaledDensity: Float? = null
  var res: Resources? = null
  var appContext: Application? = null

  fun initDefault(appContext: Application) {
    Aene.appContext = appContext
    res = appContext.resources
    assets = appContext.assets
    density = appContext.resources.displayMetrics.density
    scaledDensity = appContext.resources.displayMetrics.scaledDensity
    sharprefCommon = appContext.getSharedPreferences(TConsts.SHARPREF_COMMON_NAME, 0)
    gson = Gson()
    gsonPretty = GsonBuilder().setPrettyPrinting().create()
    confLanguagesList = arrayOf("en", "ru")
    // --- {ru} инициализация временнЫх зон библиотеки работы со временем "ThreeTenABP"
    AndroidThreeTen.init(appContext)
  }
}