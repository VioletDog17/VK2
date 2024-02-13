package Messenger

import java.lang.RuntimeException
import MiniApp.NoteNotFoundException

class DirectMessages {
    var chatId: Int = 0
    private var messeges = mutableListOf<Messege>()
    private var nextId: Int = 1
    fun sendMsg(msgText: String): Boolean {
        val Msg = Messege(id = nextId, fromId = chatId, time = 1, status = "delivered", text = msgText)
        messeges += Msg
        nextId++
        return true
    }

    fun getLastMsg(): Messege {
        return messeges.last()
    }

    fun getMsgById(id: Int): Messege {
        return messeges[id - 1] ?: throw MsgNotFoundException("No post with $id")
    }

    fun editMsg(
        msg: Messege,
        newText: String
    ): Boolean {
        val editMsg = msg.copy(text = newText, status = "delivered")
        for (i in messeges.indices) {
            if (messeges[i].id == msg.id) {
                messeges[i] = editMsg
                return true
            }
        }
        return false
    }

    fun deleteMsg(msg: Messege): Boolean {
        for (i in messeges.indices) {
            if (messeges[i].id == msg.id) {
                messeges.removeAt(i)
                return true
            }
        }
        return false
    }

    fun getStatus(): Int {
        var count = 0
        for (i in messeges.indices) {
            if (messeges[i].status == ("delivered")) {
                messeges[i].status = "read"
                count++
            }
        }
        return count

    }

    fun setChatId(id: Int): Boolean {
        chatId = id
        return true
    }

    fun getIdChat(): Int {
        return chatId
    }
}

class MsgNotFoundException(messege: String) : RuntimeException(messege)