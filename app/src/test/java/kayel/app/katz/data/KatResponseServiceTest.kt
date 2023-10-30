package kayel.app.katz.data

import io.mockk.coEvery
import io.mockk.mockk
import kayel.app.katz.entity.KatResponse
import kayel.app.katz.entity.KatResponse.Kat
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Unit tests for [KatService] class, validating the behavior of `getKatz` function.
 */
class KatResponseServiceTest
{
	
	/**
	 * Constants used for testing valid kat data.
	 */
	private companion object
	{
		const val ID = "1"
		const val TITLE = "Cat 1"
		const val URL = "http://example.com/cat1.jpg"
	}
	
	
	/**
	 * Tests the [KatService.getKatz] function with valid data.
	 * It verifies if the service returns a list containing a single kat with the specified ID, title, and URL.
	 */
	@Test
	fun testGetCatImagesWithValidData() = runBlocking {
		// Arrange (Setup)
		val service = mockk<KatService>()
		coEvery { service.getKatz() } returns KatResponse(
				data = listOf(
						Kat(id = ID, title = TITLE, link = URL)
				)
		)
		
		
		// Act
		val result = service.getKatz().data
		
		// Assert
		assertEquals(1, result.size)
		assertEquals(ID, result[0].id)
		assertEquals(TITLE, result[0].title)
		assertEquals(URL, result[0].link)
	}
}

