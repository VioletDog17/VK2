import java.lang.RuntimeException
class WallService {
    private var posts = emptyArray<DataPost>()
    private var nextId: Int = 1
    fun add(post: DataPost): DataPost {
        val committedPost = post.copy(id = nextId)
        posts += committedPost
        nextId++
        return posts.last()
    }

    fun update(checkingPost: DataPost): Boolean {
        for (i in posts.indices) {
            if (posts[i].id == checkingPost.id) {
                posts[i] = checkingPost
                return true
            }
        }
        return false
    }

    fun createComment(postId: Int, comment: Comment) {
        posts[postId].comment.plusElement(comment) ?: throw PostNotFoundException("No post with $postId")

    }
}

class PostNotFoundException(messege: String) : RuntimeException(messege)