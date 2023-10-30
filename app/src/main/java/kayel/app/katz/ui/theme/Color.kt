package kayel.app.katz.ui.theme

import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

private val darkColorScheme = darkColorScheme(
		primary = Purple80,
		secondary = PurpleGrey80,
		tertiary = Pink80
)

private val lightColorScheme = lightColorScheme(
		primary = Purple40,
		secondary = PurpleGrey40,
		tertiary = Pink40
		
		/* Other default colors to override
			background = Color(0xFFFFFBFE),
			surface = Color(0xFFFFFBFE),
			onPrimary = Color.White,
			onSecondary = Color.White,
			onTertiary = Color.White,
			onBackground = Color(0xFF1C1B1F),
			onSurface = Color(0xFF1C1B1F),
			*/
)


@Composable
fun colorScheme(
		dynamicColor: Boolean,
		darkTheme: Boolean
) = when
{
	dynamicColor && VERSION.SDK_INT >= VERSION_CODES.S ->
	{
		val context = LocalContext.current
		if (darkTheme) dynamicDarkColorScheme(context)
		else dynamicLightColorScheme(context)
	}
	
	
	darkTheme                                          -> darkColorScheme
	else                                               -> lightColorScheme
}