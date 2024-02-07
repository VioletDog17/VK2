interface Attachments {
    val type: String
}

//-----------------------------------------------------

class PhotoAttachments(
    override val type: String = "photo",
    val peculiarities: Photo = Photo()
) : Attachments

class Photo(
    val id: Int = 0,
    val ownerId: Int = 0,
    val photo_1: String = "https://vk.com/photo_link_1",
    val photo_2: String = "https://vk.com/photo_link_2",
    val photo_3: String = "https://vk.com/photo_link_3",
    val photo_4: String = "https://vk.com/photo_link_4",
    val photo_5: String = "https://vk.com/photo_link_5",
    val photo_6: String = "https://vk.com/photo_link_6",
    val photo_7: String = "https://vk.com/photo_link_7",
    val photo_8: String = "https://vk.com/photo_link_8",
    val photo_9: String = "https://vk.com/photo_link_9",
    val photo_10: String = "https://vk.com/photo_link_10"
)

//-----------------------------------------------------

class VideoAttachments(
    override val type: String = "video",
    val peculiarities: Video = Video()
) : Attachments

class Video(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String = "Base",
    val duration: Int = 0,
    val video_1: String = "https://vk.com/video_link_1",
    val video_2: String = "https://vk.com/video_link_2",
    val video_3: String = "https://vk.com/video_link_3",
    val video_4: String = "https://vk.com/video_link_4",
    val video_5: String = "https://vk.com/video_link_5"
)

//-----------------------------------------------------

class AudioAttachments(
    override val type: String = "audio",
    val peculiarities: Audio = Audio()
) : Attachments

class Audio(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String = "Base",
    val duration: Int = 0,
    val audio_1: String = "https://vk.com/audio_link_1",
    val audio_2: String = "https://vk.com/audio_link_2",
    val audio_3: String = "https://vk.com/audio_link_3",
    val audio_4: String = "https://vk.com/audio_link_4",
    val audio_5: String = "https://vk.com/audio_link_5"
)

//-----------------------------------------------------
