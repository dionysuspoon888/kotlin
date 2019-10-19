package com.example.kotlin

/**
 * Created by D on 10/18/2019.
 */
class JsonItem {
     var imageUrl: String? = null
     var creator: String? = null
     var like: Int = 0
     var view: Int = 0

    constructor(imageUrl: String, creator: String, like: Int, view: Int){
        this.imageUrl = imageUrl
        this.creator = creator
        this.like = like
        this.view = view
    }
}