package screens

import android.media.browse.MediaBrowser.MediaItem
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import components.TransactionForm
import components.TransactionList
import data.UserTransaction
import theme.BudgetProTheme
import viewmodel.BudgetViewModel

@Composable
fun HomeScreen(vm: BudgetViewModel = viewModel()) {
    val income = vm.incomeList.collectAsState().value
    val expense = vm.expenseList.collectAsState().value
    Home(income, expense, vm::addTransaction)
}

@Composable
fun Home(
    income: List<UserTransaction>,
    expense: List<UserTransaction>,
    onTransactionAdded: (UserTransaction) -> Unit
) {
    Surface(
        color = Color(red = 1, green = 46, blue = 81)
    ) {
        Column {
            TransactionForm(onTransactionAdded)
            TransactionList(title = "Income", userTransactions = income)
            TransactionList(title = "Expense", userTransactions = expense)
            //VideoPlayer(url = "https://www.youtube.com/watch?v=DljzHxC_9i4")
        }
    }
}

//@Composable
//fun VideoPlayer(
//    url: String = "https://www.youtube.com/watch?v=DljzHxC_9i4",
//) {
//    val context = LocalContext.current
//
//    val exoPlayer = remember {
//        ExoPlayer.Builder(context).build().apply {
//            val mediaItem = androidx.media3.common.MediaItem.fromUri("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
//            setMediaItem(mediaItem)
//            prepare()
//            playWhenReady = true
//            volume
//        }
//    }
//
//    DisposableEffect(
//        AndroidView(factory = {
//            PlayerView(context).apply {
//                player = exoPlayer
//            }
//        })
//    ) {
//       onDispose {
//           exoPlayer.release()
//       }
//    }
//}

@Composable
@Preview
fun PreviewHome() {
    BudgetProTheme {
        Home(
            income = listOf(
                UserTransaction(2.00f, "Food", "income"),
                UserTransaction(2.00f, "Food", "income"),
                UserTransaction(2.00f, "Food", "income"),
                UserTransaction(2.00f, "Food", "income"),
            ),
            expense = listOf(
                UserTransaction(2.00f, "Food", "income"),
                UserTransaction(2.00f, "Food", "income"),
                UserTransaction(2.00f, "Food", "income"),
                UserTransaction(2.00f, "Food", "income"),
            )
        ) {}
    }
}