package MiniApp

import Comment
import java.lang.RuntimeException

class NoteService {
    private var notes = emptyArray<DataNote>()
    private var nextId: Int = 1
    fun add(note: DataNote): DataNote { //Создает новую заметку у текущего пользователя.
        val committedNote = note.copy(id = nextId)
        notes += committedNote
        nextId++
        return notes.last()
    }

    fun delete(note: DataNote): Boolean { //Удаляет заметку текущего пользователя.
        val deleteNote = note.copy(alive = false)
        for (i in notes.indices) {
            if (notes[i].id == deleteNote.id) {
                notes[i] = deleteNote
                return true
            }
        }
        return false
    }

    fun edit(note: DataNote, newTitle: String, newText: String): Boolean { //Редактирует заметку текущего пользователя.
        val editNote = note.copy(title = newTitle, text = newText)
        for (i in notes.indices) {
            if (notes[i].id == editNote.id && notes[i].alive) {
                notes[i] = editNote
                return true
            }
        }
        return false
    }

    fun getList(): String { //Возвращает список заметок, созданных пользователем.
        var list = ""
        var count = 1
        for (i in notes.indices) {
            if (notes[i].alive) {
                list += "$count. " + notes[i].title + ",/n"
            }
            count += 1
        }
        return list
    }

    fun getById(id: Int): DataNote { //Возвращает заметку по её id.
        return notes[id] ?: throw NoteNotFoundException("No post with $id")
    }

    fun restoreNote(id: Int): Boolean { //Восстанавливает удалённый комментарий.
        for (i in notes.indices) {
            if (notes[i].id == id) {
                notes[i] = notes[i].copy(alive = true)
                return true
            }
        }
        return false
    }

    //------------------------------------------------------------------------
    fun createComment(note: DataNote, comment: Comment): Boolean { //Добавляет новый комментарий к заметке.
        note.comment.plusElement(comment)
        return true
    }

    fun deleteComment(note: DataNote, comment: Comment): Boolean { //Удаляет комментарий к заметке.
        val deletedComment = comment.copy(alive = false)
        for (i in note.comment.indices) {
            if (note.comment[i].id == comment.id) {
                note.comment[i] = deletedComment
                return true
            }
        }
        return false
    }

    fun editComment(
        note: DataNote,
        comment: Comment,
        newText: String
    ): Boolean { //Редактирует указанный комментарий у заметки.
        val editComment = comment.copy(text = newText)
        for (i in note.comment.indices) {
            if (note.comment[i].id == editComment.id && note.comment[i].alive) {
                note.comment[i] = editComment
                return true
            }
        }
        return false
    }

    fun getComment(note: DataNote): String { //Возвращает список комментариев к заметке.
        var list = ""
        var count = 1
        for (i in note.comment.indices) {
            if (note.comment[i].alive) {
                list += "$count. " + note.comment[i].text + ",/n"
            }
            count += 1
        }
        return list
    }

    fun restoreComent(note: DataNote, id: Int): Boolean { //Восстанавливает удалённый комментарий.
        for (i in note.comment.indices) {
            if (note.comment[i].id == id) {
                note.comment[i] = note.comment[i].copy(alive = true)
                return true
            }
        }
        return false
    }

}

class NoteNotFoundException(messege: String) : RuntimeException(messege)