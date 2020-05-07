package ru.surrsoft.gfbh.internet.TOkHttp

import okhttp3.*
import ru.surrsoft.gfbh.internet.top.EResultConst
import ru.surrsoft.gfbh.internet.top.HttpResult
import ru.surrsoft.gfbh.other.U
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * //needdesc
 * <p>
 * //new//
 */
object TOkHttp {

  /**
   * Perform async GET request to [url] for get answer as String.
   *
   * @param url example 'https://yandex.ru?param=1'
   * @param cb callback to result; performs on UI thread
   */
  fun requestAsync(url: String, cb: (HttpResult) -> Unit) {
    try {
      // --- req
      val req = Request.Builder()
        .url(url)
        .build()
      // --- client
      val okHttpClient = OkHttpClient()
      // --- request
      okHttpClient
        .newCall(req)
        .enqueue(object : Callback {
          override fun onResponse(call: Call, response: Response) {
            // ---
            val r =
              HttpResult(httpCode = response.code(), url = url)
            // --- body
            try {
              val body = response.body()
              r.bodyString = body?.string()
            } catch (e: java.lang.Exception) {
              r.resultConst = EResultConst.ERR_BODY
            }
            // --- resultConst
            when (response.code()) {
              in 200..299 -> r.resultConst = EResultConst.OK
              else -> r.resultConst = EResultConst.KO
            }
            // ---
            cb(r)
          }

          override fun onFailure(call: Call, e: IOException) {
            val r = HttpResult(
              exMessage = U.exAsString(e)
            )
            // ---
            when (e::class.java) {
              UnknownHostException::class.java -> r.resultConst = EResultConst.ERR_UNKNOWN_HOST
              ConnectException::class.java -> r.resultConst = EResultConst.ERR_CONNECT
              SocketTimeoutException::class.java -> r.resultConst = EResultConst.ERR_TIMEOUT
              IOException::class.java -> r.resultConst = EResultConst.ERR_IOE
            }
            // ---
            cb(r)
          }
        })
    } catch (e: Exception) {
      val result = HttpResult(
        exMessage = U.exAsString(e)
      )
      cb(result)
    }
  }

}