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
import org.kabeja.entities.Entity;
import org.kabeja.entities.Tolerance;
import org.kabeja.util.Constants;

/**
 * @author <a href="mailto:simon.mieth@gmx.de">Simon Mieth</a>
 */
public class DXFToleranceHandler extends AbstractEntityHandler {
  public static final int GROUPCODE_X_AXIS_DIRECTOPN_X = 11;
  public static final int GROUPCODE_X_AXIS_DIRECTOPN_Y = 21;
  public static final int GROUPCODE_X_AXIS_DIRECTOPN_Z = 31;
  protected Tolerance tolerance;

  @Override
  public String getDXFEntityType() {
    return Constants.ENTITY_TYPE_TOLERANCE;
  }

  @Override
  public void endDXFEntity() {}

  @Override
  public Entity getDXFEntity() {
    return tolerance;
  }

  @Override
  public boolean isFollowSequence() {
    return false;
  }

  @Override
  public void parseGroup(int groupCode, DXFValue value) {
    switch (groupCode) {
      case GROUPCODE_START_X:
        tolerance.getInsertionPoint().setX(value.getDoubleValue());

        break;

      case GROUPCODE_START_Y:
        tolerance.getInsertionPoint().setY(value.getDoubleValue());

        break;

      case GROUPCODE_START_Z:
        tolerance.getInsertionPoint().setZ(value.getDoubleValue());

        break;

      case GROUPCODE_X_AXIS_DIRECTOPN_X:
        tolerance.getXaxisDirection().setX(value.getDoubleValue());

        break;

      case GROUPCODE_X_AXIS_DIRECTOPN_Y:
        tolerance.getXaxisDirection().setY(value.getDoubleValue());

        break;

      case GROUPCODE_X_AXIS_DIRECTOPN_Z:
        tolerance.getXaxisDirection().setZ(value.getDoubleValue());

        break;

      case GROUPCODE_TEXT:
        tolerance.setText(value.getValue());

        break;

      case GROUPCODE_STYLENAME:
        tolerance.setStyleID(value.getValue());

        break;

      default:
        super.parseCommonProperty(groupCode, value, tolerance);
    }
  }

  @Override
  public void startDXFEntity() {
    tolerance = new Tolerance();
    tolerance.setDocument(doc);
  }
}
