package com.example.businesscardpatriciagea

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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

        Spacer(modifier = Modifier.height(120.dp))

        Text(
            "Patricia Gea",
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            "Mobile / Frontend Developer",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(R.drawable.rostoweb),
            contentDescription = "Minha foto",
            modifier = Modifier
                .size(260.dp)
                .clip(CircleShape)
                .border(1.dp, Color.Black, CircleShape)
        )

        Spacer(modifier = Modifier.height(30.dp))

        ContactCard()
    }
}

data class LinkItem(
    val title: String,
    val url: String
)


@Composable
fun ContactCard() {

    val context = LocalContext.current

    val links = listOf(
        LinkItem("Email me", "mailto:patricia@email.com"),
        LinkItem("LinkedIn", "https://linkedin.com"),
        LinkItem("GitHub", "https://github.com")
    )

    Card(
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(
            1.dp,
            Color.Black
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            links.forEach { item ->
                Text(
                    text = item.title,
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
                        context.startActivity(intent)
                    },
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

