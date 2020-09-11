package com.vrizzo.port;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class ContainerStorageTest
{
  @Test
  public void getPrintableInfoEmptyStorage()
  {
    final ContainerStorage containerStorage = new ContainerStorage(6);
    Assert.assertThat(containerStorage.getStatusInfo().getStatusInformation().get(0), is("A||||||"));
    Assert.assertThat(containerStorage.getStatusInfo().getStatusInformation().get(1), is("_      "));
    Assert.assertThat(containerStorage.getStatusInfo().getStatusInformation().get(2), is("A||||||"));
  }

  @Test
  public void getPrintableInfoFirstEmptyStorageAndThanLoadedOf3()
  {
    final ContainerStorage containerStorage = new ContainerStorage(6);
    Assert.assertThat(containerStorage.getStatusInfo().getStatusInformation().get(0), is("A||||||"));
    Assert.assertThat(containerStorage.getStatusInfo().getStatusInformation().get(1), is("_      "));
    Assert.assertThat(containerStorage.getStatusInfo().getStatusInformation().get(2), is("A||||||"));

    containerStorage.loadContainer(3);

    Assert.assertThat(containerStorage.getStatusInfo().getStatusInformation().get(0), is("A||||||"));
    Assert.assertThat(containerStorage.getStatusInfo().getStatusInformation().get(1), is("_XXX   "));
    Assert.assertThat(containerStorage.getStatusInfo().getStatusInformation().get(2), is("A||||||"));
  }
}