package com.shubham.gmailclone.Models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.AllInbox
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Contacts
import androidx.compose.material.icons.outlined.Discount
import androidx.compose.material.icons.outlined.Drafts
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material.icons.outlined.Inbox
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Label
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Outbox
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ScheduleSend
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.ui.graphics.vector.ImageVector


// sealed class for each item on the menu
sealed class DrawerMenuData(
    val icon: ImageVector? = null, val title: String? = null,
    val isDivider: Boolean = false, val isHeader: Boolean = false
) {

    // create an object for easy access to each of the item
    object AllInboxes : DrawerMenuData(
        icon = Icons.Outlined.AllInbox,
        title = "All inboxes"
    )
    object Primary: DrawerMenuData(
        icon = Icons.Outlined.Inbox,
        title = "Primary"
    )
    object Promotions: DrawerMenuData(
        icon = Icons.Outlined.Discount,
        title = "Promotions"
    )
    object Social: DrawerMenuData(
        icon = Icons.Outlined.Person,
        title = "Social"
    )
    object Updates: DrawerMenuData(
        icon = Icons.Outlined.Info,
        title = "Updates"
    )
    object Starred: DrawerMenuData(
        icon = Icons.Outlined.StarOutline,
        title = "Starred"
    )
    object Snoozed: DrawerMenuData(
        icon = Icons.Outlined.AccessTime,
        title = "Snoozed"
    )
    object Important: DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "Important"
    )
    object Sent: DrawerMenuData(
        icon = Icons.Outlined.Send,
        title = "Sent"
    )
    object Scheduled: DrawerMenuData(
        icon = Icons.Outlined.ScheduleSend,
        title = "Scheduled"
    )
    object Outbox: DrawerMenuData(
        icon = Icons.Outlined.Outbox,
        title = "Outbox"
    )
    object Drafts: DrawerMenuData(
        icon = Icons.Outlined.Drafts,
        title = "Drafts"
    )
    object AllMail: DrawerMenuData(
        icon = Icons.Outlined.Mail,
        title = "All mail"
    )
    object Spam: DrawerMenuData(
        icon = Icons.Outlined.Warning,
        title = "Spam"
    )
    object Bin: DrawerMenuData(
        icon = Icons.Default.DeleteOutline,
        title = "Bin"
    )
    object Calendar: DrawerMenuData(
        icon = Icons.Outlined.CalendarToday,
        title = "Calendar"
    )
    object Contacts: DrawerMenuData(
        icon = Icons.Outlined.Contacts,
        title = "Contacts"
    )
    object Settings: DrawerMenuData(
        icon = Icons.Outlined.Settings,
        title = "Settings"
    )
    object HelpAndFeedback: DrawerMenuData(
        icon = Icons.Outlined.HelpOutline,
        title = "Help and feedback"
    )

    // object for divider and headers
    object Divider: DrawerMenuData(
        isDivider = true
    )
    object HeaderOne: DrawerMenuData(
        isHeader = true,
        title = "All labels"
    )
    object HeaderTwo: DrawerMenuData(
        isHeader = true,
        title = "Google apps"
    )
}