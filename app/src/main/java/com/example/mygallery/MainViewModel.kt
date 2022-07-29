package com.example.mygallery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygallery.domain.images.Image
import com.example.mygallery.network.NetworkInteractor
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainViewModel : ViewModel() {

    @Inject
    lateinit var networkInteractor: NetworkInteractor

    private var getImagesJob: Job? = null
    private val images = MutableLiveData<List<Image>>()

    init {
        getData()
    }

    fun getImages(): LiveData<List<Image>> = images

    private fun getData() {
        if (getImagesJob != null) return

        getImagesJob = viewModelScope.async {
            //start loading
            try {
                networkInteractor.getImages()
                images.value = awaitAll()
            } catch (e: Exception) {
                onError(e)
            }

            //end loading

        }
    }

    private fun onError(error: Throwable) {
        Log.d("ERROR", error.message.toString())
    }
}