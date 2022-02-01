package com.nathanjchan.issuetrackerapp.data.api

import com.nathanjchan.issuetrackerapp.data.model.ProjectApiModel

interface ProjectsRemoteApi {
    private fun createProjectProtobuf(project: ProjectApiModel): ByteArray {
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

    fun postProject(project: ProjectApiModel) {
//        val projectByteArray = createProjectProtobuf(project)
    }

    fun getProject(project: ProjectApiModel) {
//        val projectByteArray = createProjectProtobuf(project)
    }
}
