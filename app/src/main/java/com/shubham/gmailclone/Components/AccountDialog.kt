package com.shubham.gmailclone.Components


import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.PersonAdd
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.shubham.gmailclone.Models.AccountItemModel
import com.shubham.gmailclone.Models.accountList
import com.shubham.gmailclone.R
import kotlin.random.Random

@Composable
fun AccountDialog(openAccountDialog: MutableState<Boolean>) {
    Dialog(
        onDismissRequest = {
            openAccountDialog.value = false
        },
        properties = DialogProperties(usePlatformDefaultWidth = false
            /*, dismissOnClickOutside = false*/)
    ) {
        AccountDialogUI(openAccountDialog)
    }
}

@Composable
fun AccountDialogUI(openAccountDialog: MutableState<Boolean>) {
    Card(elevation = CardDefaults.cardElevation(10.dp),
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(4.dp)) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.align(Alignment.CenterStart),
                    verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = {
                        openAccountDialog.value = false
                    }) {
                        Icon(imageVector = Icons.Default.Close, "Close")
                    }
                }
                Image(painter = painterResource(R.drawable.google), "",
                    modifier = Modifier.align(Alignment.Center).width(70.dp))
            }
            Card(modifier = Modifier.wrapContentSize().padding(8.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                AccountItem(accountList[0])
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center) {
                    Card(modifier = Modifier.wrapContentSize(),
                        shape = RoundedCornerShape(5.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        border = BorderStroke(1.dp, color = Color.Gray)

                    ) {
                        Text("Manage your Google Account",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp))
                    }
                }

                HorizontalDivider(modifier = Modifier.padding(top = 20.dp))

                Row(modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp).fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(R.drawable.cloud), "",
                        modifier = Modifier.size(15.dp))
                    Text("Storage used: 80% of 15 GB", fontSize = 12.sp,
                        modifier = Modifier.padding(start = 24.dp, top = 8.dp, bottom = 8.dp).weight(2f))
                }

                HorizontalDivider()

                AccountItem(accountList[1])
                AccountItem(accountList[2])
                Row(modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp).fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Outlined.PersonAdd, "", modifier = Modifier.size(20.dp))
                    Text("Add another account", fontSize = 14.sp, fontWeight = FontWeight.W500,
                        modifier = Modifier.padding(start = 24.dp, top = 8.dp, bottom = 8.dp).weight(2f))
                }
                Row(modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp).fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Outlined.Settings, "", modifier = Modifier.size(20.dp))
                    Text("Manage accounts on this device", fontSize = 14.sp, fontWeight = FontWeight.W500,
                        modifier = Modifier.padding(start = 24.dp, top = 8.dp, bottom = 8.dp).weight(2f))
                }
            }
            Row(modifier = Modifier.fillMaxWidth().padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Text("Privacy Policy", modifier = Modifier.padding(end = 10.dp), fontSize = 10.sp)
                Icon(imageVector = Icons.Default.Circle, "",
                    modifier = Modifier.size(5.dp))
                Text("Terms of service", modifier = Modifier.padding(start = 10.dp), fontSize = 10.sp)
            }
        }
    }
}

@Composable
fun AccountItem(accountItemModel: AccountItemModel) {
    Row(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
        // Generating Random Color
        val color = Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 0.8f)

        Card(modifier = Modifier.size(40.dp).clip(CircleShape),
            colors = CardDefaults.cardColors(color)) {
            Text(accountItemModel.userName[0].toString(),
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(8.dp).fillMaxSize())
        }
        Column(modifier = Modifier.padding(start = 16.dp).weight(2.0f)) {
            Text(accountItemModel.userName, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(accountItemModel.email, color = Color.Gray, fontSize = 12.sp, modifier = Modifier.weight(2f))
                if(accountItemModel.unreadMail > 99) {
                    Text("99+", fontSize = 12.sp)
                } else {
                    Text("${accountItemModel.unreadMail}", fontSize = 12.sp)
                }

            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun AccountDialogUIPreview() {
    AccountDialogUI(mutableStateOf(false))
}