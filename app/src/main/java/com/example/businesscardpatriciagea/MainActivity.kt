package com.example.businesscardpatriciagea

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.example.businesscardpatriciagea.ui.theme.BusinessCardPatriciaGeaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BusinessCardPatriciaGeaTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
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
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(50.dp))

        Text("Patricia Gea", style = MaterialTheme.typography.headlineLarge)

        Text("Mobile / Frontend Developer", style = MaterialTheme.typography.bodyMedium)

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(R.drawable.map_pin),
                contentDescription = null,
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
            contentDescription = null,
            modifier = Modifier
                .size(240.dp)
                .background(Color.White, CircleShape)
                .clip(CircleShape)
                .border(1.dp, Color.Black, CircleShape)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Image(
            painter = painterResource(R.drawable.androidvector),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.width(130.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        ContactCard()
    }
}

@Composable
fun ContactCard() {

    Card(
        modifier = Modifier
            .padding(16.dp)
            .size(width = 300.dp, height = 310.dp),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, Color.Black),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(29.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)

        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { }) {
                    Text("Email")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(onClick = { }) {
                    Text(" Call ")
                }
            }

            ContactItem(
                iconRes = R.drawable.house,
                text = "patriciageadev.vercel.app",
                url = "https://patriciageadev.vercel.app"
            )

            ContactItem(
                iconRes = R.drawable.vectorgit,
                text = "github.com/PatriciaGea",
                url = "https://github.com/PatriciaGea"
            )

            ContactItem(
                iconRes = R.drawable.linkedin,
                text = "linkedin.com/patriciageadev",
                url = "https://linkedin.com/in/patriciageadev"
            )
        }
    }
}

@Composable
fun ContactItem(
    iconRes: Int,
    text: String,
    url: String
) {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .clickable {
                context.startActivity(
                    Intent(Intent.ACTION_VIEW, url.toUri())
                )
            }
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall
        )
    }
}