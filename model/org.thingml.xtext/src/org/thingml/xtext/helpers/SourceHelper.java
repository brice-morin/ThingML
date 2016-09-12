/**
 * Copyright (C) 2014 SINTEF <franck.fleurey@sintef.no>
 *
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingml.xtext.helpers;

import org.sintef.thingml.constraints.ThingMLHelpers;
import org.thingml.xtext.thingML.*;

/**
 * Created by ffl on 10.05.2016.
 */
public class SourceHelper {


    public static String qname(Source self, String separator) {
        Stream stream = ThingMLHelpers.findContainingStream(self);
        return stream.getName();
    }

}
