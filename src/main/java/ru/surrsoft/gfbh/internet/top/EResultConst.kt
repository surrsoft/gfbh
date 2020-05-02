package ru.surrsoft.gfbh.internet.top

/**
 *
 */
enum class EResultConst {
  /**
   * Тело ответа успешно получено. Код ответа в диапазоне 200..300 (включительно)
   */
  OK,

  /**
   * Тело ответа успешно получено. Код ответа вне диапазона 200...300 (включительно)
   */
  KO,

  /**
   * Ошибка при извлечении тела ответа
   */
  ERR_BODY,

  /**
   * Неизвестный хост (java.net.UnknownHostException)
   */
  ERR_UNKNOWN_HOST,

  /**
   * Нет соединения или обрыв соединения (java.net.ConnectException)
   */
  ERR_CONNECT,

  /**
   * Истек таймаут (java.net.SocketTimeoutException)
   */
  ERR_TIMEOUT,

  /**
   * Другая ошибка во время запроса (IOException)
   */
  ERR_IOE,

  /**
   * Прочее
   */
  ERR_OTHER,
}