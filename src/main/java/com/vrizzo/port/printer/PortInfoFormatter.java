package com.vrizzo.port.printer;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PortInfoFormatter
{
  public String format(PortElement... portElements)
  {
    int infoMaxLength = getInfoMaxLength(portElements);

    final List<String> stringToFormatList = Stream.of(portElements)
        .map(PortElement::getStatusInfo)
        .map(PortElementStatus::getStatusInformation)
        .flatMap(List::stream)
        .map(s -> StringUtils.rightPad(s, infoMaxLength))
        .collect(Collectors.toList());

    return "-^-^\n" + format(stringToFormatList);
  }

  private String format(List<String> stringToFormatList)
  {
    StringBuilder formattedResult = new StringBuilder();
    List<String> remainingStringToFormatList = new ArrayList<>();
    for (String s : stringToFormatList)
    {
      final int lastCharIndex = s.length() - 1;
      if (lastCharIndex < 0)
        return "";

      formattedResult.append(s.charAt(lastCharIndex));
      remainingStringToFormatList.add(s.substring(0, lastCharIndex));
    }
    formattedResult.append("\n").append(format(remainingStringToFormatList));
    return formattedResult.toString();
  }

  private int getInfoMaxLength(PortElement[] portElements)
  {
    return Stream.of(portElements)
        .map(PortElement::getStatusInfo)
        .map(PortElementStatus::getStatusInformation)
        .flatMap(List::stream)
        .mapToInt(String::length)
        .max().orElse(0);
  }
}
