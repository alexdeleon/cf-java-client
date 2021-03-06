/*
 * Copyright 2013-2017 the original author or authors.
 *
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
 */

package org.cloudfoundry.client.v2.userprovidedserviceinstances;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.cloudfoundry.AllowNulls;
import org.cloudfoundry.Nullable;
import org.immutables.value.Value;

import java.util.Map;

/**
 * The request payload for the Create User Provided Service Instance
 */
@Value.Immutable
abstract class _CreateUserProvidedServiceInstanceRequest {

    /**
     * Key/value pairs to store credentials
     */
    @AllowNulls
    @JsonProperty("credentials")
    @Nullable
    abstract Map<String, Object> getCredentials();

    /**
     * The name
     */
    @JsonProperty("name")
    abstract String getName();

    /**
     * URL to which requests for bound routes will be forwarded
     */
    @JsonProperty("route_service_url")
    @Nullable
    abstract String getRouteServiceUrl();

    /**
     * The space id
     */
    @JsonProperty("space_guid")
    abstract String getSpaceId();

    /**
     * The url for the syslog_drain to direct to
     */
    @JsonProperty("syslog_drain_url")
    @Nullable
    abstract String getSyslogDrainUrl();

}
