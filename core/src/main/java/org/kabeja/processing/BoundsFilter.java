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

package org.kabeja.processing;

import java.util.Iterator;
import java.util.Map;
import org.kabeja.DraftDocument;
import org.kabeja.common.Layer;
import org.kabeja.common.Type;
import org.kabeja.entities.Entity;
import org.kabeja.math.Bounds;

public class BoundsFilter extends AbstractPostProcessor {
  public static final String PROPERTY_X = "boundsfilter.x";
  public static final String PROPERTY_Y = "boundsfilter.y";
  public static final String PROPERTY_WIDTH = "boundsfilter.width";
  public static final String PROPERTY_HEIGHT = "boundsfilter.height";
  public static final String PROPERTY_PROCESS = "boundsfilter.process";

  @Override
  public void process(DraftDocument doc, Map<String, Object> context) throws ProcessorException {
    if (this.properties.containsKey(PROPERTY_PROCESS)
        && Boolean.valueOf((String) this.properties.get(PROPERTY_PROCESS))) {
      Bounds bounds = new Bounds();

      if (this.properties.containsKey(PROPERTY_X)) {
        bounds.setMinimumX(Double.parseDouble((String) this.properties.get(PROPERTY_X)));
      }

      if (this.properties.containsKey(PROPERTY_Y)) {
        bounds.setMinimumY(Double.parseDouble((String) this.properties.get(PROPERTY_Y)));
      }

      if (this.properties.containsKey(PROPERTY_WIDTH)) {
        bounds.setMaximumX(
            bounds.getMinimumX()
                + Double.parseDouble((String) this.properties.get(PROPERTY_WIDTH)));
      }

      if (this.properties.containsKey(PROPERTY_WIDTH)) {
        bounds.setMaximumY(
            bounds.getMinimumY()
                + Double.parseDouble((String) this.properties.get(PROPERTY_HEIGHT)));
      }

      // the bounds should be setup now
      // we remove all entities which are
      // not inside our bounds
      for (Layer layer : doc.getLayers()) {
        filterLayer(layer, bounds);
      }
    }
  }

  protected void filterLayer(Layer layer, Bounds bounds) {
    for (Type<?> type : layer.getEntityTypes()) {
      Iterator<?> entities = layer.getEntitiesByType(type).iterator();

      while (entities.hasNext()) {
        Entity entity = (Entity) entities.next();

        if (!bounds.enclose(entity.getBounds())) {
          // the bounds not contains this entity
          // we remove it
          entities.remove();
        }
      }
    }
  }
}
