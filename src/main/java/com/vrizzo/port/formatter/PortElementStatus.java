package com.vrizzo.port.formatter;

import java.util.List;

public class PortElementStatus
{
  private final List<String> statusInformation;

  public PortElementStatus(List<String> statusInformation)
  {
    this.statusInformation = statusInformation;
  }

  public List<String> getStatusInformation()
  {
    return statusInformation;
  }
}
