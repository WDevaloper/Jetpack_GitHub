package com.fmt.github.home.viewmodel

import androidx.lifecycle.LiveData
import com.fmt.github.base.viewmodel.BaseViewModel
import com.fmt.github.user.repository.UserRepository

class HomeViewModel(private val mUserRepository: UserRepository) : BaseViewModel() {

    fun deleteAuthorization(id: Int): LiveData<Boolean> = emit {
        mUserRepository.deleteAuthorization(id).code() == 204
    }

    fun deleteUser() {
        launch {
            mUserRepository.deleteLocalUser(mUserRepository.getLocalUsers()[0])
        }
    }
}
