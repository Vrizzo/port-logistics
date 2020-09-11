package com.vrizzo.port;

public class Crane
{
  private UnloadingSource unloadingSource;
  private LoadingDestination loadingDestination;

  public Crane()
  {

  }

  public void joinSource(UnloadingSource source){
    unloadingSource = source;
  }

  public void joinDestination(LoadingDestination destination){
    loadingDestination = destination;
  }
  public void move()
  {
    loadingDestination.load(unloadingSource.unload(loadingDestination.getMaxOccupancy()));
  }
}
