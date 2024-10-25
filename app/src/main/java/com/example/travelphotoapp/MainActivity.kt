package com.example.travelphotoapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var currentImage = 1
    private lateinit var image: ImageView
    private var places = arrayOf(
        "AdiDev",
        "3 idiot",
        "Crime Patrol",
        "Jetha lal",
        "Biloo",
        "Krishna Temple",
        "More Gamde Moor"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val imgBtnPrev = findViewById<ImageView>(R.id.img_btnPrev)
        val imgBtnNext = findViewById<ImageView>(R.id.img_btnNext)
        val placeName = findViewById<TextView>(R.id.txt_imgDesc)

        imgBtnNext.setOnClickListener {
            // i want to get next Image
            var idCurrentImageString = "img_photo$currentImage"

            // i have to get int Add. associated with each view
            var idCurrentImageInt =
                this.resources.getIdentifier(idCurrentImageString, "id", this.packageName)
            image = findViewById(idCurrentImageInt) // give fvb to shown image
            image.alpha = 0f // make it invisible

            currentImage = (7 + currentImage + 1) % 7
            var idImageToShowString = "img_photo$currentImage"
            var idImageToShowInt =
                this.resources.getIdentifier(idImageToShowString, "id", this.packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f // make next image visible
            // set text Next image
            placeName.text = places[currentImage]
        }

        imgBtnPrev.setOnClickListener {
            var idCurrentImageString = "img_photo$currentImage"
            var idCurrentImageInt =
                this.resources.getIdentifier(idCurrentImageString, "id", this.packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (7 + currentImage - 1) % 7
            var idImageToShowString = "img_photo$currentImage"
            var idImageToShowInt =
                this.resources.getIdentifier(idImageToShowString, "id", this.packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f
            // Set text previous image
            placeName.text = places[currentImage]
        }
    }
}