package com.example.data2view
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data2view.MyAdapter

class MainActivity : AppCompatActivity() {

    private val mutableList = mutableListOf<String>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter
    private lateinit var editText: EditText
    private lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        editText = findViewById(R.id.editText)
        addButton = findViewById(R.id.addButton)

        adapter = MyAdapter(mutableList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        addButton.setOnClickListener {
            val newEntry = editText.text.toString().trim()
            if (newEntry.isNotEmpty()) {
                mutableList.add(newEntry)
                adapter.notifyDataSetChanged()
                editText.text.clear()
            }
        }
    }
}
