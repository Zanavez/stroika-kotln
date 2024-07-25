import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import components.Navbar
import org.jetbrains.compose.resources.painterResource

import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform
import screens.ReadyProjectsScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun App() {
    MaterialTheme() {
        CompositionLocalProvider(
            LocalContentColor provides Color.White
        ) {
            val listState = rememberLazyListState()
            var scrolled by remember { mutableStateOf(false) }
            LaunchedEffect(listState) {
                scrolled = listState.firstVisibleItemScrollOffset > 0
            }
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFF0060FE)
            ) {
                LazyColumn(Modifier.fillMaxWidth().padding(horizontal = 32.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    stickyHeader {
                        Navbar(modifier = Modifier.zIndex(1f), scrolled)
                    }
                    item {
                        ReadyProjectsScreen(modifier = Modifier.zIndex(0f))
                    }
                }
            }
        }
    }
}