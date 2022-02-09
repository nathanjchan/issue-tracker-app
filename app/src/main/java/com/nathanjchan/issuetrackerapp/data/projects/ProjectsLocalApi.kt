package com.nathanjchan.issuetrackerapp.data.projects

import androidx.room.*

@Dao
interface ProjectsLocalApi {
    @Query("select * from projects")
    fun getAll(): List<ProjectEntity>

    @Insert
    fun insertAll(vararg projects: ProjectEntity)

    @Update
    fun updateUsers(vararg projects: ProjectEntity)

    @Delete
    fun delete(project: ProjectEntity)
}