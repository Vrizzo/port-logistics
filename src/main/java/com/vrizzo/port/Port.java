package com.vrizzo.port;

import com.vrizzo.port.formatter.PortElement;
import com.vrizzo.port.formatter.PortInfoFormatter;

import java.util.ArrayList;
import java.util.List;

class Port
{

  private Ship ship;
  private Train train;
  private final ContainerStorage containerStorage;
  private final Crane crane1;
  private final Crane crane2;
  private final PortInfoFormatter portInfoFormatter;

  Port(Train train,
       ContainerStorage containerStorage,
       Crane crane1, Crane crane2, PortInfoFormatter portInfoFormatter)
  {
    this.train = train;
    this.containerStorage = containerStorage;
    this.crane1 = crane1;
    this.crane2 = crane2;
    crane1.joinDestination(containerStorage);
    crane2.joinSource(containerStorage);
    crane2.joinDestination(train);
    this.portInfoFormatter = portInfoFormatter;
  }

  public String show()
  {
    return portInfoFormatter.format(collectPortElement());
  }

  private PortElement[] collectPortElement()
  {
    List<PortElement> portElementList = new ArrayList<>();
    if (ship != null)
      portElementList.add(ship);

    portElementList.add(containerStorage);
    portElementList.add(train);
    return portElementList.toArray(new PortElement[0]);
  }

  public void receiveShip(Ship ship)
  {
    this.ship = ship;
    this.crane1.joinSource(ship);
  }

  public void unload()
  {
    crane1.move();
    crane2.move();
  }

  public void trainSend()
  {
    train = new Train(3);
  }
}
