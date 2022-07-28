data class Note(
    var id: Int = 0,
    var title: String,
    var text: String,
    val date: Int = 0,
    var comments: MutableList<Comment> = mutableListOf(),
    val viewUrl: String = "https://vk.com/",
    val canComment: Boolean = true
)