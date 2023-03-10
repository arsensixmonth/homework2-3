package com.example.a7_th_month_project.data.repository

import com.example.a7_th_month_project.data.base.BaseRepository
import com.example.a7_th_month_project.data.local.NoteDao
import com.example.a7_th_month_project.data.mapper.toNote
import com.example.a7_th_month_project.data.mapper.toNoteEntity
import com.example.a7_th_month_project.domain.model.Note
import com.example.a7_th_month_project.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val dao: NoteDao
) : NoteRepository, BaseRepository() {
    override fun createNote(note: Note) = doRequest {
        dao.insert(note.toNoteEntity())
    }

    override fun getAllNotes() = doRequest {
        dao.getAllNotes().map { it.toNote() }
    }

    override fun deleteNote(note: Note) = doRequest {
        dao.delete(note.toNoteEntity())
    }


    override fun updateNote(note: Note) = doRequest {
        dao.update(note.toNoteEntity())
    }
}
