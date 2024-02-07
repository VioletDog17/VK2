package MiniApp

import Comment

data class DataNote(
    val id: Int = 0,
    val title: String = "No title", // Заголовок заметки.
    val text: String = "No text", //Текст заметки.
    val privacy: Int = 0, //все пользователи.
    val commentPrivacy: Int = 0, //Уровень доступа к комментированию заметки.
    val alive: Boolean = true,
    val comment: Array<Comment> = emptyArray()
)
