package com.vrizzo.port.formatter;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

public class PortPrinterTest
{

  @Test
  public void printEmpty()
  {
    Assert.assertThat(new PortInfoFormatter().format(() -> new PortElementStatus(Arrays.asList(""))), is("-^-^\n"));
  }

  @Test
  public void printOneElement()
  {
    Assert.assertThat(new PortInfoFormatter().format(() -> new PortElementStatus(Arrays.asList("VXXXX"))), is("-^-^\nX\nX\nX\nX\nV\n"));
  }

  @Test
  public void printTwoElementEmpty()
  {
    final String print = new PortInfoFormatter().format(() -> new PortElementStatus(Arrays.asList("VXXXX")),
                                                        () -> new PortElementStatus(Arrays.asList("AXXXXX")));
    
    Assert.assertThat(print, is("-^-^\n X\nXX\nXX\nXX\nXX\nVA\n"));
    
  }
}