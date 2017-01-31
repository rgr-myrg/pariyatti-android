package org.pariyatti.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by rgr-myrg on 1/31/17.
 */

@Root(name = "enclosure", strict = false)

public class RssEnclosure {
	@Attribute(name = "url", required = false)
	private String url;

	@Attribute(name = "type", required = false)
	private String type;

	@Attribute(name = "length", required = false)
	private int length;

	public String getUrl() {
		return url;
	}

	public String getType() {
		return type;
	}

	public int getLength() {
		return length;
	}
}
