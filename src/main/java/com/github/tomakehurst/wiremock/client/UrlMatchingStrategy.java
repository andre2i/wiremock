/*
 * Copyright (C) 2011 Thomas Akehurst
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.tomakehurst.wiremock.client;

import com.github.tomakehurst.wiremock.matching.RequestPattern;
import com.github.tomakehurst.wiremock.matching.StringValuePattern;
import com.github.tomakehurst.wiremock.matching.UrlPathPattern;
import com.github.tomakehurst.wiremock.matching.UrlPattern;

import java.net.URI;

public class UrlMatchingStrategy {

	private String url;
	private String urlPattern;
    private String urlPath;
	private String urlPathPattern;

	public void contributeTo(RequestPattern requestPattern) {
		requestPattern.setUrl(url);
		requestPattern.setUrlPattern(urlPattern);
        requestPattern.setUrlPath(urlPath);
		requestPattern.setUrlPathPattern(urlPathPattern);
	}

    public UrlPattern toUrlPattern() {
        if (url != null) {
            return UrlPattern.equals(url);
        } else if (urlPattern != null) {
            return UrlPattern.matching(urlPattern);
        } else if (urlPath != null) {
            return UrlPathPattern.equals(urlPath);
        } else if (urlPathPattern != null) {
            return UrlPathPattern.matching(urlPathPattern);
        } else {
            return UrlPattern.equals("/");
        }

    }

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

	public void setUrlPathPattern(String urlPathPattern) {
		this.urlPathPattern = urlPathPattern;
	}
}
