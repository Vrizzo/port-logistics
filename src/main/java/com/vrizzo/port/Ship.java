package com.vrizzo.port;

import com.vrizzo.port.printer.PortElement;
import com.vrizzo.port.printer.PortElementStatus;

import java.util.Arrays;

public class Ship implements PortElement
{
  private int numberOfContainer;

  public Ship(int numberOfContainer)
  {
    this.numberOfContainer = numberOfContainer;
  }

  public PortElementStatus getStatusInfo()
  {
    StringBuilder stringBuilder = new StringBuilder("V");
    for(int i = 0 ; i<numberOfContainer ; i++)
      stringBuilder.append("X");
    return new PortElementStatus(Arrays.asList(stringBuilder.toString()));
  }
}
