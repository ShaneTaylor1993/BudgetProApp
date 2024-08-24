package components.scaffold

import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun AppScaffold() {
    Scaffold(
        topBar = {
            BudgetTopAppBar()
        }
    ) { paddingValues ->
        paddingValues
    }
}