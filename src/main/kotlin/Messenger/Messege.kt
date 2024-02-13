package Messenger

import Attachments

data class Messege(
    val id: Int = 0,
    val fromId: Int = 0,
    val time: Int = 0,
    var status: String = "Not delivered", // delivered, read
    val text: String
)
