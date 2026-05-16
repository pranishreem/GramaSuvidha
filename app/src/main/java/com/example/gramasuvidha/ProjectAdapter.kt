package com.example.gramasuvidha

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProjectAdapter(private val projects: List<Project>) :
    RecyclerView.Adapter<ProjectAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_project, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val project = projects[position]
        holder.projectName.text = project.name
        holder.projectStatus.text = project.status
        holder.progressBar.progress = project.currentProgress
        holder.progressText.text = holder.itemView.context.getString(R.string.progress_percentage, project.currentProgress)
    }

    override fun getItemCount() = projects.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val projectName: TextView = itemView.findViewById(R.id.projectName)
        val projectStatus: TextView = itemView.findViewById(R.id.projectStatus)
        val progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)
        val progressText: TextView = itemView.findViewById(R.id.progressText)
    }
}