/*
Copyright 2007-2011 Selenium committers

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

package org.openqa.selenium.interactions.touch;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.StubRenderedWebElement;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

/**
 * Tests the long press action.
 */
public class TouchLongPressTest {

  @Rule public JUnitRuleMockery mockery = new JUnitRuleMockery();

  private TouchScreen dummyTouch;
  private Locatable locatableElement;
  private Coordinates dummyCoordinates;

  @Before
  public void setUp() {
    dummyTouch = mockery.mock(TouchScreen.class);
    dummyCoordinates = mockery.mock(Coordinates.class);

    locatableElement = new StubRenderedWebElement() {
      @Override
      public Coordinates getCoordinates() {
        return dummyCoordinates;
      }
    };
  }

  @Test
  public void testCanLongPress() {
    mockery.checking(new Expectations() {{
      oneOf(dummyTouch).longPress(dummyCoordinates);
    }});

    LongPressAction longPress = new LongPressAction(dummyTouch, locatableElement);
    longPress.perform();
  }
}
