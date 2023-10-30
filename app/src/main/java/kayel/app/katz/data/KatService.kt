package kayel.app.katz.data

import kayel.app.katz.entity.KatResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Interface for defining API endpoints related to kat images on Imgur.
 */
interface KatService {
	/**
	 * Fetches kat images from the Imgur API.
	 * @param query The search term for cat images.
	 * @return [KatResponse] object representing kat images.
	 * @throws [HttpException] if there is an issue with the HTTP request or response.
	 * @throws [IOException] if there is a network issue.
	 */
	@Headers("Authorization: Client-ID 1ceddedc03a5d71")
	@GET("/3/gallery/search")
	suspend fun getKatz(@Query("q") query: String = "cat"): KatResponse
	
	/**
	 * Singleton instance of [KatService] created using [Retrofit] and [GsonConverterFactory].
	 */
	companion object {
		private const val BASE_URL = "https://api.imgur.com"
		
		/**
		 * Creates and provides a singleton instance of [KatService].
		 * @return Singleton [KatService] instance.
		 */
		val instance: KatService by lazy {
			Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build().create(KatService::class.java)
		}
	}
}
