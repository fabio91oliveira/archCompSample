package fabiooliveira.archcompexample

import android.arch.lifecycle.ViewModelProviders
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class CountViewModelTest {

    private lateinit var viewModel: CountViewModel

    @Before
    fun setUp(){
        val activity = Robolectric.setupActivity(CountActivity::class.java)
        viewModel = ViewModelProviders.of(activity).get(CountViewModel::class.java)
    }

    @Test
    fun should_return_Count_variable(){
        val count = viewModel.getCount()

        Assert.assertNotNull(count.value)
    }

    @Test
    fun should_add_count(){
        viewModel.addCount()

        Assert.assertEquals(viewModel.getCount().value, 1)
    }

}