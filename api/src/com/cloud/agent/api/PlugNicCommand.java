// Copyright 2012 Citrix Systems, Inc. Licensed under the
// Apache License, Version 2.0 (the "License"); you may not use this
// file except in compliance with the License.  Citrix Systems, Inc.
// reserves all rights not expressly granted by the License.
// You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// 
// Automatically generated by addcopyright.py at 04/03/2012
package com.cloud.agent.api;

import java.util.Map;

import com.cloud.agent.api.to.NicTO;
import com.cloud.agent.api.to.VirtualMachineTO;

/**
 * @author Alena Prokharchyk
 */
public class PlugNicCommand extends Command {
    public enum Param {
        DhcpRange,
        NetworkDomain
    }
    
    VirtualMachineTO vm;
    NicTO nic;
    Map<Param, String> params;
    
    public VirtualMachineTO getVirtualMachine() {
        return vm;
    }
    
    @Override
    public boolean executeInSequence() {
        return true;
    }
    
    protected PlugNicCommand() {
    }
    
    public PlugNicCommand(VirtualMachineTO vm, NicTO nic, Map<Param, String> params) {
        this.vm = vm;
        this.nic = nic;
        this.params = params;
    }
}
