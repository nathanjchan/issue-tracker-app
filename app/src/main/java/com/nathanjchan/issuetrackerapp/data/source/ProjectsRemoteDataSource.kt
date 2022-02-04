package com.nathanjchan.issuetrackerapp.data.source

import com.nathanjchan.issuetrackerapp.data.api.ProjectsRemoteApi
import com.nathanjchan.issuetrackerapp.data.model.ProjectModel

class ProjectsRemoteDataSource {

    private fun getProjectProtobufFromModel(projectModel: ProjectModel): IssueTrackerApiObjects.Project {
        projectModel.run {
            return IssueTrackerApiObjects.Project.newBuilder()
                .setProjectId(projectId)
                .setTimestampOfCreation(timestampOfCreation)
                .setTimestampOfLastEdit(timestampOfLastEdit)
                .setTitle(title)
                .setDescription(description)
                .addAllTicketIds(ticketIds)
                .addAllAccountIdsOfOwners(accountIdsOfOwners)
                .addAllAccountIdsOfMembers(accountIdsOfMembers)
                .build()
        }
    }

    private fun getProjectModelFromProtobuf(projectProtobuf: IssueTrackerApiObjects.Project): ProjectModel {
        projectProtobuf.run {
            return ProjectModel(
                projectId = projectId,
                timestampOfCreation = timestampOfCreation,
                timestampOfLastEdit = timestampOfLastEdit,
                title = title,
                description = description,
                ticketIds = ticketIdsList,
                accountIdsOfOwners = accountIdsOfOwnersList,
                accountIdsOfMembers = accountIdsOfMembersList
            )
        }
    }

    fun getProject(projectModel: ProjectModel): ProjectModel? {
        val projectProtobuf = getProjectProtobufFromModel(projectModel)
        val projectsRemoteApi = ProjectsRemoteApi.create().getProject(projectProtobuf)
        return projectsRemoteApi.execute().body()?.let {
            getProjectModelFromProtobuf(it)
        }
    }
}
