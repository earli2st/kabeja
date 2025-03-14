/*******************************************************************************
 * Copyright 2010 Simon Mieth
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package org.kabeja.dxf.parser.entities;

import org.kabeja.dxf.parser.DXFValue;
import org.kabeja.entities.Dimension;
import org.kabeja.entities.Entity;
import org.kabeja.util.Constants;

/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFDimensionHandler extends AbstractEntityHandler {
  protected static final int GROUPCODE_REFERENCE_POINT_X = 10;
  protected static final int GROUPCODE_REFERENCE_POINT_Y = 20;
  protected static final int GROUPCODE_REFERENCE_POINT_Z = 30;
  protected static final int GROUPCODE_TEXT_POINT_X = 11;
  protected static final int GROUPCODE_TEXT_POINT_Y = 21;
  protected static final int GROUPCODE_TEXT_POINT_Z = 31;
  protected static final int GROUPCODE_INSERT_POINT_X = 12;
  protected static final int GROUPCODE_INSERT_POINT_Y = 22;
  protected static final int GROUPCODE_INSERT_POINT_Z = 32;
  protected static final int GROUPCODE_REFERENCE_POINT3_X = 13;
  protected static final int GROUPCODE_REFERENCE_POINT3_Y = 23;
  protected static final int GROUPCODE_REFERENCE_POINT3_Z = 33;
  protected static final int GROUPCODE_REFERENCE_POINT4_X = 14;
  protected static final int GROUPCODE_REFERENCE_POINT4_Y = 24;
  protected static final int GROUPCODE_REFERENCE_POINT4_Z = 34;
  protected static final int GROUPCODE_REFERENCE_POINT5_X = 15;
  protected static final int GROUPCODE_REFERENCE_POINT5_Y = 25;
  protected static final int GROUPCODE_REFERENCE_POINT5_Z = 35;
  protected static final int GROUPCODE_REFERENCE_POINT6_X = 16;
  protected static final int GROUPCODE_REFERENCE_POINT6_Y = 26;
  protected static final int GROUPCODE_REFERENCE_POINT6_Z = 36;
  protected static final int GROUPCODE_DIMENSION_STYLE = 3;
  protected static final int GROUPCODE_DIMENSION_BLOCK = 2;
  protected static final int GROUPCODE_DIMENSION_AREA = 67;
  protected static final int GROUPCODE_DIMENSION_TEXT = 1;
  protected static final int GROUPCODE_LEADINGLINE_LENGTH = 40;
  protected static final int GROUPCODE_DIMENSION_ROTATE = 50;
  protected static final int GROUPCODE_HORIZONTAL_ALIGNMENT = 51;
  protected static final int GROUPCODE_INCLINATION_HELPLINE = 52;
  protected static final int GROUPCODE_TEXT_ROTATION = 53;
  protected static final int GROUPCODE_DIMENSION_TYPE = 70;

  protected Dimension dimension;

  @Override
  public void endDXFEntity() {}

  @Override
  public Entity getDXFEntity() {
    return dimension;
  }

  @Override
  public String getDXFEntityType() {
    return Constants.ENTITY_TYPE_DIMENSION;
  }

  @Override
  public boolean isFollowSequence() {
    return false;
  }

  @Override
  public void parseGroup(int groupCode, DXFValue value) {
    switch (groupCode) {
      case GROUPCODE_TEXT_POINT_X:
        dimension.getTextPoint().setX(value.getDoubleValue());

        break;

      case GROUPCODE_TEXT_POINT_Y:
        dimension.getTextPoint().setY(value.getDoubleValue());

        break;

      case GROUPCODE_TEXT_POINT_Z:
        dimension.getTextPoint().setZ(value.getDoubleValue());

        break;

      case GROUPCODE_INSERT_POINT_X:
        dimension.getInsertPoint().setX(value.getDoubleValue());

        break;

      case GROUPCODE_INSERT_POINT_Y:
        dimension.getInsertPoint().setY(value.getDoubleValue());

        break;

      case GROUPCODE_INSERT_POINT_Z:
        dimension.getInsertPoint().setZ(value.getDoubleValue());

        break;

      case GROUPCODE_REFERENCE_POINT_X:
        dimension.getReferencePoint().setX(value.getDoubleValue());

        break;

      case GROUPCODE_REFERENCE_POINT_Y:
        dimension.getReferencePoint().setY(value.getDoubleValue());

        break;

      case GROUPCODE_REFERENCE_POINT_Z:
        dimension.getReferencePoint().setZ(value.getDoubleValue());

        break;

      case GROUPCODE_REFERENCE_POINT3_X:
        dimension.getReferencePoint3().setX(value.getDoubleValue());

        break;

      case GROUPCODE_REFERENCE_POINT3_Y:
        dimension.getReferencePoint3().setY(value.getDoubleValue());

        break;

      case GROUPCODE_REFERENCE_POINT3_Z:
        dimension.getReferencePoint3().setZ(value.getDoubleValue());

        break;

      case GROUPCODE_REFERENCE_POINT4_X:
        dimension.getReferencePoint4().setX(value.getDoubleValue());

        break;

      case GROUPCODE_REFERENCE_POINT4_Y:
        dimension.getReferencePoint4().setY(value.getDoubleValue());

        break;

      case GROUPCODE_REFERENCE_POINT4_Z:
        dimension.getReferencePoint4().setZ(value.getDoubleValue());

        break;

      case GROUPCODE_REFERENCE_POINT5_X:
        dimension.getReferencePoint5().setX(value.getDoubleValue());

        break;

      case GROUPCODE_REFERENCE_POINT5_Y:
        dimension.getReferencePoint5().setY(value.getDoubleValue());

        break;

      case GROUPCODE_REFERENCE_POINT5_Z:
        dimension.getReferencePoint5().setZ(value.getDoubleValue());

        break;

      case GROUPCODE_REFERENCE_POINT6_X:
        dimension.getReferencePoint6().setX(value.getDoubleValue());

        break;

      case GROUPCODE_REFERENCE_POINT6_Y:
        dimension.getReferencePoint6().setY(value.getDoubleValue());

        break;

      case GROUPCODE_REFERENCE_POINT6_Z:
        dimension.getReferencePoint6().setZ(value.getDoubleValue());

        break;

      case GROUPCODE_DIMENSION_BLOCK:
        dimension.setDimensionBlock(value.getValue());

        break;

      case GROUPCODE_DIMENSION_STYLE:
        dimension.setDimensionStyleID(value.getValue());

        break;

      case GROUPCODE_DIMENSION_TYPE:
        dimension.setDimensionType(value.getIntegerValue());

        break;

      case GROUPCODE_DIMENSION_TEXT:
        dimension.setDimensionText(value.getValue());

        break;

      case GROUPCODE_HORIZONTAL_ALIGNMENT:
        dimension.setHorizontalAlign(value.getDoubleValue());

        break;

      case GROUPCODE_INCLINATION_HELPLINE:
        dimension.setInclinationHelpLine(value.getDoubleValue());

        break;

      case GROUPCODE_LEADINGLINE_LENGTH:
        dimension.setLeadingLineLength(value.getDoubleValue());

        break;

      case GROUPCODE_TEXT_ROTATION:
        dimension.setTextRotation(value.getDoubleValue());

        break;

      case GROUPCODE_DIMENSION_ROTATE:
        dimension.setDimensionRotation(value.getDoubleValue());

        break;

      case GROUPCODE_DIMENSION_AREA:
        dimension.setDimensionArea(value.getIntegerValue());

        break;

      default:
        super.parseCommonProperty(groupCode, value, dimension);
    }
  }

  @Override
  public void startDXFEntity() {
    dimension = new Dimension();
    dimension.setDocument(doc);
  }
}
