class Likes {
    private var count = 0
    private var userLikes = true
    private var canLike = true
    private var canPublish = true

    override fun toString(): String {
        return "[ $count, $userLikes, $canLike, $canPublish ]"
    }

    //-----------------------------------------------------
    fun setCount(value: Int) {
        this.count = value
    }

    fun getCount(): Int {
        return count
    }

    //-----------------------------------------------------
    fun setUserLikes(value: Boolean) {
        this.userLikes = value
    }

    fun getUserLikes(): Boolean {
        return userLikes
    }

    //-----------------------------------------------------
    fun setCanLike(value: Boolean) {
        this.canLike = value
    }

    fun getCanLike(): Boolean {
        return canLike
    }

    //-----------------------------------------------------
    fun setCanPublish(value: Boolean) {
        this.canPublish = value
    }

    fun getCanPublish(): Boolean {
        return canPublish
    }
}