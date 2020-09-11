package com.vrizzo.port;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class ShipTest
{
  @Test
  public void getPrintableInfo()
  {
    Assert.assertThat(new Ship(4).getPrintableInfo(), is("VXXXX"));
    Assert.assertThat(new Ship(3).getPrintableInfo(), is("VXXX"));
  }
}