package com.devopstools.app

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object ScreenAo : NavigationItem("a", R.drawable.ic_ci_cd, "Pipeline\nCI/CD")
    object ScreenBo : NavigationItem("b", R.drawable.ic_infraestructura, "Infraestructura y Automatización")
    object ScreenCo : NavigationItem("c", R.drawable.ic_monitoreo, "Monitoreo y Seguridad")
}