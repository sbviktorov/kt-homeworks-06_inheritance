package ru.netology.objects.attachments

class GraffitiAttachment(override val type: String = "graffiti", val graffiti: Graffiti) : Attachment {
}

data class Graffiti(
    val id: Int,
    val ownerId: Int,
    val photo130: String,
    val photo604: String
)