interface Attachments {
    val type: String
}

//-----------------------------------------------------

class PhotoAttachments(
    override val type: String = "photo",
    val peculiarities: Photo = Photo(
        1,
        1,
        "https://www.google.com/url?sa=i&url=https%3A%2F%2Fru.wikipedia.org%2Fwiki%2F%25D0%25A0%25D0%25B8%25D0%25BA%25D1%2580%25D0%25BE%25D0%25BB%25D0%25BB%25D0%25B8%25D0%25BD%25D0%25B3&psig=AOvVaw2DtV_Ht6yr3ugw-atO-HKz&ust=1706735828986000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPC-7MmEhoQDFQAAAAAdAAAAABAJ"
    )
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
    val peculiarities: Video = Video(1, 1, "RickRoll", 213, "https://www.youtube.com/watch?v=dQw4w9WgXcQ")
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
    val peculiarities: Audio = Audio(
        1,
        1,
        "RickRoll",
        213,
        "https://zvukipro.com/pesnya/2907-pesnja-rik-roll-v-raznyh-variantah-rick-roll.html"
    )
) : Attachments

class Audio(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val duration: Int = 0,
    val audio_1: String = "https://vk.com/another_audio_link"
)

//-----------------------------------------------------
