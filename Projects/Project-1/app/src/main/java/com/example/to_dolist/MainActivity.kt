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
import com.example.to_dolist.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
//        lateinit var binding: ActivityMainBinding

        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
//        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
//        val editor = sharedPref.edit()
        todoAdapter = TodoAdapter(mutableListOf())

//        binding.apply {
//            findViewById<Button>(R.id.btnSaveTodos).setOnClickListener {
//                val saveData = findViewById<TextView>(R.id.item_todo).text.toString()
//
//                editor.apply {
//                    putString("saveData", saveData)
//                    apply()
//                }
//            }
//
//            findViewById<Button>(R.id.btnLoadTodos).setOnClickListener {
//                val saveData = sharedPref.getString("saveData", null)
//
//                findViewById<TextView>(R.id.item_todo).text = saveData
//            }
//        }

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