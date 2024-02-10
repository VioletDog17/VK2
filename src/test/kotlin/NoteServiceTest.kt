import junit.framework.TestCase.*
import kotlin.test.Test
import MiniApp.DataNote
import MiniApp.NoteService

class NoteServiceTest {

    @Test
    fun add() {
        val service = NoteService()
        val note: DataNote = DataNote(0)
        val addedNote = service.add(note)
        assertTrue(note.id != addedNote.id && addedNote.id != 0)
    }

    @Test
    fun deleteExisting() {
        val service = NoteService()
        val addedNote = service.add(DataNote(0))
        assertTrue(service.delete(addedNote))
    }

    @Test
    fun deleteNonExisting() {
        val service = NoteService()
        val addedNote = DataNote(0)
        assertFalse(service.delete(addedNote))
    }

    @Test
    fun editExisting() {
        val service = NoteService()
        val addedNote = service.add(DataNote(0, "HI", "I'm alive"))
        assertTrue(service.edit(addedNote, "Bye", "I'm dead"))
    }

    @Test
    fun editNonExisting() {
        val service = NoteService()
        val NonAddedNote = DataNote(0, "HI", "I'm dead")
        assertFalse(service.edit(NonAddedNote, "HI", "I'm really dead"))
    }

    @Test
    fun getList() {
        val service = NoteService()
        var strSum: String = ""
        val addedNote1 = DataNote(0, "HI", "I'm dead")
        strSum += "1. " + addedNote1.title + ",/n"
        service.add(addedNote1)
        val addedNote2 = DataNote(0, "HI", "I'm alive")
        strSum += "2. " + addedNote2.title + ",/n"
        service.add(addedNote2)
        val addedNote3 = DataNote(0, "HI", "I'm not sure")
        strSum += "3. " + addedNote3.title + ",/n"
        service.add(addedNote3)
        assertTrue(service.getList() == strSum)
    }

    @Test
    fun getByIdExisting() {
        val service = NoteService()
        val addedNote = DataNote(-2, "HI", "I'm dead")
        service.add(addedNote)
        assertTrue(service.getById(1).title == "HI")
    }

    @Test
    fun restoreNoteExisting() {
        val service = NoteService()
        val addedNote = service.add(DataNote(0))
        service.delete(addedNote)
        assertTrue(service.restoreNote(1))
    }

    @Test
    fun restoreNoteNonExisting() {
        val service = NoteService()
        assertFalse(service.restoreNote(1))
    }

    @Test
    fun deleteCommentNonExisting() {
        val service = NoteService()
        var addedNote = DataNote(-2, "HI", "I'm dead")
        val comment = Comment(0, "OK")
        service.add(addedNote)
        addedNote = service.add(addedNote)
        service.deleteComment(addedNote, comment)
        assertFalse(service.deleteComment(addedNote, comment))

    }

}