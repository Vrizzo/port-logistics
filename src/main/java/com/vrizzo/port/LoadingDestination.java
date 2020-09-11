package com.vrizzo.port;

public interface LoadingDestination
{
  void load(int numberOfContainer);

  int getMaxOccupancy();
}
