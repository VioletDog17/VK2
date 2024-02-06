class Comment {
    var count = 0
    var canPost = true
    var groupsCanPost = false
    var canClose = false
    var canOpen = false

    override fun toString(): String {
        return "[ $count, $canPost, $groupsCanPost, $canClose, $canOpen ]"
    }

}
