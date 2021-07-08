package sg.edu.rp.c346.id19043996.p08_locatingaplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    Button btnNorth, btnCentral, btnEast;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)
                fm.findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback(){
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;

                LatLng northBranch = new LatLng(1.3507951229551611, 103.87043494002354);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(northBranch,
                        15));

                Marker north = map.addMarker(new
                        MarkerOptions()
                        .position(northBranch)
                        .title("North - HQ")
                        .snippet("Block 333, Admiralty Ave 3, 765654 Operating hours: 10am-5pm\n" +
                                "Tel:65433456\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                Toast.makeText(MainActivity.this, "North", Toast.LENGTH_SHORT).show();

                LatLng centralBranch = new LatLng(1.3051208285376867, 103.83216621118763);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(centralBranch,
                        15));

                Marker central = map.addMarker(new
                        MarkerOptions()
                        .position(centralBranch)
                        .title("Central")
                        .snippet("Block 3A, Orchard Ave 3, 134542 \n" +
                                "Operating hours: 11am-8pm\n" +
                                "Tel:67788652\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                Toast.makeText(MainActivity.this, "Central", Toast.LENGTH_SHORT).show();

                LatLng eastBranch = new LatLng(1.349214800739654, 103.93575385351626);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(eastBranch,
                        15));

                Marker east = map.addMarker(new
                        MarkerOptions()
                        .position(eastBranch)
                        .title("East")
                        .snippet("Block 555, Tampines Ave 3, 287788 \n" +
                                "Operating hours: 9am-5pm\n" +
                                "Tel:66776677\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                Toast.makeText(MainActivity.this, "East", Toast.LENGTH_SHORT).show();


                // To show our current location
                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION);

                if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);
                } else {
                    Log.e("GMap - Permission", "GPS access has not been granted");
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
                }

                btnNorth = findViewById(R.id.btnNorth);
                btnCentral = findViewById(R.id.btnCentral);
                btnEast = findViewById(R.id.btnEast);

                btnNorth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (map != null){
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(northBranch,
                                    15));
                        }
                    }

                });

                btnCentral.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (map != null){
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(centralBranch,
                                    15));
                        }
                    }
                });

                btnEast.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (map != null){
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(eastBranch,
                                    15));
                        }
                    }
                });

            }
        });

    }
}