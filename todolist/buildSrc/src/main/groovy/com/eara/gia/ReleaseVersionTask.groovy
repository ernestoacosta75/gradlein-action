package com.eara.gia

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

/**
 * This class extends Gradle's default task implementation
 * and express the logic from "makeReleaseVersion" task as
 * a custom task class.
 *
 * The <b>@Input</b> annotation is used to declare the input
 * property "release" and the <b>@OutputFile</b> annotation to
 * define the output file.
 * These annotations act as automatic documentation as well.
 *
 * The <b>@TaskAction</b> annotation declares the method to be
 * executed.
 *
 * @author Ernesto A. Rodriguez Acosta
 */
class ReleaseVersionTask extends DefaultTask {
    // Declaring custom task's inputs/outputs through annotations
    @Input Boolean release
    @OutputFile File destFile

    ReleaseVersionTask() {
        // Setting task's group and description properties in the constructor
        group = 'versioning'
        description = 'Makes project a release version.'
    }

    @TaskAction
    void start() {
        project.version.release = true
        ant.propertyfile(file: destFile) {
            entry( key: "release", value: "true")
        }
    }
}
