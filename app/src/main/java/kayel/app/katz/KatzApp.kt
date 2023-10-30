package kayel.app.katz

import android.app.Application
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import kayel.app.katz.core.ComposableActivity
import kayel.app.katz.ui.KatzNavigation
import kayel.app.katz.ui.theme.KatzTheme
import kayel.app.katz.ui.viewmodel.KatzViewModel

/**
 * KatzApp is the main application class that extends Application.
 */
class KatzApp : Application()


/**
 * KatzActivity is an activity class that inherits from ComposableActivity
 * and manages the UI logic for the Katz application.
 */
class KatzActivity : ComposableActivity()
{
	override var content: @Composable () -> Unit = {
		KatzTheme { KatzNavigation(viewModels<KatzViewModel>().value) }
	}
}

