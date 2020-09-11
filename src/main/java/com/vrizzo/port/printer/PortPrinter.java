package com.vrizzo.port.printer;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PortPrinter
{
  private final PrintablePortElement[] printablePortElements;

  public PortPrinter(PrintablePortElement... printablePortElements)
  {
    this.printablePortElements = printablePortElements;
  }

  public String print()
  {
    int infoMaxLenghto  = getInfoMaxLength();

    final List<String> printableStringList = Stream.of(printablePortElements)
        .map(PrintablePortElement::getPrintableInfo)
        .map(s -> StringUtils.rightPad(s, infoMaxLenghto))
        .collect(Collectors.toList());


      
    return "-^-^\n" + printPrintableString(printableStringList);
  }

  private String printPrintableString(List<String> printableStringList)
  {
    StringBuilder printableStringResult = new StringBuilder();
    List<String> remainingPrintableStringList = new ArrayList<>();
    for (String s : printableStringList)
    {
      final int lastCharIndex = s.length() -1;
      if(lastCharIndex < 0)
        return "";

      printableStringResult.append(s.charAt(lastCharIndex));
      remainingPrintableStringList.add(s.substring(0, lastCharIndex));
    }
    printableStringResult.append("\n").append(printPrintableString(remainingPrintableStringList));
    return printableStringResult.toString();
  }

  private int getInfoMaxLength()
  {
    return Stream.of(printablePortElements)
    .map(PrintablePortElement::getPrintableInfo)
    .mapToInt(String::length)
    .max().orElse(0);
  }
}
