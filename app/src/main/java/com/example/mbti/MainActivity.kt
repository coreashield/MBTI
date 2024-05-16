package com.example.mbti

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbti.ui.theme.MBTITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MBTITheme {
                val scrollState = rememberScrollState()
                Column(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(20.dp)
                         .verticalScroll(scrollState),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    MainScreen()

                    Button(
                        onClick = {
                            finish()
                        },
                        modifier = Modifier
                            .size(300.dp, 50.dp)
                            .padding(top = 10.dp),
                        shape = RoundedCornerShape(10.dp)
                    )
                    {
                        Text(text = "앱 종료", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    MainScreen()
}

@Composable
fun MainScreen() {
    val context = LocalContext.current

    TopTextView("16가지 다양한 MBTI들")

    val mbtiTypes = listOf(
        "ISTJ", "ISFJ", "INFJ", "INTJ",
        "ISTP", "ISFP", "INFP", "INTP",
        "ESTP", "ESFP", "ENFP", "ENTP",
        "ESTJ", "ESFJ", "ENFJ", "ENTJ"
    )
    for (mbtiType in mbtiTypes) {
        MbtiButton(javaclass = MbtiActivity::class.java, mbtiType)
    }
}

@Composable
fun TopTextView(s: String) {
    Text(text = s, fontSize = 20.sp)
}

@Composable
fun MbtiButton(javaclass: Class<*>, str: String) {
    val context = LocalContext.current as? Activity
    Button(
        onClick = {
            val intent = Intent(context, javaclass)
            intent.putExtra("mbti_data", str)
            context?.startActivity(intent)
        }, modifier = Modifier
            .size(300.dp, 50.dp)
            .padding(top = 10.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(text = str, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}
