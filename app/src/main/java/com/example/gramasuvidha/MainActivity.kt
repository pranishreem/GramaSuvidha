package com.example.gramasuvidha

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.projectsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val projects = loadMockProjects()
        if (projects.isEmpty()) {
            Log.w(TAG, "No projects loaded or projects list is empty")
        } else {
            Log.d(TAG, "Loaded ${projects.size} projects")
        }

        val adapter = ProjectAdapter(projects)
        recyclerView.adapter = adapter
    }

    private fun loadMockProjects(): List<Project> {
        return try {
            val jsonString = assets.open("projects.json").bufferedReader().readText()
            val type = object : TypeToken<Map<String, List<Project>>>() {}.type
            val data: Map<String, List<Project>>? = Gson().fromJson(jsonString, type)
            data?.get("projects") ?: emptyList()
        } catch (e: Exception) {
            Log.e(TAG, "Error loading projects from assets", e)
            emptyList()
        }
    }
}