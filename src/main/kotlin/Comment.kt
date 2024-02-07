data class Comment(
    val id: Int = 0,
    val text: String = "No text",
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = false,
    val canClose: Boolean = false,
    val canOpen: Boolean = false,
    val alive: Boolean = true
)
