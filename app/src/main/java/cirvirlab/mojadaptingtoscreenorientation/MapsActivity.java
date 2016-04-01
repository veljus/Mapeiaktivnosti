package cirvirlab.mojadaptingtoscreenorientation;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.VisibleRegion;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    TextView txtStreetName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        txtStreetName = (TextView)findViewById(R.id.editText);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void openSearch(View view){

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        VisibleRegion visibleRegion = mMap.getProjection().getVisibleRegion();
        List<Address> addressList = null;


        double left = visibleRegion.latLngBounds.southwest.longitude;
        double right = visibleRegion.latLngBounds.northeast.longitude;
        double top = visibleRegion.latLngBounds.northeast.latitude;
        double bottom = visibleRegion.latLngBounds.southwest.latitude;

        double longitude, latitude;

        longitude = (left+right)/2.0;
        latitude = (top+bottom)/2.0;

        String str_longitude, str_latitude;

        str_longitude = String.valueOf(longitude);
        str_latitude = String.valueOf(latitude);

        String str_address = "";
        try
        {
            addressList  =  geocoder.getFromLocation(latitude ,longitude, 1);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Address address = addressList.get(0);
        String str_street_name = address.getAddressLine(0);
        txtStreetName.setText(str_street_name);


    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        try
        {
            mMap.setMyLocationEnabled(true);
        }catch (SecurityException e)
        {
            Log.e("PERMISSION_EXCEPTION","PERMISSION_NOT_GRANTED");
        }

    }
}
