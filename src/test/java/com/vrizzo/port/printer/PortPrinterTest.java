package com.vrizzo.port.printer;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PortPrinterTest
{

  @Test
  public void print()
  {
    Assert.assertThat(new PortPrinter(() -> "").print(), is(""));
  }
}