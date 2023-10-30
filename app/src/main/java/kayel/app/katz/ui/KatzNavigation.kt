package kayel.app.katz.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kayel.app.katz.presentation.view.NavButton
import kayel.app.katz.ui.KatNavigation.HOME
import kayel.app.katz.ui.screen.KatzGridScreen
import kayel.app.katz.ui.viewmodel.KatzViewModel


/**
 * Object containing route constants for navigation.
 */
object KatNavigation
{
	const val HOME = "HOME"
}


/**
 * Custom NavHost function that provides a start destination
 * and [builder] lambda to define the navigation graph.
 *
 * @param builder Lambda that defines the navigation graph.
 */
@Composable
fun NavHostController.KatHost(builder: NavGraphBuilder.() -> Unit) =
		NavHost(this, startDestination = HOME, builder = builder)


/**
 * Represents the navigation logic for the Katz application.
 * Defines different destinations and navigation actions using [NavHostController] and [NavButton] composable.
 */
@Composable
fun NavHostController.KatzNavigation(viewModel: KatzViewModel) = KatHost {
	composable(HOME) {
		viewModel.KatzGridScreen()
	}
}
