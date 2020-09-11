package com.vrizzo.port;

import com.vrizzo.port.formatter.PortElement;
import com.vrizzo.port.formatter.PortElementStatus;

import java.util.*;

public class Train implements PortElement
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

  public void loadContainer(int containerToLoad)
  {
    loadedWagon = containerToLoad;
  }
}
