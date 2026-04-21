//UserDao.kt
package com.example.saadat

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(users: List<User>)

    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun getUserByEmail(email: String): User?

    @Query("DELETE FROM users")
    suspend fun clear()
}
