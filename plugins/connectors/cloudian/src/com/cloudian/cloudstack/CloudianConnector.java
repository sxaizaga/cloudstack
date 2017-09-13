// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package com.cloudian.cloudstack;

import org.apache.cloudstack.framework.config.ConfigKey;

import com.cloud.domain.Domain;
import com.cloud.user.Account;
import com.cloud.utils.component.PluggableService;

public interface CloudianConnector extends PluggableService {

    ConfigKey<Boolean> CloudianConnectorEnabled = new ConfigKey<>("Advanced", Boolean.class, "cloudian.connector.enabled", "false",
            "If set to true, this enables the Cloudian Connector for CloudStack.", true);

    ConfigKey<String> CloudianAdminHost = new ConfigKey<>("Advanced", String.class, "cloudian.admin.host", "s3-admin.cloudian.com",
            "The hostname of the Cloudian Admin server.", true);

    ConfigKey<String> CloudianAdminPort = new ConfigKey<>("Advanced", String.class, "cloudian.admin.port", "19443",
            "The port of the Cloudian Admin server.", true);

    ConfigKey<String> CloudianAdminProtocol = new ConfigKey<>("Advanced", String.class, "cloudian.admin.protocol", "https",
            "The protocol of the Cloudian Admin server.", true);

    ConfigKey<String> CloudianValidateSSLSecurity = new ConfigKey<>("Advanced", String.class, "cloudian.validate.ssl", "false",
            "When set to true, this will validate the SSL certificate when connecting to https/ssl enabled admin host.", true);

    ConfigKey<String> CloudianAdminUser = new ConfigKey<>("Advanced", String.class, "cloudian.admin.user", "admin",
            "The system admin user for accessing the Cloudian Admin server.", true);

    ConfigKey<String> CloudianAdminPassword = new ConfigKey<>("Advanced", String.class, "cloudian.admin.password", "public",
            "The system admin password for the Cloudian Admin server.", true);

    ConfigKey<String> CloudianCmcHost = new ConfigKey<>("Advanced", String.class, "cloudian.cmc.host", "cmc.cloudian.com",
            "The hostname of the Cloudian Management Console.", true);

    ConfigKey<String> CloudianCmcPort = new ConfigKey<>("Advanced", String.class, "cloudian.cmc.port", "8443",
            "The port of the Cloudian Management Console.", true);

    ConfigKey<String> CloudianCmcProtocol = new ConfigKey<>("Advanced", String.class, "cloudian.cmc.protocol", "https",
            "The protocol of the Cloudian Management Console.", true);

    ConfigKey<String> CloudianSsoKey = new ConfigKey<>("Advanced", String.class, "cloudian.sso.key", "ss0sh5r3dk3y",
            "The shared single sign-on key as configured in Cloudian CMC.", true);

    boolean isConnectorDisabled();
    String generateSsoUrl();
    boolean addGroup(final Domain domain);
    boolean removeGroup(final Domain domain);
    boolean addUserAccount(final Account account);
    boolean removeUserAccount(final Account account);
}