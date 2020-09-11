package com.vrizzo.port;

import com.vrizzo.port.printer.PortElement;
import com.vrizzo.port.printer.PortInfoFormatter;

import java.util.ArrayList;
import java.util.List;

class Port
{

  private Ship ship;
  private final Train train;
  private final ContainerStorage containerStorage;
  private final PortInfoFormatter portInfoFormatter;

  Port(Train train,
       ContainerStorage containerStorage,
       PortInfoFormatter portInfoFormatter)
  {
    this.train = train;
    this.containerStorage = containerStorage;
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
  }
}
