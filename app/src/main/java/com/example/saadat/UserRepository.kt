//UserRepository.kt
package com.example.saadat

class UserRepository(private val userDao: UserDao) {

    suspend fun insertUser(user: User) {
        userDao.insert(user)
    }

    suspend fun getUser(username: String, password: String): User? {
        return userDao.getUserByEmail(username)
    }

}
