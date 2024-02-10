package com.example.virtualmootcourt.data.consentAndSelection

sealed class CasUIEvent {
    data class JudgeEmailEntered( var judgeEmail: String ) : CasUIEvent()
    data class PetitionerEmailEntered( var petitionerEmail: String ) : CasUIEvent()
    data class RespondentEmailEntered( var respondentEmail: String) : CasUIEvent()
    data class NoOfDaysEntered( var noOfDaysReq: String ) : CasUIEvent()
    object CASSubmitButtonClicked : CasUIEvent()
}