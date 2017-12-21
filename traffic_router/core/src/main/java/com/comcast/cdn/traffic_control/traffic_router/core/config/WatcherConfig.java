/*
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.comcast.cdn.traffic_control.traffic_router.core.config;

import com.comcast.cdn.traffic_control.traffic_router.core.util.TrafficOpsUtils;
import com.fasterxml.jackson.databind.JsonNode;

public class WatcherConfig {
	private final String url;
	private final long interval;
	// this is an int instead of a long because of protected resource fetcher
	private final int timeout;

	public WatcherConfig(final String prefix, final JsonNode config, final TrafficOpsUtils trafficOpsUtils) {
		url = trafficOpsUtils.getUrl(prefix + ".polling.url", "");
		interval = config.has(prefix + ".polling.interval") ? config.get(prefix + ".polling.interval").asLong(-1L) : -1L;
		timeout = config.has(prefix + ".polling.timeout") ? config.get(prefix + ".polling.timeout").asInt(-1) : -1;
	}

	public long getInterval() {
		return interval;
	}

	public String getUrl() {
		return url;
	}

	public int getTimeout() {
		return timeout;
	}
}
