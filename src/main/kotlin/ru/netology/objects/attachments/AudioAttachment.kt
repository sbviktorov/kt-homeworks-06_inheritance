package ru.netology.objects.attachments

class AudioAttachment(override val type: String = "audio", val audio: Audio) : Attachment {
}

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String
)