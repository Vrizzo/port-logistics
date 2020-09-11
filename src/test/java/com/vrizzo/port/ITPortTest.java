package com.vrizzo.port;

import com.vrizzo.port.printer.PortInfoFormatter;
import org.junit.*;

import static org.hamcrest.CoreMatchers.is;

public class ITPortTest
{
  public static final Ship SHIP_4_CONTAINER = new Ship(4);
  String A_STANDARD_PORT_WITH_A_FULL_SHIP_AND_ONE_WAGON_READY = "-^-^\n"
      + " | |        \n"
      + " | |        \n"
      + "X| |        \n"
      + "X| |        \n"
      + "X| |        \n"
      + "X| |  X  D i\n"
      + "VA_A---::%%%\n";

  String A_STANDARD_PORT_WITH_A_FULL_SHIP = "-^-^\n"
      + " | |        \n"
      + " | |        \n"
      + "X| |        \n"
      + "X| |        \n"
      + "X| |        \n"
      + "X| |     D i\n"
      + "VA_A---::%%%\n";

  String A_STANDARD_PORT = "-^-^\n"
      + "| |        \n"
      + "| |        \n"
      + "| |        \n"
      + "| |        \n"
      + "| |        \n"
      + "| |     D i\n"
      + "A_A---::%%%\n";
  private Port port;

  @Test
  public void aPortWithOnlyAnEmptyShip()
  {
    final Train train = new Train(3);
    train.loadContainer(1);
    Port port = new Port(train, new ContainerStorage(6), new PortInfoFormatter());
    port.receiveShip(SHIP_4_CONTAINER);
    final String show = port.show();

    Assert.assertThat(show, is(A_STANDARD_PORT_WITH_A_FULL_SHIP_AND_ONE_WAGON_READY));
  }


  @Test
  public void testCase1()
  {
    Assert.assertThat(port.show(), is(A_STANDARD_PORT));
  }

  @Test
  public void testCase2()
  {
    port.receiveShip(SHIP_4_CONTAINER);
    Assert.assertThat(port.show(), is(A_STANDARD_PORT_WITH_A_FULL_SHIP));
  }

  @Before
  public void createPort()
  {
    final Train train = new Train(3);
    port = new Port(train, new ContainerStorage(6), new PortInfoFormatter());
  }
}
