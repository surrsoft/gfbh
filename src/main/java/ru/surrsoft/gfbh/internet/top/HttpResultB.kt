package ru.surrsoft.gfbh.internet.top

import retrofit2.Call
import retrofit2.Response

/**
 * Represents result of Retrofit-request
 */
class HttpResultB<T> {
  // TRUE if http code in 200..299
  var isSuccess = false
  var result: T? = null
  var response: Response<T>? = null
  var call: Call<T>? = null
  var ex: Throwable? = null

  companion object {
    fun <T> fromResponse(r: Response<T>, c: Call<T>): HttpResultB<T> {
      val ret = HttpResultB<T>()
      ret.isSuccess = r.isSuccessful
      ret.result = r.body()
      ret.response = r
      ret.call = c
      return ret
    }

    fun <T> fromFail(t: Throwable, c: Call<T>): HttpResultB<T> {
      val ret = HttpResultB<T>()
      ret.ex = t
      ret.call = c
      return ret
    }
  }

  override fun toString(): String {
    return "HttpResultB(isSuccess=$isSuccess, result=$result, response=$response, call=$call, ex=$ex)"
  }

  //

}