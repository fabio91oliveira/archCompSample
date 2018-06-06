package fabiooliveira.archcompexample

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class CountViewModel: ViewModel() {
    private var count: MutableLiveData<Int> = MutableLiveData()

    init {
        count.value = 0
    }

    fun getCount(): LiveData<Int> {
        return count
    }

    fun addCount(){
        count.value = count.value?.plus(1)
    }

}