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

package org.kabeja.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.kabeja.DraftDocument;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class AggregatorGenerator extends AbstractSAXFilter implements SAXGenerator {
  public static final String ROOT_ELEMENT = "aggregate";
  public static final String NAMESPACE = "http://kabeja.org/aggregate";
  protected List<SAXGenerator> generators = new ArrayList<>();
  protected DraftDocument doc;

  @Override
  public void generate(DraftDocument doc, ContentHandler handler, Map<String, Object> context)
      throws SAXException {
    this.setContentHandler(handler);
    this.doc = doc;

    try {
      handler.startDocument();

      String raw = NAMESPACE + ":" + ROOT_ELEMENT;
      handler.startElement(NAMESPACE, raw, ROOT_ELEMENT, new AttributesImpl());
      doGenerate();
      handler.endElement(NAMESPACE, raw, ROOT_ELEMENT);
      handler.endDocument();
    } catch (SAXException e) {
      e.printStackTrace();
    }
  }

  protected void doGenerate() throws SAXException {
    Iterator<SAXGenerator> i = this.generators.iterator();

    while (i.hasNext()) {
      SAXGenerator generator = (SAXGenerator) i.next();
      generator.generate(this.doc, this, null);
    }
  }

  @Override
  public void endDocument() throws SAXException {
    // ignore
  }

  @Override
  public void startDocument() throws SAXException {
    // ignore
  }

  public void addSAXGenerator(SAXGenerator generator) {
    this.generators.add(generator);
  }

  @Override
  public Map<String, Object> getProperties() {
    return this.properties;
  }
}
