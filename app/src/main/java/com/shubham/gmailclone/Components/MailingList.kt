package com.shubham.gmailclone.Components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubham.gmailclone.Models.MailItemModel
import com.shubham.gmailclone.Models.mailList
import kotlin.random.Random

@Composable
fun MailingList(paddingValues: PaddingValues, drawerSelectedItem: String, lazyListState: LazyListState) {
    Box(modifier = Modifier.padding(paddingValues).fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp),
            state = lazyListState) {
            items(mailList) { item ->
                MailItem(item, drawerSelectedItem)
            }
        }
    }
}

@Composable
fun MailItem(mailItemModel: MailItemModel, drawerSelectedItem: String) {
    Row(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
        when {
            mailItemModel.isHeader -> {
                Text(drawerSelectedItem, fontSize = 12.sp, modifier = Modifier.padding(bottom = 16.dp))
            }
            else -> {
                // Generating Random Color
                val color = Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 0.8f)

                Card(modifier = Modifier.size(40.dp).clip(CircleShape),
                    colors = CardDefaults.cardColors(color)) {
                    Text(mailItemModel.userName!![0].toString(),
                        fontSize = 20.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(8.dp).fillMaxSize())
                }
                Column(modifier = Modifier.padding(start = 16.dp).weight(2.0f)) {
                    Text(mailItemModel.userName!!, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(mailItemModel.subject!!, fontSize = 15.sp, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    Text(mailItemModel.body!!, fontSize = 14.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
                Column(modifier = Modifier.padding(start = 8.dp)) {
                    Text(mailItemModel.timeStamp!!, fontSize = 12.sp, modifier = Modifier.padding(bottom = 8.dp))
                    IconButton(onClick = {
                        // TODO
                    }, modifier = Modifier.size(22.dp).align(Alignment.End)) {
                        Icon(Icons.Outlined.StarOutline, "")
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MailItemPreview() {
    val mailItemModel = MailItemModel(
        mailId = 1,
        userName = "Christy",
        subject = "Weekly Android News",
        body = "Hello Christy we have got exciting addition  to the android api",
        timeStamp = "20:10"
    )

    MailItem(mailItemModel, "Primary")
}