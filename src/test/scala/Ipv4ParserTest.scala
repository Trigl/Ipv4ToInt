import org.scalatest.FunSuite

class Ipv4ParserTest extends FunSuite {
  import Ipv4Parser.ipv4ToLong

  test ("IPV4 address should not be null") {
    assertThrows[Exception](ipv4ToLong(null))
  }

  test ("IPV4 address should not be blank string") {
    assertThrows[Exception](ipv4ToLong(""))
  }

  test ("IPV4 address should not be blank spaces") {
    assertThrows[Exception](ipv4ToLong("   "))
  }

  test ("IPV4 address should not start with '.'") {
    assertThrows[Exception](ipv4ToLong(".168.5.1"))
  }

  test ("IPV4 address should not end with '.'") {
    assertThrows[Exception](ipv4ToLong("172.168.5."))
  }

  test ("IPV4 address can't have blank spaces inside a number") {
    assertThrows[Exception](ipv4ToLong("1  72.168.5.1"))
  }

  test ("IPV4 address's dot should be 3") {
    assertThrows[Exception](ipv4ToLong("172.168.5"))
  }

  test ("IPV4 address must contain number between dot") {
    assertThrows[Exception](ipv4ToLong("172..5.1"))
  }

  test ("IPV4 address can start with blank spaces") {
    assert(ipv4ToLong("  172.168.5.1").isValidLong)
  }

  test ("IPV4 address can have blank spaces between number and dot") {
    assert(ipv4ToLong("172  .168.5.1").isValidLong)
  }
}
