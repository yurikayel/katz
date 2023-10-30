package kayel.app.katz.ui.view

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kayel.app.katz.entity.KatResponse.Kat

/**
 * KatCard is a Composable function responsible
 * for displaying an individual cat image item.
 *
 * @receiver [Kat] object representing the cat image to be displayed.
 */
@Composable
fun Kat.Card()
{
	Card(
			modifier = Modifier
				.fillMaxWidth()
				.padding(8.dp)
				.clip(MaterialTheme.shapes.medium)
				.aspectRatio(0.75f)
	) {
		AsyncImage(
				model = images[0].link,
				contentDescription = title,
				contentScale = ContentScale.Crop,
				onError = { error -> println("Oops: $error") },
				modifier = Modifier
					.fillMaxWidth()
		
		)
	}
}
