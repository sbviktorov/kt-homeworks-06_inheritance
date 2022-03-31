package ru.netology.objects.attachments

data class PhotoAttachment(override val type: String = "photo", val photo: Photo) : Attachment {
}

data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val text: String,
    val width: Int,
    val height: Int
)