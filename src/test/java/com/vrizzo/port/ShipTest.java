package com.vrizzo.port;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class ShipTest
{
  @Test
  public void getPrintableInfo()
  {
    Assert.assertThat(new Ship(4).getStatusInfo().getStatusInformation().get(0), is("VXXXX"));
    Assert.assertThat(new Ship(3).getStatusInfo().getStatusInformation().get(0), is("VXXX"));
  }
}