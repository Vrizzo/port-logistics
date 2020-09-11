package com.vrizzo.port;

import com.vrizzo.port.formatter.PortInfoFormatter;
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

  String A_STANDARD_PORT_WITH_UNLOADED_SHIP_AND_A_LOADED_TRAIN = "-^-^\n"
      + " | |        \n"
      + " | |        \n"
      + " | |        \n"
      + " | |        \n"
      + " | |        \n"
      + " |X|XXX  D i\n"
      + "VA_A---::%%%\n";

  String A_STANDARD_PORT_WITH_UNLOADED_SHIP_AND_A_LOADED_TRAIN_TEST4 = "-^-^\n"
      + " | |        \n"
      + " |X|        \n"
      + " |X|        \n"
      + " |X|        \n"
      + " |X|        \n"
      + " |X|XXX  D i\n"
      + "VA_A---::%%%\n";

  String A_STANDARD_PORT_WITH_UNLOADED_SHIP_AND_A_LOADED_TRAIN_TEST5 = "-^-^\n"
      + " |X|        \n"
      + " |X|        \n"
      + " |X|        \n"
      + "X|X|        \n"
      + "X|X|        \n"
      + "X|X|     D i\n"
      + "VA_A---::%%%\n";
  private Port port;

  @Test
  public void aPortWithOnlyAnEmptyShip()
  {
    final Train train = new Train(3);
    train.load(1);
    final ContainerStorage containerStorage = new ContainerStorage(6);
    Port port = new Port(train, containerStorage, new Crane(), new Crane(
    ), new PortInfoFormatter());
    port.receiveShip(new Ship(4));
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
    port.receiveShip(new Ship(4));
    Assert.assertThat(port.show(), is(A_STANDARD_PORT_WITH_A_FULL_SHIP));
  }

  @Test
  public void testCase3()
  {
    port.receiveShip(new Ship(4));
    port.unload();
    Assert.assertThat(port.show(), is(A_STANDARD_PORT_WITH_UNLOADED_SHIP_AND_A_LOADED_TRAIN));
  }

  @Test
  public void testCase4()
  {
    port.receiveShip(new Ship(4));
    port.unload();
    port.receiveShip(new Ship(4));
    port.unload();
    Assert.assertThat(port.show(), is(A_STANDARD_PORT_WITH_UNLOADED_SHIP_AND_A_LOADED_TRAIN_TEST4));
  }

  @Test
  public void testCase5()
  {
    port.receiveShip(new Ship(4));
    port.unload();
    port.receiveShip(new Ship(4));
    port.unload();
    port.receiveShip(new Ship(4));
    port.unload();
    port.trainSend();
    Assert.assertThat(port.show(), is(A_STANDARD_PORT_WITH_UNLOADED_SHIP_AND_A_LOADED_TRAIN_TEST5));
  }

  @Before
  public void createPort()
  {
    final Train train = new Train(3);
    port = new Port(train, new ContainerStorage(6), new Crane(), new Crane(), new PortInfoFormatter());
  }
}
