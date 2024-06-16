package com.example.gohorse

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "app", factory, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INT PRIMARY KEY, login TEXT, name TEXT, surname TEXT, patronymic TEXT, birthdate TEXT, password TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun addUser(user: User) {
        val values = ContentValues()
        values.put("login", user.login)
        values.put("name", user.name)
        values.put("surname", user.surname)
        values.put("patronymic", user.patronymic)
        values.put("birthdate", user.birthdate)
        values.put("password", user.password)

        val db = this.writableDatabase
        db.insert("users", null, values)

        db.close()
    }

}