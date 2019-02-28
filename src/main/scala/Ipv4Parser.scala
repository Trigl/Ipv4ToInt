object Ipv4Parser {

  lazy val invalidException = new Exception("Invalid IPV4 format!")

  def ipv4ToLong(ip: String): Long = {
    if (ip.isEmpty || ip.startsWith(".") || ip.endsWith(".")) {
      throw invalidException
    }

    val strArray = ip.split('.')
    if (strArray.length != 4) {
      throw invalidException
    }

    val numArray = strArray.zipWithIndex.map {
      case (str, i) =>
        try {
          // 字符串转换成数字
          val num = str.trim.toLong
          // 右移
          num << (3 - i) * 8
        } catch {
          case e: Exception =>
            throw e
        }
    }

    numArray.reduce(_ + _)
  }

}
