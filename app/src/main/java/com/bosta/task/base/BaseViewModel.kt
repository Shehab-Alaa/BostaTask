package com.bosta.task.base

import android.app.Application
import androidx.annotation.StringRes
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bosta.task.data.DataSourceManager
import com.bosta.task.data.remote.ApiDataSource
import com.bosta.task.util.Codes.BACK_BUTTON_PRESSED
import com.bosta.task.util.Resource

open class BaseViewModel(val dataManager: DataSourceManager) : AndroidViewModel(dataManager.getAppContext()), Observable {

    val app : Application = dataManager.getAppContext()
    val apiRepository : ApiDataSource = dataManager.getApiRepository()
    private val mCallBacks: PropertyChangeRegistry = PropertyChangeRegistry()
    val mutableLiveData = MutableLiveData<Any?>()
    // for network
    val resultLiveData = MutableLiveData<Resource<Any?>?>()

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallBacks.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallBacks.add(callback)
    }

    fun notifyChange() {
        mCallBacks.notifyChange(this, 0)
    }

    fun notifyChange(propertyId: Int) {
        mCallBacks.notifyChange(this, propertyId)
    }

    fun setValue(o: Any?) {
        mutableLiveData.value = o
    }

    fun postValue(o: Any?) {
        mutableLiveData.postValue(o)
    }

    fun setResult(o: Resource<Any?>?) {
        resultLiveData.value = o
    }

    fun postResult(o: Resource<Any?>?) {
        resultLiveData.postValue(o)
    }

    fun getString(@StringRes stringRes: Int): String {
        return app.getString(stringRes)
    }

    fun onBackBtnPressed(){
        setValue(BACK_BUTTON_PRESSED)
    }

}