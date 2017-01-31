package org.pariyatti.feed;

import org.pariyatti.model.Rss;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rgr-myrg on 1/30/17.
 */

public interface PariyattiApi {
	/*
	 * http://feeds.pariyatti.org/dwob
	 */
	@GET("dwob")
	Call<Rss> getDwobEnglishRss();

	@GET("dohas")
	Call<Rss> getDohasEnglishRss();

	@GET("dohas-chinese")
	Call<Rss> getDohasChineseRss();

	@GET("dohas-lithuanian")
	Call<Rss> getDohasLithuanianRss();

	@GET("dohas-pt-br")
	Call<Rss> getDohasPortugueseBrazilRss();

	@GET("pwad")
	Call<Rss> getPwadRss();

	@GET("dwob-portugeuse")
	Call<Rss> getDwobPortugueseRss();

	@GET("dwob-french")
	Call<Rss> getDwobFrenchRss();

	@GET("dwob-espanol")
	Call<Rss> getDwobSpanishRss();

	@GET("dwob-italian")
	Call<Rss> getDwobItalianRss();

	@GET("dwob-chinese")
	Call<Rss> getDwobChineseRss();

	@GET("dwob-sr")
	Call<Rss> getDwobSerbianRss();
}
