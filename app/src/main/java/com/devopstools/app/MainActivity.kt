package com.devopstools.app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.devopstools.app.ui.theme.ScreenA
import com.devopstools.app.ui.theme.ScreenB
import com.devopstools.app.ui.theme.ScreenC
import com.devopstools.app.ui.theme.DevOpsToolsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_DevOpsTools)
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
    @Composable
    fun MainScreen() {
        val navController = rememberNavController()
        Scaffold(
            topBar = {  },
            bottomBar = { BottomNavigationBar(navController) },
            content = { padding ->
                Box(modifier = Modifier.padding(padding)) {
                    Navigation(navController = navController)
                }
            },
            backgroundColor = colorResource(R.color.colorFondoVista) // Set background color to avoid the white flashing when you switch between screens
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreenPreview() {
        MainScreen()
    }

    @Composable
    fun Navigation(navController: NavHostController) {
        NavHost(
            navController,
            startDestination = NavigationItem.ScreenAo.route
        ) {
            composable(NavigationItem.ScreenAo.route) {
                ScreenA()
            }
            composable(NavigationItem.ScreenBo.route) {
                ScreenB()
            }
            composable(NavigationItem.ScreenCo.route) {
                ScreenC()
            }
        }
    }

    @Composable
    fun TopBar() {
        TopAppBar(
            title = { Text (text = stringResource(R.string.app_name), fontSize = 18.sp) },
            backgroundColor = colorResource(id = R.color.colorPrimary),
            contentColor = colorResource(id = R.color.colorIconoSelect)
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun TopBarPreview() {
        TopBar()
    }

    @Composable
    fun BottomNavigationBar(navController: NavController) {
        val items = listOf(
            NavigationItem.ScreenAo,
            NavigationItem.ScreenBo,
            NavigationItem.ScreenCo,
        )
        BottomNavigation(
            backgroundColor = colorResource(id = R.color.colorFondoMenu),
            contentColor = colorResource(id = R.color.colorIconoSelect)
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                    label = { Text(text = item.title) },
                    selectedContentColor = colorResource(id = R.color.colorIconoSelect),
                    unselectedContentColor = colorResource(id = R.color.colorIconoUnselect),
                    alwaysShowLabel = true,
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BottomNavigationBarPreview() {
        //BottomNavigationBar()
    }
    fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    fun openLinkedInRoman(view: View?) {
        openUrl("https://www.linkedin.com/in/jeremyroman99/")
    }

    fun openLinkedInCosme(view: View?) {
        openUrl("https://www.linkedin.com/in/carloscosme99/")
    }

    fun openyoutubeRoman(view: View?) {
        openUrl("https://www.youtube.com/@JEREMYJORDANROMANQUISPE")
    }

    fun openyoutubeCosme(view: View?) {
        openUrl("https://www.youtube.com/@CARLOSDANIELCOSMEHERNANDEZ")
    }

    fun openinstagramRoman(view: View?) {
        openUrl("https://www.instagram.com/jeremy.roman99/")
    }

    fun openinstagramCosme(view: View?) {
        openUrl("https://www.instagram.com/carlosc.0199/")
    }
    fun openAws(view: View?) {
        openUrl("https://aws.amazon.com/es/")
    }

    fun openGcp(view: View?) {
        openUrl("https://cloud.google.com/?hl=es")
    }

    fun openAzure(view: View?) {
        openUrl("https://azure.microsoft.com/es-es/")
    }

    fun openGithub(view: View?) {
        openUrl("https://github.com/")
    }

    fun openBitbucket(view: View?) {
        openUrl("https://bitbucket.org/product/enterprise")
    }

    fun openGitlab(view: View?) {
        openUrl("https://about.gitlab.com/")
    }

    fun openJenkins(view: View?) {
        openUrl("https://www.jenkins.io/")
    }

    fun openGithubActions(view: View?) {
        openUrl("https://github.com/features/actions")
    }

    fun openCodePipeline(view: View?) {
        openUrl("https://aws.amazon.com/es/codepipeline/")
    }

    fun openDocker(view: View?) {
        openUrl("https://www.docker.com/")
    }

    fun openKubernetes(view: View?) {
        openUrl("https://kubernetes.io/es/")
    }

    fun openSonarqube(view: View?) {
        openUrl("https://www.sonarsource.com/products/sonarqube/")
    }

    fun openSonarCloud(view: View?) {
        openUrl("https://www.sonarsource.com/products/sonarcloud/")
    }

    fun openGrafana(view: View?) {
        openUrl("https://grafana.com/")
    }

    fun openNewRelic(view: View?) {
        openUrl("https://newrelic.com/welcome-back")
    }
}
