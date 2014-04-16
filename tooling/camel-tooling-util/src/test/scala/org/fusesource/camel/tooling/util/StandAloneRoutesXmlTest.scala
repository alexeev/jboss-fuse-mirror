/*
 * Copyright (C) FuseSource, Inc.
 * http://fusesource.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.fusesource.camel.tooling.util

import java.io.File
import org.junit.Assert._

class StandAloneRoutesXmlTest extends RouteXmlTestSupport {

  test("parses valid XML file") {
    val x = assertRoutes(new File(baseDir, "src/test/resources/routes.xml"), 1)

    val uris = x.endpointUris
    expect(0, "endpoint uris " + uris){ uris.size }
  }

  test("parses valid XML file with no Xsd") {
    val x = assertRoutes(new File(baseDir, "src/test/resources/routesNoXsd.xml"), 1)

    val uris = x.endpointUris
    expect(0, "endpoint uris " + uris){ uris.size }
  }

  test("parses empty XML file") {
    val x = assertRoutes(new File(baseDir, "src/main/resources/org/fusesource/camel/tooling/routes-exemplar.xml"), 0)
  }

}