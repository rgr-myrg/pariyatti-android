package org.pariyatti.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by rgr-myrg on 1/30/17.
 */

@Root(name = "rss", strict=false)
public class Rss {
	@Element(name = "channel", required = false)
	private RssChannel channel;

	public RssChannel getChannel() {
		return channel;
	}
}
