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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbti.ui.theme.MBTITheme

class MbtiActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MBTITheme {
                val mbtiData = intent.getStringExtra("mbti_data") ?: ""
                MainScreen(mbtiData)
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun MainScreen(mbtiData : String) {
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
                text = mbtiData,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold
            )
        }

        when(mbtiData){
            "INFP" -> Column{
                Painting(paintId = R.drawable.infp1)
                Painting(paintId = R.drawable.infp2)
            }
            "ISFJ" -> Column{
                Painting(paintId = R.drawable.isfj1)
                Painting(paintId = R.drawable.isfj2)
            }
        }

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
fun Painting(paintId: Int) {
    Image(
        painter = painterResource(id = paintId),
        contentDescription = "",
        modifier = Modifier
            .fillMaxWidth()
            .size(width = 10.dp, height = 300.dp)
            .padding(top = 1.dp, bottom = 10.dp)
    )
}