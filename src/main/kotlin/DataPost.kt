data class DataPost(
    val id: Int = 0, //Идентификатор записи.
    val ownerId: Int = 1, //Идентификатор владельца стены, на которой размещена запись
    val fromId: Int = 1, //Идентификатор автора записи
    val createdBy: Int = 2, //Идентификатор администратора, который опубликовал запись
    val text: String = " ~*-*~ ", //Текст записи.
    val friendsOnly: Boolean = false, //«Только для друзей».
    val date: Long = 1160439611, //Время публикации записи в формате unixtime.
    val like: Likes, //Информация о лайках к записи,
    val comment: Array<Comment> = emptyArray(), //Информация о коментариях к записи,
    val views: Int = 0, //Информация о просмотрах записи.
    val signer_id: DataPost?, //Идентификатор сообщества если от его имени был опубликован пост
    val attachments: Array<Attachments> = emptyArray()
)