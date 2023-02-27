package com.example.to_dolist

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
//        lateinit var binding: ActivityMainBinding

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        findViewById<RecyclerView>(R.id.rvTodoItems).adapter = todoAdapter
        findViewById<RecyclerView>(R.id.rvTodoItems).layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.btnAddTodo).setOnClickListener {
            val todoTitle = findViewById<EditText>(R.id.etTodoTitle).text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                findViewById<EditText>(R.id.etTodoTitle).text.clear()
            }
        }
        findViewById<Button>(R.id.btnDeleteDoneTodos).setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }

//        loadData()
//
//        findViewById<Button>(R.id.btnAddTodo).setOnClickListener {
//            saveData()
//        }
    }

//    private fun saveData() {
//        findViewById<Button>(R.id.btnAddTodo).setOnClickListener {
//            val insertedText = findViewById<EditText>(R.id.etTodoTitle).toString()
//            findViewById<TextView>(R.id.tvTodoTitle).text = insertedText
//
//            val sharedPreferences : SharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
//            val editor = sharedPreferences.edit()
//            editor.apply {
//                putString("STRING_KEY", insertedText)
//            }.apply()
//        }
////        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
//    }

//    private fun loadData() {
//        findViewById<Button>(R.id.btnAddTodo).setOnClickListener {
//            val sharedPreferences : SharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
//            val savedString = sharedPreferences.getString("STRING_KEY", null)
//            val savedBoolean = sharedPreferences.getBoolean("BOOLEAN_KEY", false)
//
//            findViewById<TextView>(R.id.tvTodoTitle).text = savedString
//        }
//    }
}