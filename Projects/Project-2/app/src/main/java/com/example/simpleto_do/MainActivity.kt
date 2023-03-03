package com.example.simpleto_do

import android.content.Context
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
//import com.example.to_dolist.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = com.example.simpleto_do.TodoAdapter(mutableListOf())

        findViewById<RecyclerView>(R.id.rvTodoItems).adapter = todoAdapter
        findViewById<RecyclerView>(R.id.rvTodoItems).layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.btnAddTodo).setOnClickListener {
            val todoTitle = findViewById<EditText>(R.id.etTodoTitle).text.toString()
            if (todoTitle.isNotEmpty()) {
                val todo = com.example.simpleto_do.Todo(todoTitle)
                todoAdapter.addTodo(todo)
                findViewById<EditText>(R.id.etTodoTitle).text.clear()
            }
        }
        findViewById<Button>(R.id.btnDeleteDoneTodos).setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}