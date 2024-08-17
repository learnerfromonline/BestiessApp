package com.example.besties

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.besties.data.People
import com.example.besties.data.peoples
import com.example.besties.ui.theme.BestiesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BestiesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    BestieApp()
                }
            }
        }
    }
}

@Composable
fun BestieApp(){
LazyColumn(modifier = Modifier.padding(top = 44.dp)
) {
    items(peoples){
        BestieItems(pep=it)
    }
}
}
@Composable
fun BestieItems(pep:People){
    var touchs by remember {
        mutableStateOf(false)
    }
    val color by animateColorAsState(targetValue = if (touchs) Color.LightGray else MaterialTheme.colorScheme.inversePrimary)
    Card(modifier = Modifier
        .padding(bottom = 24.dp, start = 12.dp, end = 12.dp)

        .clip(shape = RoundedCornerShape(26.dp)
            ),
        onClick = {touchs=!touchs}) {
        Column(modifier = Modifier.background(color=color)
            .animateContentSize(
animationSpec = spring(
    dampingRatio = Spring.DampingRatioNoBouncy,
    stiffness = Spring.StiffnessVeryLow
)
            )) {
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(11.dp)

                ){
                Column {
                    BestieName(pep.name)
                    BestieDesc(pep.desc)
                }
                Spacer(modifier = Modifier.weight(1f))
                BestieImage(pep.imageResourceId,pep.name)
            }
            if(touchs){
                BestieInfo(pep.info)
            }
        }

    }
}
@Composable
fun BestieName(@StringRes name:Int){
    Text(text = stringResource(id = name),
        fontWeight = FontWeight.Bold,
        fontSize = 33.sp,
        modifier = Modifier.padding(12.dp),
        color = Color.Black)

}
@Composable
fun BestieDesc(@StringRes desc:Int){
    Text(text = stringResource(id = desc),
        modifier = Modifier.padding(12.dp),
        fontSize = 23.sp,
        color = Color.Black)
}
@Composable
fun BestieImage(@DrawableRes img:Int,@StringRes name:Int){
    Image(painter = painterResource(id = img), contentDescription = stringResource(id =name ),
        modifier = Modifier
            .size(134.dp)
            .padding(top = 12.dp, bottom = 12.dp)
            .clip(shape = RoundedCornerShape(94.dp)))
}
@Composable
fun BestieInfo(@StringRes info:Int){
    Text(text = stringResource(id = info),
        lineHeight = 32.sp,
        modifier = Modifier.padding(12.dp),
        color = Color.Black)
}

@Preview
@Composable
fun Prevs(){
    BestiesTheme {
        BestieApp()
    }
}