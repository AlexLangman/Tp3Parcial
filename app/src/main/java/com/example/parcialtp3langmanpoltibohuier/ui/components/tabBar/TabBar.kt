package com.example.parcialtp3langmanpoltibohuier.ui.components.tabBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.parcialtp3langmanpoltibohuier.ui.navigation.NavItem
import com.example.parcialtp3langmanpoltibohuier.ui.theme.Green800
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun tabBar(
    navController: NavHostController,
    currentRoute: String,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope,
) {
    val items =
        listOf(
            NavItem.Home,
            NavItem.MyAccount,
            NavItem.MyCard,
            NavItem.ServicePayment,
            NavItem.MyProfile,
        )

    Row(
        modifier =
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        items.forEach { item ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(2.dp))


                val isSelected =
                    if (drawerState.isOpen) {
                        item.route == NavItem.MyProfile.route
                    } else {
                        currentRoute == item.route
                    }
                Box(
                    modifier =
                    Modifier
                        .width(60.dp)
                        .height(4.dp)
                        .background(if (isSelected) Green800 else Color.Transparent),
                )

                Spacer(modifier = Modifier.height(10.dp))

                iconTabBar(
                    icon = item.icon,
                    iconSelected = item.iconSelected,
                    label = item.label,
                    isSelected = if (drawerState.isOpen) item.route == NavItem.MyProfile.route else currentRoute == item.route,
                    onClick = {
                        if (item.route == NavItem.MyProfile.route) {
                            coroutineScope.launch {
                                if (drawerState.isClosed) {
                                    drawerState.open()
                                } else {
                                    drawerState.close()
                                }
                            }
                        } else {
                            coroutineScope.launch {
                                if (drawerState.isOpen) {
                                    drawerState.close()
                                }
                                navController.navigate(item.route)
                            }
                        }
                    },
                )
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun tabBarPreview() {
    val navControlle = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    tabBar(navControlle, "", DrawerState(DrawerValue.Closed), coroutineScope)
}
