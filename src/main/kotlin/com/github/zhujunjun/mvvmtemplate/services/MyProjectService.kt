package com.github.zhujunjun.mvvmtemplate.services

import com.intellij.openapi.project.Project
import com.github.zhujunjun.mvvmtemplate.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
