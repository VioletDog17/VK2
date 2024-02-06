fun main(args: Array<String>) {
    val comments = Comment()
    val likes = Likes()
    val service = WallService()

    val post1 = DataPost(
        like = likes,
        signer_id = null,
        attachments = (arrayOf(PhotoAttachments(), VideoAttachments(), AudioAttachments()))
    )
    val post2 = DataPost(like = likes, signer_id = null)
    val post3 = DataPost(like = likes, signer_id = null)
    service.add(post1)
    service.add(post2)
    service.add(post3)
    val post4 = post3.copy(text = "^-*-^")
    service.update(post4)
}