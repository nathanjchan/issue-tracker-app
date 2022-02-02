package com.nathanjchan.issuetrackerapp.data.api

import com.nathanjchan.issuetrackerapp.data.model.ProjectModel

interface ProjectsRemoteApi {
    private fun createProjectProtobuf(project: ProjectModel): ByteArray {
        val projectProtobuf = IssueTrackerApiObjects.Project.newBuilder()
            .setProjectId(project.projectId)
            .setTimestampOfCreation(project.timestampOfCreation)
            .setTimestampOfLastEdit(project.timestampOfLastEdit)
            .setTitle(project.title)
            .setDescription(project.description)
        project.ticketIds.forEachIndexed { i, value ->
            projectProtobuf.setTicketIds(i, value)
        }
        project.accountIdsOfOwners.forEachIndexed { i, value ->
            projectProtobuf.setAccountIdsOfOwners(i, value)
        }
        project.accountIdsOfMembers.forEachIndexed {i, value ->
            projectProtobuf.setAccountIdsOfMembers(i, value)
        }
        return projectProtobuf.build().toByteArray()
    }

    fun postProject(project: ProjectModel) {
//        val projectByteArray = createProjectProtobuf(project)
    }

    fun getProject(project: ProjectModel) {
//        val projectByteArray = createProjectProtobuf(project)
    }
}
