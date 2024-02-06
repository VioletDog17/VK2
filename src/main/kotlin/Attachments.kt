interface Attachments {
    val type: String
}

//-----------------------------------------------------

class PhotoAttachments(
    override val type: String = "photo",
    val peculiarities: Photo
) : Attachments

class Photo(
    val id: Int,
    val ownerId: Int,
    val photo_1: String = "https://vk.com/some_photo_link",
    val photo_2: String = "https://vk.com/another_photo_link"
)

//-----------------------------------------------------

class VideoAttachments(
    override val type: String = "video",
    val peculiarities: Video
) : Attachments

class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val duration: Int = 0,
    val video_1: String = "https://vk.com/another_video_link"
)

//-----------------------------------------------------

class AudioAttachments(
    override val type: String = "audio",
    val peculiarities: Audio
) : Attachments

class Audio(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val duration: Int = 0,
    val audio_1: String = "https://vk.com/another_audio_link"
)

//-----------------------------------------------------
