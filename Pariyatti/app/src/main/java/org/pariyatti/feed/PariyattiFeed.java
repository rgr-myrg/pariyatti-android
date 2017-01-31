package org.pariyatti.feed;

import org.pariyatti.BuildConfig;
import org.pariyatti.model.Rss;
import org.pariyatti.util.Debug;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rgr-myrg on 1/30/17.
 */

public class PariyattiFeed {
	public static final String TAG = PariyattiFeed.class.getSimpleName();
	public static final String BASE_URL = "http://feeds.pariyatti.org";
	public static final String UTF8 = "UTF-8";

	/*
	 * List of availabble feeds::
	 * https://pariyatti.org/FreeResources/RSSFeeds/tabid/107/Default.aspx
	 */
	public enum Type {
		DWOB,
		DWOB_PORTUGUESE,
		DWOB_FRENCH,
		DWOB_SPANISH,
		DWOB_ITALIAN,
		DWOB_CHINESE,
		DWOB_SERBIAN,
		DOHAS,
		DOHAS_CHINESE,
		DOHAS_LITHUANIAN,
		DOHAS_PORTUGESE_BRAZIL,
		PWAD
	}

	private PariyattiApi mPariyattiApi;
	private OnFeedReady mOnFeedReady;
	private OnError mOnError;

	private PariyattiFeed() {
		mPariyattiApi = PariyattiClient.getClientWithUrl(BASE_URL).create(PariyattiApi.class);
	}

	public static final PariyattiFeed Builder() {
		return new PariyattiFeed();
	}

	public PariyattiFeed onFeedReady(final OnFeedReady callback) {
		mOnFeedReady = callback;
		return this;
	}

	public PariyattiFeed onError(final OnError callback) {
		mOnError = callback;
		return this;
	}

	public void fetch(Type type) {
		Call<Rss> rssCall = null;

		switch (type) {
			case DWOB:
				rssCall = mPariyattiApi.getDwobEnglishRss();
				break;
			case DWOB_PORTUGUESE:
				rssCall = mPariyattiApi.getDwobPortugueseRss();
				break;
			case DWOB_FRENCH:
				rssCall = mPariyattiApi.getDwobFrenchRss();
				break;
			case DWOB_SPANISH:
				rssCall = mPariyattiApi.getDwobSpanishRss();
				break;
			case DWOB_ITALIAN:
				rssCall = mPariyattiApi.getDwobItalianRss();
				break;
			case DWOB_CHINESE:
				rssCall = mPariyattiApi.getDwobChineseRss();
				break;
			case DWOB_SERBIAN:
				rssCall = mPariyattiApi.getDwobSerbianRss();
				break;
			case DOHAS:
				rssCall = mPariyattiApi.getDohasEnglishRss();
				break;
			case DOHAS_CHINESE:
				rssCall = mPariyattiApi.getDohasChineseRss();
				break;
			case DOHAS_LITHUANIAN:
				rssCall = mPariyattiApi.getDohasLithuanianRss();
				break;
			case DOHAS_PORTUGESE_BRAZIL:
				rssCall = mPariyattiApi.getDohasPortugueseBrazilRss();
				break;
			case PWAD:
				rssCall = mPariyattiApi.getPwadRss();
				break;
			default:
				break;
		}

		if (rssCall == null) {
			postErrorMessage("Unknown feed type.");
			return;
		}

		rssCall.enqueue(new Callback<Rss>() {
			@Override
			public void onResponse(Call<Rss> call, Response<Rss> response) {
				if (response == null || response.body() == null || mOnFeedReady == null) {
					postErrorMessage("Response returns null");
					return;
				}

				mOnFeedReady.callback(response.body());
			}

			@Override
			public void onFailure(Call<Rss> call, Throwable t) {
				postErrorMessage(t.getMessage());
			}
		});
	}

	private void postErrorMessage(final String message) {
		if (BuildConfig.DEBUG) {
			Debug.i(TAG, message);
		}

		if (mOnError != null) {
			mOnError.callback("Error: " + message);
		}
	}

	public interface OnFeedReady {
		void callback(Rss rss);
	}

	public interface OnError {
		void callback(String message);
	}
}
