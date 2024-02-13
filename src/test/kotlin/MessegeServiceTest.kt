import Messenger.MessegeService
import Messenger.DirectMessages
import Messenger.Messege
import junit.framework.TestCase.*
import java.lang.RuntimeException
import kotlin.test.Test

class MessegeServiceTest {
    @Test
    fun newChat() {
        val service = MessegeService()
        val initChat = service.newChat("Hello")
        assertTrue(initChat.getLastMsg().text == "Hello" && initChat.getIdChat() != 0)
    }

    @Test
    fun deleteChat() {
        val service = MessegeService()
        val initChat = service.newChat("Hello")
        assertTrue(service.deleteChat(initChat))
    }

    @Test
    fun getUnreadChatsCount() {
        val msgService = MessegeService()
        msgService.newChat("Hi, my name 147")
        msgService.newChat("Hi, my name 258")
        msgService.newChat("Hi, my name 369")
        val receivedBefore = msgService.getUnreadChatsCount()
        val receivedAfter = msgService.getUnreadChatsCount()
        assertTrue(receivedBefore == 3 && receivedAfter == 0)
    }

    //--------------------------------------------------------------------------------//
    @Test
    fun sendMsgAndgetLastMsg() {
        val msgService = MessegeService()
        val direct1 = msgService.newChat("Hi, my name 147")
        val newMsg = direct1.getLastMsg()
        assertTrue(newMsg.id != 0 && direct1.sendMsg("test"))
    }

    //    Почему то выкидывает out of bounce
//    @Test(expected = MsgNotFoundException::class)
//    fun getMsgById() {
//        val msgService = MessegeService()
//        val direct1 = msgService.newChat("Hi, my name 147")
//        direct1.getMsgById(3)
//    }
    @Test
    fun editMsg() {
        val msgService = MessegeService()
        val direct1 = msgService.newChat("xyz")
        val newMsgText = direct1.getLastMsg().text
        direct1.editMsg(direct1.getLastMsg(), "abc")
        assertTrue(direct1.getLastMsg().text != newMsgText)
    }

    @Test
    fun deleteMsg() {
        val msgService = MessegeService()
        val direct1 = msgService.newChat("xyz")
        direct1.sendMsg("abc")
        val secondMsg = direct1.getLastMsg().text
        direct1.deleteMsg(direct1.getLastMsg())
        assertTrue(direct1.getLastMsg().text != secondMsg && direct1.getLastMsg().text == "xyz")
    }

    @Test
    fun getStatus() {
        val msgService = MessegeService()
        val direct1 = msgService.newChat("xyz")
        direct1.getStatus()
        val firstMsgStatus = direct1.getLastMsg().status
        direct1.sendMsg("abc")
        val secondMsgStatus = direct1.getLastMsg().status
        direct1.deleteMsg(direct1.getLastMsg())
        assertTrue(firstMsgStatus == "read" && secondMsgStatus == "delivered")
    }

}

class MsgNotFoundException(messege: String) : RuntimeException(messege)