package dev.ariltw.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.ariltw.dagger.car.Car
import dev.ariltw.dagger.dagger.CarComponent
import javax.inject.Inject
import dev.ariltw.dagger.dagger.DieselEngineModule
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import dev.ariltw.dagger.dagger.DaggerCarComponent


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerCarComponent.builder()
            .dieselEngineModule(DieselEngineModule(100))
            .build()
        component.inject(this)

        car.drive()
    }
}
