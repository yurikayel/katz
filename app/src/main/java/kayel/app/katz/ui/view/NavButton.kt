package kayel.app.katz.presentation.view

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

/**
 * Represents a button used for navigation between different destinations in the Katz application.
 *
 * @param route The destination route to navigate to when the button is clicked.
 * @param popUpTo The destination route to pop up to when navigating.
 * @param inc A boolean value indicating whether to include the destination route specified in [popUpTo].
 */
@Composable
fun NavHostController.NavButton(
		route: String,
		popUpTo: String?,
		inc: Boolean = true
)
{
	Button(
			onClick = {
				navigate(route) {
					if (popUpTo != null)
					{
						popUpTo(popUpTo) {
							inclusive = inc
						}
					}
				}
			}
	) {
		Text(route)
	}
}