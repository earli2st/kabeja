package org.kabeja.entities;

import java.util.ArrayList;
import java.util.List;
import org.kabeja.entities.util.XDataElement;

/** Created by Veronika Zwickenpflug on 30.12.2016. */
public class XData {

  private final String applicationName;

  private String xDataString;

  private List<XDataElement> xDataElements = new ArrayList<>();

  public XData(String applicationName) {
    this.applicationName = applicationName;
  }

  public String getXDataString() {
    return xDataString;
  }

  public void setXDataString(String xDataString) {
    this.xDataString = xDataString;
  }

  public String getApplicationName() {
    return applicationName;
  }

  public List<XDataElement> getXDataElements() {
    return xDataElements;
  }

  public int getXDataElementSize() {
    return this.xDataElements.size();
  }

  public void addXDataElement(int groupCode, String value) {
    this.xDataElements.add(new XDataElement(groupCode, value));
  }
}
