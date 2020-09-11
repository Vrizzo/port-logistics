package com.vrizzo.port;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class TrainTest
{
  @Test
  public void anEmptyTrain()
  {
    final List<String> statusInformation = new Train(3).getStatusInfo().getStatusInformation();
    Assert.assertThat(statusInformation.get(0), is("- "));
    Assert.assertThat(statusInformation.get(1), is("- "));
    Assert.assertThat(statusInformation.get(2), is("- "));
    Assert.assertThat(statusInformation.get(3), is(":"));
    Assert.assertThat(statusInformation.get(4), is(":"));
    Assert.assertThat(statusInformation.get(5), is("%D"));
    Assert.assertThat(statusInformation.get(6), is("%"));
    Assert.assertThat(statusInformation.get(7), is("%i"));
  }

  @Test
  public void aTrainLoadedBy3Container()
  {
    final Train train = new Train(3);

    train.load(2);
    
    final List<String> statusInformation = train.getStatusInfo().getStatusInformation();
    Assert.assertThat(statusInformation.get(0), is("- "));
    Assert.assertThat(statusInformation.get(1), is("-X"));
    Assert.assertThat(statusInformation.get(2), is("-X"));
    Assert.assertThat(statusInformation.get(3), is(":"));
    Assert.assertThat(statusInformation.get(4), is(":"));
    Assert.assertThat(statusInformation.get(5), is("%D"));
    Assert.assertThat(statusInformation.get(6), is("%"));
    Assert.assertThat(statusInformation.get(7), is("%i"));
  }
}