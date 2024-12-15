package com.hector.pre_cafeteria

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _primerPlat = MutableLiveData<String>()
    val primerPlat: LiveData<String> get() = _primerPlat

    private val _quantitatPlat = MutableLiveData<Int>()
    val quantitatPlat: LiveData<Int> get() = _quantitatPlat

    private val _preuPlat = MutableLiveData<Double>()
    val preuPlat: LiveData<Double> get() = _preuPlat

    private val _beguda = MutableLiveData<String>()
    val beguda: LiveData<String> get() = _beguda

    private val _quantitatBeguda = MutableLiveData<Int>()
    val quantitatBeguda: LiveData<Int> get() = _quantitatBeguda

    private val _preuBeguda = MutableLiveData<Double>()
    val preuBeguda: LiveData<Double> get() = _preuBeguda

    val totalPreu = MediatorLiveData<Double>().apply {
        addSource(_preuPlat) { value = calcularTotal() }
        addSource(_preuBeguda) { value = calcularTotal() }
    }

    fun savePrimerPlat(nom: String, quantitat: Int, preu: Double) {
        _primerPlat.value = nom
        _quantitatPlat.value = quantitat
        _preuPlat.value = preu
    }

    fun saveBeguda(nom: String, quantitat: Int, preu: Double) {
        _beguda.value = nom
        _quantitatBeguda.value = quantitat
        _preuBeguda.value = preu
    }

    private fun calcularTotal(): Double {
        val plat = (_quantitatPlat.value ?: 0) * (_preuPlat.value ?: 0.0)
        val beguda = (_quantitatBeguda.value ?: 0) * (_preuBeguda.value ?: 0.0)
        return plat + beguda
    }
}
