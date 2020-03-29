package com.example.android.gymondoautomationtest.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class ExercisesModel(val results: List<ResultsModel> = arrayListOf()) {
    fun getListOfValidResults(): List<String> {
        val listOfValidResults = arrayListOf<String>()
        results
            .filter { !it.name.isNullOrEmpty() }
            .forEach { listOfValidResults.add(it.getFinalResultName()) }
        return listOfValidResults
    }
}
data class ResultsModel(val id: Int, val name: String?) {
    fun getFinalResultName(): String {
        return "$id - $name"
    }
}
inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object : TypeToken<T>() {}.type)