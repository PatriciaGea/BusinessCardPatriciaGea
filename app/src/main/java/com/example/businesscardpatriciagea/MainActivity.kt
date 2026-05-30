package com.example.businesscardpatriciagea

import android.content.Intent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.businesscardpatriciagea.ui.theme.BusinessCardPatriciaGeaTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.core.net.toUri


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BusinessCardPatriciaGeaTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background
                ) { innerPadding ->
                    BusinessCardScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            "Patricia Gea",
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            "Mobile / Frontend Developer",
            style = MaterialTheme.typography.bodyMedium
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.map_pin),
                contentDescription = "Location",
                tint = Color.Black
            )

            Text(
            "Stockholm, Sweden",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black
        )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(R.drawable.rostoweb),
            contentDescription = "Minha foto",
            modifier = Modifier
                .size(260.dp)
                .background(Color.White, CircleShape)
                .clip(CircleShape)
                .border(1.dp, Color.Black, CircleShape))
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(R.drawable.androidvector),
            contentDescription = "Android",
            contentScale = ContentScale.Fit,
            modifier = Modifier.width(150.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))

            ContactCard()
    }
}

//data class LinkItem(
//    val title: String,
//    val url: String
//)


@Composable
fun ContactCard() {

//    val context = LocalContext.current
//
//    val links = listOf(
//        LinkItem("Email", "mailto:patricia.gea@email.com"),
//        LinkItem("patriciageadev.vercel.app", "https://patriciageadev.vercel.app/"),
//        LinkItem("GitHub", "https://github.com")
//    )

    Card(
        modifier = Modifier
            .padding(16.dp)
            .size(
                width = 260.dp,
                height = 350.dp
            ),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(
            1.dp,
            Color.Black
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { }) {
                Text("Email")
            }

            Spacer(modifier = Modifier.width(16.dp)) // 👈 AQUI O ESPAÇO

            Button(onClick = { }) {
                Text("Call")
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {

//            links.forEach { item ->
//                Text(
//                    text = item.title,
//                    modifier = Modifier.clickable {
//                        val intent = Intent(Intent.ACTION_VIEW, item.url.toUri())
//                        context.startActivity(intent)
//                    },
//                    style = MaterialTheme.typography.bodyLarge
//                )
//            }
        }
    }
}

