package org.pariyatti.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by rgr-myrg on 1/30/17.
 */

@Root(name = "channel", strict=false)
public class RssChannel {

	@Element(name = "item", required = false)
	private RssItem item;

	public RssItem getItem() {
		return item;
	}
}
