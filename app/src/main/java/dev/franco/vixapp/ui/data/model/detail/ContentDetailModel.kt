package dev.franco.vixapp.ui.data.model.detail

data class ContentDetailModel(
    val title: String?,
    val description: String?,
    val genre: List<String>?,
    val year: String?,
    val ratings: List<String>?,
    val chips: List<String>?,
    val director: String?,
    val casting: List<String>?,
    val cover: String?,
)
