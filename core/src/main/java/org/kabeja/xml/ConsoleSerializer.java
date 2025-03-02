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
 * Created on 28.11.2005
 *
 */
package org.kabeja.xml;

import java.io.OutputStream;

/**
 * @author simon
 */
public class ConsoleSerializer extends SAXPrettyOutputter {
  /* (non-Javadoc)
   * @see org.kabeja.xml.SAXSerializer#setOutput(java.io.OutputStream)
   */
  @Override
  public void setOutput(OutputStream out) {
    // switch output to console
    super.setOutput(System.out);
  }
}
