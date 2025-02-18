package com.example.a2_artspaceapp_457647

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a2_artspaceapp_457647.data.Artwork
import com.example.a2_artspaceapp_457647.data.artworks
import com.example.a2_artspaceapp_457647.ui.theme.A2_ArtSpaceApp_457647Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            A2_ArtSpaceApp_457647Theme {
                Artspace()
            }
        }
    }
}


@Composable
fun Artspace() {
    var index = remember { mutableStateOf(1) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn {
            items(artworks) {
                ArtworkItem(
                    art = it,
                    index.value
                )
            }
        }
        Column(verticalArrangement = Arrangement.Bottom) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                ButtonPrevious(onClick = {
                    if (index.value > 1) {
                        index.value--
                    } else {
                        index.value = 3
                    }
                })
                ButtonNext(onClick = {
                    if (index.value < 3) {
                        index.value++
                    } else {
                        index.value = 1
                    }
                })
            }
        }
    }


}

@Composable
fun ArtworkItem(art: Artwork, index: Int) {
    if (index == art.id) {
        Column() {
            ArtworkImage(art.imageResourceId)
        }
        Column(
            modifier = Modifier
                .padding(15.dp)
                .background(color = Color.LightGray)
        ) {
            ArtworkText(art.title, art.artist, art.year)
        }
    }


}


@Composable
fun ArtworkImage(@DrawableRes img: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(img),
            contentDescription = null,
            modifier = Modifier.size(500.dp)
        )
    }

}

@Composable
fun ArtworkText(title: String, artist: String, year: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Text(text = title, fontSize = 24.sp, fontWeight = FontWeight.Light)
        Row {
            Text(text = artist, fontWeight = FontWeight.Bold)
            Text(text = " (" + year.toString() + ")", fontWeight = FontWeight.Light)
        }
    }


}

@Composable
fun ButtonPrevious(onClick: () -> Unit) {
    Column() {
        Button(
            onClick = onClick,
            modifier = Modifier
                .padding(15.dp)
                .size(120.dp, 45.dp)
        ) { Text(text = "Previous") }
    }
}

@Composable
fun ButtonNext(onClick: () -> Unit) {
    Column() {
        Button(
            onClick = onClick,
            modifier = Modifier
                .padding(15.dp)
                .size(120.dp, 45.dp)
        ) { Text(text = "Next") }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    A2_ArtSpaceApp_457647Theme {
        Artspace()
    }
}