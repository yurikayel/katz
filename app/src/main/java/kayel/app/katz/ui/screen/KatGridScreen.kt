package kayel.app.katz.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells.Fixed
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kayel.app.katz.entity.KatResponse.Kat
import kayel.app.katz.ui.view.Card
import kayel.app.katz.ui.viewmodel.KatzViewModel
import kayel.app.katz.ui.viewmodel.KatzViewModel.KatState.Error
import kayel.app.katz.ui.viewmodel.KatzViewModel.KatState.Success

/**
 * kayel.app.katz.ui.screen.KatzGridScreen is a Composable
 * function responsible for displaying a grid of cat images.
 * It takes a [KatzViewModel] to observe the cat image states.
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun KatzViewModel.KatzGridScreen() = Column(modifier = Modifier.fillMaxSize()) {
	Spacer(modifier = Modifier.height(16.dp))
	katState.collectAsState().value.run {
		when (this)
		{
			is Success -> Success()
			is Error   -> Error()
			else       -> Loading()
		}
	}
}


@Composable
private fun Loading()
{
	CircularProgressIndicator(
			modifier = Modifier
				.fillMaxSize()
				.padding(16.dp)
				.wrapContentSize(Alignment.Center)
	)
}


@Composable
private fun Error.Error()
{
	Text(
			text = error,
			color = MaterialTheme.colorScheme.error,
			modifier = Modifier.padding(16.dp)
	)
}


@Composable
private fun Success.Success() = katz.filter().run {
	LazyVerticalGrid(
			columns = Fixed(4),
			contentPadding = PaddingValues(8.dp),
			modifier = Modifier.fillMaxSize()
	) { items(size) { get(it).Card() } }
}


@Composable
private fun List<Kat>.filter(): List<Kat> = filter {
	it.images.isNotEmpty() &&
	it.images[0].link.run {
		contains(".jpg") ||
		contains(".jpeg") ||
		contains(".png")
	}
}