package com.example.quickdoro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickdoro.databinding.TodoItemBinding

class ToDoAdapter(
    private val toDoList: MutableList<ToDoItem>
) : RecyclerView.Adapter<ToDoAdapter.ToDoListHolder>() {

    inner class ToDoListHolder(val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: ToDoItem){
            binding.tvTask.text = item.task
            binding.cbCheck.isChecked = item.check
        }
    }

    //Sets the layout for the view of the new inserted 'todoItem'
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoListHolder {
        return ToDoListHolder(
            TodoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    //Binds the new view to the correspondent 'toDoItem' in 'toDoList'
    override fun onBindViewHolder(holder: ToDoListHolder, position: Int) {
        val currentToDoItem = toDoList[position]
        holder.bindItem(currentToDoItem)
    }

    //Returns 'toDoList' size
    override fun getItemCount(): Int {
        return toDoList.size
    }

    fun addToDoItem(item: ToDoItem) {
        toDoList.add(item)
        notifyItemInserted(toDoList.size - 1)
    }

    //Deletes all done 'toDoList' items (checked == true)
    fun delDoneToDo() {
        toDoList.removeAll { toDoItem ->
            toDoItem.check
        }
        notifyDataSetChanged()
    }
}