package com.example.parcialtp3langmanpoltibohuier.ui.navigation

object TopBarTitles {
    private val titles = mapOf(
        AppRoutes.HOME to "Inicio",
        AppRoutes.MY_ACCOUNT to "Mi Cuenta",
        AppRoutes.MY_CARD to "Mi Tarjeta",
        AppRoutes.SERVICE_PAYMENT to "Pago de Servicios",
        AppRoutes.MY_PROFILE to "Mi Perfil"
    )

    fun getTitle(route: String): String {
        return titles[route] ?: ""
    }
}