package org.pariyatti.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by rgr-myrg on 1/30/17.
 */

@Root(name = "item", strict = false)
@NamespaceList({
		@Namespace(prefix = "feedburner", reference = "http://rssnamespace.org/feedburner/ext/1.0"),
		@Namespace(prefix = "itunes", reference = "http://www.itunes.com/dtds/podcast-1.0.dtd")
})
public class RssItem {
	@Element(name = "title", required = false)
	private String title;

	@Element(name = "summary", required = false)
	private String summary;

	@Element(name = "description", required = false)
	private String description;

	@Element(name = "enclosure", required = false)
	private RssEnclosure enclosure;

	public String getTitle() {
		return title;
	}

	public String getSummary() {
		return summary;
	}

	public String getDescription() {
		return description;
	}

	public RssEnclosure getEnclosure() {
		return enclosure;
	}
}
