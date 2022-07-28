fun main() {

    val note1 = Note(title = "Один", text = "Первая заметка")
    val note2 = Note(title = "Два", text = "Вторая заметка")
    val note3 = Note(title = "Три", text = "Третья заметка")

    val comment1 = Comment(text = "Первый комментарий")
    val comment2 = Comment(text = "Второй комментарий")

    val noteService = NoteService()

    noteService.add(note1)
    noteService.add(note2)
    println("Добавление заметок:")
    for (note in noteService.notes) {
        println(note)
    }

    noteService.delete(1)
    println("\nУдаление заметки:")
    for (note in noteService.notes) {
        println(note)
    }

    noteService.add(note3)
    println("\nДобавление заметки:")
    for (note in noteService.notes) {
        println(note)
    }

    noteService.edit(3, "Четыри", "Изменена заметка")
    println("\nРедактирование заметки по id")
    for (note in noteService.notes) {
        println(note)
    }

    println("\nВывод списка заметок")
    println(noteService.getAllNotes())

    println("\nПолучение заметки по id")
    println(noteService.getById(2))

    println("\nДобавление комментария к записи:")
    noteService.createComment(2, comment1)
    noteService.createComment(2, comment2)
    for (note in noteService.notes) {
        println(note)
    }

    println("\nРедактирование комментария:")
    noteService.editComment(2, 1, "Изменен комментарий")
    println(noteService.notes[0])

    println("\nСписок комментариев к заметке с заданным id:")
    println(
        "1)${noteService.getComments(2)?.get(0)?.text}" +
                "\n2)${noteService.getComments(2)?.get(1)?.text} "
    )

    println("\nУдаление комментария:")
    noteService.deleteComment(2, 1)
    println(noteService.notes[0])

    println("\nВосстановление комментария:")
    noteService.restoreComment(2, 1)
    println(noteService.notes[0])

    println("\nПолучаем комментарии по заданному id (все, кроме удалённых):")
    println(noteService.getComments(2))
}