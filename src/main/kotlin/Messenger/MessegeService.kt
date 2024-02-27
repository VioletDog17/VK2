package Messenger

class MessegeService {
    private var chats = mutableListOf<DirectMessages>()
    private var nextId: Int = 1
    fun newChat(text: String): DirectMessages {
        val chat = DirectMessages()
        chat.setChatId(nextId)
        chat.sendMsg(text)
        chats += chat
        nextId++
        return chats.last()
    }

    fun deleteChat(chat: DirectMessages): Boolean {
        for (i in chats.indices) {
            if (chats[i].getIdChat() == chat.chatId) {
                chats.removeAt(i)
                return true
            }
        }
        return false
    }

    fun getChatList(): String {
        val ans = chats.asSequence()
            .joinToString(separator = "\n") { it.LastToString() }
        return ans
    }

    fun getUnreadChatsCount(): Int {
        var list: List<DirectMessages> = chats.filter { chat: DirectMessages -> chat.getStatus() > 0 }
        return list.size
    }

    fun getLastMsgList(): String {
        val ans = chats.asSequence()
            .joinToString(separator = "\n") { it.getLastMsg().text }
        return ans
    }

}