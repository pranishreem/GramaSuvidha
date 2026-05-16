package com.example.gramasuvidha

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProjectAdapter(private val projects: List<Project>) :
    RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>() {

    inner class ProjectViewHolder(itemView: android.view.View) :
        RecyclerView.ViewHolder(itemView) {

        private val projectName: TextView = itemView.findViewById(R.id.projectName)
        private val projectDescription: TextView = itemView.findViewById(R.id.projectDescription)
        private val projectCategory: TextView = itemView.findViewById(R.id.projectCategory)

        fun bind(project: Project) {
            projectName.text = project.name
            projectDescription.text = project.description
            projectCategory.text = project.category
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_project, parent, false)
        return ProjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.bind(projects[position])
    }

    override fun getItemCount(): Int = projects.size
}