/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2014 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.undertow.server.handlers.resource;

import java.io.Closeable;
import java.io.IOException;

import io.undertow.UndertowMessages;

/**
 *
 * Representation of a resource manager. A resource manager knows how to obtain
 * a resource for a given path.
 *
 * @author Stuart Douglas
 */
public interface ResourceManager extends Closeable {

    /**
     * Returns a resource for the given path.
     *
     * It is the responsibility of the called to make sure that the path in Canonicalised.
     *
     * @param path The path
     * @return The resource representing the path, or null if no resource was found.
     */
    Resource getResource(final String path) throws IOException;

    ResourceManager EMPTY_RESOURCE_MANAGER = new ResourceManager() {
        @Override
        public Resource getResource(final String path){
            return null;
        }


        @Override
        public void close() throws IOException {
        }
    };
}
