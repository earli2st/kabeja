package org.kabeja.entities.util;

public final class XDataElement {

  private int groupCode;

  private String value;

  public XDataElement() {
    super();
  }

  public XDataElement(int groupCode, String value) {
    this.groupCode = groupCode;
    this.value = value;
  }

  public int getGroupCode() {
    return groupCode;
  }

  public void setGroupCode(int groupCode) {
    this.groupCode = groupCode;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public double getDoubleValue() {
    return Double.parseDouble(value);
  }

  public int getIntegerValue() {
    return Integer.parseInt(value.trim());
  }

  public boolean getBooleanValue() {
    return getIntegerValue() == 1;
  }
}
