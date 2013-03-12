/**
 * Copyright (C) 2013 Alessandro <alessandro dot leite at alessandro dot cc>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gridobservatory.greencomputing.repository;

import java.util.Collection;

import org.gridobservatory.greencomputing.adapters.Middleware;
import org.springframework.stereotype.Repository;

@Repository
public class MiddlewareRepository extends RepositorySupport {

	public void insert(Middleware middleware) {

		this.getJdbcTemplate()
				.update("insert into middleware (middleware_id,middleware_type,product_name,product_version,kernel_name,kernel_version,arch) values (?,?,?,?,?,?,?)",
						middleware.getMiddlewareID(),
						middleware.getMiddlewareType().name(),
						middleware.getProductName(),
						middleware.getProductVersion(),
						middleware.getKernelName(),
						middleware.getKernelVersion(), middleware.getArch());
	}

	public void insert(Collection<Middleware> middlewares) {
		for (Middleware middleware : middlewares) {
			this.insert(middleware);
		}
	}
}