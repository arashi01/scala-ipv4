package be.jvb.datatypes

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec


/**
 * @author <a href="http://janvanbesien.blogspot.com">Jan Van Besien</a>
 */
class IpAddressRangeExample extends WordSpec with ShouldMatchers {
  "An ip address range" should {
    val range = new IpAddressRange(new IpAddress("192.168.0.1"), new IpAddress("192.168.0.5"))

    "be constructable from two ip addresses" in {
      new IpAddressRange(new IpAddress("192.168.0.1"), new IpAddress("192.168.0.5")) should be(range)
    }

    "have a length equal to the number of addresses in the range" in {
      range.length should be(range.addresses.size)
    }

    "have a method to check if it contains an address" in {
      range.contains(new IpAddress("192.168.0.3")) should be(true)
      range.contains(new IpAddress("192.168.0.13")) should be(false)
    }

    "have a method to check if it contains another range" in {
      range.contains(new IpAddressRange(new IpAddress("192.168.0.3"), new IpAddress("192.168.0.5"))) should be(true)
      range.contains(new IpAddressRange(new IpAddress("192.168.0.13"), new IpAddress("192.168.0.15"))) should be(false)
      range.contains(new IpAddressRange(new IpAddress("192.168.0.3"), new IpAddress("192.168.0.15"))) should be(false)
    }

    "have a method to check if it overlaps with another range" in {
      range.overlaps(new IpAddressRange(new IpAddress("192.168.0.3"), new IpAddress("192.168.0.5"))) should be(true)
      range.overlaps(new IpAddressRange(new IpAddress("192.168.0.13"), new IpAddress("192.168.0.15"))) should be(false)
      range.overlaps(new IpAddressRange(new IpAddress("192.168.0.3"), new IpAddress("192.168.0.15"))) should be(true)
    }

    "be comparable" in {
      range > new IpAddressRange(new IpAddress("192.168.0.3"), new IpAddress("192.168.0.5")) should be(false)
      range < new IpAddressRange(new IpAddress("192.168.0.13"), new IpAddress("192.168.0.15")) should be(true)
      range >= new IpAddressRange(new IpAddress("192.168.0.3"), new IpAddress("192.168.0.15")) should be(false)
    }

    "have a method to subtract something from the range, resulting in to different ranges" in {
      fail("todo")
    }

  }
}