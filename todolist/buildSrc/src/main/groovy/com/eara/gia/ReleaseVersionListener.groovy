package com.eara.gia

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionGraph
import org.gradle.api.execution.TaskExecutionGraphListener

class ReleaseVersionListener implements TaskExecutionGraphListener {

    final static String releaseTaskPath = ':release'

    @Override
    void graphPopulated(TaskExecutionGraph taskGraph) {
        // Determines whether release task is included in execution graph
        if(taskGraph.hasTask(releaseTaskPath)) {
            List<Task> allTasks = taskGraph.allTasks

            //Filtere release task from list of all tasks within execution graph
            Task releaseTask = allTasks.find {it.path == releaseTaskPath}

            //Every task knows which project it belongs to
            Project project = releaseTask.project

            if(!project.version.release) {
                project.version.release = true
                project.ant.propertyfile(file: project.versionFile) {
                    entry( key: "release", value: "true")
                }
            }
        }
    }
}


