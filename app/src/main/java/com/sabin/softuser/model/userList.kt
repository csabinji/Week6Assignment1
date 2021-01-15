package com.sabin.softuser.model

object userList {
    var lstUser = ArrayList<User>()

    fun addUser(user: User){
        lstUser.add(user)
    }

    fun showUser(): ArrayList<User> {
        return lstUser
    }
}