package com.nathanjchan.issuetrackerapp.data.projects

import IssueTrackerApiObjects
import com.nathanjchan.issuetrackerapp.data.retrofitconverter.ProtoConverterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET

interface ProjectsRemoteApi {

    @GET("")
    fun getProject(@Body project: IssueTrackerApiObjects.Project) : Call<IssueTrackerApiObjects.Project>

    companion object {
        private const val BASE_URL = "http://54.241.64.13:8090/"

        fun create(): ProjectsRemoteApi {
            return Retrofit.Builder()
                .addConverterFactory(ProtoConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(ProjectsRemoteApi::class.java)
        }
    }

//    fun postProject(project: ProjectModel) {
//        val projectByteArray = createProjectProtobuf(project)
//    }

//    fun getProject(project: ProjectModel) {
//        val projectByteArray = createProjectProtobuf(project)
//    }
}
