package com.vrizzo.port;

import com.vrizzo.port.formatter.PortElement;
import com.vrizzo.port.formatter.PortElementStatus;

import java.util.*;

public class Train implements PortElement, LoadingDestination
{
  private final int wagonNumber;

  private int loadedWagon;

  public Train(int wagonNumber)
  {
    this.wagonNumber = wagonNumber;
  }

  @Override
  public PortElementStatus getStatusInfo()
  {
    List<String> statusInfoList = new ArrayList<>();
    for (int i = 0; i < wagonNumber; i++)
    {
      statusInfoList.add("-" + ((i < loadedWagon) ? "X" : " "));
    }

    Collections.reverse(statusInfoList);

    statusInfoList.add(":");
    statusInfoList.add(":");
    statusInfoList.add("%D");
    statusInfoList.add("%");
    statusInfoList.add("%i");
    return new PortElementStatus(statusInfoList);
  }

  @Override public void load(int numberOfContainer)
  {
    loadedWagon = loadedWagon + numberOfContainer;
  }

  @Override public int getMaxOccupancy()
  {
    return wagonNumber - loadedWagon;
  }
}
