import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class WallServiceTest {

    @Test
    fun add() {
        val comments = emptyArray<Comment>()
        val likes = Likes()
        var post = DataPost(like = likes, comment = comments, signer_id = null)
        val service = WallService()
        var commitPost = service.add(post)
        assertTrue(commitPost.id != post.id && commitPost.id != 0)
    }

    @Test
    fun updateSuccessful() {
        val likes = Likes()
        val comments =  emptyArray<Comment>()
        val service = WallService()
        var post = DataPost(like = likes, comment = comments, signer_id = null)

        service.add(post)
        var post2 = DataPost(like = likes, comment = comments, signer_id = null)
        service.add(post2)
        assertFalse(service.update(post2))

    }

    @Test
    fun updateUnSuccessful() {
        val comments =  emptyArray<Comment>()
        val likes = Likes()
        var post = DataPost(like = likes, comment = comments, signer_id = null)
        val service = WallService()
        service.add(post)
        var post2 = DataPost(like = likes, comment = comments, signer_id = null)
        service.add(post2)
        var post3 = DataPost(id = -2, like = likes, comment = comments, signer_id = null)
        assertFalse(service.update(post3))
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val service = WallService()
        service.createComment(postId = -2, comment = Comment())
    }
}