package com.vrizzo.port.printer;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PortPrinterTest
{

  @Test
  public void printEmpty()
  {
    Assert.assertThat(new PortPrinter(() -> "").print(), is("-^-^\n"));
  }

  @Test
  public void printOneElement()
  {
    Assert.assertThat(new PortPrinter(() -> "VXXXX").print(), is("-^-^\nX\nX\nX\nX\nV\n"));
  }

  @Test
  public void printTwoElementEmpty()
  {
    final String print = new PortPrinter(() -> "VXXXX",
                                         () -> "AXXXXX").print();
    
    Assert.assertThat(print, is("-^-^\n X\nXX\nXX\nXX\nXX\nVA\n"));
    
  }
}