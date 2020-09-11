package com.vrizzo.port.printer;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class PortPrinterTest
{

  @Test
  public void printEmpty()
  {
    Assert.assertThat(new PortInfoFormatter().format(() -> ""), is("-^-^\n"));
  }

  @Test
  public void printOneElement()
  {
    Assert.assertThat(new PortInfoFormatter().format(() -> "VXXXX"), is("-^-^\nX\nX\nX\nX\nV\n"));
  }

  @Test
  public void printTwoElementEmpty()
  {
    final String print = new PortInfoFormatter().format(() -> "VXXXX",
                                                        () -> "AXXXXX");
    
    Assert.assertThat(print, is("-^-^\n X\nXX\nXX\nXX\nXX\nVA\n"));
    
  }
}