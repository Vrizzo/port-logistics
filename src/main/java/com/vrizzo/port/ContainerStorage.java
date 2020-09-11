package com.vrizzo.port;

import com.vrizzo.port.formatter.PortElement;
import com.vrizzo.port.formatter.PortElementStatus;

import java.util.Arrays;

public class ContainerStorage implements PortElement
{
  private final int maxContainer;
  private int numberOfContainer;

  public ContainerStorage(int maxContainer)
  {
    this.maxContainer = maxContainer;
  }

  @Override public PortElementStatus getStatusInfo()
  {
    StringBuilder stringBuilderSide = new StringBuilder("A");
    StringBuilder stringBuilderStack = new StringBuilder("_");
    for (int i = 0; i < maxContainer; i++)
    {
      stringBuilderSide.append("|");
      stringBuilderStack.append((i < numberOfContainer) ? "X" : " ");
    }
    return new PortElementStatus(Arrays.asList(stringBuilderSide.toString(),
                                               stringBuilderStack.toString(),
                                               stringBuilderSide.toString()));
  }

  public void loadContainer(int containers)
  {
    numberOfContainer = containers;
  }
}
