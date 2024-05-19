package com.devopstools.app

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object ScreenAo : NavigationItem("a", R.drawable.ic_home, "Inicio")
    object ScreenBo : NavigationItem("b", R.drawable.ic_resource, "Recursos")
    object ScreenCo : NavigationItem("c", R.drawable.ic_collaborator, "Colaboradores")
}