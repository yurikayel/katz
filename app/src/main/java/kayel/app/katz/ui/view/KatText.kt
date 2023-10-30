package kayel.app.katz.ui.view

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

/**
 * A versatile text input field that can be customized for various use cases.
 *
 * @param value The current text value of the input field.
 * @param onValueChange A callback function that is called when the text value changes.
 * @param modifier The modifier for styling and layout of the text field.
 * @param textStyle The text style to be applied to the input text.
 * @param placeholder An optional composable for displaying a placeholder when the field is empty.
 * @param keyboardType The keyboard type to use for text input (e.g., text, number, email).
 * @param imeAction The IME (Input Method Editor) action for the keyboard (e.g., Done, Search).
 * @param onImeAction A callback function to handle the IME action.
 * @param isPassword Indicates whether the input should be treated as a password (text is masked).
 * @param visualTransformation The visual transformation applied to the input text (e.g., password masking).
 * @param leadingIcon An optional composable for displaying an icon before the input.
 * @param trailingIcon An optional composable for displaying an icon after the input.
 *
 * @see OutlinedTextField for the underlying text field implementation.
 */
@Composable
fun KatText(
		value: String,
		onValueChange: (String) -> Unit,
		modifier: Modifier = Modifier,
		textStyle: TextStyle = TextStyle.Default,
		placeholder: @Composable (() -> Unit)? = null,
		keyboardType: KeyboardType = KeyboardType.Text,
		imeAction: ImeAction = ImeAction.Default,
		onImeAction: () -> Unit = {},
		leadingIcon: @Composable (() -> Unit)? = null,
		trailingIcon: @Composable (() -> Unit)? = null,
		isPassword: Boolean = false,
		visualTransformation: VisualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
) {
	OutlinedTextField(
			value = value,
			onValueChange = { newValue -> onValueChange(newValue) },
			modifier = modifier,
			textStyle = textStyle,
			placeholder = placeholder,
			keyboardOptions = KeyboardOptions(
					keyboardType = keyboardType,
					imeAction = imeAction
			),
			keyboardActions = KeyboardActions(
					onDone = { onImeAction() }
			),
			visualTransformation = visualTransformation,
			leadingIcon = leadingIcon,
			trailingIcon = trailingIcon
	)
}

