package com.vrizzo.port;

import com.vrizzo.port.printer.PortInfoFormatter;

class Port
{
  private final Ship ship;
  private final PortInfoFormatter portInfoFormatter;
  Port(Ship ship, PortInfoFormatter portInfoFormatter)
  {
    this.ship = ship;
    this.portInfoFormatter = portInfoFormatter;
  }

  public String show()
  {
    return portInfoFormatter.format();
  }

}
