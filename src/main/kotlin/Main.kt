import Messenger.MessegeService

fun main(args: Array<String>) {
    val newComment = Comment(1, "HI")
    val comments = emptyArray<Comment>()
    val likes = Likes()
    val service = WallService()

    val post1 = DataPost(
        like = likes,
        signer_id = null,
        attachments = (arrayOf(PhotoAttachments(), VideoAttachments(), AudioAttachments()))

    )
    var post2 = DataPost(like = likes, signer_id = null, comment = comments)
    var post3 = DataPost(like = likes, signer_id = null)
    service.add(post1)
    post2 = service.add(post2)
    service.createComment(post2.id, newComment)
    service.add(post3)
    val post4 = post3.copy(text = "^-*-^")
    service.update(post4)
    //-------------------------------------------------------------------------------------//
    val msgService = MessegeService()
    val direct1 = msgService.newChat("Hi, my name 147")
    val direct2 = msgService.newChat("Hi, my name 258")
    val direct3 = msgService.newChat("Hi, my name 369")
    direct1.sendMsg("Hi, 258")
    direct1.sendMsg("Hi, 369")

    direct2.sendMsg("Hi, 147")
    direct2.sendMsg("Hi, 369")

    direct3.sendMsg("Hi, 147")
    direct3.sendMsg("Hi, 258")

    println(msgService.getLastMsgList())
    println()
    println(msgService.getChatList())
    println()
    println("Unread chats " + (msgService.getUnreadChatsCount()).toString())
    println()
    println(msgService.getChatList())
    println("Unread chats " + (msgService.getUnreadChatsCount()).toString())
    msgService.deleteChat(direct3)
    direct1.deleteMsg(direct1.getLastMsg())
    println(msgService.getChatList())
    println()
    direct2.editMsg(direct2.getLastMsg(), "adc")
    println(msgService.getChatList())
    println()
    println()
    println("Unread chats " + (msgService.getUnreadChatsCount()).toString())
    println(msgService.getChatList())
    println()

}
