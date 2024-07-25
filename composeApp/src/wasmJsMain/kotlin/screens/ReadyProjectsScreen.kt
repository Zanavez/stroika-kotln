package screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import kotlinproject.composeapp.generated.resources.*
import kotlinproject.composeapp.generated.resources.CallTouch
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.pr1
import kotlinproject.composeapp.generated.resources.pr2
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ReadyProjectsScreen(
    modifier: Modifier = Modifier
) {
    var isFirstLineVisible by remember { mutableStateOf(false) }
    var isSecondLineVisible by remember { mutableStateOf(false) }
    var isThirdLineVisible by remember { mutableStateOf(false) }
    var isCardsVisible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        delay(300)
        isFirstLineVisible = true
        delay(300)
        isSecondLineVisible = true
        delay(300)
        isThirdLineVisible = true
        delay(300)
        isCardsVisible = true
    }
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color(0xFF0060FE)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            AnimatedVisibility(
                isFirstLineVisible,
                enter = slideIn(animationSpec = tween(100), initialOffset = { offset ->
                    IntOffset(offset.width, offset.height)
                })
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(55.dp)
                ) {
                    Text(
                        "Готовые",
                        fontSize = 120.sp
                    )
                    Text("проекты", fontSize = 120.sp)
                }
            }
            AnimatedVisibility(
                isSecondLineVisible,
                enter = slideIn(animationSpec = tween(100), initialOffset = { offset ->
                    IntOffset(offset.width, offset.height)
                })
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(51.dp)
                ) {
                    Text(
                        "Гот",
                        fontSize = 120.sp,
                        color = Color.Transparent
                    )
                    Text("зданий", fontSize = 120.sp, color = Color(0xFF71A7FE))
                    Text(buildAnnotatedString {
                        append("для ")
                        withStyle(SpanStyle(color = Color(0xFF71A7FE))) {
                            append("вашего")
                        }
                    }, fontSize = 120.sp)
                }
            }

            AnimatedVisibility(
                isThirdLineVisible,
                enter = slideIn(animationSpec = tween(100), initialOffset = { offset ->
                    IntOffset(offset.width, offset.height)
                })
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(51.dp)
                ) {
                    Text(
                        "Гот",
                        fontSize = 120.sp,
                        color = Color.Transparent
                    )
                    Text("зданий", fontSize = 120.sp, color = Color.Transparent)
                    Text(buildAnnotatedString {
                        withStyle(SpanStyle(color = Color.Transparent)) {
                            append("для ")
                            append("ва")
                        }
                    }, fontSize = 120.sp)
                    Text(
                        "бизнеса",
                        fontSize = 120.sp
                    )
                }
            }
            AnimatedVisibility(isCardsVisible, enter = slideInHorizontally()) {
                Box {
                    Row(
                        modifier = Modifier.fillMaxWidth().zIndex(1f).align(Alignment.BottomStart),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.spacedBy(32.dp)
                    ) {
                        ProjectCard(Res.drawable.pr1, "Проекты  для сельского хозяйства")
                        ProjectCard(Res.drawable.pr2, "Проекты для торговли и хранения")
                        ProjectCard(Res.drawable.pr3, "Проекты гаражей, мастерских и СТО ")
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth().align(Alignment.BottomEnd).offset(y = (-64).dp).sizeIn(maxWidth = 250.dp),
                        verticalArrangement = Arrangement.spacedBy(32.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            "Готовые проекты\n" +
                                    "для бизнеса,\n" +
                                    "проверенные реальным\nбизнесом",
                            textAlign = TextAlign.End,
                            fontSize = 18.sp
                        )
                        Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color(0xFF0060FE))) {
                            Text("ВЫБРАТЬ ПРОЕКТ", fontSize = 14.sp)
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth().align(Alignment.TopEnd),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Image(painter = painterResource(Res.drawable.CallTouch), contentDescription = null)
                    }
                    Image(
                        painter = painterResource(Res.drawable.cow),
                        contentDescription = null,
                        modifier = Modifier.zIndex(-1f).align(Alignment.TopStart)
                    )
                }
            }
        }
    }
}

@Composable
fun ProjectCard(drawableResource: DrawableResource, text: String) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.sizeIn(maxWidth = 300.dp)
    ) {
        Image(painter = painterResource(drawableResource), contentDescription = null, modifier = Modifier.size(300.dp, 200.dp).clip(
            RoundedCornerShape(24.dp)
        ))
        Text(text = text, fontSize = 18.sp, fontWeight = FontWeight.Medium)
    }
}