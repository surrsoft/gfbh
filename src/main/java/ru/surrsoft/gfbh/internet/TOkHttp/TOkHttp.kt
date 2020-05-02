package ru.surrsoft.gfbh.internet.TOkHttp

import android.util.Log
import okhttp3.*
import ru.surrsoft.gfbh.internet.top.EResultConst
import ru.surrsoft.gfbh.internet.top.HttpRequestResult
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
  fun requestAsync(url: String, cb: (HttpRequestResult) -> Unit) {
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
              HttpRequestResult(httpCode = response.code(), url = url)
            // --- body
            try {
              val body = response.body()
              r.bodyString = body?.string()
            } catch (e: java.lang.Exception) {
              r.resultConst = EResultConst.ERR_BODY
            }
            // --- resultConst
            val code = response.code()
            when {
              code == 200 -> r.resultConst = EResultConst.OK
              code != 200 -> r.resultConst = EResultConst.KO
            }
            // ---
            cb(r)
          }

          override fun onFailure(call: Call, e: IOException) {
            val r = HttpRequestResult(
              exMessage = mtExceptionAsString(e)
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
      val result = HttpRequestResult(
        exMessage = mtExceptionAsString(e)
      )
      cb(result)
    }
  }

  // --- private

  private fun mtExceptionAsString(e: java.lang.Exception) =
    "ERR*: ${e::class.qualifiedName} : ${e.message}"


}