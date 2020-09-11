package com.vrizzo.port;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ContainerStorageTest
{
  @Test
  public void getPrintableInfoEmptyStorage()
  {
    final ContainerStorage containerStorage = new ContainerStorage(6);
    Assert.assertThat(containerStorage.getStatusInfo().getStatusInformation().get(0), is("A||||||\n"));
    Assert.assertThat(containerStorage.getStatusInfo().getStatusInformation().get(1), is("_      \n"));
    Assert.assertThat(containerStorage.getStatusInfo().getStatusInformation().get(2), is("A||||||\n"));
  }

  @Test
  public void getPrintableInfoFirstEmptyStorageAndThanLoadedOf3()
  {
    final ContainerStorage containerStorage = new ContainerStorage(6);
    Assert.assertThat(containerStorage.getStatusInfo().getStatusInformation().get(0), is("A||||||\n"));
    Assert.assertThat(containerStorage.getStatusInfo().getStatusInformation().get(1), is("_      \n"));
    Assert.assertThat(containerStorage.getStatusInfo().getStatusInformation().get(2), is("A||||||\n"));

    containerStorage.loadContainer(3);

    Assert.assertThat(containerStorage.getStatusInfo().getStatusInformation().get(0), is("A||||||\n"));
    Assert.assertThat(containerStorage.getStatusInfo().getStatusInformation().get(1), is("_XXX   \n"));
    Assert.assertThat(containerStorage.getStatusInfo().getStatusInformation().get(2), is("A||||||\n"));
  }
}