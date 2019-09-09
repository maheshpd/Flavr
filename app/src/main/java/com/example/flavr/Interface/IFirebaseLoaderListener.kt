package com.example.flavr.Interface

import com.example.flavr.model.CategoryModel

interface IFirebaseLoaderListener {
    fun onFirebaseLoadListener(categoryItem: List<CategoryModel>)
    fun onFirebaseLoadFailed(message: String)
}