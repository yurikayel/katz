package kayel.app.katz.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat.setDecorFitsSystemWindows


/**[ComponentActivity] for composing UI with Jetpack Compose.
 * @property content The main content of the activity provided as a composable function.
 * @see [ComponentActivity]
 */
abstract class ComposableActivity : ComponentActivity()
{
	abstract var content: @Composable () -> Unit
	
	
	/**@function [onCreate] is called when the activity is created.
	 * @param savedInstanceState The saved instance state if available.
	 * @return Nothing.
	 * [setDecorFitsSystemWindows] false to ensure a full-screen Composable experience.
	 * [setContent] to set the Composable content for the activity.
	 */
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setDecorFitsSystemWindows(window, false)
		setContent(content = content)
	}
}
