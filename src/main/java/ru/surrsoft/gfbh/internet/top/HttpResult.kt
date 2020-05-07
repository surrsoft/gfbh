package ru.surrsoft.gfbh.internet.top

/**
 * Represents string result of request
 */
class HttpResult(
  var bodyString: String? = null,
  var exMessage: String? = null,
  var httpCode: Int = 0,
  var resultConst: EResultConst = EResultConst.ERR_OTHER,
  var url: String = ""
) {

  //
  fun isSuccess() = resultConst == EResultConst.OK

  //
  override fun toString(): String {
    return "Result(" +
        "isSuccess=${isSuccess()}, " +
        "httpCode=$httpCode, " +
        "resultConst=$resultConst, " +
        "exMessage=$exMessage, " +
        "url=$url, " +
        "string=$bodyString" +
        ")"
  }
}