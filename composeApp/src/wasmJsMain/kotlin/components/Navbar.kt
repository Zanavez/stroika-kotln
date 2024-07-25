package components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinproject.composeapp.generated.resources.*
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.logo
import kotlinproject.composeapp.generated.resources.person
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Navbar(
    modifier: Modifier = Modifier,
    isScrolled: Boolean
) {
    var navbarVisible by remember { mutableStateOf(false) }
    val logo = painterResource(Res.drawable.logo)
    val person = painterResource(Res.drawable.person)
    val stack = painterResource(Res.drawable.stack)

    val alpha by animateFloatAsState(if (isScrolled) 1f else 0.2f)
    val contentColor by animateColorAsState(if (isScrolled) Color(0xFF0060FE) else Color.White)

    LaunchedEffect(Unit) {
        delay(500)
        navbarVisible = true
    }
    CompositionLocalProvider(
        LocalContentColor provides contentColor
    ) {
        AnimatedVisibility(navbarVisible) {
            Surface(
                modifier = modifier.padding(horizontal = 32.dp).padding(top = 32.dp).fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)),
                color = Color.White.copy(alpha = alpha),
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 32.dp, vertical = 18.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    Image(painter = logo, contentDescription = null)
                    Spacer(Modifier.weight(1f))
                    Text("+7 (912) 999-99-99")
                    Image(painter = person, contentDescription = null)
                    Image(painter = stack, contentDescription = null)
                }
            }
        }
    }
}