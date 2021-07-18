package com.rajshekhar.instagramcloneui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {

        TopBar(name = "Rajshekhar", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
    }
}

@Composable
fun TopBar(name: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(text = name, overflow = TextOverflow.Ellipsis, fontSize = 26.sp)

        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Notification",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Menu",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
    }

}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.raj), modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatsSection(modifier = Modifier.weight(7f))

        }

        ProfileDescription(
            displayName = "Rajshekhar",
            description = "Bla bla bla ..5 Years of coding experience \n want to create any app email me at @yrajshekhar231@gmail.com",
            url = "https://youtube.com",
            followedBy = listOf("Abhishek", "Punt", "XYZ", "UVW"), otherCount = 16

        )

    }


}

@Composable
fun RoundImage(image: Painter, modifier: Modifier) {

    Image(
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(width = 1.dp, shape = CircleShape, color = Color.LightGray)
            .padding(3.dp)
            .clip(
                CircleShape
            ), contentDescription = null, painter = image
    )

}

@Composable
fun StatsSection(modifier: Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        ProfileStats("60", title = "Posts")
        ProfileStats("100", title = "Followers")
        ProfileStats("60", title = "Following")
    }

}

@Composable
fun ProfileStats(number: String, title: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        Text(text = number, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(6.dp))
        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)

    }

}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing,
        )
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing,
        )
        Text(
            text = description,
            fontWeight = FontWeight.Normal,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing,
        )
        Text(
            text = url,
            color = Color.Blue,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing,
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)
                    append("Followed By ")
                    pushStyle(boldStyle)
                    followedBy.forEachIndexed { index, name ->

                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }

                    }
                    if (otherCount > 2) {
                        pop()

                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight


            )
        }

    }
}


