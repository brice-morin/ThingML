/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 */
package org.thingml.externalthingplugins.c.posix.dnssd;

import java.util.Map;

import org.thingml.compilers.c.CCfgMainGenerator;
import org.thingml.compilers.c.CCompilerContext;
import org.thingml.externalthingplugins.c.posix.PosixDNSSDExternalThingPlugin;
import org.thingml.externalthingplugins.c.posix.dnssd.utils.DNSSDUtils;
import org.thingml.xtext.constraints.ThingMLHelpers;
import org.thingml.xtext.helpers.ConfigurationHelper;
import org.thingml.xtext.helpers.ThingMLElementHelper;
import org.thingml.xtext.thingML.CompositeState;
import org.thingml.xtext.thingML.Configuration;
import org.thingml.xtext.thingML.Expression;
import org.thingml.xtext.thingML.Instance;
import org.thingml.xtext.thingML.Message;
import org.thingml.xtext.thingML.Port;
import org.thingml.xtext.thingML.Property;

/**
 * Created by vassik on 17.11.16.
 */
public class PosixDNSSDCfgMainGenerator extends CCfgMainGenerator {

    private final PosixDNSSDExternalThingPlugin plugin;

    public PosixDNSSDCfgMainGenerator(PosixDNSSDExternalThingPlugin _plugin) {
        plugin = _plugin;
    }

    @Override
    protected void generateMessageHandleCallToDispatcherMessage(Map.Entry<Instance, Port> receiver, Message m,
                                                                StringBuilder builder, CCompilerContext ctx) {
        builder.append("// Call handle to dispatch '" +m.getName()+"' received by the DNSSD thing.\n" +
                "// Generated by " + this.getClass().getSimpleName() + "\n");

        if (ThingMLHelpers.allStateMachines(receiver.getKey().getType()).size() == 0)
            return; // there is no state machine

        builder.append(ctx.getHandlerName(receiver.getKey().getType(), receiver.getValue(), m));
        ctx.appendActualParametersForDispatcher(receiver.getKey().getType(), builder, m, "&" + ctx.getInstanceVarName(receiver.getKey()));
        builder.append(";\n");
    }

    @Override
    public void generateInitializationSimpleProperties(Instance inst, Configuration cfg, StringBuilder builder, CCompilerContext ctx) {
        builder.append("// Initialization of DNSSD related properties.\n" +
                "// Generated by " + this.getClass().getSimpleName() + "\n");
        Map<String, Object> def_pro_values = DNSSDUtils.getDNSSDDefaultPropValue();

        for (Map.Entry<Property, Expression> init : ConfigurationHelper.initExpressionsForInstance(cfg, inst).entrySet()) {
            if(def_pro_values.containsKey(init.getKey().getName())) {
                builder.append(ctx.getInstanceVarName(inst) + "." + ctx.getVariableName(init.getKey()) + " = ");
                if (init.getValue() != null) {
                    ctx.generateFixedAtInitValue(cfg, inst, init.getValue(), builder);
                }else {
                    Object default_value = def_pro_values.get(init.getKey().getName());
                    if(default_value == null) {
                        builder.append("NULL");
                    }else if (default_value instanceof Integer) {
                        builder.append(default_value.toString());
                    }else if (default_value instanceof String) {
                        builder.append("\"" + default_value.toString()+ "\"");
                    }else {
                        builder.append("// Default value is of an unknown type. Check " + this.getClass().getSimpleName() + "\n");
                    }
                }
                builder.append(";\n");
            }
        }

    }

    @Override
    protected void generateCleanupOnTerminateInstance(Instance inst, Configuration cfg, StringBuilder builder, CCompilerContext ctx) {
        builder.append("// Cleanup for DNSSD things.\n" +
                "// Generated by " + this.getClass().getSimpleName() + "\n");
        if (ThingMLHelpers.allStateMachines(inst.getType()).size() == 0)
            return; // there is no state machine

        CompositeState sm = ThingMLHelpers.allStateMachines(inst.getType()).get(0);
        builder.append(ThingMLElementHelper.qname(sm, "_") + "_OnEntry(" +
                DNSSDUtils.getTerminateStateName(inst.getType()) + ", &" + ctx.getInstanceVarName(inst) + ");\n");
    }
}
