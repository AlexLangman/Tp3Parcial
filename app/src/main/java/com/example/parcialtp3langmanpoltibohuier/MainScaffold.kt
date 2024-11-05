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
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.parcialtp3langmanpoltibohuier.Navigation
import com.example.parcialtp3langmanpoltibohuier.ui.components.tabBar.tabBar
import com.example.parcialtp3langmanpoltibohuier.ui.components.topBar.topBarCustom
import com.example.parcialtp3langmanpoltibohuier.ui.navigation.AppRoutes
import com.example.parcialtp3langmanpoltibohuier.ui.screens.myProfile.MyProfileRoutes


@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScaffold(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: AppRoutes.HOME

    Scaffold(
        topBar = {
            if (currentRoute != AppRoutes.SPLASH && currentRoute != AppRoutes.LOG_IN && currentRoute != AppRoutes.HOME) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                ) {
                    topBarCustom(currentRoute)
                }
            }
        },
        bottomBar = {
            if (currentRoute != AppRoutes.SPLASH && currentRoute != AppRoutes.LOG_IN) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                ){
                    tabBar(navController = navController, currentRoute = currentRoute, drawerState = drawerState, coroutineScope = coroutineScope)
                }
            }
        },
        modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars)
    ) { innerPadding ->
        ModalNavigationDrawer (
            drawerState = drawerState,
            gesturesEnabled = drawerState.isOpen,
            drawerContent = {
                Box(
                    modifier = Modifier
                        .padding(innerPadding)
                        .background(MaterialTheme.colorScheme.primary)

                ) {
                    MyProfileRoutes(navController = navController)
                }
            },

        ) {
            Navigation(navController = navController, Modifier.padding(innerPadding))
        }
    }
}
