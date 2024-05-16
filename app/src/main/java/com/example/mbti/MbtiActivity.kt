package com.example.mbti

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun MainScreen(mbtiData: String) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 8.dp, end = 8.dp)

            .background(color = Color.White), horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box {
            Text(
                modifier = Modifier.align(Alignment.TopCenter),
                text = mbtiData,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold
            )
        }

        when (mbtiData) {
            "INFP" -> Column { Painting(paintId = R.drawable.infp) }
            "INTJ" -> Column { Painting(paintId = R.drawable.intj) }
            "INFJ" -> Column { Painting(paintId = R.drawable.infj) }
            "INTP" -> Column { Painting(paintId = R.drawable.intp) }

            "ISFJ" -> Column { Painting(paintId = R.drawable.isfj) }
            "ISFP" -> Column { Painting(paintId = R.drawable.isfp) }
            "ISTJ" -> Column { Painting(paintId = R.drawable.istj) }
            "ISTP" -> Column { Painting(paintId = R.drawable.istp) }

            "ESFJ" -> Column { Painting(paintId = R.drawable.esfj) }
            "ESFP" -> Column { Painting(paintId = R.drawable.esfj) }
            "ESTJ" -> Column { Painting(paintId = R.drawable.estj) }
            "ESTP" -> Column { Painting(paintId = R.drawable.estp) }

            "ENTP" -> Column { Painting(paintId = R.drawable.entp) }
            "ENTJ" -> Column { Painting(paintId = R.drawable.entj) }
            "ENFJ" -> Column { Painting(paintId = R.drawable.enfj) }
            "ENFP" -> Column { Painting(paintId = R.drawable.enfp) }

        }

        Row {
            val context = LocalContext.current as? Activity
            Button(
                onClick = { context?.finish() },
                modifier = Modifier
                    .width(184.dp)
                    .height(105.dp)
                    .padding(top = 40.dp)
            ) {
                Text(text = "이전 화면으로", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.width(5.dp))
            MyButton(mbtiData)
        }
    }
}


@Composable
fun Painting(paintId: Int) {
    Image(
        painter = painterResource(id = paintId),
        contentDescription = "",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
//            .fillMaxWidth()
            .height(560.dp)
            .padding(top = 20.dp)
    )
}

@Composable
fun MyButton(mbtitext: String) {
    val context = LocalContext.current
    val intent = remember {
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.16personalities.com/ko/%EC%84%B1%EA%B2%A9%EC%9C%A0%ED%98%95-$mbtitext")
        )
    }

    Button(
        onClick = { context.startActivity(intent) },
        modifier = Modifier
            .width(184.dp)
            .height(105.dp)
            .padding(top = 40.dp)
    ) {
        Text(text = "${mbtitext} 추가 정보", fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}
