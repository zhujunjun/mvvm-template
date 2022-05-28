package com.aiways.mvvmtemplate.services

import com.intellij.openapi.project.Project
import com.aiways.mvvmtemplate.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
