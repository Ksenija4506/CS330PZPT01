package com.metropolitan.nav.screens

import MapViewModel
import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

@Composable
fun MapScreen() {
    val context = LocalContext.current
    val viewModel: MapViewModel = viewModel()

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = {
            val mapView = MapView(it).apply {

                onCreate(null)
                getMapAsync { googleMap ->
                    viewModel.setGoogleMap(googleMap = googleMap)
                }
            }
            mapView
        },
        update = { mapView ->

            mapView.onResume()
            viewModel.configureMap()
        }
    )
}