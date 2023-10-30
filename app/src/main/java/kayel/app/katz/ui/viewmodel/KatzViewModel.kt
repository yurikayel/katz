package kayel.app.katz.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kayel.app.katz.domain.FetchKatUseCase
import kayel.app.katz.entity.KatResponse.Kat
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * ViewModel class responsible for managing the UI-related data of the Katz feature.
 *
 * @param useCase The use case responsible for fetching kat images.
 */
class KatzViewModel(
		private val useCase: FetchKatUseCase = FetchKatUseCase()
) : ViewModel()
{
	
	init
	{
		fetchCatImages()
	}
	
	
	// Use sealed classes for better readability and exhaustiveness of states
	sealed class KatState
	{
		object Loading : KatState()
		data class Success(val katz: List<Kat>) : KatState()
		data class Error(val error: String) : KatState()
	}
	
	
	// StateFlow to hold the UI state, initialized with Loading state
	private val _katState = MutableStateFlow<KatState>(KatState.Loading)
	
	
	// Expose the state as a StateFlow, which is immutable
	val katState: StateFlow<KatState> get() = _katState
	
	
	/**
	 * Fetches cat images asynchronously and updates the UI state accordingly.
	 *
	 * @param dispatcher The CoroutineDispatcher to execute the operation on. Default is [Dispatchers.IO].
	 */
	fun fetchCatImages(dispatcher: CoroutineDispatcher = IO)
	{
		viewModelScope.launch {
			try
			{
				withContext(dispatcher) {
					_katState.value = KatState.Success(useCase.execute())
				}
			} catch (e: Exception)
			{
				_katState.value = KatState.Error(
						e.message ?: "An error occurred"
				)
			}
		}
	}
}
