import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapViewModel : ViewModel() {

    private var googleMap: GoogleMap? = null

    private val _markerLiveData = MutableLiveData<MarkerOptions>()
    val markerLiveData: LiveData<MarkerOptions> = _markerLiveData

    fun setGoogleMap(googleMap: GoogleMap?) {
        this.googleMap = googleMap
    }

    fun configureMap() {
        val met = LatLng(44.83, 20.45)

        val markerOptions = MarkerOptions()
            .position(met)
            .title("Met")

        _markerLiveData.postValue(markerOptions)

        googleMap?.addMarker(markerOptions)
        googleMap?.moveCamera(CameraUpdateFactory.newLatLng(met))
    }
}
