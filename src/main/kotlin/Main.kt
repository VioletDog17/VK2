fun main(args: Array<String>) {
    val newComment = Comment("Hi")
    val comments = emptyArray<Comment>()
    val likes = Likes()
    val service = WallService()

    val post1 = DataPost(
        like = likes,
        signer_id = null,
        attachments = (arrayOf(PhotoAttachments(), VideoAttachments(), AudioAttachments()))

    )
    val post2 = DataPost(like = likes, signer_id = null, comment = comments)
    val post3 = DataPost(like = likes, signer_id = null)
    service.add(post1)
    service.createComment(post2.id, newComment)
    service.add(post2)
    service.add(post3)
    val post4 = post3.copy(text = "^-*-^")
    service.update(post4)
}