package kayel.app.katz.domain

import kayel.app.katz.data.KatService
import kayel.app.katz.entity.KatResponse.Kat
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Use case for fetching kat images from the Imgur API.
 *
 * This use case encapsulates the logic for fetching kat images from the Imgur API using the provided [KatService] instance.
 *
 * @property katService The [KatService] instance responsible for fetching kat images.
 */
class FetchKatUseCase @Inject constructor(
		private val katService: KatService = KatService.instance
)
{
	
	/**
	 * Executes the use case to fetch kat images.
	 *
	 * This function asynchronously fetches kat images from the Imgur API using the [katService] instance.
	 *
	 * @return List of [KatService.Kat] objects representing kat images.
	 *
	 * @throws [IOException] if there is a network issue during the data fetching process.
	 * @throws [HttpException] if there is an issue with the HTTP request or response.
	 */
	@Throws(IOException::class, HttpException::class)
	suspend fun execute(): List<Kat>
	{
		try
		{
			// Call the service method to get kat images
			return katService.getKatz().data
		} catch (e: IOException)
		{
			// Handle network issues
			throw e
		} catch (e: HttpException)
		{
			// Handle HTTP issues
			throw e
		}
	}
}
