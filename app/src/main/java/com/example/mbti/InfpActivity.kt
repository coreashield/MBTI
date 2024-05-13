package com.example.mbti

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbti.ui.theme.MBTITheme

class InfpAtivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MBTITheme {
                InfpMainScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfpMainScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 8.dp, end = 8.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Text(
                modifier = Modifier
                    .align(Alignment.TopCenter),
                text = "INFP (열정적인 중재자)",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Infp_mainIMG()
        Infp_desIMG()

        Row {
            val context = LocalContext.current as? Activity
            Button(
                onClick = { context?.finish() },
                modifier = Modifier
                    .width(205.dp)
                    .height(105.dp)
                    .padding(top = 40.dp, bottom = 10.dp)
            ) {
                Text(text = "이전 화면으로", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun Infp_mainIMG() {
    Image(
        painter = painterResource(id = R.drawable.infp_character),
        contentDescription = "infp",
        modifier = Modifier
            .fillMaxWidth()
            .size(width = 10.dp, height = 300.dp)
            .padding(top = 10.dp)
    )
}

@Composable
fun Infp_desIMG() {
    Image(
        painter = painterResource(id = R.drawable.des_infp),
        contentDescription = "descript_infp",
        modifier = Modifier
            .fillMaxWidth()
            .size(width = 10.dp, height = 300.dp)
            .padding(top = 1.dp, bottom = 10.dp)
    )
}
