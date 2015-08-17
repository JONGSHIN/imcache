/*
* Copyright (C) 2015 Cetsoft, http://www.cetsoft.com
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
* 
* Author : Yusuf Aytas
* Date   : Nov 8, 2013
*/
package com.cetsoft.imcache.cache.search.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class LEFilter is used to retrieve items
 * less than given value.
 */
public class LTFilter extends ArithmeticFilter {

	/**
	 * Instantiates a new lE filter.
	 *
	 * @param attributeName the attribute name
	 * @param value the value
	 */
	public LTFilter(String attributeName, Object value) {
		super(attributeName, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cetsoft.imcache.cache.search.filter.Filter#filter(java.util.List)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Object> filter(List<Object> objects) {
		List<Object> result = new ArrayList<Object>(objects.size());
		for (Object object : objects) {
			Comparable objectValue = (Comparable) getAttributeValue(object);
			if (objectValue.compareTo(value) < 0) {
				result.add(object);
			}
		}
		return result;
	}

}