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
/*
   Copyright 2007 Simon Mieth

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package org.kabeja.dxf.parser.objects;

import org.kabeja.dxf.parser.DXFValue;
import org.kabeja.objects.DraftObject;
import org.kabeja.objects.Layout;
import org.kabeja.util.Constants;

public class DXFLayoutHandler extends DXFPlotsettingsHandler {
  public static final int GROUPCODE_MINIMUM_LIMITS_X = 10;
  public static final int GROUPCODE_MINIMUM_LIMITS_Y = 20;
  public static final int GROUPCODE_MAXIMUM_LIMITS_X = 11;
  public static final int GROUPCODE_MAXIMUM_LIMITS_Y = 21;
  public static final int GROUPCODE_INSERT_POINT_X = 12;
  public static final int GROUPCODE_INSERT_POINT_Y = 22;
  public static final int GROUPCODE_INSERT_POINT_Z = 32;
  public static final int GROUPCODE_MINIMUM_EXTENTS_X = 14;
  public static final int GROUPCODE_MINIMUM_EXTENTS_Y = 24;
  public static final int GROUPCODE_MINIMUM_EXTENTS_Z = 34;
  public static final int GROUPCODE_MAXIMUM_EXTENTS_X = 15;
  public static final int GROUPCODE_MAXIMUM_EXTENTS_Y = 25;
  public static final int GROUPCODE_MAXIMUM_EXTENTS_Z = 35;
  public static final int GROUPCODE_ELEVATION = 146;
  public static final int GROUPCODE_UCS_ORIGIN_X = 13;
  public static final int GROUPCODE_UCS_ORIGIN_Y = 23;
  public static final int GROUPCODE_UCS_ORIGIN_Z = 33;
  public static final int GROUPCODE_UCS_AXIS_X_X = 16;
  public static final int GROUPCODE_UCS_AXIS_X_Y = 26;
  public static final int GROUPCODE_UCS_AXIS_X_Z = 36;
  public static final int GROUPCODE_UCS_AXIS_Y_X = 17;
  public static final int GROUPCODE_UCS_AXIS_Y_Y = 27;
  public static final int GROUPCODE_UCS_AXIS_Y_Z = 37;
  public static final int GROUPCODE_UCS_ORTHOGRAPHIC_TYPE = 76;
  public static final int GROUPCODE_PAPER_SPACE_BLOCK_RECORD_ID = 330;
  public static final int GROUPCODE_LAST_ACTIVE_VIEWPORT_ID = 331;
  public static final int GROUPCODE_UCS_ID = 345;
  public static final int GROUPCODE_UCS_BASE_ID = 346;
  protected Layout layout;

  @Override
  public void endObject() {}

  @Override
  public DraftObject getDXFObject() {
    return this.layout;
  }

  @Override
  public String getObjectType() {
    return Constants.OBJECT_TYPE_LAYOUT;
  }

  @Override
  public void parseGroup(int groupCode, DXFValue value) {
    switch (groupCode) {
      case GROUPCODE_ELEVATION:
        this.layout.setElevation(value.getDoubleValue());

        break;

      case GROUPCODE_INSERT_POINT_X:
        this.layout.getInsertPoint().setX(value.getDoubleValue());

        break;

      case GROUPCODE_INSERT_POINT_Y:
        this.layout.getInsertPoint().setY(value.getDoubleValue());

        break;

      case GROUPCODE_INSERT_POINT_Z:
        this.layout.getInsertPoint().setZ(value.getDoubleValue());

        break;

      case GROUPCODE_LAST_ACTIVE_VIEWPORT_ID:
        this.layout.setLastActiveViewportID(value.getValue());

        break;

      case GROUPCODE_MAXIMUM_EXTENTS_X:
        this.layout.getExtent().setMaximumX(value.getDoubleValue());

        break;

      case GROUPCODE_MAXIMUM_EXTENTS_Y:
        this.layout.getExtent().setMaximumY(value.getDoubleValue());

        break;

      case GROUPCODE_MAXIMUM_EXTENTS_Z:
        this.layout.getExtent().setMaximumZ(value.getDoubleValue());

        break;

      case GROUPCODE_MAXIMUM_LIMITS_X:
        this.layout.getLimits().setMaximumX(value.getDoubleValue());

        break;

      case GROUPCODE_MAXIMUM_LIMITS_Y:
        this.layout.getLimits().setMaximumY(value.getDoubleValue());

        break;

      case GROUPCODE_MINIMUM_EXTENTS_X:
        this.layout.getExtent().setMinimumX(value.getDoubleValue());

        break;

      case GROUPCODE_MINIMUM_EXTENTS_Y:
        this.layout.getExtent().setMinimumY(value.getDoubleValue());

        break;

      case GROUPCODE_MINIMUM_EXTENTS_Z:
        this.layout.getExtent().setMinimumZ(value.getDoubleValue());

        break;

      case GROUPCODE_MINIMUM_LIMITS_X:
        this.layout.getLimits().setMinimumX(value.getDoubleValue());

        break;

      case GROUPCODE_MINIMUM_LIMITS_Y:
        this.layout.getLimits().setMinimumY(value.getDoubleValue());

        break;

      case GROUPCODE_PAPER_SPACE_BLOCK_RECORD_ID:
        this.layout.setPaperSpaceBlockID(value.getValue());

        break;

      case GROUPCODE_UCS_AXIS_X_X:
        this.layout.getXAxisUCS().setX(value.getDoubleValue());

        break;

      case GROUPCODE_UCS_AXIS_X_Y:
        this.layout.getXAxisUCS().setY(value.getDoubleValue());

        break;

      case GROUPCODE_UCS_AXIS_X_Z:
        this.layout.getXAxisUCS().setZ(value.getDoubleValue());

        break;

      case GROUPCODE_UCS_AXIS_Y_X:
        this.layout.getYAxisUCS().setX(value.getDoubleValue());

        break;

      case GROUPCODE_UCS_AXIS_Y_Y:
        this.layout.getYAxisUCS().setY(value.getDoubleValue());

        break;

      case GROUPCODE_UCS_AXIS_Y_Z:
        this.layout.getYAxisUCS().setZ(value.getDoubleValue());

        break;

      case GROUPCODE_UCS_BASE_ID:
        this.layout.setBaseUCSID(value.getValue());

        break;

      case GROUPCODE_UCS_ID:
        this.layout.setNamedUCSID(value.getValue());

        break;

      case GROUPCODE_UCS_ORIGIN_X:
        this.layout.getOriginUCS().setX(value.getDoubleValue());

        break;

      case GROUPCODE_UCS_ORIGIN_Y:
        this.layout.getOriginUCS().setY(value.getDoubleValue());

        break;

      case GROUPCODE_UCS_ORIGIN_Z:
        this.layout.getOriginUCS().setZ(value.getDoubleValue());

        break;

      case GROUPCODE_UCS_ORTHOGRAPHIC_TYPE:
        this.layout.setOrthographicTypeOfUCS(value.getIntegerValue());

        break;

      default:
        super.parseGroup(groupCode, value);
    }
  }

  @Override
  public void startObject() {
    this.layout = new Layout();
    this.plotSettings = this.layout;
  }
}
