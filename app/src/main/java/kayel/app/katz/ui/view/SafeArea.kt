package kayel.app.katz.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * A composable that adds a safe area around the content, adjusting for system bars.
 *
 * @param content The composable content to be displayed within the safe area.
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SafeArea(content: @Composable () -> Unit) = Box(
		modifier = Modifier
			.fillMaxSize()
			.statusBarsPadding()
			.background(Color.Gray)
) {
	Scaffold { _ -> content() }
}