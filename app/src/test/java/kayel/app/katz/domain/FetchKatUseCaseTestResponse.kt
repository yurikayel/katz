package kayel.app.katz.domain

import io.mockk.coEvery
import io.mockk.mockk
import kayel.app.katz.data.KatService
import kayel.app.katz.entity.KatResponse.Kat
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class FetchKatUseCaseTestResponse
{
	
	@Test
	fun `execute() should return kat images when the service call is successful`()
	{
		// Given
		val mockKatService = mockk<KatService>()
		val useCase = FetchKatUseCase(mockKatService)
		val mockResponse = listOf(Kat())
		
		coEvery { mockKatService.getKatz().data } returns mockResponse
		
		// When
		val result = runBlocking { useCase.execute() }
		
		// Then
		assertEquals(mockResponse, result)
	}
	
	
	@Test(expected = IOException::class)
	fun `execute() should throw IOException when there is a network issue`()
	{
		// Given
		val mockKatService = mockk<KatService>()
		val useCase = FetchKatUseCase(mockKatService)
		
		coEvery { mockKatService.getKatz() } throws IOException("Network error")
		
		// When
		runBlocking { useCase.execute() }
	}
	
	
	@Test(expected = HttpException::class)
	fun `execute() should throw HttpException when there is an HTTP issue`()
	{
		// Given
		val mockKatService = mockk<KatService>()
		val useCase = FetchKatUseCase(mockKatService)
		
		coEvery { mockKatService.getKatz() } throws HttpException(
				Response.error<Any>(
						404,
						"".toResponseBody()
				)
		)
		
		// When
		runBlocking { useCase.execute() }
	}
}
