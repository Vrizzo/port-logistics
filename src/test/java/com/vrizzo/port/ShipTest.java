package com.vrizzo.port;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class ShipTest
{
  @Test
  public void getPrintableInfo()
  {
    Assert.assertThat(new Ship(4).getStatusInfo(), is("VXXXX"));
    Assert.assertThat(new Ship(3).getStatusInfo(), is("VXXX"));
  }
}