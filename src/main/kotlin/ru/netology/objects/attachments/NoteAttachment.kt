package ru.netology.objects.attachments

data class NoteAttachment(override val type: String = "note", val note: Note) : Attachment {
}

data class Note(
    val id: Int,
    val ownerId: Int,
    var title: String?,
    val text: String,
    val date: Long
)