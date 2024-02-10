package com.example.virtualmootcourt.data.consentAndSelection

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class CasViewModel : ViewModel() {
    private var casState = mutableStateOf(CasState())
    fun onEvent(event: CasUIEvent) {
        when(event) {
            is CasUIEvent.JudgeEmailEntered -> {
                casState.value = casState.value.copy(
                    judgeEmail = event.judgeEmail
                )
            }
            is CasUIEvent.PetitionerEmailEntered -> {
                casState.value = casState.value.copy(
                    petitionerEmail = event.petitionerEmail
                )
            }
            is CasUIEvent.RespondentEmailEntered -> {
                casState.value = casState.value.copy(
                    respondentEmail = event.respondentEmail
                )
            }
            is CasUIEvent.NoOfDaysEntered -> {
                casState.value = casState.value.copy(
                    noOfDaysReq = event.noOfDaysReq
                )
            }
            is CasUIEvent.CASSubmitButtonClicked -> {
                writeEntriesToDB(
                    jEmail = casState.value.judgeEmail,
                    pEmail = casState.value.petitionerEmail ,
                    rEmail = casState.value.respondentEmail ,
                    nOfDays = casState.value.noOfDaysReq )
            }
        }
    }

    private lateinit var database: DatabaseReference
    data class UserEntries(
        val judgeEmail: String?= null,
        val petitionerEmail: String?= null,
        val respondentEmail: String?= null,
        val noOfDaysReq: String?= null
    )
    private fun writeEntriesToDB(
        jEmail: String = "",
        pEmail: String = "",
        rEmail: String = "",
        nOfDays: String = ""){
        database = Firebase.database.reference
        val userEntry = UserEntries(jEmail, pEmail, rEmail, nOfDays)
        database.child("UserEntries").push().setValue(userEntry)
    }
}