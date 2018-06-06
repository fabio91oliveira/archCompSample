package fabiooliveira.archcompexample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_count.*

class CountActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(CountViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count)
        initValues()
        initListeners()
    }

    private fun initValues() {
        txtCount.text = viewModel.getCount().value.toString()
    }

    private fun initListeners() {
        btCount.setOnClickListener { viewModel.addCount() }
        viewModel.getCount().observe(this, Observer { t ->
            txtCount.text = t.toString()
        })
    }
}
