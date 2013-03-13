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
package org.gridobservatory.greencomputing.dao;

import java.util.Collections;

import org.gridobservatory.greencomputing.adapters.Middleware;
import org.gridobservatory.greencomputing.repository.MiddlewareRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MiddlewareDao extends DaoSupport implements MiddlewareRepository {

	@Override
	public void insert(Middleware middleware) {
		this.insert(Collections.singleton(middleware));
	}

	@Override
	public void insert(Iterable<Middleware> middlewares) {
		for (Middleware middleware : middlewares) {
			this.getJdbcTemplate()
					.update("insert into middleware (middleware_id,middleware_type,product_name,product_version,kernel_name,kernel_version,arch) values (?,?,?,?,?,?,?)",
							middleware.getMiddlewareID(),
							middleware.getMiddlewareType().name(),
							middleware.getProductName(),
							middleware.getProductVersion(),
							middleware.getKernelName(),
							middleware.getKernelVersion(), middleware.getArch());
		}
	}
}