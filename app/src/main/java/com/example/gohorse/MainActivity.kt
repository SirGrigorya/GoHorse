package com.example.gohorse

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val userLogin: EditText = findViewById(R.id.user_login)
        val userName: EditText = findViewById(R.id.user_name)
        val userSurname: EditText = findViewById(R.id.user_surename)
        val userPatronymic: EditText = findViewById(R.id.user_patronymic)
        val userBirthdate: EditText = findViewById(R.id.user_birthdate)
        val userPassword: EditText = findViewById(R.id.user_password)

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val name = userName.text.toString().trim()
            val surname = userSurname.text.toString().trim()
            val patronymic = userPatronymic.text.toString().trim()
            val birthdate = userBirthdate.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if (login == "" || name == "" || surname == "" || patronymic == "" || birthdate == "" || password == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else if (birthdate.count() != 10)
                Toast.makeText(this, "Введите дату рождения в формате ДД.ММ.ГГГГ", Toast.LENGTH_LONG).show()
            else {
                val user = User(login, name, surname, patronymic, birthdate, password)

                val db = DBHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userName.text.clear()
                userSurname.text.clear()
                userPatronymic.text.clear()
                userBirthdate.text.clear()
                userPassword.text.clear()
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}