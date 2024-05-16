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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbti.ui.theme.MBTITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MBTITheme {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(20.dp),
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
                        Text(text = "앱 종료", fontSize = 10.sp)
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

    MbtiButton(javaclass = MbtiActivity::class.java, "INFP")
    MbtiButton(javaclass = MbtiActivity::class.java, "INFJ")
    MbtiButton(javaclass = MbtiActivity::class.java, "ISFJ")
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
        Text(text = str)
    }
}
