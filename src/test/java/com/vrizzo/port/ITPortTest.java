package com.vrizzo.port;

import com.vrizzo.port.printer.PortInfoFormatter;
import org.junit.*;

import static org.hamcrest.CoreMatchers.is;

public class ITPortTest
{
  String A_STANDARD_PORT_WITH_A_FULL_SHIP_AND_ONE_WAGON_READY = "-^-^\n"
      + " | |        \n"
      + " | |        \n"
      + "X| |        \n"
      + "X| |        \n"
      + "X| |        \n"
      + "X| |  X  D i\n"
      + "VA_A---::%%%\n";
  
  @Test
  public void aPortWithOnlyAnEmptyShip()
  {
    final Ship ship = new Ship(4);
    final Train train = new Train(3);
    train.loadContainer(1);
    Port port = new Port(train, new ContainerStorage(6), new PortInfoFormatter());
    port.receiveShip(ship);
    final String show = port.show();

    Assert.assertThat(show, is(A_STANDARD_PORT_WITH_A_FULL_SHIP_AND_ONE_WAGON_READY));
  }


}
