package kayel.app.katz.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kayel.app.katz.plugins.window
import kayel.app.katz.ui.view.SafeArea


@Composable
fun KatzTheme(
		darkTheme: Boolean = isSystemInDarkTheme(),
		dynamicColor: Boolean = true,
		navHostController: NavHostController = rememberNavController(),
		colorScheme: ColorScheme = colorScheme(dynamicColor, darkTheme),
		content: @Composable NavHostController.() -> Unit
)
{
	LocalView(colorScheme, darkTheme)
	MaterialTheme(
			colorScheme = colorScheme,
			typography = Typography,
			content = { SafeArea { navHostController.content() } }
	)
}


@Composable
private fun LocalView(
		colorScheme: ColorScheme,
		darkTheme: Boolean = isSystemInDarkTheme()
) = with(LocalView.current) {
	if (!isInEditMode)
	{
		SideEffect {
			window.statusBarColor = colorScheme.primary.toArgb()
			WindowCompat.getInsetsController(window, this)
				.isAppearanceLightStatusBars = darkTheme
		}
	}
}

