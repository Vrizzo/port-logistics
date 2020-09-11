package com.vrizzo.port;

import com.vrizzo.port.formatter.PortElement;
import com.vrizzo.port.formatter.PortElementStatus;

import java.util.Arrays;

public class Ship implements PortElement, UnloadingSource
{
  private int numberOfContainer;

  public Ship(int numberOfContainer)
  {
    this.numberOfContainer = numberOfContainer;
  }

  public PortElementStatus getStatusInfo()
  {
    StringBuilder stringBuilder = new StringBuilder("V");
    for (int i = 0; i < numberOfContainer; i++)
      stringBuilder.append("X");
    return new PortElementStatus(Arrays.asList(stringBuilder.toString()));
  }

  @Override
  public int unload(int numberOfUnload)
  {
    if(numberOfUnload > numberOfContainer)
    {
      numberOfUnload = numberOfContainer;
      numberOfContainer = 0;
      return numberOfUnload;
    }

    numberOfContainer = numberOfContainer -numberOfUnload;
    return numberOfUnload;
  }
  
}
