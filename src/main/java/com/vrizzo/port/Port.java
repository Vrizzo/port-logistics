package com.vrizzo.port;

import com.vrizzo.port.printer.PortPrinter;
import com.vrizzo.port.printer.PrintablePortElement;

class Port implements PrintablePortElement
{
  private final Ship ship;
  private final PortPrinter portPrinter;
  Port(Ship ship, PortPrinter portPrinter)
  {
    this.ship = ship;
    this.portPrinter = portPrinter;
  }

  public String show()
  {
    return portPrinter.print();
  }

  public String getPrintableInfo()
  {
    return "-^-^";
  }
}
