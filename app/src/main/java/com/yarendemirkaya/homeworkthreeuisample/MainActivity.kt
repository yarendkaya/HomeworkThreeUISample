package com.yarendemirkaya.homeworkthreeuisample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yarendemirkaya.homeworkthreeuisample.ui.theme.Black
import com.yarendemirkaya.homeworkthreeuisample.ui.theme.HomeworkThreeUISampleTheme
import com.yarendemirkaya.homeworkthreeuisample.ui.theme.MainColumnDark
import com.yarendemirkaya.homeworkthreeuisample.ui.theme.TextColorBlack
import com.yarendemirkaya.homeworkthreeuisample.ui.theme.White
import com.yarendemirkaya.homeworkthreeuisample.ui.theme.btnColor
import com.yarendemirkaya.homeworkthreeuisample.ui.theme.darkWeeksRecipe
import com.yarendemirkaya.homeworkthreeuisample.ui.theme.lora
import com.yarendemirkaya.homeworkthreeuisample.ui.theme.weeksRecipe

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeworkThreeUISampleTheme {
                HomeScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(darkTheme: Boolean = isSystemInDarkTheme()) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.app_name),
                    fontFamily = lora,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = if (darkTheme) Black else Color.White,
                titleContentColor = if (darkTheme) White else Color.Black
            )
        )
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(if (darkTheme) MainColumnDark else Color(0xFFF6EFBA))
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = stringResource(R.string.categories),
                color = if (darkTheme) Color.White else Color.Black,
                fontWeight = FontWeight.Normal,
                fontFamily = lora,
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            val categories = listOf(R.string.breakfast, R.string.lunch, R.string.dinner, R.string.dessert)

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(11.dp),
                contentPadding = PaddingValues(horizontal = 14.dp)
            ) {
                items(categories) { category ->
                    CategoryButton(stringResource(id = category))
                }
            }




            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(R.string.populer_recipes),
                color = if (darkTheme) Color.White else Color.Black,
                fontWeight = FontWeight.Normal,
                fontFamily = lora,
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(25.dp))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(
                    1
                ) {
                    RecipeCard(stringResource(R.string.vegetable), R.drawable.vegetablstirfry,darkTheme)
                    Spacer(modifier = Modifier.width(16.dp))
                    RecipeCard(stringResource(R.string.caprise), R.drawable.caprese_salad,darkTheme)
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(R.string.recipes_week),
                color = if (darkTheme) Color.White else Color.Black,
                fontFamily = lora,
                fontWeight = FontWeight.Normal,
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(
                    1
                )
                {
                    WeeksRecipe(stringResource(R.string.seafood), R.drawable.seafood,darkTheme)
                    Spacer(modifier = Modifier.height(16.dp))
                    WeeksRecipe(stringResource(R.string.grilled_salmon), R.drawable.grilled_salmon, darkTheme)
                }
            }
        }
    }
}

@Composable
fun RecipeCard(recipeName: String, imageRes: Int,darkTheme: Boolean) {
    Column(
        modifier = Modifier
            .width(160.dp)
            .background(if(darkTheme) darkWeeksRecipe else weeksRecipe, RoundedCornerShape(16.dp))
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = recipeName,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clip(RoundedCornerShape(12.dp))
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = recipeName,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = lora,
            ),
            maxLines = 1,
            textAlign = TextAlign.Center,
            color = TextColorBlack
        )
    }
}

@Composable
fun WeeksRecipe(recipeName: String, imageRes: Int, darkTheme: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(if(darkTheme) darkWeeksRecipe else weeksRecipe, RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(if(darkTheme) darkWeeksRecipe else weeksRecipe, RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = recipeName,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(8.dp))
            )
        }


        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = recipeName,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                ),
                color = TextColorBlack,

                )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(R.string.explanation),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 14.sp,
                    fontFamily = lora,
                ),
                color = TextColorBlack,
            )
        }

        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_book_24),
                contentDescription = "Bookmark",
                tint = Color(0xFFFF9800)
            )
        }
    }
}

@Composable
fun CategoryButton(category: String, darkTheme: Boolean = isSystemInDarkTheme()) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (darkTheme) btnColor else Color(0xFFE1A44B),
            contentColor = White
        )
    ) {
        Text(text = category, fontSize = 15.sp)
    }
}


@Preview(showBackground = true, locale = "tr")
@Composable
fun GreetingPreview() {
    HomeworkThreeUISampleTheme {

    }
}
