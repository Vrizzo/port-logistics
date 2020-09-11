package com.vrizzo.port;

import com.vrizzo.port.printer.PrintablePortElement;

public class Ship implements PrintablePortElement
{
  private int numberOfContainer;

  public Ship(int numberOfContainer)
  {
    this.numberOfContainer = numberOfContainer;
  }

  public String getPrintableInfo()
  {
    StringBuilder stringBuilder = new StringBuilder("V");
    for(int i = 0 ; i<numberOfContainer ; i++)
      stringBuilder.append("X");
    return stringBuilder.toString();
  }
}
