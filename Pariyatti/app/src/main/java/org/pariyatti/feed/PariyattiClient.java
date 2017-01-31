package org.pariyatti.feed;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Creates Retrofit Client with Retrofit.Builder()
 * Created by rgr-myrg on 1/30/17.
 */

public class PariyattiClient {
	private static Retrofit sRetrofit = null;

	public static final Retrofit getClientWithUrl(final String url) {
		if (sRetrofit == null) {
			sRetrofit = new Retrofit.Builder()
					.baseUrl(url)
					.addConverterFactory(SimpleXmlConverterFactory.create())
					.build();
		}

		return sRetrofit;
	}
}
