package kayel.app.katz.plugins

import android.app.Activity
import android.view.View
import android.view.Window


val View.window: Window get() = (context as Activity).window
