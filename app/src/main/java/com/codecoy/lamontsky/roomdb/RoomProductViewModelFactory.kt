package com.codecoy.lamontsky.roomdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class RoomProductViewModelFactory(private val roomProductRepo: RoomProductRepo) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RoomProductViewModel(roomProductRepo) as T
    }
}