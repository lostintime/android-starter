package com.example.starter.ui

import android.os.Bundle
import android.widget.Toast
import com.example.starter.R
import com.example.starter.service.IdentificationService
import com.example.starter.service.SampleService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.layout.*
import javax.inject.Inject


class MainActivity : BaseActivity() {

    @Inject
    lateinit var idService: IdentificationService

    @Inject
    lateinit var sampleService: SampleService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent().inject(this);

        setContentView(R.layout.layout)

        val installUuid = idService.getInstallUuid()

        textView.text = "INSTALL UUID: $installUuid"
    }

    override fun onResume() {
        super.onResume()

        sampleService
                .getEntities("test")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Toast.makeText(getStarterApplication(), "Success!", Toast.LENGTH_SHORT).show()
                }, {
                    Toast.makeText(getStarterApplication(), "Failed!", Toast.LENGTH_SHORT).show()
                }, {
                    Toast.makeText(getStarterApplication(), "Complete!", Toast.LENGTH_SHORT).show()
                })

    }
}
