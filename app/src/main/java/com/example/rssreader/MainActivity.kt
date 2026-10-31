package com.example.rssreader

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rssreader.ui.theme.RSSReaderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val people = listOf(
            Person("DJ", "Malone", 25),
            Person("Wyatt", "Ledford", 28),
            Person("Emily", "Erickson", 29)
        )

        val agefilter = people.filter { it.age > 26 }

        setContent {
            RSSReaderTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    LazyColumn {
                        items(agefilter) {
                            CardView(it)
                        }                        }
                    }
                }
            }
        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RSSReaderTheme {
        Greeting("Android")
    }
}


@Composable
fun CardView(person: Person) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(12.dp)
    ) {
        Row {
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.baseline_person_24),
                contentDescription = "Profile Image",
                modifier = Modifier.width(100.dp)
                    .height(100.dp)
            )
            Column() {
                Text(
                    text = person.firstName,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = person.lastName,
                    modifier = Modifier.padding(0.dp)
                )
                Text(
                    text = person.age.toString(),
                    modifier = Modifier.padding(0.dp)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CardReviiew() {
    RSSReaderTheme {
            val wyatt = Person("Wyatt", "Ledford", 28)
            CardView(wyatt)
        }
    }
