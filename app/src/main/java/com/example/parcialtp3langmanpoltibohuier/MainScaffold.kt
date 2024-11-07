import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.parcialtp3langmanpoltibohuier.MainViewModel
import com.example.parcialtp3langmanpoltibohuier.Navigation
import com.example.parcialtp3langmanpoltibohuier.ui.components.drawer.CustomDrawerRightToLeft
import com.example.parcialtp3langmanpoltibohuier.ui.components.tabBar.tabBar
import com.example.parcialtp3langmanpoltibohuier.ui.components.topBar.topBarCustom
import com.example.parcialtp3langmanpoltibohuier.ui.navigation.AppRoutes
import com.example.parcialtp3langmanpoltibohuier.ui.screens.myProfile.MyProfileRoutes
import kotlinx.coroutines.CoroutineScope

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScaffold(
    navController: NavHostController,
    mainViewModel: MainViewModel,
    currentRoute: String,
    coroutineScope: CoroutineScope,
) {
    Scaffold(
        topBar = {
            if (mainViewModel.drawerState.isClosed &&
                currentRoute != AppRoutes.SPLASH &&
                currentRoute != AppRoutes.LOG_IN &&
                currentRoute != AppRoutes.HOME
            ) {
                Box(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primary),
                ) {
                    topBarCustom(currentRoute)
                }
            }
        },
        bottomBar = {
            if (currentRoute != AppRoutes.SPLASH && currentRoute != AppRoutes.LOG_IN) {
                Box(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primary),
                ) {
                    tabBar(
                        navController = navController,
                        currentRoute = currentRoute,
                        drawerState = mainViewModel.drawerState,
                        coroutineScope = coroutineScope,
                    )
                }
            }
        },
        modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars),
    ) { innerPadding ->
        CustomDrawerRightToLeft(
            drawerState = mainViewModel.drawerState,
            drawerContent = {
                Box(
                    modifier =
                        Modifier
                            .padding(innerPadding)
                            .background(MaterialTheme.colorScheme.background),
                ) {
                    MyProfileRoutes(
                        navController = navController,
                        mainViewModel = mainViewModel,
                        coroutineScope = coroutineScope,
                    )
                }
            },
        ) {
            Box(Modifier.padding(innerPadding)) {
                Navigation(navController = navController, mainViewModel = mainViewModel, coroutineScope = coroutineScope)
            }
        }
    }
}
