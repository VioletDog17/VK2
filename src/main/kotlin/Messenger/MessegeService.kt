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

    fun deleteChat(chat: DirectMessages): Boolean { //Удалить чат, т. е. целиком удалить всю переписку.
        for (i in chats.indices) {
            if (chats[i].getIdChat() == chat.chatId) {
                chats.removeAt(i)
                return true
            }
        }
        return false
    }

    fun getChatList(): String {
        var ans: String = ""
        for (i in chats.indices) {
            var txt = chats[i].getLastMsg().text
            ans += (chats[i].getLastMsg().fromId).toString() + "\n" + txt + "      " + (chats[i].getLastMsg().time).toString() + " -> " + chats[i].getLastMsg().status + "\n \n"

        }
        return ans
    }

    fun getUnreadChatsCount(): Int {
        var list: List<DirectMessages> = chats.filter { chat: DirectMessages -> chat.getStatus() > 0 }
        return list.size
    }

    fun getLastMsgList(): String {
        var ans: String = ""
        var count: Int = 1
        for (i in chats.indices) {
            ans += count.toString() + ". " + chats[i].getLastMsg().text + "\n"
            count++
        }
        return ans
    }

}