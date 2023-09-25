package com.example.quickdoro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickdoro.databinding.ActivityTodoBinding

class ToDoActivity : AppCompatActivity() {

    private lateinit var toDoAdapter: ToDoAdapter
    private var binding: ActivityTodoBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //Attaches adapter to recycling view
        toDoAdapter = ToDoAdapter(mutableListOf())
        binding?.rvTodolist?.adapter = toDoAdapter

        binding?.rvTodolist?.layoutManager = LinearLayoutManager(this)

        //Button to add a new task to to-do list
        binding?.btAddtask?.setOnClickListener{
            val task = binding?.etInput?.text.toString()
            if(task.isNotEmpty()){
                toDoAdapter.addToDoItem(ToDoItem(task))
                binding?.etInput?.text?.clear()
                Toast.makeText(this, "Sucesso!", Toast.LENGTH_SHORT).show()
            }
        }

        //Button to delete all done tasks on to-do list
        binding?.btDelete?.setOnClickListener{
            toDoAdapter.delDoneToDo()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}