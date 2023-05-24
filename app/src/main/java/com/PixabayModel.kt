package com

data class PixabayModel (
    val hits: ArrayList<ImageModel>
    )

data class ImageModel(
    var largeImageUrl: String
)