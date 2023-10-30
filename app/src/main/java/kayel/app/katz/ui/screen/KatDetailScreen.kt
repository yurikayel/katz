//package kayel.app.katz.presentation.screen
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import kayel.app.katz.ui.viewmodel.KatzModel
//import kayel.app.katz.ui.viewmodel.KatzModel.State.Loading
//import kayel.app.katz.ui.viewmodel.KatzModel.State.Success
//
//
///**
// * [Composable] that displays user details.
// * [KatzModel] used for data retrieval.
// * @param navController The [NavHostController] for navigation.
// */
//@Composable
//fun KatzModel.UserDetailScreen()
//{
////	val user by userState.collectAsState()
//
//	Column(
//			modifier = Modifier
//				.fillMaxSize()
//				.padding(16.dp),
//			verticalArrangement = Arrangement.Top,
//			horizontalAlignment = Alignment.CenterHorizontally
//	) {
////		BackButton(onBackClick = { navController.popBackStack() })
//		Spacer(modifier = Modifier.height(16.dp))
//		if (user is Loading) LoadingIndicator()
//		else UserContent(
//				user = when (user)
//				{
//					is Success -> (user as Success).data
//					else       -> null
//				},
//				errorMessage = when (user)
//				{
//					is Error -> (user as Error).message
//					else     -> null
//				}
//		)
//	}
//}
//
//
///**
// * [BackButton]
// * @param onBackClick callback to handle back click.
// */
//@Composable
//private fun BackButton(onBackClick: () -> Unit)
//{
//	IconButton(
//			onClick = { onBackClick() },
//			modifier = Modifier.padding(start = 16.dp)
//	) {
//		Icon(
//				painter = painterResource(id = R.drawable.ic_search),
//				contentDescription = null,
//				tint = Color.Black
//		)
//	}
//}
//
//
///**[LoadingIndicator] Composable.
// */
//@Composable
//private fun LoadingIndicator()
//{
//	CircularProgressIndicator(
//			modifier = Modifier.size(48.dp)
//	)
//}
//
//
///**[Composable] that displays [UserContent].
// * @param user The GitHub user to display.
// * @param errorMessage Error message to display if the user is null.
// */
//@Composable
//private fun UserContent(
//		user: User,
//		errorMessage: String?
//) = user?.run {
//	UserInfo()
//	Spacer(modifier = Modifier.height(8.dp))
//	UserAvatar()
//} ?: ErrorMessage(message = errorMessage ?: "User is null")
//
//
///**Composable that displays the [UserAvatar]
// */
//@Composable
//private fun User.UserAvatar()
//{
//	Image(
//			painter = rememberAsyncImagePainter(model = avatarUrl),
//			contentDescription = null,
//			modifier = Modifier
//				.size(120.dp)
//				.clip(CircleShape)
//	)
//}
//
//
//
//
///**[Info]
// * @param label The label for the user information.
// * @param value The value of the user information.
// */
//@Composable
//private infix fun String?.Info(label: String) = this?.let {
//	Column {
//		Text(text = label, fontWeight = FontWeight.Bold)
//		Text(text = this@Info, color = Color.Gray)
//	}
//}
//
//
///**
// * Composable that displays an error message.
// *
// * @param message The error message to display.
// */
//@Composable
//private fun ErrorMessage(message: String)
//{
//	Text(
//			text = message,
//			color = Color.Red,
//			fontSize = 16.sp,
//			modifier = Modifier.fillMaxWidth(),
//			textAlign = TextAlign.Center
//	)
//}
//
//
//@Composable
//private infix fun String.Title(fontSize: Int)
//{
//	Text(
//			text = this,
//			fontWeight = FontWeight.Bold,
//			fontSize = fontSize.sp,
//			color = Color.Black
//	)
//	Spacer()
//}
//
//
//@Composable
//private fun Spacer(dp: Int = 8) = Spacer(modifier = Modifier.height(dp.dp))