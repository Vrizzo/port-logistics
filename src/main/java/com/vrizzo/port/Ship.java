package com.vrizzo.port;

import com.vrizzo.port.printer.PortElement;

public class Ship implements PortElement
{
  private int numberOfContainer;

  public Ship(int numberOfContainer)
  {
    this.numberOfContainer = numberOfContainer;
  }

  public String getStatusInfo()
  {
    StringBuilder stringBuilder = new StringBuilder("V");
    for(int i = 0 ; i<numberOfContainer ; i++)
      stringBuilder.append("X");
    return stringBuilder.toString();
  }
}
