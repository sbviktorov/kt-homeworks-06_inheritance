package ru.netology.objects.attachments

import ru.netology.objects.Attachment

data class VideoAttachment(override val type: String = "video", val video: Video) : Attachment {
}

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int,
)