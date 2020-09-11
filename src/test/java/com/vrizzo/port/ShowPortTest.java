package com.vrizzo.port;

import com.vrizzo.port.printer.PortInfoFormatter;
import org.junit.*;

import static org.hamcrest.CoreMatchers.is;

public class ShowPortTest
{
  String A_STANDARD_PORT_WITH_ONLY_A_FULL_SHIP = "-^-^\n"
      + " | |\n"
      + "X| |\n"
      + "X| |\n"
      + "X| |\n"
      + "X| |  X  D i\n"
      + "VA_A---::%%%";
  
  String A_PORT_WITH_ONLY_AN_EMPTY_SHIP =  "-^-^\n"
                                         + "\n"
                                         + "X\n"
                                         + "X\n"
                                         + "X\n"
                                         + "X\n"
                                         + "V";
  @Test
  @Ignore
  public void aPortWithOnlyAnEmptyShip()
  {
    System.out.println(A_PORT_WITH_ONLY_AN_EMPTY_SHIP);
    final Ship ship = new Ship(4);
    Port port = new Port(ship, new PortInfoFormatter());
    Assert.assertThat(port.show(), is(A_PORT_WITH_ONLY_AN_EMPTY_SHIP));
  }

}
