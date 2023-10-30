import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kayel.app.katz.data.KatService
import kayel.app.katz.domain.FetchKatUseCase
import kayel.app.katz.entity.KatResponse.Kat
import kayel.app.katz.ui.viewmodel.KatzViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class KatzViewModelTest
{
	private val testDispatcher = TestCoroutineDispatcher()
	
	
	@Before
	fun setup()
	{
		// Set the main dispatcher to the test dispatcher
		Dispatchers.setMain(testDispatcher)
	}
	
	
	@After
	fun tearDown()
	{
		// Reset the main dispatcher after the test
		Dispatchers.resetMain()
		testDispatcher.cleanupTestCoroutines()
	}
	
	
	@Test
	fun `fetchCatImages should emit success state with valid data`() =
			testDispatcher.runBlockingTest {
				// Arrange
				val katService = mockk<KatService>()
				val fetchKatUseCase = FetchKatUseCase(katService)
				val katzViewModel = KatzViewModel(fetchKatUseCase)
				
				val mockKats = listOf(
						Kat(link = "url1"),
						Kat(link = "url2")
				)
				coEvery { katService.getKatz().data } returns mockKats
				
				// Act
				katzViewModel.fetchCatImages(testDispatcher)
				
				// Assert
				assertEquals(
						KatzViewModel.KatState.Success(mockKats),
						katzViewModel.katState.value
				)
			}
	
	
	@Test
	fun `fetchCatImages should emit error state on exception`() =
			testDispatcher.runBlockingTest {
				// Arrange
				val katService = mockk<KatService>()
				val fetchKatUseCase = FetchKatUseCase(katService)
				val katzViewModel = KatzViewModel(fetchKatUseCase)
				
				val errorMessage = "Network error"
				coEvery { katService.getKatz() } throws Exception(errorMessage)
				
				// Act
				katzViewModel.fetchCatImages(testDispatcher)
				
				// Assert
				assertEquals(
						KatzViewModel.KatState.Error(errorMessage),
						katzViewModel.katState.value
				)
			}
}
