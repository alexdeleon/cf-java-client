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

package org.cloudfoundry.reactor.routing;

import org.cloudfoundry.reactor.ConnectionContext;
import org.cloudfoundry.reactor.TokenProvider;
import org.cloudfoundry.reactor.routing.v1.routergroups.ReactorRouterGroups;
import org.cloudfoundry.reactor.routing.v1.tcproutes.ReactorTcpRoutes;
import org.cloudfoundry.routing.RoutingClient;
import org.cloudfoundry.routing.v1.routergroups.RouterGroups;
import org.cloudfoundry.routing.v1.tcproutes.TcpRoutes;
import org.cloudfoundry.uaa.UaaClient;
import org.immutables.value.Value;
import reactor.core.publisher.Mono;

/**
 * The Reactor-based implementation of {@link UaaClient}
 */
@Value.Immutable
abstract class _ReactorRoutingClient implements RoutingClient {

    @Override
    @Value.Derived
    public RouterGroups routerGroups() {
        return new ReactorRouterGroups(getConnectionContext(), getRoot(), getTokenProvider());
    }

    @Override
    @Value.Derived
    public TcpRoutes tcpRoutes() {
        return new ReactorTcpRoutes(getConnectionContext(), getRoot(), getTokenProvider());
    }

    /**
     * The connection context
     */
    abstract ConnectionContext getConnectionContext();

    @Value.Default
    Mono<String> getRoot() {
        return getConnectionContext().getRootProvider().getRoot("routing_endpoint", getConnectionContext());
    }

    /**
     * The token provider
     */
    abstract TokenProvider getTokenProvider();

}
